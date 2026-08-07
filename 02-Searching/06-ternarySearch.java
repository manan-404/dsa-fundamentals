public class ternarySearch {

    // O(log₃ n) - divides sorted array into 3 parts instead of 2
    public static int search(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // base case: not found
        }

        int mid1 = low + (high - low) / 3;
        int mid2 = high - (high - low) / 3;

        if (arr[mid1] == target) {
            return mid1;
        }
        if (arr[mid2] == target) {
            return mid2;
        }

        if (target < arr[mid1]) {
            return search(arr, target, low, mid1 - 1);
        } else if (target > arr[mid2]) {
            return search(arr, target, mid2 + 1, high);
        } else {
            return search(arr, target, mid1 + 1, mid2 - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 9, 12, 18, 22, 27, 31};

        System.out.println("Searching for 18: index " + search(arr, 18, 0, arr.length - 1));
        System.out.println("Searching for 4: index " + search(arr, 4, 0, arr.length - 1));
    }
}
