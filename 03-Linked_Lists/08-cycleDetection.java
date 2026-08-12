public class cycleDetection {

    Node head;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    void addToBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }

    // Floyd's Cycle Detection (tortoise and hare) - O(n) time, O(1) space
    boolean hasCycle(Node startNode) {
        if (startNode == null) return false;

        Node slow = startNode;
        Node fast = startNode;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // pointers met -> cycle exists
            }
        }
        return false; // fast reached the end -> no cycle
    }

    public static void main(String[] args) {
        cycleDetection list = new cycleDetection();
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        list.addToBack(4);

        System.out.println("List without cycle -> hasCycle: " + list.hasCycle(list.head));

        // manually creating a cycle: 4 -> 2 (as in the example: 1->2->3->4->2)
        Node third = list.head.next.next;      // node 3
        Node fourth = third.next;               // node 4
        Node second = list.head.next;           // node 2
        fourth.next = second;                   // create the cycle

        System.out.println("List with cycle (4 -> 2) -> hasCycle: " + list.hasCycle(list.head));
    }
}
