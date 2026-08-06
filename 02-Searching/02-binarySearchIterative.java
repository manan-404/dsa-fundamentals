public class binarySearchIterative {

    // O(log n) - requires sorted array
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
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 9, 12, 18, 22};

        System.out.println("Searching for 12: index " + search(arr, 12));
        System.out.println("Searching for 4: index " + search(arr, 4));
    }
}
