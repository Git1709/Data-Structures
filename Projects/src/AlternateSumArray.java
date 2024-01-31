import java.util.Arrays;
import java.util.Scanner;

class AlternateSumArray {
    public static void main(String[] args) {
        int i, elementsOdd = 0, elementsEven = 0, elementsTotal = 0, ArrayLen; // Declaring variables
        Scanner in = new Scanner(System.in); // Declaring scanner
        System.out.println("Enter the number of elements: ");
        ArrayLen = in.nextInt();
        int[] inputArray = new int[ArrayLen]; // Declaring array
        System.out.print("Input " + ArrayLen + " elements: ");
        for (i = 0; i < ArrayLen; i++) {
            inputArray[i] = in.nextInt(); // Inputting elements of the array
        }
        for (i = 0; i < ArrayLen; i++) {
            elementsTotal = elementsTotal + inputArray[i]; // Adding total number of elements
            if (i % 2 != 0){
                elementsEven = elementsEven + inputArray[i]; // Adding number of even elements

            }
            else {
                elementsOdd = elementsOdd + inputArray[i]; // Adding number of odd elements
            }
        }

        System.out.println("Sum of all elements : " + elementsTotal);
        System.out.println("Sum of Odd alternate elements: " + elementsOdd); // Print the sum of odd elements
        System.out.println("Sum of Even alternate elements: " + elementsEven); // Print the sum of even elements
        Arrays.sort(inputArray);
        System.out.println("The second largest number in the array is " + inputArray[ArrayLen - 2]);
    }
}
