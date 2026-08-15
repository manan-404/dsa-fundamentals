public class linkedListQueue {

    Node front, rear;
    int size = 0;

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    void enQueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty.");
            return -1;
        }
        int temp = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return temp;
    }

    boolean isEmpty() { return front == null; }

    int getFront() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return -1;
        }
        return front.data;
    }

    int getSize() { return size; }

    void printAll() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedListQueue queue = new linkedListQueue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.printAll();
        System.out.println(queue.deQueue() + " removed");
        queue.printAll();
        System.out.println("Size: " + queue.getSize());
        System.out.println("Front: " + queue.getFront());
    }
}