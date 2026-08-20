import java.util.Stack;

public class sortStackUsingOneExtraStack {

    // Sorts so the smallest item ends up on top, using only one extra stack.
    static Stack<Integer> sortStack(Stack<Integer> unsorted) {
        Stack<Integer> temp = new Stack<>();

        while (!unsorted.isEmpty()) {
            int current = unsorted.pop();

            // move everything smaller than 'current' back to unsorted
            while (!temp.isEmpty() && temp.peek() < current) {
                unsorted.push(temp.pop());
            }
            temp.push(current);
        }

        // temp is now sorted with largest on top - flip it back so smallest is on top
        while (!temp.isEmpty()) {
            unsorted.push(temp.pop());
        }
        return unsorted;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(40);
        stack.push(20);

        System.out.println("Before sorting: " + stack);
        sortStack(stack);
        System.out.println("After sorting (smallest on top): " + stack);
    }
}
