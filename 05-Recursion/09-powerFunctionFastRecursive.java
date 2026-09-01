public class powerFunctionFastRecursive {

    // Naive version - O(n), one recursive call per multiplication
    static long powerNaive(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * powerNaive(base, exponent - 1);
    }

    // Fast power (exponentiation by squaring) - O(log n)
    // Key idea: x^n = (x^(n/2))^2, adjusted for odd exponents
    static long powerFast(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        long half = powerFast(base, exponent / 2);
        long halfSquared = half * half;

        if (exponent % 2 == 0) {
            return halfSquared;
        } else {
            return base * halfSquared;
        }
    }

    public static void main(String[] args) {
        System.out.println("2^10 naive: " + powerNaive(2, 10));
        System.out.println("2^10 fast: " + powerFast(2, 10));

        System.out.println("3^13 naive: " + powerNaive(3, 13));
        System.out.println("3^13 fast: " + powerFast(3, 13));
    }
}
