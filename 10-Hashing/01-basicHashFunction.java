public class basicHashFunction {

    private int tableSize;

    public basicHashFunction(int tableSize) {
        this.tableSize = tableSize;
    }

    // Sums character codes, then folds into table range with modulo.
    // Simple but not collision-resistant - anagrams (e.g. "cat"/"act") hash identically.
    public int getHash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += c;
        }
        return sum % tableSize;
    }

    public static void main(String[] args) {
        basicHashFunction hasher = new basicHashFunction(10);

        System.out.println("Hash of \"apple\": " + hasher.getHash("apple"));
        System.out.println("Hash of \"banana\": " + hasher.getHash("banana"));
        System.out.println("Hash of \"cat\": " + hasher.getHash("cat"));
        System.out.println("Hash of \"act\" (anagram of cat): " + hasher.getHash("act"));
    }
}
