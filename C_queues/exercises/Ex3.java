package C_queues.exercises;

import C_queues.FilaCircular;

public class Ex3 {
    public static void main(String[] args) {
        int maxSize = 10;
        FilaCircular<Integer> f = new FilaCircular<>(maxSize);
        System.out.println("Antes: ");

        for(int i = 0; i<maxSize-2; i++){
            f.enqueue(i);
            System.out.print(i+" ");
        }


        f.invert();

        System.out.println("\nDepois: ");

        for(int i=0; i<f.size(); i++){
            Integer x = f.dequeue();
            System.out.print(x+" ");
            f.enqueue(x);
        }
    }
}
