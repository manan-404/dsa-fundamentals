public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] original = {21, 9, 17, 43, 9, 15, 21, 6, 38, 6};
        int[] arr = original.clone();
        int newLength = arr.length;

        for (int i = 0; i < newLength; i++) {
            for (int j = i + 1; j < newLength; j++) {
                if (arr[i] == arr[j]) {
                    // shift left to remove arr[j]
                    for (int k = j; k < newLength - 1; k++) {
                        arr[k] = arr[k + 1];
                    }
                    newLength--;
                    j--;
                }
            }
        }

        System.out.print("Original array: ");
        for (int val : original) System.out.print(val + " ");

        System.out.print("\nArray after removing duplicates: ");
        for (int i = 0; i < newLength; i++) System.out.print(arr[i] + " ");

        System.out.println("\nSize of original array: " + original.length);
        System.out.println("Size of new array: " + newLength);
    }
}
