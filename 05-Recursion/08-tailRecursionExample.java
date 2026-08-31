public class tailRecursionExample {

    // Tail-recursive: the recursive call is the LAST action, nothing happens after it returns.
    // NOTE: Java does NOT optimize tail calls (unlike some functional languages) -
    // this still uses one stack frame per call, and WILL overflow for large n.
    // It's shown here purely to demonstrate the pattern, not as a performance trick in Java.
    static int factorialTailRecursive(int n, int accumulator) {
        if (n == 0 || n == 1) {
            return accumulator; // no pending multiplication after this returns
        }
        return factorialTailRecursive(n - 1, n * accumulator);
    }

    // Compare: the regular version (like file 02) is NOT tail-recursive -
    // "n * factorial(n - 1)" still has work (the multiplication) waiting
    // to happen AFTER the recursive call returns.
    static int factorialRegular(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRegular(n - 1); // multiplication happens after the call returns
    }

    public static void main(String[] args) {
        int input = 5;
        System.out.println("Tail-recursive factorial(" + input + ") = " +
                factorialTailRecursive(input, 1));
        System.out.println("Regular factorial(" + input + ") = " +
                factorialRegular(input));
    }
}
