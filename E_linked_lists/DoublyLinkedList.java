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
