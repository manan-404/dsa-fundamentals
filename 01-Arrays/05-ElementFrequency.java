public class ElementFrequency {

    public static void main(String[] args) {
        int[] arr = {21, 9, 17, 9, 21, 9};

        System.out.print("Array values are: ");
        for (int val : arr) System.out.print(val + " ");
        System.out.println();

        boolean[] counted = new boolean[arr.length];
        System.out.println("The frequency of all elements of the array are:");

        for (int i = 0; i < arr.length; i++) {
            if (counted[i]) continue; // already reported this value

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    counted[j] = true;
                }
            }
            System.out.println(arr[i] + " occurs " + count + " times");
        }
    }
}
