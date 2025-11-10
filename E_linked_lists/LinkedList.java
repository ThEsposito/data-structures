package E_linked_lists;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList(){
        this.size = 0;
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getSize() {
        return this.size;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> getFirst(){
        return this.head;
    }

    public Node<T> getLast(){
        if(isEmpty()) return null;

        Node<T> aux = head;

        while(aux.getNext() != null){
            aux = aux.getNext();
        }

        return aux;
    }

    public Node<T> get(int pos){
        if(pos < 0 || pos >= size) return null; // Illegal Argument
        if(pos == 0) return this.getHead();

        Node<T> aux = head;

        for(int i=0; i<pos; i++){
            aux = aux.getNext();
        }

        return aux;
    }

    public void addFirst(T e){
        head = new Node<>(e, head); // Ainda funciona, se head for null
        size++;
    }

    public void addLast(T e){
        if(isEmpty()){
            this.head = new Node<>(e);
        } else {
            Node<T> aux = head;

            while(aux.getNext() != null){
                aux = aux.getNext();
            }

            aux.setNext(new Node<>(e));
        }
        size++;
    }

    public void insert(T e, int pos){
        if(pos < 0 || pos > size) return; // Illegal argument

        if(isEmpty() || pos == size) {
            this.addLast(e);
            return;
        }

        if(pos == 0){
            this.addFirst(e);
            return;
        }

        size++;
        Node<T> aux = head;
        for(int i=0; i<pos-1; i++){
            aux = aux.getNext();
        }

        aux.setNext(new Node<>(e, aux.getNext()));
    }

    public boolean remove(T e){
        if(isEmpty()) return false;
        Node<T> aux = head;
        Node<T> previous = null;

        while(aux != null && !aux.getData().equals(e)){
            previous = aux;
            aux = aux.getNext();
        }
        if(aux == null) return false; // Not found

        if(head == aux) {
            head = head.getNext();
        } else {
            previous.setNext(aux.getNext());
        }

        size--;
        return true;
    }

    public boolean removeAt(int pos){
        if(pos < 0 || pos >= size) return false;
        if(isEmpty()) return false;

        if(pos == 0) {
            pollFirst();
            return true;
        }

        if(pos == size-1){
            pollLast();
            return true;
        }

        Node<T> aux = head;
        for(int i=0; i<pos-1; i++){
            aux = aux.getNext();
        }
        aux.setNext(aux.getNext().getNext());
        size--;
        return true;
    }

    public Node<T> search(T data){
        if(this.isEmpty()) return null;

        Node<T> aux = head;

        while(aux != null){
            if(aux.getData().equals(data)) return aux;

            aux = aux.getNext();
        }

        return null; // Not found
    }

    public Node<T> pollFirst() {
        if(isEmpty()) return null; // Illegal State
        this.size--;

        Node<T> aux = head;
        head = head.getNext();
        return aux;
    }

    public Node<T> pollLast() {
        if(isEmpty()) return null;
        this.size--;

        // Se houver só 1 elemento
        if(head.getNext() == null) {
            Node<T> aux = head;
            head = null;
            return aux;
        }

        Node<T> aux = head;
        while (aux.getNext().getNext() != null){
            aux = aux.getNext();
        }

        Node<T> last = aux.getNext();
        aux.setNext(null);
        return last;
    }

    public void clear(){
        this.head = null;
        this.size = 0;
    }

    public void invert() { // Tempo em O(n), Memória em O(1)
        if(isEmpty() || size==1) return;

        Node<T> aux = head;
        Node<T> prior = null;
        Node<T> next = null;
        while(aux != null){
            next = aux.getNext();
            aux.setNext(prior);
            
            prior = aux;
            aux = next;            
        }
        head = prior;
    }

    public void cat(LinkedList<T> list){
        if(list.isEmpty()) return;

        if(this.isEmpty()){
            this.head = list.getHead();
            return;
        }

        Node<T> current = head;
        while(current.getNext() != null)
            current = current.getNext(); /// Find tail

        current.setNext(list.getHead());
        size += list.getSize();
    }


    public void merge(LinkedList<T> list) {
        if(list.isEmpty()) return;

        if(this.isEmpty()) {
            this.head = list.getHead();
            this.size = list.getSize();
            return;
        }

        Node<T> curA = this.head;
        Node<T> nextA = curA.getNext();

        Node<T> curB = list.getHead();
        Node<T> nextB = curB.getNext();

        while(nextA != null && nextB != null){
            nextA = curA.getNext();
            nextB = curB.getNext();

            curA.setNext(curB);
            curB.setNext(nextA);
            curA = nextA;
            curB = nextB;
        }

        if (nextA == null && curA != null) { // Fim dessa lista, completa com o da próxima
            curA.setNext(curB);
        }
        this.size+=list.getSize();



    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("[");

        Node<T> aux = head;

        while(aux != null){
            result.append(aux.getData());
            result.append(" ");
            aux = aux.getNext();
        }

        result.append(']');
        result.append("\nSize: ");
        result.append(size);
        result.append('\n');

        return result.toString();
    }
}
