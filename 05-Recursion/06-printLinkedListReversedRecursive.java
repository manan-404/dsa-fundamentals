import java.util.LinkedList;

public class printLinkedListReversedRecursive {

    static void printReversed(LinkedList<Integer> list) {
        if (!list.isEmpty()) {
            int first = list.getFirst();
            list.removeFirst();
            printReversed(list);   // go all the way to the end first...
            System.out.print(first + " "); // ...then print on the way back up
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) list.addFirst(i);

        System.out.print("Original order: ");
        for (int x : list) System.out.print(x + " ");

        System.out.print("\nReversed (recursive print): ");
        printReversed(list);
    }
}
