import java.util.Scanner;

public class StaticStackUsingArray {
    private static final int SIZE = 5;
    private static final int[] stack = new int[SIZE];
    private static int top = -1;

    private static void push(Scanner scanner) {
        if (top == SIZE - 1) {
            System.out.println("Stack is overflow.");
            return;
        }
        System.out.print("Enter value: ");
        stack[++top] = scanner.nextInt();
        System.out.println("Insert done.");
    }

    private static void pop() {
        if (top == -1) {
            System.out.println("Stack is underflow.");
            return;
        }
        System.out.println(stack[top--] + " is deleted.");
    }

    private static void peek() {
        if (top == -1) {
            System.out.println("Stack is underflow.");
            return;
        }
        System.out.println(stack[top] + " is on top.");
    }

    private static void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements (top to bottom):");
        for (int index = top; index >= 0; index--) {
            System.out.println("| " + stack[index] + " |");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Stack Operation ===");
            System.out.println("1. Push  2. Pop  3. Peek  4. Display  5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> push(scanner);
                case 2 -> pop();
                case 3 -> peek();
                case 4 -> display();
                case 5 -> System.out.println("Bye Bye.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
