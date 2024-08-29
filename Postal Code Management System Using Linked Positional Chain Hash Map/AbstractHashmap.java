import java.util.Random;

/**
 * An abstract implementation of the Map interface using a hash table.
 * This class provides common functionality for hash map implementations.
 *
 * @param <K> The type of keys maintained by this hash map
 * @param <V> The type of mapped values
 */
public abstract class AbstractHashmap<K,V> extends AbstractMap<K,V> {
    protected int n = 0;
    protected int capacity;
    private int prime;
    private long scale, shift;

    /**
     * Constructs a hash map with the specified initial capacity and prime number.
     *
     * @param cap The initial capacity of the hash map
     * @param p The prime number used for hashing
     */
    public AbstractHashmap(int cap, int p){
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    /**
     * Constructs a hash map with the specified initial capacity and default prime number.
     *
     * @param cap The initial capacity of the hash map
     */
    public AbstractHashmap(int cap){
        this(cap, 109345121);
    }

    /**
     * Constructs a hash map with a default initial capacity and prime number.
     */
    public AbstractHashmap(){
        this(17);
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return The number of key-value mappings in this map
     */
    public int size(){
        return n;
    }

    /**
     * Returns the value to which the specified key is mapped in this map,
     * or null if this map contains no mapping for the key.
     *
     * @param key The key whose associated value is to be returned
     * @return The value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    public V get(K key){
        return bucketGet(hashValue(key), key);
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key The key whose mapping is to be removed from the map
     * @return The previous value associated with the specified key, or null if there was no mapping for the key
     */
    public V remove(K key){
        return bucketRemove(hashValue(key), key);
    }

    /**
     * Associates the specified value with the specified key in this map.
     *
     * @param key The key with which the specified value is to be associated
     * @param value The value to be associated with the specified key
     * @return The previous value associated with the specified key, or null if there was no mapping for the key
     */
    public V put(K key, V value){
        V answer = bucketPut(hashValue(key), key, value);
        if(n > capacity / 2) resize(2 * capacity - 1);
        return answer;
    }

    private int hashValue(K key){
        return (int)((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private void resize(int newCap){
        LinkedPositionalList<Entry<K,V>> buffer = new LinkedPositionalList<>();
        for(Entry<K,V> e : entrySet())buffer.addLast(e);
        capacity = newCap;
        createTable();
        n = 0;
        for(Entry<K,V> e : buffer){
            put(e.getKey(), e.getValue());
        }
    }

    /**
     * Creates the hash table.
     */
    protected abstract void createTable();

    /**
     * Retrieves the value associated with the specified key from the specified bucket in the hash map.
     *
     * @param h The hash value of the key
     * @param k The key whose associated value is to be retrieved
     * @return The value associated with the specified key, or null if no mapping for the key is found
     */
    protected abstract V bucketGet(int h, K k);

    /**
     * Associates the specified value with the specified key in the specified bucket of the hash map.
     *
     * @param h The hash value of the key
     * @param k The key with which the specified value is to be associated
     * @param v The value to be associated with the specified key
     * @return The previous value associated with the specified key, or null if there was no mapping for the key
     */
    protected abstract V bucketPut(int h, K k, V v);

    /**
     * Removes the mapping for the specified key from the specified bucket in the hash map if present.
     *
     * @param h The hash value of the key
     * @param k The key whose mapping is to be removed from the map
     * @return The previous value associated with the specified key, or null if there was no mapping for the key
     */
    protected abstract V bucketRemove(int h, K k);
}
