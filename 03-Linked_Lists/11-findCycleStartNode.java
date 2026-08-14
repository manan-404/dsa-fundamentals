public class findCycleStartNode {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Floyd's algorithm, extended: after slow/fast meet inside the cycle,
    // reset one pointer to head and advance both one step at a time.
    // Where they meet again is the start of the cycle. O(n) time, O(1) space.
    static Node findCycleStart(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // this is the cycle's starting node
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; // cycle starts at node 2 (1 -> 2 -> 3 -> 4 -> 2)

        Node cycleStart = findCycleStart(n1);
        System.out.println("Cycle starts at node with data: " +
                (cycleStart != null ? cycleStart.data : "no cycle"));
    }
}