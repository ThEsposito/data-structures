package C_queues.exercises;

import C_queues.FilaCircular;

public class Ex5 {
    public static void main(String[] args) {
        int maxSize = 5;
        FilaCircular<Integer> f = new FilaCircular<>(maxSize);

        // F = { 0, 1, 2, 3, 4 }
        System.out.print("F = { ");
        for(int i=0; i<maxSize; i++){
            f.enqueue(i);
            System.out.print(i+ " ");
        }
        System.out.println('}');

        // F = { 0, 2, 4 }
        f.dequeuePosOdd();

        System.out.print("F = { ");
        while(!f.isEmpty()){
            System.out.print(f.dequeue()+" ");
        }
        System.out.println('}');

    }
}
