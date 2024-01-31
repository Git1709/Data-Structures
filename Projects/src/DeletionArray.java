import java.util.Scanner;

public class DeletionArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements (N): ");
        int N = scanner.nextInt();

        int[] LA = new int[N];

        System.out.println("Enter the elements:");
        for (int i = 0; i < N; i++) {
            LA[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of K (1-based index): ");
        int K = scanner.nextInt();

        if (K <= N) {
            int ITEM = LA[K - 1];

            for (int j = K - 1; j < N - 1; j++) {
                LA[j] = LA[j + 1];
            }

            N--;
            System.out.println("Deleted element: " + ITEM);

            System.out.println("Updated array:");
            for (int i = 0; i < N; i++) {
                System.out.print(LA[i] + " ");
            }
        } else {
            System.out.println("Invalid value of K.");
        }

        scanner.close();
    }
}
