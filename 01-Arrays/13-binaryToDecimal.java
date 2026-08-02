import java.util.Scanner;

public class BinaryToDecimal {

    public static int binaryToDecimal(int[] bits) {
        int decimal = 0;
        for (int bit : bits) {
            decimal = decimal * 2 + bit;
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bits: ");
        int size = sc.nextInt();
        int[] bits = new int[size];

        System.out.println("Enter bits (0 or 1), left to right (MSB first):");
        for (int i = 0; i < size; i++) {
            System.out.print("Bit " + (i + 1) + ": ");
            bits[i] = sc.nextInt();
            while (bits[i] != 0 && bits[i] != 1) {
                System.out.print("Not binary, enter again: ");
                bits[i] = sc.nextInt();
            }
        }

        System.out.println("Decimal value: " + binaryToDecimal(bits));
    }
}
