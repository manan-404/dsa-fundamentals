import java.util.LinkedList;

public class printLinkedListRecursive {

    static void printList(LinkedList<Integer> list) {
        if (!list.isEmpty()) {
            int first = list.getFirst();
            System.out.print(first + " ");
            list.removeFirst();
            printList(list);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) list.addFirst(i);

        System.out.print("List (forward, recursive print): ");
        printList(list);
    }
}
