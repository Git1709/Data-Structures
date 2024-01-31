import java.util.Scanner;
public class LinearQueue {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of queue");
       int a= sc.nextInt();
        Queue q= new Queue(a);
        System.out.println("Initial queue: ");
        Queue.display();
        Queue.enqueue(10);
        Queue.enqueue(20);
        Queue.enqueue(30);
        Queue.enqueue(40);
        Queue.enqueue(50);
        Queue.display();
        System.out.println("\n peeking :");
        Queue.peek();
        System.out.println("DeQueueing ");
        Queue.dequeue();
        System.out.println("Peeking after dequeue");
        Queue.peek();
        System.out.println("Display queue again");
        Queue.display();
        System.out.println("\n\n Linked List queue: \n");
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.displayFR();
        queue.display();
        queue.dequeue();
        queue.peek();
        queue.displayFR();


    }
}
class Queue{
    private static int front, rear, capacity;
    private static int[] queue;
    Queue(int size){
        front = rear=0;
        capacity = size;
        queue= new int[capacity];
    }
    //inserting element
    static void enqueue(int item){
        if(capacity==rear){
            System.out.println("Queue full !\n");
            return;
        }
        queue[rear]=item;
        rear++;

    }
    static void dequeue(){
        if(front==rear){
            System.out.println("Queue is empty");
            return;
        }
        for(int i=0;i<rear-1;i++){
            queue[i]=queue[i+1];
        }
        if(rear<capacity){
            queue[rear]=0;
            rear--;
        }

    }
    static void display(){
        int i;
        if(front==rear){
            System.out.println("Empty");
        }
        for(i=front;i<rear;i++){
            System.out.printf("%d,",queue[i]);
        }

    }
    //for front element
    static void peek(){
        if(front==rear){
            System.out.println("queue empty");
        }
        System.out.println(queue[front]);
    }
}
class LinkedListQueue
{
    private Node front, rear;
    private int queueSize;
    private class Node {
        int data;
        Node next;
    }

    public LinkedListQueue()
    {
        front = null;
        rear = null;
        queueSize = 0;
    }

    public boolean isEmpty()
    {
        return (queueSize == 0);
    }

    public int dequeue()
    {
        int data = front.data;
        front = front.next;
        if (isEmpty())
        {
            rear = null;
        }
        queueSize--;
        System.out.println("Element " + data+ " removed from the queue");
        return data;
    }

    public void enqueue(int data)
    {
        Node oldRear = rear;
        rear = new Node();
        rear.data = data;
        rear.next = null;
        if (isEmpty())
        {
            front = rear;
        }
        else  {
            oldRear.next = rear;
        }
        queueSize++;
        System.out.println("Element " + data+ " added to the queue");
    }
    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        else{
            System.out.println(front.data);
        }
    }
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
}
    public void displayFR() {
        System.out.println("Front of the queue:" + front.data
                + " Rear of the queue:" + rear.data);
    }
}