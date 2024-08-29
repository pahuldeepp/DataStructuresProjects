import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Pahuldeep Singh
 * Student ID: 3153555
 * 
 * An abstract implementation of the Tree interface providing common functionality.
 *
 * @param <E> the type of elements stored in the tree
 */
public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * Checks if a given position represents an internal node.
     *
     * @param p the position to check
     * @return true if the position represents an internal node, false otherwise
     */
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * Checks if a given position represents an external node (leaf).
     *
     * @param p the position to check
     * @return true if the position represents an external node, false otherwise
     */
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * Checks if a given position represents the root of the tree.
     *
     * @param p the position to check
     * @return true if the position represents the root, false otherwise
     */
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * Checks if the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the depth of a given position in the tree.
     *
     * @param p the position whose depth is to be determined
     * @return the depth of the position
     */
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    /**
     * Returns the height of the subtree rooted at a given position.
     *
     * @param p the position whose subtree's height is to be determined
     * @return the height of the subtree rooted at the position
     */
    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }
    
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    // Nested class representing an iterator over the elements of the tree
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();

        /**
         * Checks if there are more elements in the tree.
         * 
         * @return true if there are more elements, false otherwise
         */
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        /**
         * Returns the next element in the tree.
         * 
         * @return the next element in the tree
         */
        public E next() {
            return posIterator.next().getElement();
        }

        /**
         * Removes the current element from the tree.
         */
        public void remove() {
            posIterator.remove();
        }
    }


     private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

   

    /**
     * Performs a postorder traversal of the tree and returns an iterable collection of positions.
     * 
     * @return an iterable collection of positions obtained from the postorder traversal
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }

    /**
     * Returns an iterable collection of positions obtained from a postorder traversal of the tree.
     * 
     * @return an iterable collection of positions obtained from the postorder traversal
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c);
                }

            }

        }
        return snapshot;
    }
       /**
     * Returns an iterable collection of positions in the tree, obtained from a
     * preorder traversal.
     * 
     * @return an iterable collection of positions obtained from the preorder
     *         traversal
     */ public Iterable<Position<E>> positions() {
        return preorder();
    }

}