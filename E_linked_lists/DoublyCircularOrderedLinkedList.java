package E_linked_lists;

// Doubly, Circular and Ordered Linked List
public class DoublyCircularOrderedLinkedList<T extends Comparable<T>> {
    DNode<T> head;
    int size;

    public DoublyCircularOrderedLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public int getSize(){
        return this.size;
    }

    public DNode<T> getHead() {
        return head;
    }

    // TODO: test
    public int search(T e) {
        if (isEmpty()) return -1;

        int i = 0;
        DNode<T> current = head;
        while (current.getRight() != head && current.getData().compareTo(e) <= 0) {
            current = current.getRight();
            i++;
        }

        if (current.getData().equals(e)) return i;
        return -1;
    }

    public void insert(T e){
        DNode<T> newNode = new DNode<>(e);

        if(isEmpty()) {
            head = newNode;
            head.setLeft(head);
            head.setRight(head);
            size++;
            return;
        }

        DNode<T> current = head;

        while(current.getRight() != head && current.getData().compareTo(e) < 0){
            current = current.getRight();
        }

        if(current == head && current.getData().compareTo(e) > 0) { // Não andou, inserção no começo
            newNode.setLeft(head.getLeft());
            newNode.setRight(head);

            head.getLeft().setRight(newNode);
            head.setLeft(newNode);
            head = newNode;
        } else if(current.getRight() == head && current.getData().compareTo(e) < 0){ // Insserçãao no final
            newNode.setRight(head);
            newNode.setLeft(current);
            current.setRight(newNode);
            head.setLeft(newNode);
        } else { // Inserção no final
            newNode.setRight(current);
            newNode.setLeft(current.getLeft());

            current.getLeft().setRight(newNode);
            current.setLeft(newNode);
        }
        size++;
    }

    public boolean remove(T data){
        if(isEmpty()) return false;

        DNode<T> current = head;
        while(current.getRight() != head && current.getData().compareTo(data) < 0) {
            current = current.getRight();
        }

        if(!current.getData().equals(data)) return false;

        if (current == current.getRight()){ // Remove the single element
            head = null;
        } else if(current == head) { // Found at head (1st iteration)
            DNode<T> tail = current.getLeft();
            head = current.getRight();
            head.setLeft(tail);
            tail.setRight(head);

        } else {
            current.getLeft().setRight(current.getRight());
            current.getRight().setLeft(current.getLeft());
        }

        // Cleaning references
        current.setLeft(null);
        current.setRight(null);;

        size--;
        return true;
    }

    public void invert() {
        if(isEmpty() || head == head.getRight()) return; // size <= 1;

        DNode<T> current = head;
        DNode<T> right = null;

        while(right != head){
            right  = current.getRight();

            current.setRight(current.getLeft());
            current.setLeft(right);

            current = right;
        }

        head = current.getRight();
    }

//    public void insertAscending(T data){
//        // A LINHA DE BAIXO VAI FAZER AUX APONTAR PRA NULO!!!! VAI DAR PAU
//        DNode<T> newNode;
//        newNode = new DNode<>(data, newNode, newNode); // Começa apontando para si próprio
//        if(isEmpty()) head = newNode;
//
//        DNode<T> pWalks = head;
//        while(pWalks.getData().compareTo(newNode.getData()) < 0){
//
//            pWalks = pWalks.getRight();
//        }
//    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        if(isEmpty()) return "{}";

        sb.append("{");
        DNode<T> current = head;

        while (current.getRight() != head){
            sb.append(current.getData()).append(" ");
            current = current.getRight();
        }
        sb.append(current.getData()).append("} ");
        return sb.toString();
    }
}
