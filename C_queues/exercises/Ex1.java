package C_queues.exercises;
import C_queues.FilaCircular;

public class Ex1 {
    public static void main(String[] args) {
        FilaCircular<Integer> F = new FilaCircular<>(10);
        F.enqueue(5);
        for (int i = 0; i< 5; i++) F.enqueue(F.front() + i);
        F.enqueue(F.rear());
        F.enqueue(F. dequeue( ));
        F.enqueue(F.size());

        while (! F.isFull()) F.enqueue(F.rear());

        System.out.println("Resultado da Fila F: ");
        while(!F.isEmpty())
            System.out.println(F.dequeue( ) + " ");
    }
}
