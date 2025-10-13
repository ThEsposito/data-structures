package E_linked_lists;

public class ListaEncadeada<T> {
    private Node<T> head;
    private int size;

    public ListaEncadeada(){
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
        if(isEmpty()){
            this.head = new Node<>(e);
        } else {
            // Head passa a ser um novo elemento, que aponta para o antigo head
            head = new Node<>(e, head);
        }

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
}
