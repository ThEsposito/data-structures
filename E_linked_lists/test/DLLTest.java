package E_linked_lists.test;

import E_linked_lists.DoublyCircularOrderedLinkedList;

public class DLLTest {
    public static void main(String[] args) {
        DoublyCircularOrderedLinkedList<Integer> list = new DoublyCircularOrderedLinkedList<>();

        System.out.println("1️⃣ Inserção em lista vazia: 10");
        list.insert(10);
        System.out.println(list); // [10]

        System.out.println("\n2️⃣ Inserção no começo (menor que head): 5");
        list.insert(5);
        System.out.println(list); // [5, 10]

        System.out.println("\n3️⃣ Inserção no meio: 7");
        list.insert(7);
        System.out.println(list); // [5, 7, 10]

        System.out.println("\n4️⃣ Inserção no fim (maior que todos): 20");
        list.insert(20);
        System.out.println(list); // [5, 7, 10, 20]

        System.out.println("\n5️⃣ Inserção de elemento repetido: 10");
        list.insert(10);
        System.out.println(list); // [5, 7, 10, 10, 20]

        System.out.println("\n✅ Teste finalizado!");
    }
}