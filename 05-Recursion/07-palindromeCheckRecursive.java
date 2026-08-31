public class palindromeCheckRecursive {

    static boolean isPalindrome(int start, int end, char[] arr) {
        if (start >= end) {
            return true; // base case: pointers met or crossed
        }
        if (arr[start] != arr[end]) {
            return false;
        }
        return isPalindrome(start + 1, end - 1, arr);
    }

    static boolean isPalindrome(String word) {
        char[] arr = word.toLowerCase().toCharArray();
        return isPalindrome(0, arr.length - 1, arr);
    }

    public static void main(String[] args) {
        String[] tests = {"refer", "hello", "racecar"};
        for (String word : tests) {
            System.out.println("Is \"" + word + "\" a palindrome? " + isPalindrome(word));
        }
    }
}
