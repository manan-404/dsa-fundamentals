import java.util.Scanner;

public class ColumnMagicCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];

        System.out.println("Enter values for 3x3 array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter at (" + (i + 1) + "," + (j + 1) + "): ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Array values are:");
        for (int[] row : arr) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }

        int firstColSum = 0;
        for (int i = 0; i < arr.length; i++) firstColSum += arr[i][0];

        boolean isColumnMagic = true;
        for (int col = 1; col < arr[0].length; col++) {
            int colSum = 0;
            for (int i = 0; i < arr.length; i++) colSum += arr[i][col];
            if (colSum != firstColSum) {
                isColumnMagic = false;
                break;
            }
        }

        System.out.println(isColumnMagic ? "The array is Column-Magic" : "The array is not Column-Magic");
    }
}
