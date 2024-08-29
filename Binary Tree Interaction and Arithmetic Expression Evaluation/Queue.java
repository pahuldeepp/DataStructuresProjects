// Pahuldeep Singh
// Student ID: 3153555

/**
 * Queue interface represents a queue data structure, which follows the FIFO (First-In-First-Out) principle.
 * @param <E> the type of elements stored in the queue
 */
public interface Queue<E> {
    /**
     * Returns the number of elements in the queue.
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Checks whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue.
     * @param e the element to be inserted
     */
    void enqueue(E e);

    /**
     * Returns the first element of the queue without removing it.
     * @return the first element of the queue
     */
    E first();

    /**
     * Removes and returns the first element of the queue.
     * @return the first element of the queue
     */
    E dequeue();
}
