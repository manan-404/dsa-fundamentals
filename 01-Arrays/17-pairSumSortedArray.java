public class pairSumSortedArray {

    // Two-pointer approach: O(n) on a sorted array
    public static int[] findPairWithSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // no pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 9};
        int target = 10;

        int[] result = findPairWithSum(arr, target);
        if (result[0] == -1) {
            System.out.println("No pair found with sum " + target);
        } else {
            System.out.println("Pair found at indices " + result[0] + " and " + result[1]
                    + " -> values " + arr[result[0]] + " + " + arr[result[1]] + " = " + target);
        }
    }
}
