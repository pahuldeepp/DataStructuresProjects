import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Driver {

    /**
     * Main method to analyze the text file.
     *
     * @param args Command line arguments
     * @throws FileNotFoundException if the file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("PartA.txt");
        Scanner kb = new Scanner(file);
        Map<String, Integer> wordsMap = new ProbeHashMap<>();
        Map<Character, Integer> charMap = new ProbeHashMap<>();
        kb.useDelimiter("[^a-zA-Z]+");
        while (kb.hasNext()) {
            String input = kb.next();

            // Counting words
            Integer wordCount = wordsMap.get(input);
            if (wordCount != null) {
                wordsMap.put(input, wordCount + 1);
            } else {
                wordsMap.put(input, 1);
            }

            // Counting characters
            char[] charr = input.toCharArray();
            for (char c : charr) {
                Integer charCount = charMap.get(c);
                if (charCount != null) {
                    charMap.put(c, charCount + 1);
                } else {
                    charMap.put(c, 1);
                }
            }
        }

        List<String> pronoun = new ArrayList<>();
        pronoun.add("I");
        pronoun.add("we");
        pronoun.add("you");
        pronoun.add("he");
        pronoun.add("she");
        pronoun.add("it");
        pronoun.add("they");

        // Print word counts
        System.out.println("Text Analyzer");
        System.out.println("Total number of distinct words: " + wordsMap.size());
        System.out.println("Total number of distinct letters: " + charMap.size());

        Entry<Character, Integer> mostOccurringCharEntry = findMaxLeast(charMap, new OrderLettersByFrequency(), true);
        System.out.println("Most occurring character: " + mostOccurringCharEntry.getKey() + ", " + mostOccurringCharEntry.getValue());

        Entry<Character, Integer> leastOccurringCharEntry = findMaxLeast(charMap, new OrderLettersByFrequency(), false);
        System.out.println("Least occurring character: " + leastOccurringCharEntry.getKey() + ", " + leastOccurringCharEntry.getValue());

        Entry<String, Integer> mostOccurringWordEntry = findMaxLeast(wordsMap, new OrderWordsByFrequency(), true);
        System.out.println("Most occurring word: " + mostOccurringWordEntry.getKey() + ", " + mostOccurringWordEntry.getValue());

        Entry<String, Integer> leastOccurringWordEntry = findMaxLeast(wordsMap, new OrderWordsByFrequency(), false);
        System.out.println("Least occurring word: " + leastOccurringWordEntry.getKey() + ", " + leastOccurringWordEntry.getValue());

        Entry<String, Integer> mostOccurringPronounEntry = findCategoryMaxLeast(wordsMap, new OrderWordsByFrequency(), true, pronoun);
        System.out.println("Most occurring pronoun: " + mostOccurringPronounEntry.getKey() + ", " + mostOccurringPronounEntry.getValue());

        Entry<String, Integer> leastOccurringPronounEntry = findCategoryMaxLeast(wordsMap, new OrderWordsByFrequency(), false, pronoun);
        System.out.println("Least occurring pronoun: " + leastOccurringPronounEntry.getKey() + ", " + leastOccurringPronounEntry.getValue());
    }

    /**
     * Finds the entry with the maximum or minimum value from the map based on the provided comparator.
     *
     * @param m     The map to search
     * @param comp  The comparator to use for comparison
     * @param valid True if looking for maximum, false if looking for minimum
     * @param <K>   Type of the keys in the map
     * @return Entry with maximum or minimum value
     */
    public static <K> Entry<K, Integer> findMaxLeast(Map<K, Integer> m, Comparator<Entry<K, Integer>> comp,
                                                      boolean valid) {
        if (m.isEmpty()) {
            throw new IllegalArgumentException("Map is Empty");
        }
        List<Entry<K, Integer>> entryList = new ArrayList<>();
        entryList=(List<Entry<K, Integer>>) m.entrySet();
        entryList.sort(comp);

        if (valid) {
            // If finding maximum, return the last entry in the sorted list
            return entryList.get(entryList.size() - 1);
        } else {
            // If finding least, return the first entry in the sorted list
            return entryList.get(0);
        }
    }

    /**
     * Finds the entry with the maximum or minimum value for the keys present in the provided list from the map
     * based on the provided comparator.
     *
     * @param map     The map to search
     * @param comp    The comparator to use for comparison
     * @param findMax True if looking for maximum, false if looking for minimum
     * @param list    List of keys to consider
     * @param <K>     Type of the keys in the map
     * @param <V>     Type of the values in the map
     * @return Entry with maximum or minimum value for the specified keys
     */
    public static <K, V> Entry<K, V> findCategoryMaxLeast(Map<K, V> map, Comparator<Entry<K, V>> comp, boolean findMax,
                                                           List<K> list) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Map is Empty");
        }

        Entry<K, V> maxEntry = null;
        Entry<K, V> minEntry = null;

        for (Entry<K, V> entry : map.entrySet()) {
            if (list.contains(entry.getKey())) {
                if (maxEntry == null || comp.compare(entry, maxEntry) > 0) {
                    maxEntry = entry;
                }
                if (minEntry == null || comp.compare(entry, minEntry) < 0) {
                    minEntry = entry;
                }
            }
        }

        if (findMax) {
            return maxEntry;
        } else {
            return minEntry;
        }
    }
}
