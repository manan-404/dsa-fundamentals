public class doublyLinkedListBasic {

    Node head;

    static class Node {
        int data;
        Node next, prev;
        Node(int data) {
            this.data = data;
        }
    }

    void addToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
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
        if (head != null) head.prev = null;
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
        newNode.prev = curr;
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
        while (curr.next != null) curr = curr.next;
        curr.prev.next = null;
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
            System.out.println("The list is already empty.");
            return;
        }
        if (head.data == key) {
            head = head.next;
            if (head != null) head.prev = null;
            System.out.println(key + " has been removed.");
            return;
        }
        Node curr = head;
        while (curr != null && curr.data != key) curr = curr.next;
        if (curr == null) {
            System.out.println(key + " not found in list.");
            return;
        }
        curr.prev.next = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;
        System.out.println(key + " has been removed from list.");
    }

    boolean isListEmpty() {
        return head == null;
    }

    // Inserts `key` before the node containing `targetValue`
    void addKeyBeforeNode(int key, int targetValue) {
        Node newNode = new Node(key);
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == targetValue) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            System.out.println(key + " inserted at head.");
            return;
        }
        Node curr = head;
        while (curr != null && curr.data != targetValue) curr = curr.next;
        if (curr == null) {
            System.out.println(targetValue + " not found in list.");
            return;
        }
        newNode.prev = curr.prev;
        newNode.next = curr;
        curr.prev.next = newNode;
        curr.prev = newNode;
        System.out.println(key + " inserted before " + targetValue);
    }

    // Inserts `key` after the node containing `targetValue`
    void addKeyAfterNode(int key, int targetValue) {
        Node newNode = new Node(key);
        Node curr = head;
        while (curr != null && curr.data != targetValue) curr = curr.next;
        if (curr == null) {
            System.out.println(targetValue + " not found in list.");
            return;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        if (curr.next != null) curr.next.prev = newNode;
        curr.next = newNode;
        System.out.println(key + " inserted after " + targetValue);
    }

    void printAll() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doublyLinkedListBasic list = new doublyLinkedListBasic();
        list.addToFront(10);
        list.addToFront(100);
        System.out.println("Front: " + list.getFrontItem());
        list.removeFrontItem();
        list.addToBack(250);
        System.out.println("Back: " + list.getBackItem());
        System.out.println("Find 250: " + list.find(250));
        list.printAll();
        list.addKeyBeforeNode(9, 10);
        list.printAll();
        list.addKeyAfterNode(44, 9);
        list.printAll();
    }
}