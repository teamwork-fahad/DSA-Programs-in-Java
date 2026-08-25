import java.util.Scanner;

public class SimpleQueue {
    private static final int SIZE = 5;
    private static final int[] queue = new int[SIZE];
    private static int front = 0;
    private static int rear = -1;

    private static boolean isEmpty() {
        return front > rear;
    }

    private static void enqueue(Scanner scanner) {
        if (rear == SIZE - 1) {
            System.out.println("Queue is overflow.");
            return;
        }
        System.out.print("Enter value: ");
        queue[++rear] = scanner.nextInt();
        System.out.println("Element inserted.");
    }

    private static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is underflow.");
            return;
        }
        System.out.println(queue[front++] + " is deleted.");
        if (isEmpty()) {
            front = 0;
            rear = -1;
        }
    }

    private static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int index = front; index <= rear; index++) {
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Simple Queue ===");
            System.out.println("1. Enqueue  2. Dequeue  3. Display  4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> enqueue(scanner);
                case 2 -> dequeue();
                case 3 -> display();
                case 4 -> System.out.println("Bye Bye.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
