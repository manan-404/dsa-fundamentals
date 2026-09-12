public class heapSort extends maxHeap {

    public heapSort(int capacity) {
        super(capacity);
    }

    // Builds on the max-heap this class extends:
    // repeatedly swap the max (root) with the last unsorted element, shrink the heap by one,
    // then heapify-down the new root - each extraction places one more element in its final sorted spot.
    public void sort() {
        int n = size;
        for (int i = n - 1; i >= 1; i--) {
            swap(0, i);           // move current max to the end (its final sorted position)
            heapifyDown(0, i);    // restore heap property within the shrinking unsorted region
        }
    }

    public static void main(String[] args) {
        heapSort sorter = new heapSort(10);
        sorter.insert(20);
        sorter.insert(15);
        sorter.insert(30);
        sorter.insert(40);
        sorter.insert(10);

        System.out.println("Array before HeapSort:");
        sorter.display();

        sorter.sort();

        System.out.println("Array after HeapSort:");
        sorter.display();
    }
}
