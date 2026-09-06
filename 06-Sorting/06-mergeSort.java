public class mergeSort {

    // Divide-and-conquer, O(n log n) guaranteed (worst, average, and best case)
    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return; // base case: 0 or 1 element, already "sorted"
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);       // sort left half
        mergeSort(arr, mid + 1, high);  // sort right half
        merge(arr, low, mid, high);     // merge the two sorted halves
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        // copy merged result back into the original array
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }

    static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.print("Before sorting: ");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("After sorting:  ");
        printArray(arr);
    }
}
