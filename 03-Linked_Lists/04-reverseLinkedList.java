public class reverseLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Classic 3-pointer in-place reversal — O(n) time, O(1) space
    void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next; // save next before overwriting
            curr.next = prev;      // reverse the link
            prev = curr;           // move prev forward
            curr = next;           // move curr forward
        }
        head = prev; // prev is the new head after the loop ends
    }

    void showList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        reverseLinkedList list = new reverseLinkedList();
        list.addFront(5);
        list.addFront(10);
        list.addFront(15);
        list.addFront(30);

        System.out.print("Original list: ");
        list.showList();

        list.reverse();

        System.out.print("Reversed list: ");
        list.showList();
    }
}