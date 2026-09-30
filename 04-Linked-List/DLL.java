import java.util.Scanner;
public class DLL
{
    // Node
    class Node
    {
        int data;
        Node next,prev;
        Node(int data)
        {
            this.data = data;
            next = null;
            prev=null;
        }
    }
    Node head = null;

    // Insert at Beginning
    void insertBeg(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        head.prev = newNode;
        
        System.out.println("Inserted at beginning.");
    }

    // Insert at End
    void insertEnd(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            insertBeg(data);
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev=temp;
        }
        System.out.println("Inserted at end.");
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
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        DLL list = new DLL();

        while (true)
        {
            System.out.println("\n===== Doubly LINKED LIST =====");
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

                case 7:
                    list.display();
                    break;
            }
        }
    }
}
