public class BinarySearchIndex {

    // Returns index of target if found, otherwise the index where it would be inserted.
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // insertion point
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println("Target 5 -> index: " + search(nums, 5));
        System.out.println("Target 2 -> index: " + search(nums, 2));
        System.out.println("Target 7 -> index: " + search(nums, 7));
    }
}
