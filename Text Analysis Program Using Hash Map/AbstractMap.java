import java.util.Iterator;

/**
 * An abstract implementation of the Map interface, providing common
 * functionality.
 * This class provides basic implementations for isEmpty() method and iterators
 * for keys and values.
 * /**
 * Student id 3153555
 * Pahuldeep Singh
 *
 * @param <K> The type of keys maintained by this map
 * @param <V> The type of mapped values
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * A map entry (key-value pair).
     *
     * @param <K> The type of keys maintained by this map entry
     * @param <V> The type of mapped values
     */
    protected static class MapEntry<K, V> implements Entry<K,V> {
        private K k;
        private V v;

        /**
         * Constructs a map entry with the specified key and value.
         *
         * @param key   The key for this entry
         * @param value The value for this entry
         */
        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        /**
         * Returns the key corresponding to this entry.
         *
         * @return The key corresponding to this entry
         */
        public K getKey() {
            return k;
        }

        /**
         * Returns the value corresponding to this entry.
         *
         * @return The value corresponding to this entry
         */
        public V getValue() {
            return v;
        }

        /**
         * Sets the key for this entry.
         *
         * @param key The new key for this entry
         */
        protected void setKey(K key) {
            k = key;
        }

        /**
         * Sets the value for this entry and returns the old value.
         *
         * @param value The new value for this entry
         * @return The old value for this entry
         */
        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }

    /**
     * An iterator over the keys in the map.
     */
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * @return {@code true} if the iteration has more elements; {@code false}
         *         otherwise
         */
        public boolean hasNext() {
            return entries.hasNext();
        }

        /**
         * Returns the next key in the iteration.
         *
         * @return The next key in the iteration
         */
        public K next() {
            return entries.next().getKey();
        }

        /**
         * Removes from the underlying map the last key returned by this iterator
         * (optional operation).
         *
         * @throws UnsupportedOperationException if the {@code remove} operation is not
         *                                       supported by this iterator
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * An iterable collection of keys in the map.
     */
    private class KeyIterable implements Iterable<K> {

        /**
         * Returns an iterator over the elements in this iterable collection of keys.
         *
         * @return An iterator over the elements in this iterable collection of keys
         */
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

        /**
         * Returns an iterable collection of keys in this map.
         *
         * @return An iterable collection of keys in this map
         */
        public Iterable<K> keySet() {
            return new KeyIterable();
        }
    

    /**
     * An iterator over the values in the map.
     */
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Returns {@code true} if the iteration has more elements.
         *
         * @return {@code true} if the iteration has more elements; {@code false}
         *         otherwise
         */
        public boolean hasNext() {
            return entries.hasNext();
        }

        /**
         * Returns the next value in the iteration.
         *
         * @return The next value in the iteration
         */
        public V next() {
            return entries.next().getValue();
        }

        /**
         * Removes from the underlying map the last value returned by this iterator
         * (optional operation).
         *
         * @throws UnsupportedOperationException if the {@code remove} operation is not
         *                                       supported by this iterator
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * An iterable collection of values in the map.
     */
    private class ValueIterable implements Iterable<V> {

        /**
         * Returns an iterator over the elements in this iterable collection of values.
         *
         * @return An iterator over the elements in this iterable collection of values
         */
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    /**
     * Returns an iterable collection of values in this map.
     *
     * @return An iterable collection of values in this map
     */
    public Iterable<V> values() {
        return new ValueIterable();
    }
}
