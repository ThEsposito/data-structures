package E_linked_lists.test;

import E_linked_lists.DoublyCircularOrderedLinkedList;

public class Ex7Test {
    public static void main(String[] args) {
        DoublyCircularOrderedLinkedList<Integer> l =  new DoublyCircularOrderedLinkedList<>();

        for(int i=0; i<5; i++){
            l.insert(i);
        }
        System.out.println(l);
        l.invert();
        System.out.println(l);
    }
}
