import java.util.Scanner;

public class RowMagicCheck {

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

        int firstRowSum = 0;
        for (int val : arr[0]) firstRowSum += val;

        boolean isRowMagic = true;
        for (int i = 1; i < arr.length; i++) {
            int rowSum = 0;
            for (int val : arr[i]) rowSum += val;
            if (rowSum != firstRowSum) {
                isRowMagic = false;
                break;
            }
        }

        System.out.println(isRowMagic ? "The array is Row-Magic" : "The array is not Row-Magic");
    }
}
