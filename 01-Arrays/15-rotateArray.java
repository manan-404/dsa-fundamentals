import java.util.Scanner;

public class rotateArray {

    static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

    // Rotates array left by k positions
    static int[] rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[i] = arr[(i + k) % n];
        }
        return rotated;
    }

    // Rotates array right by k positions
    static int[] rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();

        System.out.print("Enter rotation count k: ");
        int k = sc.nextInt();

        System.out.print("Original array: ");
        printArray(arr);

        System.out.print("Left rotated by " + k + ": ");
        printArray(rotateLeft(arr, k));

        System.out.print("Right rotated by " + k + ": ");
        printArray(rotateRight(arr, k));
    }
}