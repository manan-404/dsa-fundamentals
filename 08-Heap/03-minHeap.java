public class minHeap {

    protected int[] heap;
    protected int size;
    protected int capacity;

    public minHeap(int capacity) {
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

        // heapify up: bubble the new value toward the root while it's SMALLER than its parent
        while (current != 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        return heap[0];
    }

    protected void heapifyDown(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
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
        minHeap heap = new minHeap(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(5);
        heap.insert(10);

        System.out.println("After inserting elements:");
        heap.display();
        System.out.println("Minimum value: " + heap.getMin());
        System.out.println("Extracted min: " + heap.extractMin());
        System.out.println("Heap after extracting min:");
        heap.display();
    }
}
