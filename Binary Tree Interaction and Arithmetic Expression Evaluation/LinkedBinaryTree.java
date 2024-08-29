
/**
 * Pahuldeep Singh
 * Student ID: 3153555
 * 
 * An implementation of a binary tree using linked nodes.
 *
 * @param <E> the type of elements stored in the tree
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    /**
     * Nested static class representing a node in the binary tree.
     */
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        /**
         * Constructs a node with the given element, parent, left child, and right
         * child.
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightchild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightchild;
        }

        /**
         * Returns the element stored in the node.
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the parent of the node.
         */
        public Node<E> getParent() {
            return parent;
        }

        /**
         * Returns the left child of the node.
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * Returns the right child of the node.
         */
        public Node<E> getRight() {
            return right;
        }

        /**
         * Sets the element stored in the node.
         */
        public void setElement(E e) {
            element = e;
        }

        /**
         * Sets the parent of the node.
         */
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        /**
         * Sets the left child of the node.
         */
        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        /**
         * Sets the right child of the node.
         */
        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }

        /**
         * Returns a string representation of the node.
         */
        public String toString() {
            return element + " ";
        }
    }

    /**
     * Factory method to create a new node storing element e.
     * 
     * @param e      the element to be stored in the new node
     * @param parent the parent node of the new node
     * @param left   the left child node of the new node
     * @param right  the right child node of the new node
     * @return the new node
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    // Attributes to store the root node and the size of the tree
    protected Node<E> root = null;
    private int size = 0;

    // Constructors
    public LinkedBinaryTree() {
    }

    /**
     * Validates a position and casts it to a Node.
     * 
     * @param p the position to validate
     * @return the node corresponding to the given position
     * @throws IllegalArgumentException if the position is not valid or no longer in
     *                                  the tree
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    // Methods to get the size and the root position of the tree
    /**
     * Returns the number of nodes in the tree.
     * 
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Returns the position of the root of the tree.
     * 
     * @return the position of the root of the tree
     */
    public Position<E> root() {
        return root;
    }

    // Methods to get the parent, left child, and right child of a given position
    /**
     * Returns the position of the parent of the given position.
     * 
     * @param p the position whose parent to find
     * @return the position of the parent of the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the position of the left child of the given position.
     * 
     * @param p the position whose left child to find
     * @return the position of the left child of the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the position of the right child of the given position.
     * 
     * @param p the position whose right child to find
     * @return the position of the right child of the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    // Methods to add a root, left child, and right child to a given position
    /**
     * Adds a root node to the tree with the given element.
     * 
     * @param e the element to be stored in the root node
     * @return the position of the newly added root node
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!(isEmpty()))
            throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Adds a left child to the given position with the given element.
     * 
     * @param p the position to which to add the left child
     * @param e the element to be stored in the left child
     * @return the position of the newly added left child
     * @throws IllegalArgumentException if the position is not valid or already has
     *                                  a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Adds a right child to the given position with the given element.
     * 
     * @param p the position to which to add the right child
     * @param e the element to be stored in the right child
     * @return the position of the newly added right child
     * @throws IllegalArgumentException if the position is not valid or already has
     *                                  a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    // Method to set the element of a given position
    /**
     * Sets the element stored at the given position to the given element.
     * 
     * @param p the position whose element to set
     * @param e the new element to be stored at the position
     * @return the previous element stored at the position
     * @throws IllegalArgumentException if the position is not valid
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    // Method to remove a node at a given position
    /**
     * Removes the node at the given position from the tree and returns its element.
     * 
     * @param p the position of the node to remove
     * @return the element of the removed node
     * @throws IllegalArgumentException if the position is not valid or has two
     *                                  children
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("P has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent());
        if (node == root)
            root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setRight(null);
        node.setLeft(null);
        node.setParent(null);
        return temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        @SuppressWarnings("unchecked")
        List<E> list = (ArrayList<E>) preorder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");
        }
        return sb.toString();

    }
}
