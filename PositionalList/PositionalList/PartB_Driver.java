/**
 * PartB_Driver class is used to demonstrate the functionality of
 * ArrayPositionalList.
 * Name Pahuldeep Singh
 * Student 3153555
 */
public class PartB_Driver {
    /**
     * Main method to execute the driver program.
     * 
     * @param args command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Create an instance of ArrayPositionalList with a capacity of 16
        ArrayPositionalList<String> list = new ArrayPositionalList<>(16);

        // Adding elements to the list
        list.addFirst("harry");
        Position<String> cursor = list.first();
        list.addAfter(cursor, "ron");
        list.addLast("hermione");
        cursor = list.last();
        list.addBefore(cursor, "tom");
        cursor = list.before(cursor);
        list.addBefore(cursor, "tom");
        cursor = list.before(cursor);
        list.set(cursor, "tom");

        // cursor = list.before(cursor); // Move cursor to the position before the first
        // "tom"
        // list.addAfter(cursor, "tom");

        // Clearing the list and adding new elements
        // list.clear();
        // list.addFirst("mary");
        // list.addFirst("hermione");
        // list.addFirst("harry");
        // list.addFirst("ron");
        // list.addFirst("tom");
        // list.clear();

        // list.addLast("mary");
        // list.addLast("mary");
        // list.addLast("tom");
        // list.addLast("james");
        // list.addLast("hermione");
        // list.addLast("hermione");

        // Position<String> cursor = list.addLast("james");
        // cursor = list.addAfter(cursor, "harry");
        // list.addBefore(cursor,"james");

        // list.addLast("harry");
        // list.addLast("harry");

        System.out.println("Original positional List: ");
        cursor = list.first();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(cursor + " ");
            cursor = list.after(cursor);
        }

        // Call removeConsecutiveDuplicates to remove consecutive duplicates
        int count = removeConsecutiveDuplicates(list);

        // Output the number of entries after removing duplicates
        System.out.println();
        System.out.println("Number of entries after call: " + count);

        // Output the list with duplicates removed
        System.out.println("List with duplicate removed: ");
        cursor = list.first();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(cursor + " ");
            cursor = list.after(cursor);
        }

        ArrayPositionalList<Character> charlist = new ArrayPositionalList<>();
        charlist.addLast('S');
        charlist.addLast('C');
        charlist.addLast('R');
        charlist.addLast('A');
        charlist.addLast('M');
        charlist.addLast('B');
        charlist.addLast('L');
        charlist.addLast('E');
        charlist.addLast('G');
        charlist.addLast('A');
        charlist.addLast('M');
        charlist.addLast('E');
        insertionSort(charlist);
        System.out.println();
        System.out.println("Sorted characters using Insertion sort algorithm:");
        Position<Character> newcursor = charlist.first();
        for (int i = 0; i < charlist.size(); i++) {
            System.out.print(newcursor + " ");
            newcursor = charlist.after(newcursor);
        }

    }

    /**
     * Removes consecutive duplicates from the given ArrayPositionalList.
     * 
     * @param input the ArrayPositionalList from which to remove duplicates
     * @return the count of non-duplicate elements after removal
     */
    public static int removeConsecutiveDuplicates(ArrayPositionalList<String> input) {
        Position<String> cursor = input.first();
        int count = 0;
        int size = input.size();
        // Iterate through the list and remove consecutive duplicates
        while (cursor != null && input.after(cursor) != null) {
            Position<String> nextPosition = input.after(cursor);

            if (nextPosition.getElement().equals(cursor.getElement())) {
                input.remove(nextPosition); // Remove the duplicate element
                count++;
            } else {
                cursor = input.after(cursor); // Move cursor to the next position
            }
        }

        // Calculate the count of non-duplicate elements
        int num = size - count;
        return num;
    }

    public static void insertionSort(ArrayPositionalList<Character> list) {
        int n = list.size();
        //Start the cursor at second position
        Position<Character> cursor = list.after(list.first());
    
        for (int k = 1; k < n; k++) {
            char cur = cursor.getElement();
            // Take the prev position in new cursor
            Position<Character> prev = list.before(cursor);
            int j=k;
            Position<Character> newcur=cursor;
            while (j>0&&prev!=null&& prev.getElement()> (cur)) {
                list.set(newcur, prev.getElement());
                newcur = prev;
                prev = list.before(prev);
                j--;
            }
    
            cursor = list.after(cursor); 
             list.set(newcur, cur);
        }
    }
}    