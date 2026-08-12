public class circularLinkedList {

    Node head, tail;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    void addToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    void addToBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("The list is already empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    void deleteFromEnd() {
        if (head == null) {
            System.out.println("The list is already empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node curr = head;
        while (curr.next != tail) curr = curr.next;
        curr.next = head;
        tail = curr;
    }

    void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        circularLinkedList list = new circularLinkedList();
        list.addToFront(50);
        list.addToBack(100);
        list.addToFront(30);
        list.printList();
        list.deleteFromEnd();
        list.deleteFromBeginning();
        list.printList();
    }
}
