public class linkedListInsertionSort {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    Node head;
    Node sortedHead;

    void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    void insertionSort() {
        sortedHead = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sortedHead;
    }

    void sortedInsert(Node newNode) {
        if (sortedHead == null || sortedHead.data >= newNode.data) {
            newNode.next = sortedHead;
            sortedHead = newNode;
        } else {
            Node current = sortedHead;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedListInsertionSort list = new linkedListInsertionSort();
        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);

        System.out.print("Before sorting: ");
        list.printList();

        list.insertionSort();

        System.out.print("After sorting: ");
        list.printList();
    }
}
