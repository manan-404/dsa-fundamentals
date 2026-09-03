public class bubbleSelectionInsertionComparison {

    static void bubbleSort(int[] arr) {
        int size = arr.length;
        int comparisons = 0, swaps = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Bubble Sort -> Comparisons: " + comparisons + ", Swaps: " + swaps);
        printArray(arr);
    }

    static void selectionSort(int[] arr) {
        int size = arr.length;
        int comparisons = 0, swaps = 0;

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }
        }
        System.out.println("Selection Sort -> Comparisons: " + comparisons + ", Swaps: " + swaps);
        printArray(arr);
    }

    static void insertionSort(int[] arr) {
        int size = arr.length;
        int comparisons = 0, swaps = 0;

        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    swaps++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        System.out.println("Insertion Sort -> Comparisons: " + comparisons + ", Swaps: " + swaps);
        printArray(arr);
    }

    static void printArray(int[] arr) {
        System.out.print("Sorted result: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    static void runAllSorts(String label, int[] arr) {
        System.out.println("\n--- " + label + " ---");
        System.out.print("Original: ");
        printArrayRaw(arr);
        bubbleSort(copyArray(arr));
        selectionSort(copyArray(arr));
        insertionSort(copyArray(arr));
    }

    static void printArrayRaw(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] randomArray = {5, 2, 9, 1, 6};
        int[] descendingArray = {9, 7, 5, 3, 1};
        int[] almostSortedArray = {1, 2, 4, 3, 5};

        runAllSorts("Random Array", randomArray);
        runAllSorts("Descending Array (worst case for most of these)", descendingArray);
        runAllSorts("Almost Sorted Array (best case for insertion sort)", almostSortedArray);
    }
}
