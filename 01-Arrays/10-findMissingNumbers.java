public class FindMissingNumbers {

    public static int[] findMissing(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1]; // index 0 unused

        for (int num : nums) {
            if (num >= 1 && num <= n) present[num] = true;
        }

        int missingCount = 0;
        for (int i = 1; i <= n; i++) {
            if (!present[i]) missingCount++;
        }

        int[] missing = new int[missingCount];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (!present[i]) missing[idx++] = i;
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] missing = findMissing(nums);

        System.out.print("Missing numbers: ");
        for (int val : missing) System.out.print(val + " ");
    }
}
