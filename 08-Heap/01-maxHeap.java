public class maxHeap {

    protected int[] heap;
    protected int size;
    protected int capacity;

    public maxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    protected int parent(int i) { return (i - 1) / 2; }
    protected int left(int i) { return 2 * i + 1; }
    protected int right(int i) { return 2 * i + 2; }

    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = val;
        int current = size;
        size++;

        // heapify up: bubble the new value toward the root while it's bigger than its parent
        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0, size);
        return max;
    }

    public int getMax() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        return heap[0];
    }

    // heapify down: push a value at index i toward the leaves while it's smaller than a child.
    // 'limit' controls how much of the array still counts as "the heap" - needed because
    // HeapSort (in the next file) reuses this same array as storage after shrinking the heap.
    protected void heapifyDown(int i, int limit) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < limit && heap[l] > heap[largest]) largest = l;
        if (r < limit && heap[r] > heap[largest]) largest = r;

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest, limit);
        }
    }

    protected void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void display() {
        System.out.print("Heap elements: ");
        for (int i = 0; i < size; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        maxHeap heap = new maxHeap(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);

        System.out.println("After inserting elements:");
        heap.display();
        System.out.println("Maximum value: " + heap.getMax());
        System.out.println("Extracted max: " + heap.extractMax());
        System.out.println("Heap after extracting max:");
        heap.display();

        heap.insert(50);
        System.out.println("Heap after inserting 50:");
        heap.display();
    }
}
