import java.util.Scanner;
class SLL
{
    class Node{
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    public void SLL()
    {
        head=null;
    }

    public void insertBeg(int data)
    {
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
        System.out.println("Insert beg done...");
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("SLL is empty");
        }
        else
        {
            Node temp=head;
            while(temp != null)
            {
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
        }

    }
    static void menu()
    {
        System.out.println("===> Singly Linked List <===");
        System.out.println("1.Insert at Beg");
        System.out.println("2.Insert at End");
        System.out.println("3.Insert at Specific position");
        System.out.println("4.Display List");
        System.out.println("5.Delete from Beg");
        System.out.println("6.Delete from End");
        System.out.println("7.Delete at Specific Beg");
        System.out.println("8.Search");
        System.out.println("0.Exit");
    }
    public static void main(String args[])
    {
        int d;
        Scanner sc=new Scanner(System.in);
        SLL s1=new SLL();
        while(true)
        {
            menu();
            System.out.println("Enter your choice=>");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 0:
                    System.out.println("Exit");
                    return;

                case 1:
                    System.out.println("Enter data=>");
                    d=sc.nextInt();
                    s1.insertBeg(d);
                    break;

                case 4:
                    s1.display();
                    System.out.println("----------");
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}