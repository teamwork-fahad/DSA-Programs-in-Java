import java.util.Scanner;

public class CircularQueue {
    private static final int SIZE = 5;
    private static final int[] queue = new int[SIZE];
    private static int front = -1;
    private static int rear = -1;

    private static boolean isEmpty() {
        return front == -1;
    }

    private static boolean isFull() {
        return (rear + 1) % SIZE == front;
    }

    private static void enqueue(Scanner scanner) {
        if (isFull()) {
            System.out.println("Queue is overflow.");
            return;
        }

        System.out.print("Enter value: ");
        int value = scanner.nextInt();

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % SIZE;
        }

        queue[rear] = value;
        System.out.println("Element inserted.");
    }

    private static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is underflow.");
            return;
        }

        System.out.println(queue[front] + " is deleted.");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
    }

    private static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element is " + queue[front]);
    }

    private static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % SIZE;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Circular Queue ===");
            System.out.println("1. Enqueue  2. Dequeue  3. Display  4. Peek  5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> enqueue(scanner);
                case 2 -> dequeue();
                case 3 -> display();
                case 4 -> peek();
                case 5 -> System.out.println("Bye Bye.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
