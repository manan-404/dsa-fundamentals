public class fibonacciRecursive {

    // O(2^n) - exponential, since it recomputes the same sub-values repeatedly
    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n; // base cases: fib(0)=0, fib(1)=1
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 8; i++) {
            System.out.println("fibonacci(" + i + ") = " + fibonacci(i));
        }
    }
}
