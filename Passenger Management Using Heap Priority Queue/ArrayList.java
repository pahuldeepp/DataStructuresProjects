import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Student ID: 3153555
 * Author: Pahuldeep Singh
 * Represents an implementation of the List interface using an array-based data structure.
 * @param <E> the type of elements in this list
 */
public class ArrayList<E> implements List<E> {
    private static final int CAPACITY = 4;
    private int size;
    private E[] data;

    // Default constructor
    public ArrayList() {
        this(CAPACITY);
    }

    // Constructor with specified capacity
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    // Returns the number of elements in the list
    public int size() {
        return size;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if index is valid
    protected void checkIndex(int index, int n) throws IndexOutOfBoundsException {
        if (index < 0 || index >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + index);
    }

    // Returns the element at the specified index
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }

    // Replaces the element at the specified index with the given element
    public E set(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E temp = data[index];
        data[index] = element;
        return temp;
    }

   
   // Adds an element at the specified index
   /**
    * Inserts the specified element at the specified position in this list.
    * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
    * @param index index at which the specified element is to be inserted
    * @param element element to be inserted
    * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
    * @throws IllegalStateException if the element cannot be added at the specified index
    */
    public void add(int index, E element) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(index, size + 1);

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int k = size - 1; k >= index; k--) {
            data[k + 1] = data[k];
        }
        data[index] = element;
        size++;
    }
    
    // Adds an element at the end 
    /**
     * Appends the specified element to the end of this list.
     * @param element element to be appended to this list
     * @throws IndexOutOfBoundsException if the element cannot be added
     * @throws IllegalStateException if the element cannot be added at the specified index
     */
    public void add(E element) throws IndexOutOfBoundsException, IllegalStateException {
        add(size, element);
    }

    // Removes the element at the specified index
    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        
        E temp = data[index];
        for (int k = index; k < size - 1; k++) {
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
    
        // Resize the array if necessary
        if (size < data.length / 4) {
            resize(data.length / 2);
        }
        
        return temp;
    }
    
    // resize the arraylist
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;
    }
    
    // Equals method checks if the objects are equals
    /**
     * Compares this list to the specified object. The result is true if and only if the argument is not null and is an ArrayList object that represents the same sequence of elements as this object.
     * @param o the object to compare
     * @return true if the given object represents an ArrayList equivalent to this list, false otherwise
     */
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        
        ArrayList<E> other = (ArrayList<E>) o;
        
        if (this.size() != other.size()) return false; // Check if sizes are equal
        
        for (int i = 0; i < this.size(); i++) {
            if (!other.get(i).equals(this.get(i))) { // Use equals() method for comparison
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Returns a string representation of this list.
     * @return a string representation of this list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(this.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
    
        return sb.toString();
    }
    
    // Returns an iterator over the elements in the list
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    // Iterator implementation for the ArrayList
    private class ArrayIterator implements Iterator<E> {
        private int currentIndex = 0; // Current index
        private boolean removable = false; // Flag to track if element is removable

        // Checks if there is a next element
        public boolean hasNext() {
            return currentIndex < size;
        }

        // Returns the next element in the iteration
        public E next() throws NoSuchElementException {
            if (currentIndex == size)
                throw new NoSuchElementException("No next element");
            removable = true;
            return data[currentIndex++];
        }

        // Removes the last element returned by the iterator from the underlying collection
        public void remove() throws IllegalStateException {
            if (!removable)
                throw new IllegalStateException("Nothing to remove");
            ArrayList.this.remove(currentIndex - 1);
            currentIndex--;
            removable = false;
        }
    }

}
