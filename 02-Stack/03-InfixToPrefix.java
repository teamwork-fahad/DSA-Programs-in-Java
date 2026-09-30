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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i;
        int j = 0;

        System.out.println("\n==============================================");
        System.out.println("        INFIX TO PREFIX CONVERSION");
        System.out.println("==============================================");

        System.out.print("\nEnter Infix Expression : ");
        String infix = sc.nextLine();

        // Reverse infix expression
        String reversed = "";

        for (i = infix.length() - 1; i >= 0; i--) {

            if (infix.charAt(i) == '(') {
                reversed = reversed + ')';
            }
            else if (infix.charAt(i) == ')') {
                reversed = reversed + '(';
            }
            else {
                reversed = reversed + infix.charAt(i);
            }
        }

        // Temporary array for postfix
        char[] temp = new char[SIZE];

        // Convert reversed expression into postfix
        for (i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            // Opening bracket
            if (ch == '(') {
                push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (top >= 0 && stack[top] != '(') {
                    temp[j] = pop();
                    j++;
                }

                if (top >= 0) {
                    pop();
                }
            }

            // + and -
            else if (ch == '+' || ch == '-') {

                while (top >= 0 &&
                       (stack[top] == '^' ||
                        stack[top] == '/' ||
                        stack[top] == '*' ||
                        stack[top] == '+' ||
                        stack[top] == '-')) {

                    temp[j] = pop();
                    j++;
                }

                push(ch);
            }

            // * and /
            else if (ch == '*' || ch == '/') {

                while (top >= 0 &&
                       (stack[top] == '^' ||
                        stack[top] == '*' ||
                        stack[top] == '/')) {

                    temp[j] = pop();
                    j++;
                }

                push(ch);
            }

            // ^
            else if (ch == '^') {
                push(ch);
            }

            // Operand
            else {
                temp[j] = ch;
                j++;
            }
        }

        // Pop remaining operators
        while (top >= 0) {
            temp[j] = pop();
            j++;
        }

        // Reverse temporary result to get Prefix
        System.out.println("\n==============================================");
        System.out.print("      PREFIX EXPRESSION = ");

        for (i = j - 1; i >= 0; i--) {
            System.out.print(temp[i]);
        }

        System.out.println();
        System.out.println("==============================================");

        sc.close();
    }
}
