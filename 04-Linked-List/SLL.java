import java.util.Scanner;
public class sll
{
    // Node
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    Node head = null;

    // Insert at Beginning
    void insertBeg(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at beginning.");
    }

    // Insert at End
    void insertEnd(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted at end.");
    }

    // Insert at Specific Position
    void insertPos(int data, int pos)
    {
        Node newNode = new Node(data);
        if (pos == 1)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
        {
            temp = temp.next;
        }
        if (temp == null)
        {
            System.out.println("Invalid position.");
        }
        else
        {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Inserted at position " + pos);
        }
    }

    // Delete from Beginning
    void deleteBeg()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
        }
        else
        {
            head = head.next;
            System.out.println("Deleted from beginning.");
        }
    }

    // Delete from End
    void deleteEnd()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
        }
        else if (head.next == null)
        {
            head = null;
            System.out.println("Deleted from end.");
        }
        else
        {
            Node temp = head;
            while (temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
            System.out.println("Deleted from end.");
        }
    }

    // Delete from Specific Position
    void deletePos(int pos)
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        if (pos == 1)
        {
            head = head.next;
            System.out.println("Deleted from position 1.");
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
        {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
        {
            System.out.println("Invalid position.");
        }
        else
        {
            temp.next = temp.next.next;
            System.out.println("Deleted from position " + pos);
        }
    }

    // Display
    void display()
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Search
    void search(int data)
    {
        Node temp = head;
        int pos = 1;
        while (temp != null)
        {
            if (temp.data == data)
            {
                System.out.println("Element found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element not found.");
    }

    // Main
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        sll list = new sll();

        while (true)
        {
            System.out.println("\n===== SINGLY LINKED LIST =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display");
            System.out.println("8. Search");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch)
            {
                case 1:
                    System.out.print("Enter data: ");
                    list.insertBeg(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    list.insertEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();

                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertPos(data, pos);
                    break;

                case 4:
                    list.deleteBeg();
                    break;

                case 5:
                    list.deleteEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    list.deletePos(sc.nextInt());
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.print("Enter data to search: ");
                    list.search(sc.nextInt());
                    break;

                case 0:
                    System.out.println("Program End.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}