import java.util.Comparator;

public class OrderWordsByFrequency implements Comparator<Entry<String,Integer>> {

    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        int frequencyComparison = Integer.compare(o1.getValue(), o2.getValue());

        if (frequencyComparison != 0) {
            // If frequencies are different, sort by frequency in ascending order
            return frequencyComparison;
        } else {
            // If frequencies are the same, sort by word in ascending order
            return o1.getKey().compareTo(o2.getKey());
        }
    }
}
