public class factorialRecursive {

    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int input = 3;
        System.out.println("Factorial of " + input + " is: " + factorial(input));

        input = 5;
        System.out.println("Factorial of " + input + " is: " + factorial(input));
    }
}
