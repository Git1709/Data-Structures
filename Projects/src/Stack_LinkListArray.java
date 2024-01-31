import java.util.Scanner;

class Node4 {
    int data;
    Node4 next;

    public Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

class ArrayStack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Array Stack is full. Cannot push " + item);
        } else {
            stackArray[++top] = item;
            System.out.println("Pushed " + item + " to Array Stack");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Array Stack is empty.");
            return -1;
        } else {
            int item = stackArray[top--];
            System.out.println("Popped " + item + " from Array Stack");
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Array Stack is empty.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public int size() {
        return top + 1;
    }
}

class LinkedListStack {
    private Node4 top;

    public LinkedListStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int item) {
        Node4 newNode4 = new Node4(item);
        newNode4.next = top;
        top = newNode4;
        System.out.println("Pushed " + item + " to Linked List Stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Linked List Stack is empty.");
            return -1;
        }
        int item = top.data;
        top = top.next;
        System.out.println("Popped " + item + " from Linked List Stack");
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Linked List Stack is empty.");
            return -1;
        }
        return top.data;
    }
}

public class Stack_LinkListArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayStack arrayStack = new ArrayStack(5);
        LinkedListStack linkedListStack = new LinkedListStack();

        int choice;
        do {
            System.out.println("\nStack Menu:");
            System.out.println("1. Push to Array Stack");
            System.out.println("2. Pop from Array Stack");
            System.out.println("3. Peek Array Stack");
            System.out.println("4. Push to Linked List Stack");
            System.out.println("5. Pop from Linked List Stack");
            System.out.println("6. Peek Linked List Stack");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to push to Array Stack: ");
                    int arrayElement = scanner.nextInt();
                    arrayStack.push(arrayElement);
                    break;
                case 2:
                    int poppedFromArray = arrayStack.pop();
                    if (poppedFromArray != -1) {
                        System.out.println("Popped element from Array Stack: " + poppedFromArray);
                    }
                    break;
                case 3:
                    int peekedArray = arrayStack.peek();
                    if (peekedArray != -1) {
                        System.out.println("Top element of Array Stack: " + peekedArray);
                    }
                    break;
                case 4:
                    System.out.print("Enter an element to push to Linked List Stack: ");
                    int listElement = scanner.nextInt();
                    linkedListStack.push(listElement);
                    break;
                case 5:
                    int poppedFromList = linkedListStack.pop();
                    if (poppedFromList != -1) {
                        System.out.println("Popped element from Linked List Stack: " + poppedFromList);
                    }
                    break;
                case 6:
                    int peekedList = linkedListStack.peek();
                    if (peekedList != -1) {
                        System.out.println("Top element of Linked List Stack: " + peekedList);
                    }
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
