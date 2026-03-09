package E_linked_lists.test;

import E_linked_lists.LinkedList;

public class Ex12Test {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        for(int i=0; i<5; i++){
            l1.addLast(i);
        }
        System.out.println("L1: "+l1);

        for(int i=0; i<5; i++) l2.addLast(i);
        System.out.println("L2: "+l2);

        l1.merge(l2);
        System.out.println("Merge: " + l1);
        System.out.println("New size: "+l1.getSize());
    }
}
