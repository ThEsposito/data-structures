package E_linked_lists.test;

import E_linked_lists.CircleLinkedList;

public class Ex6Test {
    public static void main(String[] args) {
        CircleLinkedList<Integer> l = new CircleLinkedList<>();

        for(int i=0; i<100; i++)
            l.addLast(i);
        System.out.println(l);

        l.invert();
        System.out.println(l);
    }
}
