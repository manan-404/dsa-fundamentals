public class arrayStack {

    int[] arr;
    int top;

    arrayStack(int capacity) {
        arr = new int[capacity];
        top = 0;
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("The stack is full.");
            return;
        }
        arr[top++] = data;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("The stack is already empty.");
            return -1;
        }
        return arr[--top];
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return -1;
        }
        return arr[top - 1];
    }

    int getSize() { return top; }
    boolean isEmpty() { return top == 0; }
    boolean isFull() { return top == arr.length; }

    void printAll() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.print("Stack (first to last): ");
        for (int i = 0; i < top; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        arrayStack stack = new arrayStack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printAll();
        System.out.println("Popped: " + stack.pop());
        stack.printAll();
        stack.push(40);
        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.getSize());
    }
}