public class removeNthFromEnd {

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

    // Two-pointer gap technique - single pass, O(n) time, O(1) space
    static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        // move fast n+1 steps ahead, creating a gap of n between slow and fast
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                System.out.println("n is larger than list length.");
                return head;
            }
            fast = fast.next;
        }

        // move both until fast hits the end - slow lands right before the node to remove
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // skip the target node
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
        Node[] list = new Node[2];
        addToBack(list, 10);
        addToBack(list, 20);
        addToBack(list, 30);
        addToBack(list, 40);
        addToBack(list, 50);

        System.out.print("Original: ");
        printList(list[0]);

        Node result = removeNthFromEnd(list[0], 2); // should remove 40 (2nd from end)
        System.out.print("After removing 2nd-from-end: ");
        printList(result);
    }
}