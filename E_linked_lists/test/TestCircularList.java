package E_linked_lists.test;

import E_linked_lists.CircleLinkedList;
import E_linked_lists.Node;

public class TestCircularList {
    public static void main(String[] args) {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();

        System.out.println("=== Teste 1: Inserir em lista vazia ===");
        list.insertTail(10);
        System.out.println(list);
        System.out.println("Head: " + list.getHead().getData());
        System.out.println("Tail: " + list.getTail().getData());
        System.out.println("Tail.next == Head ? " + (list.getTail().getNext() == list.getHead()));

        System.out.println("\n=== Teste 2: Inserir mais elementos ===");
        list.insertTail(20);
        list.insertHead(30);
        list.insertHead(40);
        System.out.println(list);

        System.out.println("Size esperado: 4 -> " + list.getSize());
        System.out.println("Tail.next == Head ? " + (list.getTail().getNext() == list.getHead()));

        System.out.println("\n=== Teste 3: Circularidade real ===");
        Node<Integer> temp = list.getHead();
        for (int i = 0; i < 8; i++) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println("\n(A lista realmente volta ao início)");
        System.out.println("\nÍndice 2 da lista: "+list.get(2));
    }
}
