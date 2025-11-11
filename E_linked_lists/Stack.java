package E_linked_lists;

public class Stack<T> {
    private Node<T> head;
    private int size;

    public Stack(){
        this. head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(T e){
        head = new Node<T>(e, head);
        size++;
    }

    public T top() {
        return head.getData();
    }

    public T pop(){
        T e = head.getData();
        head = head.getNext();
        return e;;
    }

    public Node<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
}
