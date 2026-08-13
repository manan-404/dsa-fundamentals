public class middleElementLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    void addToFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Slow/fast pointer technique - O(n), single pass
    // For even-length lists, this returns the SECOND of the two middle elements
    Integer middleElement() {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        middleElementLinkedList list = new middleElementLinkedList();
        System.out.println("Middle of empty list: " + list.middleElement());

        list.addToFront(10);
        list.addToFront(20);
        list.addToFront(30);
        list.addToFront(40);
        list.addToFront(50);
        // list is: 50 -> 40 -> 30 -> 20 -> 10
        System.out.println("Middle (odd length, 5 elements): " + list.middleElement()); // expected 30

        list.addToFront(60);
        // list is: 60 -> 50 -> 40 -> 30 -> 20 -> 10
        System.out.println("Middle (even length, 6 elements): " + list.middleElement()); // expected 30
    }
}