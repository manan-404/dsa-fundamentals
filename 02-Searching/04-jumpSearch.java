public class jumpSearch {

    // O(sqrt n) - middle ground between linear and binary search
    // Jumps ahead by fixed block size, then does linear search within the block
    public static int search(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1;
            }
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};

        System.out.println("Searching for 15: index " + search(arr, 15));
        System.out.println("Searching for 8: index " + search(arr, 8));
    }
}
