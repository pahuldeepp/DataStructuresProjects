import java.util.Comparator;

/**
 * //Name Pahuldeep Singh
// Studentid 3153555
 * An implementation of a priority queue using a binary heap.
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class HeapPriorityQueue<K,V>extends AbstractPriorityQueue<K,V> {
    protected ArrayList<Entry<K,V>> heap = new ArrayList<>();

    /**
     * Constructs an empty heap priority queue.
     */
    public HeapPriorityQueue(){
        super();
    }

    /**
     * Constructs an empty heap priority queue with the specified comparator.
     * @param comp the comparator to determine the priority of keys
     */
    public HeapPriorityQueue(Comparator<K> comp){
        super(comp);
    }

    // Methods for maintaining the heap structure

    protected int parent(int j){
        return (j-1)/2;
    }

    protected int left(int j){
        return 2*j+1;
    }

    protected int right(int j){
        return 2*j+2;
    }

    protected boolean hasLeft(int j){
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j){
        return right(j) < heap.size();
    }

    protected void swap(int i, int j){
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upheap(int j){
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) break;
            swap(j, p);
            j = p;
        }
    }

    protected void downheap(int j){
        while(hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if(hasRight(j)){
                int rightIndex = right(j);
                if(compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            }
            if(compare(heap.get(smallChildIndex), heap.get(j)) >= 0) break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    // Public methods of the priority queue

    /**
     * Returns the number of entries in the priority queue.
     * @return the number of entries in the priority queue
     */
    public int size(){
        return heap.size();
    }

    /**
     * Returns (but does not remove) the minimum entry in the priority queue.
     * @return the minimum entry in the priority queue, or null if the priority queue is empty
     */
    public Entry<K,V> min(){
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }

    /**
     * Inserts a key-value pair into the priority queue.
     * @param key the key of the entry
     * @param value the value of the entry
     * @return the entry created and inserted into the priority queue
     * @throws IllegalArgumentException if the key is not valid for the priority queue
     */
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size()-1);
        return newest;
    }

    /**
     * Removes and returns the minimum entry from the priority queue.
     * @return the minimum entry in the priority queue, or null if the priority queue is empty
     */
    public Entry<K,V> removeMin(){
        if(heap.isEmpty()) return null;
        Entry<K,V> answer = heap.get(0);
        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);
        downheap(0);
        return answer;
    }

    /**
     * Returns a string representation of the priority queue.
     * @return a string representation of the priority queue
     */
    public String toString() {
        return heap.toString();
    }
}
