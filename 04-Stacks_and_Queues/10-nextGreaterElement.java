import java.util.Stack;

public class nextGreaterElement {

    // Monotonic stack approach - O(n) instead of the O(n^2) brute force
    static int[] findNextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> indexStack = new Stack<>(); // holds indices, values kept decreasing bottom to top

        for (int i = 0; i < n; i++) {
            // current element is bigger than whatever the stack's top index points to
            while (!indexStack.isEmpty() && arr[indexStack.peek()] < arr[i]) {
                result[indexStack.pop()] = arr[i];
            }
            indexStack.push(i);
        }

        // anything left in the stack has no greater element to its right
        while (!indexStack.isEmpty()) {
            result[indexStack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7, 8};
        int[] result = findNextGreater(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " -> next greater: " + result[i]);
        }
    }
}