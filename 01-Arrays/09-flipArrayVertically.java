import java.util.Scanner;

public class FlipArrayVertically {

    static void readArray(int[][] arr, Scanner sc) {
        System.out.println("Enter values for 2D array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter at (" + (i + 1) + "," + (j + 1) + "): ");
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    static void flipVertically(int[][] arr) {
        int top = 0, bottom = arr.length - 1;
        while (top < bottom) {
            int[] temp = arr[top];
            arr[top] = arr[bottom];
            arr[bottom] = temp;
            top++;
            bottom--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];
        readArray(arr, sc);

        System.out.println("Original array:");
        printArray(arr);

        flipVertically(arr);
        System.out.println("Vertically flipped array:");
        printArray(arr);
    }
}
