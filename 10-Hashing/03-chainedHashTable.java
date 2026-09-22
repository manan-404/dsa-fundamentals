import java.util.LinkedList;

public class chainedHashTable {

    private LinkedList<String>[] table;

    public chainedHashTable(int size) {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) sum += c;
        return sum % table.length;
    }

    // Chaining: each slot holds a list, so collisions just mean adding to that slot's list
    // instead of needing to find a different slot (the other approach, in file 02).
    public void insert(String key) {
        int index = hash(key);
        table[index].add(key);
    }

    public boolean search(String key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    public void delete(String key) {
        int index = hash(key);
        table[index].remove(key);
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        chainedHashTable ht = new chainedHashTable(5);
        ht.insert("apple");
        ht.insert("orange");
        ht.insert("banana");
        ht.insert("grape");
        ht.printTable();

        System.out.println("Search \"banana\": " + ht.search("banana"));
        ht.delete("banana");
        System.out.println("Search \"banana\" after delete: " + ht.search("banana"));
    }
}
