package E_linked_lists.test;

import E_linked_lists.LinkedList;

public class Ex1Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<10; i++){
            list.addLast(i);
        }
        System.out.print("Antes: ");
        System.out.println(list);
        list.invert();

        System.out.println("Depois: ");
        System.out.println(list);
    }
}
