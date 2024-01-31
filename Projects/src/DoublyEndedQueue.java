import java.util.Scanner;
class Deque {
    Node front, rear;
    int maxSize;
    int[] arrayDeque;
    int frontIndex, rearIndex;
    public Deque(int maxSize) {
        this.maxSize = maxSize;
        arrayDeque = new int[maxSize];
        front = null;
        rear = null;
        frontIndex = -1;
        rearIndex = 0;
    }
    void insertFront(int data) {
        if (frontIndex == -1) {
            arrayDeque[++frontIndex] = data;
            return;
        }
        if (frontIndex + 1 == rearIndex || (frontIndex == maxSize - 1 && rearIndex == 0)) {
            System.out.println("Deque is full. Cannot insert element at front.");
            return;
        }
        if (frontIndex == maxSize - 1) {
            frontIndex = 0;
        } else {
            frontIndex++;
        }
        arrayDeque[frontIndex] = data;
    }
    void insertRear(int data) {
        if (frontIndex == -1) {
            arrayDeque[++frontIndex] = data;
            return;
        }
        if (frontIndex + 1 == rearIndex || (frontIndex == maxSize - 1 && rearIndex == 0)) {
            System.out.println("Deque is full. Cannot insert element at rear.");
            return;
        }
        if (rearIndex == 0) {
            rearIndex = maxSize - 1;
        } else {
            rearIndex--;
        }
        arrayDeque[rearIndex] = data;
    }
    void deleteFront() {
        if (frontIndex == -1) {
            System.out.println("Deque is empty. Nothing to delete from front.");
            return;
        }
        if (frontIndex == rearIndex) {
            frontIndex = -1;
            rearIndex = 0;
        } else if (frontIndex == 0) {
            frontIndex = maxSize - 1;
        } else {
            frontIndex--;
        }
    }
    void deleteRear() {
        if (frontIndex == -1) {
            System.out.println("Deque is empty. Nothing to delete from rear.");
            return;
        }
        if (frontIndex == rearIndex) {
            frontIndex = -1;
            rearIndex = 0;
        } else if (rearIndex == maxSize - 1) {
            rearIndex = 0;
        } else {
            rearIndex++;
        }
    }
    void displayDeque() {
        if (frontIndex == -1) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.println("Elements of the deque:");
        if (frontIndex >= rearIndex) {
            for (int i = frontIndex; i >= rearIndex; i--) {
                System.out.print(arrayDeque[i] + " ");
            }
        } else {
            for (int i = frontIndex; i >= 0; i--) {
                System.out.print(arrayDeque[i] + " ");
            }
            for (int i = maxSize - 1; i >= rearIndex; i--) {
                System.out.print(arrayDeque[i] + " ");
            }
        }
        System.out.println();
    }
}
public class DoublyEndedQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the maximum size of the deque:");
        int maxSize = scanner.nextInt();
        Deque deque = new Deque(maxSize);
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Insert at front");
            System.out.println("2. Insert at rear");
            System.out.println("3. Delete from front");
            System.out.println("4. Delete from rear");
            System.out.println("5. Display deque");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to insert at front:");
                    int dataFront = scanner.nextInt();
                    deque.insertFront(dataFront);
                    break;
                case 2:
                    System.out.println("Enter element to insert at rear:");
                    int dataRear = scanner.nextInt();
                    deque.insertRear(dataRear);
                    break;
                case 3:
                    deque.deleteFront();
                    break;
                case 4:
                    deque.deleteRear();
                    break;
                case 5:
                    deque.displayDeque();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
    //private static class Node {
    //commented out node class because using public class from other files
      //  int data;
       // Node next;
        //Node prev;
        //public Node(int data) {
          //  this.data = data;
            //this.next = null;
            //this.prev = null;
        //}
    }
