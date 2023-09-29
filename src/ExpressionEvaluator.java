import MyStack.MyStack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpressionEvaluator {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                |--------------------------------------------------------|
                |------------WELCOME TO EXPRESSION EVALUATOR-------------|
                |---------------MADE BY ABDUL WASAY IMRAN----------------|
                |--------------------------------------------------------| 
                
                Press (1): For converting infix expression to postfix
                Press (2): For evaluating postfix expression
                Press (3): For converting AND evaluating infix expressions
                Press (4): To exit
                            
                Response: 
                """);
        int choice = -1;
        while (choice != 4) {
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e){
                System.out.print("Opps! Looks like you made a wrong choice. Try again: ");
            }

            switch (choice){
                case 1 -> calculateInfixToPostfix();
                case 2 -> evaluatePostfix();
                case 3 -> calculateAndEvaluate();
                case 4 -> exit();
            }
            if (choice != 4) {
                System.out.println("""
                        Do you want to do something more?
                                        
                        Press (1): For converting infix expression to postfix
                        Press (2): For evaluating postfix expression
                        Press (3): For converting AND evaluating infix expressions
                        Press (4): To exit""");
            }
        }
    }

    public static void exit(){
        System.out.println("Thank you for using. bye");
    }
    public static void calculateAndEvaluate(){
        Scanner input = new Scanner(System.in);
        System.out.println("Infix Evaluation: ");
        System.out.print("Enter the infix expression WITH spaces around everything\n");
        System.out.print("Expression: ");
        String exp = input.nextLine();
        System.out.println("The input string is : " + exp);
        System.out.println("The postfix expression is : " + infixToPostfix(exp));
        System.out.println("The evaluated answer is : " + postfixToAnswer(infixToPostfix(exp)));
    }
    public static void evaluatePostfix(){
        Scanner input = new Scanner(System.in);
        System.out.println("Evaluate Postfix Expression: ");
        System.out.print("Enter the postfix expression WITH spaces around everything\n");
        System.out.print("Expression: ");
        String exp = input.nextLine();
        System.out.println("The input string is : " + exp);
        System.out.println("The evaluated answer is : " + postfixToAnswer(exp));
    }
    public static void calculateInfixToPostfix(){
        Scanner input = new Scanner(System.in);
        System.out.println("Infix to postfix conversion: ");
        System.out.print("Enter the infix expression WITH spaces around everything\n");
        System.out.print("Expression: ");
        String exp = input.nextLine();
        System.out.println("The input string is : " + exp);
        System.out.println("The postfix expression is : " + infixToPostfix(exp));
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
                        if ((operator == '+' || operator == '-') && (operators.peek() == '/' || operators.peek() == '*')){
                            while (!operators.isEmpty() && (operators.peek() == '/' || operators.peek() == '*')){
                                s.append(operators.pop()).append(" ");
                            }
                            operators.push(operator);
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

        return s.toString().trim();
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
