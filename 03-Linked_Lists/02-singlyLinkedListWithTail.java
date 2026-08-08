public class singlyLinkedListWithTail {

    Node head, tail;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void addToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
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
    }

    void addToBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
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
        Node curr = head;
        while (curr.next != tail) curr = curr.next;
        curr.next = null;
        tail = curr;
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
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == key) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }
        Node curr = head, prev = null;
        while (curr != null && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Can't remove " + key + ", not in list.");
            return;
        }
        if (curr == tail) tail = prev;
        prev.next = curr.next;
    }

    void printAll() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        singlyLinkedListWithTail list = new singlyLinkedListWithTail();
        list.addToFront(5);
        list.addToFront(3);
        list.addToBack(7);
        System.out.println("Front: " + list.getFrontItem() + " | Back: " + list.getBackItem());
        list.removeBackItem();
        System.out.println("Back after remove: " + list.getBackItem());
        list.printAll();
    }
}
