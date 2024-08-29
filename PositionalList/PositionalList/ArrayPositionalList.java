

/** Name Pahuldeep Singh
 * Student 3153555
 * ACS-2947 Assignment 2 Part B
 */

public class ArrayPositionalList<E> implements PositionalList<E> {

	private static class ArrPosition<E> implements Position<E> {

        private int index;
        private E element;

        public ArrPosition(int i, E e) {
            index = i;
            element = e;
        }

        public E getElement() throws IllegalStateException {
            if (index == -1) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public void setElement(E e) {
            element = e;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int i) {
            index = i;
        }
        public String toString(){
            return "["+this.getIndex()+"] "+this.getElement();
        }
    }

	public static final int CAPACITY = 16;
    private ArrPosition<E>[] data;
    private int size = 0;

    public ArrayPositionalList() {
        this(CAPACITY);
    }

    public ArrayPositionalList(int capacity) {
        data = (ArrPosition<E>[]) new ArrPosition[capacity];
    }
    public int size(){
        return size;
    }

    // Method to check if the list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // Method to validate a position and convert it to ArrPosition
    private ArrPosition<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof ArrPosition))
            throw new IllegalArgumentException("Invalid p");
        ArrPosition<E> arrPosition = (ArrPosition<E>) p;
        if (arrPosition.getIndex() <0)
            throw new IllegalArgumentException("Position is no longer in the list");
        return arrPosition;
    }

    // Method to get the first position in the list
    public Position<E> first(){
        if (isEmpty())
            return null;
        return data[0];
    }

    // Method to get the last position in the list
    public Position<E> last(){
        if (isEmpty())
            return null;
        return data[size - 1];
    }

    // Method to get the position before a given position
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        ArrPosition<E> arrPosition = validate(p);
        int index = arrPosition.getIndex();
        if (index == 0) {
            return null; // Handle the case when p is the first position in the list
        }
        return data[index - 1];
    }
    

    // Method to get the position after a given position
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        ArrPosition<E> arrPosition = validate(p);
        int index = arrPosition.getIndex();
        return (index == size ) ? null : data[index + 1];
    }

    // Method to add a new element between existing elements
    private Position<E> addBetween(int i, E e) throws IndexOutOfBoundsException {
        if (size == data.length) {
            throw new IllegalStateException("List is full");
        } else if (i < 0 || i > size) {
            throw new IllegalArgumentException("The index is not valid");
        } else {
            ArrPosition<E> arrPosition = new ArrPosition<>(i, e);
            for (int j = size - 1; j >= i; j--) {
                data[j].setIndex(j+1);
                data[j + 1] = data[j];  // Shift elements to the right
              
            }
            data[i] = arrPosition;
            size++;
            return arrPosition;
        }
    }
    

    // Method to add an element at the beginning of the list
    public Position<E> addFirst(E e){
        return addBetween(0,e);
    }

    // Method to add an element at the end of the list
    public Position<E> addLast(E e){
        return addBetween(size,e);
    }

    // Method to add an element before a given position
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        ArrPosition<E> arrPosition = validate(p);
        return addBetween(arrPosition.getIndex(),e);
    }

    // Method to add an element after a given position
    public Position<E> addAfter(Position<E> p, E e){
        ArrPosition<E> arrPosition = validate(p);
        return addBetween(arrPosition.getIndex() + 1,e);
    }

    // Method to set the element at a given position to a new element
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        ArrPosition<E> arrPosition = validate(p);
        E answer = arrPosition.getElement();
        arrPosition.setElement(e);
        return answer;
    }

    // Method to remove the element at a given position
    public E remove(Position<E> p) throws IllegalArgumentException {
        ArrPosition<E> arrPosition = validate(p);
        E answer = arrPosition.getElement();
        int index = arrPosition.getIndex();
        for (int i = index; i < size-1; i++) {
            data[i+1].setIndex(i);
            data[i] = data[i + 1];  // Shift elements to the left
             }
        data[size - 1] = null;
        size--;
        return answer;
    }
        // Method to clear the list
    // public void clear(){
    //     size=0;
    // }

    // Method to generate a string representation of the list
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i].getElement());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}