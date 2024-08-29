import java.util.ArrayList;
/**
 * Implementation of a hash map using linear probing for collision resolution.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public class ProbeHashMap<K, V> extends AbstractHashmap<K, V> {
    private MapEntry<K,V>[] table;
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);

    /**
     * Constructs an empty hash map.
     */
    public ProbeHashMap() {
        super();
    }

    /**
     * Constructs an empty hash map with the specified initial capacity.
     *
     * @param cap The initial capacity.
     */
    public ProbeHashMap(int cap) {
        super(cap);
    }

    /**
     * Constructs an empty hash map with the specified initial capacity and prime factor.
     *
     * @param cap The initial capacity.
     * @param p   The prime factor used for hash computation.
     */
    public ProbeHashMap(int cap, int p) {
        super(cap, p);
    }

    /**
     * Creates the table for storing key-value pairs.
     */
    
    @SuppressWarnings("unchecked")
    protected void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }

    /**
     * Checks if a slot in the table is available for insertion.
     *
     * @param j The index of the slot to check.
     * @return True if the slot is available, false otherwise.
     */
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    /**
     * Finds the index of the slot containing the given key or where the key can be inserted.
     *
     * @param h The original hash value of the key.
     * @param k The key to search for.
     * @return The index of the slot if found, or the index where the key can be inserted with a negative offset.
     */
    private int findSlot(int h, K k) {
        int avail = -1;
        int j = h;
        do {
            if (isAvailable(j)) {
                if (avail == -1)
                    avail = j;
                if (table[j] == null)
                    break;
            } else if (table[j].getKey().equals(k))
                return j;
            j = (j + 1) % capacity;
        } while (j != h);
        return -(avail + 1);
    }

    /**
     * Retrieves the value associated with the given key in the bucket.
     *
     * @param h The original hash value of the key.
     * @param k The key to search for.
     * @return The value associated with the key, or null if not found.
     */
    protected V bucketGet(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) return null;
        return table[j].getValue();
    }

    /**
     * Associates the given key with the given value in the bucket.
     *
     * @param h The original hash value of the key.
     * @param k The key to associate with the value.
     * @param v The value to be associated with the key.
     * @return The previous value associated with the key, or null if not found.
     */
    protected V bucketPut(int h, K k, V v) {
        int j = findSlot(h, k);
        if (j >= 0) return table[j].setValue(v);
        table[-(j + 1)] = new MapEntry<>(k, v);
        n++;
        return null;
    }

    /**
     * Removes the entry associated with the given key from the bucket.
     *
     * @param h The original hash value of the key.
     * @param k The key to remove.
     * @return The value associated with the removed key, or null if not found.
     */
    protected V bucketRemove(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) return null;
        V answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    }

    /**
     * Returns an iterable collection of all entries in the hash map.
     *
     * @return An iterable collection of entries.
     */
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (!isAvailable(h)) buffer.add(table[h]);
        }
        return buffer;
    }
}
