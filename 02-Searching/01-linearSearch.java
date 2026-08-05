public class linearSearch {

    // O(n) - checks every element, works on unsorted arrays too
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 15, 6, 22, 9, 1};

        System.out.println("Searching for 22: index " + search(arr, 22));
        System.out.println("Searching for 100: index " + search(arr, 100));
    }
}