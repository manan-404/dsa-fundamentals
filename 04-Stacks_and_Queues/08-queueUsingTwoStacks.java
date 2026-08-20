import java.util.Stack;

public class queueUsingTwoStacks {

    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    void enQueue(int data) {
        inStack.push(data);
    }

    Integer deQueue() {
        if (outStack.isEmpty()) {
            // only transfer when outStack runs dry - this is what keeps it efficient
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return outStack.pop();
    }

    Integer getFront() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return outStack.peek();
    }

    boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    int getSize() {
        return inStack.size() + outStack.size();
    }

    void printAll() {
        System.out.print("Queue (front to rear): ");
        for (int i = outStack.size() - 1; i >= 0; i--) System.out.print(outStack.get(i) + " ");
        for (int val : inStack) System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        queueUsingTwoStacks queue = new queueUsingTwoStacks();
        System.out.println("Is empty? " + queue.isEmpty());

        for (int i = 1; i <= 5; i++) {
            queue.enQueue(i * 10);
            System.out.println("Enqueued: " + (i * 10));
        }
        queue.printAll();
        System.out.println("Front: " + queue.getFront());
        System.out.println("Size: " + queue.getSize());

        System.out.println("Dequeued: " + queue.deQueue());
        queue.printAll();

        queue.enQueue(60);
        queue.printAll();

        System.out.println("Dequeueing all:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.deQueue());
        }
    }
}
