public class kadaneMaxSubarray {

    // Kadane's Algorithm: O(n) max subarray sum
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array: {-2, 1, -3, 4, -1, 2, 1, -5, 4}");
        System.out.println("Max subarray sum: " + maxSubArraySum(arr1)); // expected 6 (4,-1,2,1)

        int[] arr2 = {5, 4, -1, 7, 8};
        System.out.println("\nArray: {5, 4, -1, 7, 8}");
        System.out.println("Max subarray sum: " + maxSubArraySum(arr2)); // expected 23
    }
}