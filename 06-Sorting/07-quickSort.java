public class quickSort {

    // Divide-and-conquer, O(n log n) average, O(n^2) worst case (already-sorted/reverse-sorted
    // input with this pivot choice is the classic worst case to be aware of)
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return; // base case: 0 or 1 element
        }

        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    // Lomuto partition scheme - picks the last element as pivot
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // boundary of elements known to be <= pivot

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // place pivot in its correct final position
        return i + 1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.print("Before sorting: ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.print("After sorting:  ");
        printArray(arr);
    }
}
