import java.util.Stack;

public class palindromeCheckUsingStack {

    static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        // popping a stack naturally reverses order - compare against original
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return word.equals(reversed.toString());
    }

    public static void main(String[] args) {
        String[] tests = {"Moom", "hello", "racecar"};
        for (String word : tests) {
            System.out.println("\"" + word + "\" is palindrome: " + isPalindrome(word));
        }
    }
}