import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter postfix expression: ");
        String exp = sc.nextLine();

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                s.push(ch - '0');
            }
            else {
                int b = s.pop();
                int a = s.pop();

                if (ch == '+')
                    s.push(a + b);
                else if (ch == '-')
                    s.push(a - b);
                else if (ch == '*')
                    s.push(a * b);
                else if (ch == '/')
                    s.push(a / b);
            }
        }

        System.out.println("Result = " + s.pop());
    }
}
