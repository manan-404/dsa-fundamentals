import java.util.HashMap;

public class simpleDictionary {

    private HashMap<String, String> dictionary = new HashMap<>();

    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String searchWord(String word) {
        return dictionary.get(word);
    }

    public void deleteWord(String word) {
        dictionary.remove(word);
    }

    public void printAll() {
        System.out.println(dictionary);
    }

    public static void main(String[] args) {
        simpleDictionary dict = new simpleDictionary();
        dict.addWord("apple", "A fruit");
        dict.addWord("dog", "A domestic animal");

        System.out.println("Meaning of dog: " + dict.searchWord("dog"));
        System.out.println("Meaning of unknown word: " + dict.searchWord("xyz"));

        dict.deleteWord("apple");
        dict.printAll();
    }
}
