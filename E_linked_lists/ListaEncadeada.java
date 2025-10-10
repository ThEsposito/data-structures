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

    public boolean isFull() {
        // Checagem para conferir se houve estouro de memória
        return new Node<>() == null;
    }

    public int getSize(){
        return this.size;
    }

    public Node<T> getHead(){
        return this.head;
    }

    // Cadê as exceções?????
    public Node<T> get(int pos) {
        if(this.isEmpty()) return null;
        if(pos <= 0 || pos > size) return null;

        int i = 1;
        Node<T> aux = head;
        while(i != pos){
            aux = aux.getNext();
            i++;
        }

        return aux;
    }

    public boolean insertHead(T e){
        if(isFull()) return false;

        if(isEmpty()) {
            head = new Node<>(e, null);
        } else {
            head = new Node<>(e, head);
        }
        this.size++;
        return true;
    }

    public boolean insertTail(T e){
        if(isFull()) return false;

        if(isEmpty()) {
            head = new Node<>(e, null);
        } else {
            Node<T> aux = head;
            int i=1;

            while(i != size-1){
                aux = aux.getNext();
                i++;
            }
            // Aux agora aponta para o último elemento da lista
            aux.setNext(new Node<>(e, null));
        }
        this.size++;
        return true;
    }

    public boolean addFirst(T e){
        return this.insertHead(e);
    }

    public boolean addLast(T e){
        return this.insertTail(e);
    }

    // TODO: conferir se esse método funciona normalmente
    public boolean insert(T e, int pos){
        if(pos <= 0) return false;
        if(this.isFull()) return false;

        if(pos==1) return this.addFirst(e);

        if(pos>=size) return this.addLast(e);

        // Elemento no meio da lista
        Node<T> aux = head;
        int i = 1;

        while(aux.getNext() != null && i != pos-1){
            aux = aux.getNext();
            i++;
        }

        // Aux aponta para o elemento anterior ao que vamos inserir
        aux.setNext(new Node<>(e, aux.getNext()));

        this.size++;
        return true;
    }

    // TODO: conferir se esse método funciona normalmente
    public Node<T> search(T e){
        if(this.isEmpty()) return null;

        Node<T> aux = head;

        while(aux.getNext() != null){
            if(aux.getData().equals(e)) return aux;
            aux = aux.getNext();
        }
        return null;
    }

    public boolean pollFirst(){
        if(isEmpty()) return false;

        this.head = head.getNext();
        this.size--;
        return true;
    }

    public boolean pollLast(){
        if(isEmpty()) return false;

        Node<T> aux = this.head;

        while(aux.getNext().getNext() != null){
            aux = aux.getNext();
        }
        // Agora aux aponta para o penúltimo elemento
        // Remove a referência para o próximo (e último) elemento
        aux.setNext(null);
        this.size--;
        return true;
    }

    public boolean removeAt(int pos) {
        if(this.isEmpty()) return false;
        if(pos < 0) return false;
        if(pos == 0) return this.pollFirst();
        if(pos >= size) return this.pollLast();

        Node<T> aux = head;
        int i = 1;
        while(i<pos){
            aux = aux.getNext();
            i++;
        }

        aux.setNext(aux.getNext().getNext());
        this.size--;

        return true;
    }

    public boolean remove(T e) {
        if(this.isEmpty()) return false;
        Node<T> aux = head;

        this.size--;
        return true;
    }
}
