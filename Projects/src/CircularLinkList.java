
import java.util.Scanner;

class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkList {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode; // Point to itself to create a circular link
            head = newNode;
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode; // Point to itself to create a circular link
            head = newNode;
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;
            tail.next = newNode;
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

        Node newNode = new Node(data);
        Node current = head;
        int currentPosition = 1;

        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Invalid position. The list is shorter than the specified position.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            Node prev = null;
            while (current.next != head) {
                prev = current;
                current = current.next;
            }
            prev.next = head;
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

        Node current = head;
        Node prev = null;
        int currentPosition = 1;

        while (current != null && currentPosition < position) {
            prev = current;
            current = current.next;
            currentPosition++;
        }

        if (current == null) {
            System.out.println("Invalid position. The list is shorter than the specified position.");
        } else {
            prev.next = current.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkList list = new CircularLinkList();

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
                    System.out.print("Circular Linked List: ");
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