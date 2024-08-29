import java.util.Comparator;
//Name Pahuldeep Singh
// Student id 3153555

public class PassengerComparator<E> implements Comparator<Passenger> {
    public int compare(Passenger a, Passenger b) {
        int fareComparison = a.getFareCode().compareTo(b.getFareCode());
        if (fareComparison != 0) {
            return fareComparison;
        }

        int statusComparison = a.getStatus().compareTo(b.getStatus());
        if (statusComparison != 0) {
            return statusComparison;
        }

        return a.getTime().compareTo(b.getTime());
    }
}
