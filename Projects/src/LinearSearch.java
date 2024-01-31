import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int ArraySize,K,j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of Array : ");

        ArraySize = sc.nextInt();
        int[] LA = new int[ArraySize];
        System.out.println("Enter elements ");
        for (int i = 0; i < ArraySize; i++) {
            LA[i] = sc.nextInt();
        }
        System.out.println("Enter Item to find location");
        K = sc.nextInt();
        for (j=0;j<ArraySize;j++){
            if (LA[j]==K) {
                System.out.println("Position of Item is "+(j+1));
                break;
            }
        }
    }
}