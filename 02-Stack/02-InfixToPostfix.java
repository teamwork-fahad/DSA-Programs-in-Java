// Java Program to Convert Infix Expression to Postfix

import java.util.Scanner;

public class InfixToPostfix {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int step = 1;

        System.out.println("\n==============================================");
        System.out.println("       INFIX TO POSTFIX CONVERSION");
        System.out.println("==============================================");

        System.out.print("\nEnter Infix Expression : ");
        String infix = sc.nextLine();

        // Add brackets for easy conversion
        push('(');
        infix = infix + ")";

        StringBuilder postfix = new StringBuilder();

        System.out.println("\n\n----------------------------------------------");
        System.out.println(" Step\tSymbol\t\tStack\t\tPostfix");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < infix.length(); i++) {

            char symbol = infix.charAt(i);

            switch (symbol) {

                // Opening bracket
                case '(':
                    push(symbol);
                    break;

                // Closing bracket
                case ')':

                    while (stack[top] != '(') {
                        postfix.append(pop());
                    }

                    pop(); // Remove '('
                    break;

                // + and -
                case '+':
                case '-':

                    while (top >= 0 &&
                           (stack[top] == '^' ||
                            stack[top] == '/' ||
                            stack[top] == '*' ||
                            stack[top] == '+' ||
                            stack[top] == '-')) {

                        postfix.append(pop());
                    }

                    push(symbol);
                    break;

                // * and /
                case '*':
                case '/':

                    while (top >= 0 &&
                           (stack[top] == '^' ||
                            stack[top] == '*' ||
                            stack[top] == '/')) {

                        postfix.append(pop());
                    }

                    push(symbol);
                    break;

                // ^
                case '^':
                    push(symbol);
                    break;

                // Operand
                default:
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

        System.out.println("\n----------------------------------------------");

        System.out.println("\n==============================================");
        System.out.println("      POSTFIX EXPRESSION = " + postfix);
        System.out.println("==============================================");

        sc.close();
    }
}
