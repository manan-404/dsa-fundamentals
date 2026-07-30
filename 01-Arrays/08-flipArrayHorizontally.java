import java.util.Scanner;

public class FlipArrayHorizontally {

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

    static void flipHorizontally(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right = arr[i].length - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
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

        flipHorizontally(arr);
        System.out.println("Horizontally flipped array:");
        printArray(arr);
    }
}
