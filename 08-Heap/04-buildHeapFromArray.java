public class buildHeapFromArray {

    // Builds a max-heap from an existing array in O(n) - NOT O(n log n).
    // Key idea: heapify-down starting from the LAST non-leaf node, working backward to the root.
    // Leaf nodes are already valid single-element heaps, so there's no need to touch them.
    static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        int lastNonLeaf = (n / 2) - 1;

        for (int i = lastNonLeaf; i >= 0; i--) {
            heapifyDown(arr, i, n);
        }
    }

    static void heapifyDown(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyDown(arr, largest, n);
        }
    }

    static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1, 8, 9, 2};

        System.out.print("Before building heap: ");
        printArray(arr);

        buildMaxHeap(arr);

        System.out.print("After building heap:  ");
        printArray(arr);
    }
}
