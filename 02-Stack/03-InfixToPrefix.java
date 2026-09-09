// Java Program to Convert Infix Expression to Prefix

import java.util.Scanner;

public class InfixToPrefix {

    static final int SIZE = 100;

    static char[] stack = new char[SIZE];
    static int top = -1;

    // Push character into stack
    static void push(char ch) {
        top++;
        stack[top] = ch;
    }

    // Pop character from stack
    static char pop() {
        char ch = stack[top];
        top--;
        return ch;
    }

    // Display stack as String
    static String getStack() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i <= top; i++) {
            str.append(stack[i]);
        }

        return str.toString();
    }

    // Check operator
    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' ||
               ch == '*' || ch == '/' ||
               ch == '^';
    }

    // Get precedence
    static int precedence(char ch) {

        switch (ch) {
            case '^':
                return 3;

            case '*':
            case '/':
                return 2;

            case '+':
            case '-':
                return 1;

            default:
                return 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int step = 1;

        System.out.println("\n==============================================");
        System.out.println("        INFIX TO PREFIX CONVERSION");
        System.out.println("==============================================");

        System.out.print("\nEnter Infix Expression : ");
        String infix = sc.nextLine();

        /*
         * Step 1:
         * Reverse the infix expression
         */
        StringBuilder reversed = new StringBuilder(infix).reverse();

        /*
         * Step 2:
         * Replace '(' with ')' and ')' with '('
         */
        for (int i = 0; i < reversed.length(); i++) {

            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            }
            else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }

        StringBuilder postfix = new StringBuilder();

        System.out.println("\n\n----------------------------------------------");
        System.out.println(" Step\tSymbol\t\tStack\t\tPostfix");
        System.out.println("----------------------------------------------");

        /*
         * Step 3:
         * Convert reversed expression into postfix
         */
        for (int i = 0; i < reversed.length(); i++) {

            char symbol = reversed.charAt(i);

            // Opening bracket
            if (symbol == '(') {

                push(symbol);
            }

            // Closing bracket
            else if (symbol == ')') {

                while (top >= 0 && stack[top] != '(') {
                    postfix.append(pop());
                }

                if (top >= 0) {
                    pop(); // Remove '('
                }
            }

            // Operator
            else if (isOperator(symbol)) {

                while (top >= 0 &&
                       stack[top] != '(' &&
                       precedence(stack[top]) > precedence(symbol)) {

                    postfix.append(pop());
                }

                push(symbol);
            }

            // Operand
            else {

                postfix.append(symbol);
            }

            System.out.printf(
                    "\n %2d\t  %c\t\t%-10s\t%s",
                    step,
                    symbol,
                    getStack(),
                    postfix
            );

            step++;
        }

        // Pop remaining operators
        while (top >= 0) {
            postfix.append(pop());
        }

        /*
         * Step 4:
         * Reverse postfix to get prefix
         */
        String prefix = postfix.reverse().toString();

        System.out.println("\n----------------------------------------------");

        System.out.println("\n==============================================");
        System.out.println("      PREFIX EXPRESSION = " + prefix);
        System.out.println("==============================================");

        sc.close();
    }
}
