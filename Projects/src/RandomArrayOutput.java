import java.util.Random;

public class RandomArrayOutput {
    public static void main(String[] args) {
        int[] randomArray = new int[10];
        Random random = new Random();

        // Initialize the array with ten random integers
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100); // Assuming random integers between 0 and 99 (inclusive)
        }

        // Print every element at an even index
        System.out.print("Elements at even index: ");
        for (int i = 0; i < randomArray.length; i += 2) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();

        // Print every odd element
        System.out.print("Odd elements: ");
        for (int num : randomArray) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // Print all elements in reverse order
        System.out.print("Elements in reverse order: ");
        for (int i = randomArray.length - 1; i >= 0; i--) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();

        // Print only the first and last element
        System.out.println("First element: " + randomArray[0]);
        System.out.println("Last element: " + randomArray[randomArray.length - 1]);
    }
}
