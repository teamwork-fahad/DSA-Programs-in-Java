import java.util.Scanner;

public class SinglyLinkedList {
    private static class Node {
        private final int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private static Node head;

    private static void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    private static void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    private static void delete(int value) {
        if (head == null) {
            System.out.println("SLL is empty.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println("Node deleted.");
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Value not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Node deleted.");
        }
    }

    private static void display() {
        if (head == null) {
            System.out.println("SLL is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Singly Linked List ===");
            System.out.println("1. Insert at beginning  2. Insert at end");
            System.out.println("3. Delete by value       4. Display  5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1, 2 -> {
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    if (choice == 1) insertAtBeginning(value);
                    else insertAtEnd(value);
                }
                case 3 -> {
                    System.out.print("Enter value to delete: ");
                    delete(scanner.nextInt());
                }
                case 4 -> display();
                case 5 -> System.out.println("Bye Bye.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
