public class indexBasedLinkedList {

    Node head, tail;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Integer get(int index) {
        if (index < 0) return null;
        Node curr = head;
        int count = 0;
        while (curr != null) {
            if (count == index) return curr.data;
            curr = curr.next;
            count++;
        }
        return null; // index out of range
    }

    void insertAt(int index, int data) {
        if (index < 0) {
            System.out.println("Invalid index: " + index);
            return;
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) tail = newNode;
            System.out.println(data + " inserted at index " + index);
            return;
        }
        Node prev = head;
        int count = 0;
        while (prev != null && count < index - 1) {
            prev = prev.next;
            count++;
        }
        if (prev == null) {
            System.out.println("Index " + index + " out of range, insert failed.");
            return;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        if (newNode.next == null) tail = newNode;
        System.out.println(data + " inserted at index " + index);
    }

    void removeFrom(int index) {
        if (head == null || index < 0) {
            System.out.println("Invalid removal at index " + index);
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
            System.out.println("Index 0 removed.");
            return;
        }
        Node prev = head;
        int count = 0;
        while (prev.next != null && count < index - 1) {
            prev = prev.next;
            count++;
        }
        if (prev.next == null) {
            System.out.println("Index " + index + " out of range, removal failed.");
            return;
        }
        prev.next = prev.next.next;
        if (prev.next == null) tail = prev;
        System.out.println("Index " + index + " removed.");
    }

    int getSize() {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    void showList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curr = head;
        System.out.print("Elements: ");
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        indexBasedLinkedList list = new indexBasedLinkedList();
        System.out.println("Size: " + list.getSize());
        list.insertAt(0, 12);
        list.insertAt(1, 24);
        list.insertAt(0, 51);
        list.insertAt(1, 99);
        list.showList();
        System.out.println("Size: " + list.getSize());
        System.out.println("get(2): " + list.get(2));
        list.removeFrom(0);
        list.showList();
    }
}