import java.util.HashMap;

public class wordFrequencyCounter {

    private HashMap<String, Integer> frequencyMap = new HashMap<>();

    public void addText(String text) {
        String[] words = text.split("\\s+"); // handles multiple spaces/tabs, not just single spaces
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
    }

    public void printFrequency() {
        System.out.println(frequencyMap);
    }

    public static void main(String[] args) {
        wordFrequencyCounter counter = new wordFrequencyCounter();
        counter.addText("the cat sat on the mat");
        counter.addText("the dog sat too");
        counter.printFrequency();
    }
}
