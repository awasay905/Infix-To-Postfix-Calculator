import MyStack.MyStack;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpressionEvaluator {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the expression with spaces");
        String infix = input.nextLine();
        String postfix = infixToPostfix(infix);
        double result = postfixToAnswer(postfix);
        System.out.println("Given Infix Expression was : " + infix);
        System.out.println("Its postfix form is        : " + postfix);
        System.out.println("Evaluated answer is        : " + result );
    }

    public static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }
    public static boolean isNotOperator(char c){
        return c != '+' &&c != '-' && c != '*' && c != '/' && c != '('&& c != '{'&& c != '['&& c != ')'&& c != '}'&& c != ']';
    }

    public static String infixToPostfix(String expression) {
        String[] words = expression.split(" ");
        MyStack<Character> operators = new MyStack<Character>();
        StringBuilder s = new StringBuilder();
        //starts reading characters

        for (int i = 0; i < words.length; i++) {
            //If we find a number, we just append it in the string
            if (isNotOperator(words[i].charAt(0))) s.append(words[i]).append(" ");
            else {
                //we see we recived a character
                char operator = words[i].charAt(0);
                //if stack is empty, we push the character to the stack
                if (operators.isEmpty()){
                    operators.push(operator);
                }
                else {
                    //then we check for bracket
                    if (operator == ')') {
                        while (operators.peek() != '(') {
                            s.append(operators.pop()).append(" ");
                        }
                        operators.pop();
                    } else if (operator == '}') {
                        while (operators.peek() != '{') {
                            s.append(operators.pop()).append(" ");
                        }
                        operators.pop();
                    } else if (operator == ']') {
                        while (operators.peek() != '[') {
                            s.append(operators.pop()).append(" ");
                        }
                        operators.pop();
                    } else {
                        //now we compare the priority
                        if ((operator == '+' || operator == '-') && (operators.peek() == '/' || operators.peek() == '*')){
                            while (!operators.isEmpty() && (operators.peek() == '/' || operators.peek() == '*')){
                                s.append(operators.pop()).append(" ");
                            }
                        }
                        else {
                            operators.push(operator);
                        }
                    }
                }
            }
        }

        while(!operators.isEmpty()){
            s.append(operators.pop()).append(" ");
        }

        return s.toString();
    }

    public static double postfixToAnswer(String expression){
        String[] words = expression.split(" ");
        MyStack<Double> numbers = new MyStack<Double>();

        for (int i = 0; i < words.length; i++) {
            if (isNotOperator(words[i].charAt(0))){
                double number = Double.parseDouble(words[i]);
                numbers.push(number);
            } else {
                double num2 = numbers.pop();
                double num1 = numbers.pop();
                char operator = words[i].charAt(0);

                switch (operator) {
                    case '+' -> numbers.push(num1 + num2);
                    case '-' -> numbers.push(num1 - num2);
                    case '*' -> numbers.push(num1 * num2);
                    case '/' -> numbers.push(num1 / num2);
                }
            }
        }
        return numbers.pop();
    }
}
