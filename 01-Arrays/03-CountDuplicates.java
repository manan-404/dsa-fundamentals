public class CountDuplicates {

    public static void main(String[] args) {
        int[] arr = {21, 9, 17, 43, 9, 15, 21, 6, 38, 6};
        int duplicateCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicateCount++;
                    break; // count this value once, move to next i
                }
            }
        }

        System.out.print("Array values are: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println("\nThe count of duplicate values is: " + duplicateCount);
    }
}
