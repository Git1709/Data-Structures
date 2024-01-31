import java.util.Scanner;

public class InsertionArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int N = scanner.nextInt();
        int[] LA = new int[N + 1];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            LA[i] = scanner.nextInt();
        }
        System.out.print("Enter the position (K) where you want to insert the element: ");
        int K = scanner.nextInt();
        if (K < 1 || K > N + 1) {
            System.out.println("Invalid position.");
            return;
        }
        K=K-1;
        System.out.print("Enter the element to be inserted: ");
        int ITEM = scanner.nextInt();
        int J = N-1;
        while (J >= K) {
            LA[J+1] = LA[J];
            J--;
        }
        LA[K] = ITEM;
        N++;
        System.out.println("Array after insertion:");
        for (int i = 0; i < N; i++) {
            System.out.print(LA[i] + " ");
        }
    }
}
