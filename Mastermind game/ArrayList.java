//Student id 3153555
//Pahuldeep Singh

import java.util.Iterator;
import java.util.NoSuchElementException;


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
    public void add(E element) throws IndexOutOfBoundsException, IllegalStateException{
        
        add(size,element);
    }
    // Removes the element at the specified index
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
    
        for (int i = 0; i < size; i++) {
            sb.append(this.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
    
        return sb.toString();
    }
    
    // Returns an iterator over the elements in the list
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
