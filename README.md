# Infix to Postfix Expression Converter and Evaluator

This is a simple Java application that takes an infix arithmetic expression as input, converts it to postfix notation using a custom stack class, and then evaluates the postfix expression to provide the result. The application currently supports basic arithmetic operations (addition, subtraction, multiplication, and division). Future plans include adding support for exponentiation and logarithmic operations.

## How to Use

1. **Compile the Code:**
    - Ensure you have Java installed on your system.
    - Ensure you are in the src folder
    - Compile the `ExpressionEvaluator.java` file in the src folder using the following command:

   ```shell
   javac ExpressionEvaluator.java
   ```

2. **Run the Application:**
    - Run the compiled code using the following command:

   ```shell
   java ExpressionEvaluator
   ```

3. **Enter Infix Expressions:**
    - The application will prompt you to enter an infix expression.
    - Enter a valid arithmetic expression using integers and basic arithmetic operators (+, -, *, /) with proper parentheses to indicate the order of operations.
    - Make sure to keep spaces between everything.

4. **View Results:**
    - The application will first convert the infix expression to postfix notation.
    - Then, it will evaluate the postfix expression and display the result.
    - It will also show the postfix expression.

## Example Usage

Here are some example usages of the application:

1. **Basic Arithmetic:**
    - Enter: `2 + 3 * 4 - 1`
    - Postfix: `2 3 4 * + 1 - `
    - Result: `11`

2. **Parenthesis Expressions:**
    - Enter: `1 - ( 2 + 3 * 4 ) / 5`
    - Postfix: `1 2 3 4 * + 5 / -`
    - Result: `25`

## Future Plans

In the future, we plan to enhance the functionality of this application by adding support for more advanced mathematical operations such as exponentiation (^) and logarithmic operations (log). These additions will make the calculator even more versatile and useful for a wider range of mathematical expressions.

## Author

- Abdul Wasay Imran

Feel free to explore, modify, and build upon this simple Java application for infix to postfix conversion and evaluation. If you have any questions or suggestions, please don't hesitate to reach out. Enjoy using the application!