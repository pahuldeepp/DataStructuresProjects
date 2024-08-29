import java.util.Comparator;
//Name Pahuldeep Singh
// Studentid 3153555
/**
 * An abstract implementation of the PriorityQueue interface.
 * @param <K> The type of keys maintained by this priority queue
 * @param <V> The type of mapped values
 */
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    /**
     * A static nested class representing an entry in the priority queue.
     * @param <K> The type of keys maintained by this priority queue
     * @param <V> The type of mapped values
     */
    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;

        /**
         * Constructs a priority queue entry with the specified key and value.
         * @param key The key of the entry
         * @param value The value of the entry
         */
        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        /**
         * Returns the key of this entry.
         * @return The key of this entry
         */
        public K getKey() {
            return k;
        }

        /**
         * Returns the value of this entry.
         * @return The value of this entry
         */
        public V getValue() {
            return v;
        }

        /**
         * Sets the key of this entry.
         * @param key The key to be set
         */
        protected void setKey(K key) {
            k = key;
        }

        /**
         * Sets the value of this entry.
         * @param value The value to be set
         */
        protected void setValue(V value) {
            v = value;
        }

        /**
         * Returns a string representation of this entry's value.
         * @return A string representation of this entry's value
         */
        public String toString() {
            return v.toString();
        }
    }

    private Comparator<K> comp;

    /**
     * Constructs a priority queue with the specified comparator.
     * @param c The comparator to be used for ordering
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Constructs a priority queue using the default comparator.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    /**
     * Compares the keys of the given entries.
     * @param a The first entry
     * @param b The second entry
     * @return A negative integer, zero, or a positive integer as the first key is less than, equal to, or greater than the second key
     */
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Checks whether the given key is valid for use in this priority queue.
     * @param key The key to be checked
     * @return True if the key is valid, false otherwise
     * @throws IllegalArgumentException if the key is not compatible with the priority queue
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return comp.compare(key, key) == 0;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Checks whether the priority queue is empty.
     * @return True if the priority queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
