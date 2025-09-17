package C_queues.exercises;

import C_queues.FilaCircular;

public class Ex3 {
    public static void main(String[] args) {
        FilaCircular<Integer> f = new FilaCircular<>(11);
        for(int i =0; i<10; i++){
            f.enqueue(i);
        }
        System.out.println("Antes: ");
        for(int i=0; i<10; i++){
            Integer x = f.dequeue();
            System.out.print(x+" ");
            f.enqueue(x);
        }

        f.invert();

        System.out.println("Depois: ");

        for(int i=0; i<10; i++){
            Integer x = f.dequeue();
            System.out.print(x+" ");
            f.enqueue(x);
        }
    }
}
