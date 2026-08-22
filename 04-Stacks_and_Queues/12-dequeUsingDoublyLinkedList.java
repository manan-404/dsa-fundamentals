public class dequeUsingDoublyLinkedList {

    Node front, rear;
    int size = 0;

    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    void addFront(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    void addRear(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    Integer removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return null;
        }
        int data = front.data;
        front = front.next;
        if (front == null) rear = null;
        else front.prev = null;
        size--;
        return data;
    }

    Integer removeRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return null;
        }
        int data = rear.data;
        rear = rear.prev;
        if (rear == null) front = null;
        else rear.next = null;
        size--;
        return data;
    }

    Integer peekFront() { return isEmpty() ? null : front.data; }
    Integer peekRear() { return isEmpty() ? null : rear.data; }
    boolean isEmpty() { return size == 0; }
    int getSize() { return size; }

    void printAll() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque (front to rear): ");
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        dequeUsingDoublyLinkedList deque = new dequeUsingDoublyLinkedList();
        deque.addRear(10);
        deque.addRear(20);
        deque.addFront(5);
        deque.printAll();

        System.out.println("Removed from front: " + deque.removeFront());
        System.out.println("Removed from rear: " + deque.removeRear());
        deque.printAll();

        System.out.println("Peek front: " + deque.peekFront());
        System.out.println("Size: " + deque.getSize());
    }
}
