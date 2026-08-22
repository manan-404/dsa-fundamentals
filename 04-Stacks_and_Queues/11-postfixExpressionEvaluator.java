import java.util.Stack;

public class postfixExpressionEvaluator {

    // Evaluates a postfix (Reverse Polish) expression, e.g. "23+4*" = (2+3)*4 = 20
    static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // single-digit operands only, keeps this simple
            } else if (isOperator(c)) {
                int b = stack.pop(); // second operand comes off first
                int a = stack.pop();
                stack.push(applyOperator(a, b, c));
            }
            // spaces or anything else are ignored
        }
        return stack.pop();
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static int applyOperator(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String[] expressions = {"23+4*", "52*3+", "82/3-"};
        for (String expr : expressions) {
            System.out.println(expr + " = " + evaluate(expr));
        }
    }
}
