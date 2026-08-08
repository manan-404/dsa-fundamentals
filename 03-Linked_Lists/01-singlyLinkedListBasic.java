public class singlyLinkedListBasic {

    Node head;

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

    Integer getBackItem() {
        if (head == null) return null;
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        return curr.data;
    }

    void removeBackItem() {
        if (head == null) {
            System.out.println("The list is already empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) curr = curr.next;
        curr.next = null;
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
        prev.next = curr.next;
    }

    boolean isListEmpty() {
        return head == null;
    }

    void addKeyBeforeNode(int key, int before) {
        Node newNode = new Node(key);
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == before) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null && curr.next.data != before) curr = curr.next;
        if (curr.next == null) {
            System.out.println(before + " not found in list.");
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    void addKeyAfterNode(int key, int after) {
        Node newNode = new Node(key);
        Node curr = head;
        while (curr != null && curr.data != after) curr = curr.next;
        if (curr == null) {
            System.out.println(after + " not found in list.");
            return;
        }
        newNode.next = curr.next;
        curr.next = newNode;
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
        singlyLinkedListBasic list = new singlyLinkedListBasic();
        list.addToFront(5);
        list.addToFront(3);
        list.addToFront(10);
        System.out.println("Front: " + list.getFrontItem());
        list.removeFrontItem();
        System.out.println("Front after remove: " + list.getFrontItem());
        list.addToBack(7);
        System.out.println("Back: " + list.getBackItem());
        System.out.println("Find 3: " + list.find(3));
        list.removeKey(5);
        list.addKeyBeforeNode(100, 3);
        list.addKeyAfterNode(21, 7);
        list.printAll();
    }
}
