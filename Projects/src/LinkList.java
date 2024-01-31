import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

        public LinkedList() {
        head = null;
    }


    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }


    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 1;
        while (currentPosition < position - 1 && current != null) {
            current = current.next;
            currentPosition++;
        }
        if (current == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }


    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        head = head.next;
    }
        public void deleteAtEnd() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void deleteAtPosition(int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            deleteAtBeginning();
            return;
        }
        Node current = head;
        int currentPosition = 1;
        while (currentPosition < position - 1 && current != null) {
            current = current.next;
            currentPosition++;
        }
        if (current == null || current.next == null) {
            System.out.println("Invalid position");
            return;
        }
        current.next = current.next.next;
    }


    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class LinkList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert at a specific position");
            System.out.println("4. Delete at the beginning");
            System.out.println("5. Delete at the end");
            System.out.println("6. Delete at a specific position");
            System.out.println("7. Display the linked list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to insert at the beginning: ");
                    int data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter the data to insert at the end: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter the data to insert: ");
                    data = scanner.nextInt();
                    System.out.print("Enter the position to insert at: ");
                    int position = scanner.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    list.deleteAtBeginning();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter the position to delete from: ");
                    position = scanner.nextInt();
                    list.deleteAtPosition(position);
                    break;
                case 7:
                    System.out.println("Linked List:");
                    list.display();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
