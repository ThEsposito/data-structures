package E_linked_lists;

import java.util.EmptyStackException;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(T e){
        Node<T> newNode =  new Node<>(e, null);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
        }
        size++;
    }

    public T front() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return this.head.getData();
    }

    public T rear()throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return this.tail.getData();
    }

    public T dequeue() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();

        T front = head.getData();
        if(head==tail) tail = null; // Reatribui o tail, caso só fique 1 elememnto
        head = head.getNext();
        size--;
        return front;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }
}
