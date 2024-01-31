import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        int i, ArraySize;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of Array: ");
        ArraySize = sc.nextInt();
        int[] Arr = new int[ArraySize];
        System.out.println("Enter elements: " );
        for (i = 0; i < ArraySize; i++) {

            Arr[i] = sc.nextInt();
        }
        Arrays.sort(Arr);
        System.out.println("Sorted list:");
        for(i=0;i<Arr.length;i++){
            System.out.println(Arr[i]);
        }
        System.out.println("Enter element to search: ");
        int searchElement = sc.nextInt();
        int start = 0;
        int end = Arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (Arr[mid] == searchElement) {
                result = mid;
                break;
            } else if (Arr[mid] < searchElement) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element is at position " + (result+1));
        }
    }
}
