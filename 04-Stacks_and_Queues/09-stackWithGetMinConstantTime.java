import java.util.Stack;

public class stackWithGetMinConstantTime {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>(); // top always holds current minimum

    void push(int data) {
        mainStack.push(data);
        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    Integer pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        int popped = mainStack.pop();
        if (popped == minStack.peek()) {
            minStack.pop(); // this value was the current min - retire it too
        }
        return popped;
    }

    Integer getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return minStack.peek(); // O(1) - just a peek, no scanning
    }

    public static void main(String[] args) {
        stackWithGetMinConstantTime stack = new stackWithGetMinConstantTime();
        int[] values = {5, 2, 8, 1, 1, 9};

        for (int v : values) {
            stack.push(v);
            System.out.println("Pushed " + v + " | Current min: " + stack.getMin());
        }

        for (int i = 0; i < values.length; i++) {
            System.out.println("Popped: " + stack.pop() + " | Min now: " + stack.getMin());
        }
    }
}