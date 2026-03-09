package C_queues.exercises;

import B_stacks.Pilha;
import C_queues.FilaCircular;

public class Ex2 {
    public static void main(String args[]){
        FilaCircular<Integer> f = new FilaCircular<>(10);
        Pilha<Integer> p = new Pilha<>(10);
        int cont = 6;
        int digitoTIA = 6;
        while ( !p.isFull()) p.push( (digitoTIA +1)*cont--);
        while (!f.isFull()) f.enqueue( p.pop() % 2 );
        p.push(f.dequeue( ));
        p.push(f.dequeue( ));
        f.enqueue(p.pop() % 2 );
        while( !f.isEmpty( )) System.out.println( f.dequeue( ));
    }
}
