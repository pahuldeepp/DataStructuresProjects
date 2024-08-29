import java.util.Comparator;

public class OrderbyCode implements Comparator<Entry<String, PostalCode>> {

    @Override
    public int compare(Entry<String, PostalCode> entry1, Entry<String, PostalCode> entry2) {
        // Implement comparison logic based on the longitude of PostalCode
        // For example:
        String longitude1 = entry1.getKey();
        String longitude2 = entry2.getKey();
        return longitude1.compareTo(longitude2);
    }
}