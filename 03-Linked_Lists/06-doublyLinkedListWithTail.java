public class doublyLinkedListWithTail {

    Node head, tail;

    static class Node {
        int data;
        Node next, prev;
        Node(int data) {
            this.data = data;
        }
    }

    void addToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    Integer getFrontItem() {
        return (head == null) ? null : head.data;
    }

    void removeFrontItem() {
        if (head == null) {
            System.out.println("The list is already empty.");
            return;
        }
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
    }

    void addToBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    Integer getBackItem() {
        return (tail == null) ? null : tail.data;
    }

    void removeBackItem() {
        if (head == null) {
            System.out.println("The list is already empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    boolean find(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) return true;
            curr = curr.next;
        }
        return false;
    }

    void removeKey(int key) {
        if (head == null) {
            System.out.println("The list is already empty.");
            return;
        }
        if (head.data == key) {
            removeFrontItem();
            return;
        }
        if (tail.data == key) {
            removeBackItem();
            return;
        }
        Node curr = head;
        while (curr != null && curr.data != key) curr = curr.next;
        if (curr == null) {
            System.out.println(key + " not found in list.");
            return;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        System.out.println(key + " has been removed from list.");
    }

    void printAll() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    void printInReverseOrder() {
        if (tail == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doublyLinkedListWithTail list = new doublyLinkedListWithTail();
        list.addToFront(20);
        list.addToFront(15);
        list.addToBack(50);
        list.printAll();
        list.printInReverseOrder();
        list.removeKey(20);
        list.printAll();
    }
}