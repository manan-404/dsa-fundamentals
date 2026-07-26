import java.util.Scanner;

public class ReverseArrayCopy {

    static Scanner sc = new Scanner(System.in);

    static void readArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter value at position " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
    }

    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[(arr.length - 1) - i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        readArray(arr);
        System.out.print("Original array: ");
        printArray(arr);

        int[] reversed = reverseArray(arr);
        System.out.print("\nReversed array: ");
        printArray(reversed);
    }
}
