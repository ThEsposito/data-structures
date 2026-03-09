package E_linked_lists.test;

import E_linked_lists.LinkedList;

public class Ex8Test {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        for(int i=0; i<5; i++){
            l1.addLast(i);
        }
        System.out.println("L1: "+l1);

        for(int i=6; i<10; i++) l2.addLast(i);
        System.out.println("L2: "+l2);

        l1.cat(l2);
        System.out.println("Cat: " + l1);
    }
}
