public class mergeTwoSortedViaInsertionSort {

    static int[] insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    static int[] mergeAndSort(int[] arr1, int[] arr2) {
        arr1 = insertionSort(arr1);
        arr2 = insertionSort(arr2);

        System.out.print("Array 1 sorted: ");
        printArray(arr1);
        System.out.print("Array 2 sorted: ");
        printArray(arr2);

        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) merged[k++] = arr1[i++];
        while (j < arr2.length) merged[k++] = arr2[j++];

        return merged;
    }

    static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 2, 1};
        int[] arr2 = {3, 6, 0, 8};

        int[] result = mergeAndSort(arr1, arr2);
        System.out.print("Final merged & sorted: ");
        printArray(result);
    }
}
