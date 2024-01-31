
import java.util.Scanner;

class Node3 {
    int data;
    Node3 next;
    Node3 prev;

    public Node3(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node3 head;
    Node3 tail;

    public void insertAtBeginning(int data) {
        Node3 newNode = new Node3(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node3 newNode = new Node3(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAtSpecificLocation(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be 1 or greater.");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node3 newNode = new Node3(data);
        Node3 current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Invalid position. The list is shorter than the specified position.");
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteAtSpecificLocation(int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be 1 or greater.");
            return;
        }

        if (position == 1) {
            deleteAtBeginning();
            return;
        }

        Node3 current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null || current.next == null) {
            System.out.println("Invalid position. The list is shorter than the specified position.");
        } else {
            Node3 nodeToDelete = current.next;
            current.next = nodeToDelete.next;
            if (nodeToDelete.next != null) {
                nodeToDelete.next.prev = current;
            }
        }
    }

    public void display() {
        Node3 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.print("Enter the number of nodes to create: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            int data = scanner.nextInt();
            list.insertAtEnd(data);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert at a specific location");
            System.out.println("4. Delete at the beginning");
            System.out.println("5. Delete at the end");
            System.out.println("6. Delete at a specific location");
            System.out.println("7. Display the list");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at the beginning: ");
                    int dataAtBeginning = scanner.nextInt();
                    list.insertAtBeginning(dataAtBeginning);
                    break;
                case 2:
                    System.out.print("Enter data to insert at the end: ");
                    int dataAtEnd = scanner.nextInt();
                    list.insertAtEnd(dataAtEnd);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    int dataToInsert = scanner.nextInt();
                    System.out.print("Enter position to insert at: ");
                    int positionToInsert = scanner.nextInt();
                    list.insertAtSpecificLocation(dataToInsert, positionToInsert);
                    break;
                case 4:
                    list.deleteAtBeginning();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete from: ");
                    int positionToDelete = scanner.nextInt();
                    list.deleteAtSpecificLocation(positionToDelete);
                    break;
                case 7:
                    System.out.print("Doubly Linked List: ");
                    list.display();
                    break;
                case 8:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}






