import java.util.Scanner;

public class DoubleEndedQueue {
    private static final int SIZE = 5;
    private static final int[] queue = new int[SIZE];
    private static int front = -1;
    private static int rear = -1;

    private static boolean isEmpty() {
        return front == -1;
    }

    private static boolean isFull() {
        return (front == 0 && rear == SIZE - 1) || (front == rear + 1);
    }

    private static void insertFront(Scanner scanner) {
        if (isFull()) {
            System.out.println("Queue is overflow.");
            return;
        }

        System.out.print("Enter value: ");
        int value = scanner.nextInt();

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = SIZE - 1;
        } else {
            front--;
        }

        queue[front] = value;
        System.out.println("Inserted at front.");
    }

    private static void insertRear(Scanner scanner) {
        if (isFull()) {
            System.out.println("Queue is overflow.");
            return;
        }

        System.out.print("Enter value: ");
        int value = scanner.nextInt();

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == SIZE - 1) {
            rear = 0;
        } else {
            rear++;
        }

        queue[rear] = value;
        System.out.println("Inserted at rear.");
    }

    private static void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue is underflow.");
            return;
        }

        System.out.println(queue[front] + " deleted from front.");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == SIZE - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    private static void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue is underflow.");
            return;
        }

        System.out.println(queue[rear] + " deleted from rear.");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = SIZE - 1;
        } else {
            rear--;
        }
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
            System.out.println("\n=== Double Ended Queue (Deque) ===");
            System.out.println("1. Insert Front  2. Insert Rear");
            System.out.println("3. Delete Front  4. Delete Rear");
            System.out.println("5. Display       6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> insertFront(scanner);
                case 2 -> insertRear(scanner);
                case 3 -> deleteFront();
                case 4 -> deleteRear();
                case 5 -> display();
                case 6 -> System.out.println("Bye Bye.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}
