public class MergeSortedArrays {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
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

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9};
        int[] arr2 = {1, 4, 7};

        int[] merged = mergeArrays(arr1, arr2);
        for (int val : merged) System.out.print(val + " ");
    }
}
