import java.util.Comparator;

/**
 * Represents a default comparator that compares elements using their natural ordering.
 * @param <E> the type of elements to be compared
 * //Name Pahuldeep Singh
// Studentid 3153555
 */
public class DefaultComparator<E> implements Comparator<E>{

    /**
     * Compares two elements for order using their natural ordering.
     * @param a the first element to be compared
     * @param b the second element to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
     * @throws ClassCastException if the elements' types are not compatible with their natural ordering
     */
    @SuppressWarnings("unchecked")
    public int compare(E a, E b) throws ClassCastException{
        return ((Comparable<E>)a).compareTo(b);
    }
}
