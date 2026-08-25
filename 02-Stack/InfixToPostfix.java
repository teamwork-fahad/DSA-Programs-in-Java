import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }

    private static String convert(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for (char symbol : expression.toCharArray()) {
            if (Character.isWhitespace(symbol)) {
                continue;
            }
            if (Character.isLetterOrDigit(symbol)) {
                postfix.append(symbol);
            } else if (symbol == '(') {
                operators.push(symbol);
            } else if (symbol == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    postfix.append(operators.pop());
                }
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Unbalanced parentheses.");
                }
                operators.pop();
            } else if (precedence(symbol) > 0) {
                while (!operators.isEmpty() && operators.peek() != '('
                        && (precedence(operators.peek()) > precedence(symbol)
                        || (precedence(operators.peek()) == precedence(symbol) && symbol != '^'))) {
                    postfix.append(operators.pop());
                }
                operators.push(symbol);
            } else {
                throw new IllegalArgumentException("Unsupported symbol: " + symbol);
            }
        }

        while (!operators.isEmpty()) {
            if (operators.peek() == '(') {
                throw new IllegalArgumentException("Unbalanced parentheses.");
            }
            postfix.append(operators.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String expression = scanner.nextLine();
        try {
            System.out.println("Postfix expression = " + convert(expression));
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid expression: " + exception.getMessage());
        }
    }
}
