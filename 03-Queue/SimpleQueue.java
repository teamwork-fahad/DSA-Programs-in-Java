import java.util.Scanner;

public class CircularQueueUsingArray {
    int queue_arr[];
    int front = -1;
    int rear = -1;

    public CircularQueueUsingArray(int size) {
        queue_arr = new int[size];
    }
    
    public boolean isEmpty(){
        if(front == -1 && rear == -1){
            return true;
        }
        return false;
    }
    
    public boolean isFull(){
        if( (rear+1) % queue_arr.length == front ){
            return true;
        }
        return false;
    }
    
    public void enqueue(int element){
        if(isFull()){
            System.out.println("The Queue is Full.. ");
        }
        else if(isEmpty()){
            front = 0;
            rear = 0;
            queue_arr[rear] = element;
            System.out.println( queue_arr[rear] + " Inserted successfully..");
        }
        else{
            rear = (rear+1) % queue_arr.length;
            queue_arr[rear] = element;
            System.out.println( queue_arr[rear] + " Inserted successfully..");
        }
    }
    
    public void dequeue(){
        if(isEmpty()){
            System.out.println("The Queue is Empty.. ");
        }
        else if(front == rear){
            System.out.println(queue_arr[front] + " Deleted..");
            front = -1;
            rear = -1;
        }
        else{
            System.out.println(queue_arr[front] + " Deleted..");
            front = (front+1) % queue_arr.length;
        }
    }
    
    public void peep(){
        if(isEmpty()){
            System.out.println("The Queue is Empty.. ");
            return;
        }
        System.out.println("First element is " + queue_arr[front]);
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("The Queue is Empty.. ");
            return;
        }
        for(int i=front;i!=rear;i = (i+1) % queue_arr.length){
            System.out.print(queue_arr[i] + " ");
        }
        System.out.print(queue_arr[rear]);
    }
    
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of queue : ");
        int size=input.nextInt();
        
        CircularQueueUsingArray queue=new CircularQueueUsingArray(size);
        
        while(true){
            System.out.println();
            System.out.println("1. ENQUEUE operation ");
            System.out.println("2. DEQUEUE operation ");
            System.out.println("3. PEEK operation ");
            System.out.println("4. DISPLAY operation ");
            System.out.println("0. Exit ");
            
            System.out.print("Enter Choice : ");
            int choice = input.nextInt();
            
            switch(choice){
                case 1:
                    System.out.print("Enter the element to insert : ");
                    int element=input.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peep();
                    break;
                case 4:
                    queue.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Choice...");
            }
        }
    }
}

