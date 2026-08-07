public class exponentialSearch {

    // O(log n) - useful for unbounded/very large sorted arrays
    // Finds a range where the target could exist, then binary searches within it
    public static int search(int[] arr, int target) {
        int n = arr.length;
        if (arr[0] == target) {
            return 0;
        }

        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }

        return binarySearch(arr, target, i / 2, Math.min(i, n - 1));
    }

    private static int binarySearch(int[] arr, int target, int low, int high) {
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
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};

        System.out.println("Searching for 16: index " + search(arr, 16));
        System.out.println("Searching for 5: index " + search(arr, 5));
    }
}
