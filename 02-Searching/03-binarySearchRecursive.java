public class binarySearchRecursive {

    // O(log n) time, O(log n) space due to recursion stack
    public static int search(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // base case: not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return search(arr, target, mid + 1, high);
        } else {
            return search(arr, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 9, 12, 18, 22};

        System.out.println("Searching for 18: index " + search(arr, 18, 0, arr.length - 1));
        System.out.println("Searching for 7: index " + search(arr, 7, 0, arr.length - 1));
    }
}
