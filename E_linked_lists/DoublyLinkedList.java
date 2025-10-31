package E_linked_lists;

// Doubly, Circular and Ordered Linked List
public class DoublyLinkedList<T extends Comparable<T>> {
    DNode<T> head;
    int size;

    public DoublyLinkedList(){
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

    public void showAscending() {
        if(isEmpty()) {
            System.out.println("{}");
            return;
        }

        System.out.print("{ ");
        DNode<T> current = head;

        while (head.getRight() != head){
            System.out.print(current.getData()+" ");
            current = current.getRight();
        }
        System.out.println(current.getData() + "} ");
    }

    public void showDescending() {
        if(isEmpty()) {
            System.out.println("{}");
            return;
        }

        System.out.print("{ ");
        DNode<T> current = head.getLeft();
        while(current.getLeft() != head){
            System.out.print(current.getData() + " ");
            current = current.getLeft();
        }
        System.out.println(current.getData() + " ");
    }

    // TODO: test
    public int searchAscending(T e) {
        if (isEmpty()) return -1;

        int i = 0;
        DNode<T> current = head;
        while (current.getRight() != head && !current.getData().equals(e)) {
            current = current.getRight();
            i++;
        }

        if (current.getData().equals(e)) return i;
        return -1;
    }

//    public void insertAscending(T data){
//        // A LINHA DE BAIXO VAI FAZER AUX APONTAR PRA NULO!!!! VAI DAR PAU
//        DNode<T> newNode = new DNode<>(data, newNode, newNode); // Começa apontando para si próprio
//        if(isEmpty()) head = newNode;
//
//        DNode<T> pWalks = head;
//        while(pWalks.getData().compareTo(newNode.getData()) < 0){
//
//            pWalks = pWalks.getRight();
//        }
//    }
}
