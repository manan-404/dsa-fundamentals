public class decodeShuffledSentenceByIndex {

    // Each word ends with a digit indicating its correct position (1-indexed).
    // This is positional placement, not a comparison-based sort - included here
    // because it's the kind of "sorting-adjacent" puzzle question labs like to sneak in.
    static String decode(String shuffled) {
        String[] words = shuffled.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            int position = word.charAt(word.length() - 1) - '0';
            String actualWord = word.substring(0, word.length() - 1);
            result[position - 1] = actualWord;
        }
        return String.join(" ", result);
    }

    public static void main(String[] args) {
        String s1 = "is2 sentence4 This1 a3";
        System.out.println("Shuffled: " + s1);
        System.out.println("Decoded:  " + decode(s1));

        System.out.println();

        String s2 = "Myself2 Me1 I4 and3";
        System.out.println("Shuffled: " + s2);
        System.out.println("Decoded:  " + decode(s2));
    }
}
