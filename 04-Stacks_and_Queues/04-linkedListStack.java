public class linkedListStack {

    Node top;
    int size = 0;

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    boolean isEmpty() { return top == null; }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("The stack is already empty.");
            return -1;
        }
        int temp = top.data;
        top = top.next;
        size--;
        return temp;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return -1;
        }
        return top.data;
    }

    int getSize() { return size; }

    void printAll() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.print("Stack elements (top first): ");
        Node curr = top;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedListStack stack = new linkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printAll();
        stack.pop();
        System.out.println("Top: " + stack.peek());
        stack.printAll();
    }
}