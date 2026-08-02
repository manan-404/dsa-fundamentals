public class DecimalToBinary {

    public static int[] decimalToBinary(int num) {
        int[] bits = new int[8]; // fixed 8-bit output, values 0-255
        for (int i = 7; i >= 0; i--) {
            bits[i] = num % 2;
            num /= 2;
        }
        return bits;
    }

    public static void main(String[] args) {
        int num = 5;
        int[] bits = decimalToBinary(num);

        System.out.println("Binary of " + num + ":");
        for (int bit : bits) System.out.print(bit + " ");

        System.out.println();
        num = 255;
        bits = decimalToBinary(num);
        System.out.println("Binary of " + num + ":");
        for (int bit : bits) System.out.print(bit + " ");
    }
}
