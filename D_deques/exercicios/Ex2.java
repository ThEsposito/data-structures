package D_deques.exercicios;

import B_stacks.Pilha;
import C_queues.FilaCircular;
import D_deques.Deque;
import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Scanner;

/*
Suponha duas filas chamadas qpar e qimpar e uma pilha s. Considere que as três estruturas
são representadas por vetores com, no máximo, 30 elementos.

Solicita-se o desenvolvimento de um algoritmo que lê uma sequência indeterminada de valores
inteiros. Assuma que o valor zero finaliza a entrada de dados. Em seguida, deve ser determinado se
um número lido é par ou ímpar.

Se o número for par, devemos colocá-lo na fila qpar; caso contrário, na fila qímpar. Logo após a
entrada do valor zero, alternadamente (começando-se pela fila qímpar), devemos retirar um
elemento de cada fila até o momento em que ambas tornam-se vazias.

Se o elemento retirado de uma das filas for um valor positivo, devemos colocá-lo na pilha s; caso
contrário, removemos um elemento da pilha s. Quando finalizarmos esse processo, devemos exibir todo
o conteúdo da pilha s.
Simular as filas e a pilha utilizando DEQUE.
 */
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> p = new Deque<>(30);
        Deque<Integer> qPar = new Deque<>(30);
        Deque<Integer> qImpar = new Deque<>(30);

        int n = sc.nextInt();
        while (n != 0){
            if(n%2 == 0) qPar.enqueueRight(n);
            else qImpar.enqueueRight(n);

            n = sc.nextInt();
        }

        // DeMorgan: !qPar.isEmpty() && !qImpar.isEmpty() = !(qPar.isEmpty() || qImpar.isEmpty())

        while(!( qPar.isEmpty() || qPar.isEmpty() )){
            if(!qImpar.isEmpty()) {
                int impar = qImpar.dequeueLeft();

                if (impar > 0) p.enqueueRight(impar);
                else if (!p.isEmpty()) p.dequeueRight();
            }

            if(!qPar.isEmpty()) {
                int par = qPar.dequeueLeft();

                if (par > 0) p.enqueueRight(par);
                else if (!p.isEmpty()) p.dequeueRight();
            }
        }

        // Como estou tratando p como uma pilha, ele vai exibir os resultados em ordem inversa.
        // Pra não ter que criar outra lógica pra exibir na mesma ordem de inserção, bastaria
        // usar um .dequeueLeft(). Optei por usar p como pilha até o fim para fins didáticos.

        while(!p.isEmpty()){
            System.out.print(p.dequeueRight()+" ");
        }
    }
}
