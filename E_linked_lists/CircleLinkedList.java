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
        if(idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index "+idx+" out of bounds for length "+size);

        if(idx == size-1) return tail.getData();

        Node<T> current = head;

        // O(n)
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

    public void insert(T e, int idx){
        if(idx < 0 || idx > size)
            throw new IndexOutOfBoundsException("Index "+idx+" out of bounds for length "+size);

        if(idx == size) addLast(e);
        else if(idx == 0) addFirst(e);
        else {
            Node<T> newNode = new Node<>(e, null);
            Node<T> current = head;

            for(int i=0; i<idx-1; i++) current = current.getNext();
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    }

    public int search(T e){
        if(isEmpty()) return -1;

        Node<T> current = head;
        int i = 0;
        while(current != tail && !current.getData().equals(e)) {
            current = current.getNext();
            i++;
        }

        if(current.getData().equals(e)) return i;

        return -1;
    }

    public boolean remove(T e){
        if(isEmpty()) return false;

        Node<T> current = head;
        Node<T> prev = null;

        while(current != tail && !current.getData().equals(e)){
            prev = current;
            current = current.getNext();
        }

        if(!current.getData().equals(e)) return false; // not found, including tail

        if(prev == null) { // Remove head
            head = head.getNext();
            tail.setNext(head);
        } else if(current == tail) { // Remove teil
            tail.setNext(null);
            tail = prev;
            tail.setNext(head);
        } else if(head == tail){ // Remove the only element
            head = tail = null;
        } else { // Not extremities
            prev.setNext(current.getNext());
        }
        size--;
        return true;
    }

    // TODO: test
    public void removeAt(int idx){
        if(isEmpty()) throw new NoSuchElementException();
        if(idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index "+idx+" out of bounds for length "+size);

        if(idx == size-1) pollLast();
        else {
            Node<T> current = head;
            for(int i=0; i<idx-1; i++) current = current.getNext();

            Node<T> next = current.getNext();
            current.setNext(head);
            next.setNext(null);

            size--;
        }

    }

    public T pollFirst(){
        if(isEmpty()) throw new NoSuchElementException();

        Node<T> first = head;

        if(tail == head){ // 1 element
            tail = head = null;
        } else {
            head = head.getNext();
            tail.setNext(head);
        }
        size--;
        first.setNext(null); // Disconnects the removed node to allow GC and avoid lingering references
        return first.getData();
    }

    public T pollLast(){
        if(isEmpty()) throw new NoSuchElementException();
        Node<T> last = tail;

        if(head == tail) head = tail = null;
        else {
            Node<T> current = head;
            while(current.getNext() != tail) current = current.getNext(); // O(n)
            current.setNext(head);
            tail = current;
        }
        size--;
        last.setNext(null);
        return last.getData();
    }

    public T pollAt(int idx){
        if(isEmpty()) throw new NoSuchElementException();
        if(idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index "+idx+" out of bounds for length "+size);

        if(idx == size-1) return pollLast();

        Node<T> current = head;

        for(int i=0; i<idx-1; i++) current = current.getNext();

        Node<T> next = current.getNext();
        current.setNext(head);
        next.setNext(null);
        size--;

        return next.getData();
    }

    public void invert(){
        if(head == null || head == tail) return; // if(size<=1)

        Node<T> current = head;
        Node<T> prev = tail;
        Node<T> next = head.getNext();

        while(current != tail){
            current.setNext(prev);
            prev = current;
            current = next;

            next = next.getNext();
        }
        current.setNext(prev);

        tail = head;
        head = current; // Current points to tail when the loop stops
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
