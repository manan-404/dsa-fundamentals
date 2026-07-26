import java.util.Scanner;

public class MergeTwoArrays {

    static Scanner sc = new Scanner(System.in);

    static void readArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter size of array 1: ");
        int size1 = sc.nextInt();
        System.out.print("Enter size of array 2: ");
        int size2 = sc.nextInt();

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        System.out.println("Enter values for array 1:");
        readArray(arr1);
        System.out.println("Enter values for array 2:");
        readArray(arr2);

        int[] combined = new int[size1 + size2];
        for (int i = 0; i < size1; i++) combined[i] = arr1[i];
        for (int i = 0; i < size2; i++) combined[size1 + i] = arr2[i];

        System.out.print("Array 1: ");
        printArray(arr1);
        System.out.print("\nArray 2: ");
        printArray(arr2);
        System.out.println("\nCombined array (array1 + array2):");
        printArray(combined);
    }
}
