import java.util.Stack;

public class reverseStackUsingRecursion {

    static Stack<Integer> reverse(Stack<Integer> input, Stack<Integer> output) {
        if (!input.isEmpty()) {
            output.push(input.pop());
            reverse(input, output);
        }
        return output;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) stack.push(i);

        System.out.print("Original: ");
        for (int x : stack) System.out.print(x + " ");

        Stack<Integer> reversed = reverse(stack, new Stack<>());
        System.out.print("\nReversed: ");
        for (int x : reversed) System.out.print(x + " ");
    }
}
