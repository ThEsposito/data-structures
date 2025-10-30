package E_linked_lists;

/*
Sobre o lançamento de exceções:
 - Considerei mais adequado lançar exceções ao tentar acessar elementos em uma lista vazia ou índices inválidos.
   Evita bugs "silenciosos" com NullPointerExceptions e torna a descoberta desses bugs mais fácil.
*/

import java.util.NoSuchElementException;

public class CircleLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public CircleLinkedList(){
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null; // or head == tail or size==0
    }

    public int getSize() {
        return size;
    }

    public Node<T> getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return head;
    }

    public Node<T> getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return tail;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public T get(int idx){
        if(isEmpty()) throw new NoSuchElementException();
        if(idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Index "+idx+" out of bounds for length "+size);

        if(idx == size-1) return tail.getData();

        Node<T> current = head;
        for(int i=0; i<idx; i++) current = current.getNext(); // Already returns head, if idx==0

        return current.getData();
    }


    public void insertTail(T e) {
        Node<T> newNode = new Node<>(e);
        if(isEmpty()) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
        tail.setNext(head);
        size++;
    }

    public void addLast(T e) {
        insertTail(e);
    }

    public void insertHead(T e){
        Node<T> newNode = new Node<>(e);

        if(isEmpty()) tail = newNode;
        else newNode.setNext(head);

        head = newNode;
        tail.setNext(head);
        size++;
    }

    public void addFirst(T e) {
        insertHead(e);
    }

    @Override
    public String toString(){
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        Node<T> current = head;
        int count = 0;

        // limit impede loop infinito caso a circularidade esteja errada
        while (count < size) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
            count++;
        }
        sb.append(current.getData());
        sb.append("(head) }");
        return sb.toString();
    }
}
