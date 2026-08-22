public class recursiveBinarySearch {

    static boolean search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    static boolean search(int[] arr, int target, int low, int high) {
        if (low > high) {
            return false; // search space exhausted - not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] < target) {
            return search(arr, target, mid + 1, high);
        } else {
            return search(arr, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        System.out.println("Searching for 3: " + search(arr, 3));
        System.out.println("Searching for 100: " + search(arr, 100));
    }
}
