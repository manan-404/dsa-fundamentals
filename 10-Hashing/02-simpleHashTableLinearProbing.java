public class simpleHashTableLinearProbing {

    private String[] table;

    public simpleHashTableLinearProbing(int size) {
        table = new String[size];
    }

    private int hash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) sum += c;
        return sum % table.length;
    }

    // Open addressing with linear probing: if the natural slot is taken,
    // check the next slot, then the next, wrapping around, until an empty one is found.
    public void insert(String key) {
        int index = hash(key);
        int originalIndex = index;

        while (table[index] != null) {
            System.out.println("Collision at index " + index + " for key: " + key + " - probing next slot");
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                System.out.println("Table is full, cannot insert: " + key);
                return;
            }
        }
        table[index] = key;
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        simpleHashTableLinearProbing ht = new simpleHashTableLinearProbing(5);
        ht.insert("apple");
        ht.insert("orange");
        ht.insert("banana");
        ht.insert("grape");
        ht.printTable();
    }
}
