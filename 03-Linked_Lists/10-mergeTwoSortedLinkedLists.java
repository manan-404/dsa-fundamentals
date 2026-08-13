public class mergeTwoSortedLinkedLists {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static void addToBack(Node[] headTail, int data) {
        Node newNode = new Node(data);
        if (headTail[0] == null) {
            headTail[0] = headTail[1] = newNode;
            return;
        }
        headTail[1].next = newNode;
        headTail[1] = newNode;
    }

    // Merges two already-sorted lists into one sorted list - O(n + m)
    static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1); // placeholder to avoid special-casing the new head
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // attach whichever list still has leftover nodes
        tail.next = (head1 != null) ? head1 : head2;

        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node[] list1 = new Node[2];
        addToBack(list1, 1);
        addToBack(list1, 3);
        addToBack(list1, 5);

        Node[] list2 = new Node[2];
        addToBack(list2, 2);
        addToBack(list2, 4);
        addToBack(list2, 6);

        System.out.print("List 1: ");
        printList(list1[0]);
        System.out.print("List 2: ");
        printList(list2[0]);

        Node merged = merge(list1[0], list2[0]);
        System.out.print("Merged: ");
        printList(merged);
    }
}