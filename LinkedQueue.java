// Pahuldeep Singh
// Student ID: 3153555

/**
 * LinkedQueue class represents a queue implementation using a singly linked list.
 * @param <E> the type of elements stored in the queue
 */
public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    /**
     * Constructs an empty LinkedQueue.
     */
    public LinkedQueue() {
    }

    /**
     * Returns the number of elements in the queue.
     * @return the number of elements in the queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Checks whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds an element to the back of the queue.
     * @param element the element to be added to the queue
     */
    public void enqueue(E element) {
        list.addLast(element);
    }

    /**
     * Returns (but does not remove) the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    public E first() {
        return list.first();
    }

    /**
     * Removes and returns the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
    public E dequeue() {
        return list.removeFirst();
    }
}
