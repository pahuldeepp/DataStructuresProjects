
public class CircularDoublyLinkedList<E>{

static class Node<E>{

    private E Element;
    private Node<E> next;
    private Node<E> previous;
    public Node(E e,Node<E>p,Node<E>n){
        Element=e;
        next=n;
        previous=p;
    }
    public E getElement(){
        return Element;
    }
    public Node<E> getNext(){
        return next;
    }
    public void setNext(Node<E> n){
        next=n;
    }
    public void setPrevious(Node<E> p){
        previous=p;
    }
    public Node<E> getPrevious(){
        return previous;
    }
}
private Node<E> tail=null;
private int size;
public CircularDoublyLinkedList(){
    tail=null;
    size=0;
}
public int size(){
    return size;
}
public boolean isEmpty(){
    return size==0;
}
public E first(){
    if(isEmpty()) return null;
    return tail.getNext().getElement();
}
public E last(){
    if(isEmpty()) return null;
    return tail.getElement();
}
public void addFirst(E e){
    if(isEmpty()){
        tail=new Node<>(e, null, null);
        tail.setPrevious(tail);
        tail.setNext(tail);
        size++;
    }
    addBetween(e,tail,tail.getNext());
}
private void addBetween(E e, Node<E> pre, Node<E> successor){
    Node<E> newest= new Node<E>(e,pre,successor);
    pre.setNext(newest);
    successor.setPrevious(newest);
    size++;
}


public E removeFirst(){
    if(isEmpty())return null;
    return remove(tail.getNext());
}
private E remove(Node<E> node){
    
    Node<E> pre=node.getPrevious();
    Node<E> success=node.getNext();
    pre.setNext(success);
    success.setPrevious(pre);
    size--;

    return node.getElement();
}
public E removeLast(){
    if(isEmpty())return null;
    Node<E> temp=tail;
    tail=tail.getPrevious();
    return remove(temp);
    
}
public void rotate(){
    if(tail.getNext()!=tail){
    tail= tail.getNext();
    }
}
public void addLast(E e) {
    if (isEmpty()) {
        tail = new Node<>(e, null, null);
        tail.setPrevious(tail);
        tail.setNext(tail);
        size++;
    } else {
        addBetween(e, tail, tail.getNext());
        tail = tail.getNext(); 
    }
}

public boolean contains(E e){
if(isEmpty())return false;
Node<E> current = tail.getNext();
for( int i=0;i<size;i++){
    if(e.equals(current.getElement())){
        return true;
    }
current=current.getNext();
}
return false;
}
public Node<E> getNext(){
    if(isEmpty()) return null;
    return this.tail.getNext();
}
public String toString() {
    if (isEmpty())
        return "[]";
    StringBuilder sb = new StringBuilder();
    
    Node<E> current = tail.getNext(); 
    for (int i = 0; i < size; i++) {
        sb.append(current.getElement()).append(" "); 
        current = current.getNext(); 
    }
    
    return sb.toString();
}
}