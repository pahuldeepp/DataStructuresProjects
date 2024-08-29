public class LinkedPositionalChainHashMap<K, V> extends AbstractHashmap<K, V> {

    private LinkedPositionalList<MapEntry<K, V>>[] table;
    private int count = 0;

    public LinkedPositionalChainHashMap() {
        super();
    }

    public LinkedPositionalChainHashMap(int cap) {
        super(cap);
    }

    public LinkedPositionalChainHashMap(int cap, int p) {
        super(cap, p);
    }

    protected void createTable() {
        table = (LinkedPositionalList<MapEntry<K,V>>[]) new LinkedPositionalList[capacity];
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

        for (int h = 0; h < capacity; h++) {
            LinkedPositionalList<MapEntry<K, V>> bucket = table[h];
            if (bucket != null) {
                for (MapEntry<K, V> entry : bucket) {
                    list.addLast(entry);
                
                }
            }
        }
        return list;
    }

    @Override
    protected V bucketGet(int h, K k) {
        LinkedPositionalList<MapEntry<K, V>> bucket = table[h];
        if (bucket == null)
            return null;

        for (Position<MapEntry<K, V>> p : bucket.positions()) {
            if (p.getElement().getKey().equals(k)) {
                return p.getElement().getValue();
            }
        }

        return null; // Key not found
    }

    @Override
    protected V bucketPut(int h, K k, V v) {
        LinkedPositionalList<MapEntry<K, V>> bucket = table[h];
        if (bucket == null) {
            bucket = table[h] = new LinkedPositionalList<>();
        } else {
            // Check for collisions only if the bucket is not null (i.e., it already exists)
            for (Position<MapEntry<K, V>> p : bucket.positions()) {
                if (p.getElement().getKey().equals(k)) {
                    count++; // Increment overall collisions if the key is found in the bucket
                    return p.getElement().setValue(v); // Update value if key is found
                }
            }
        }

        // If the key is not found in the bucket, add a new entry
        bucket.addLast(new MapEntry<>(k, v));
        n++; // Increment overall count of entries
        return null; // No previous value
    }
        /**
     * Removes the entry with the specified key from the bucket at index h.
     *
     * @param h The index of the bucket.
     * @param k The key of the entry to be removed.
     * @return The value associated with the removed key, or null if the key is not found.
     */
    @Override
    protected V bucketRemove(int h, K k) {
        LinkedPositionalList<MapEntry<K, V>> bucket = table[h];
        if (bucket == null)
            return null;

        for (Position<MapEntry<K, V>> p : bucket.positions()) {
            if (p.getElement().getKey().equals(k)) {
                V value = p.getElement().getValue();
                bucket.remove(p);
                n--;
                return value;
            }
        }

        return null; // Key not found
    }
    protected int getCollisions(){
        return count;
    }
}