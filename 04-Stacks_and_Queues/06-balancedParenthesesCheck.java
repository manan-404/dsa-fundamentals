import java.util.Stack;

public class balancedParenthesesCheck {

    static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // closing bracket with nothing open
                }
                char top = stack.pop();
                boolean matches = (top == '(' && c == ')') ||
                                   (top == '{' && c == '}') ||
                                   (top == '[' && c == ']');
                if (!matches) {
                    return false; // wrong type of bracket closed
                }
            }
        }
        return stack.isEmpty(); // balanced only if nothing left open
    }

    public static void main(String[] args) {
        String[] tests = {"({[]})", "[]{}()", "([)]", "(("};
        for (String test : tests) {
            System.out.println("\"" + test + "\" balanced: " + isBalanced(test));
        }
    }
}