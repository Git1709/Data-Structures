import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
    Create an array of integer with size n. Return the difference between the largest and the smallest value inside that array.
*/

    public static void main(String[] args) {
        int Array_size;

        System.out.println("Enter the Size of the Array : ");
        Scanner UserIn = new Scanner(System.in);
        Array_size= UserIn.nextInt();
        int[] array1= new int[Array_size];
        System.out.println("Enter elements of array : ");
        for(int i=0;i<Array_size;i++){
            array1[i]= UserIn.nextInt();
        }
        Arrays.sort(array1);
        System.out.println("Minimum element is : "+array1[0]+"\nMaximum element is : "+array1[Array_size-1]);
        System.out.println("Difference between minimum and maximum elements in array is : "+ (array1[Array_size-1] -array1[0]));
    }

}