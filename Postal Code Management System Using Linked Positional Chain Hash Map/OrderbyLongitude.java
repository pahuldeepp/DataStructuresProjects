import java.util.Comparator;

public class OrderbyLongitude implements Comparator<Entry<String, PostalCode>> {

    @Override
    public int compare(Entry<String, PostalCode> entry1, Entry<String, PostalCode> entry2) {
        // Implement comparison logic based on the longitude of PostalCode
        // For example:
        double longitude1 = entry1.getValue().getLongitude();
        double longitude2 = entry2.getValue().getLongitude();
        return Double.compare(longitude1, longitude2);
    }
}