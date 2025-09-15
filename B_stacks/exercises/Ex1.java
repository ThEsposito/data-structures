package B_stacks.exercises;

import B_stacks.Pilha;

import java.util.Scanner;

/*
5. Considere o trecho de código abaixo para a pilha P (tam. 100) com valores
numéricos inteiros positivos. Faça um programa que remova todos os múltiplos
de 3 de P1 e mantenha a mesma ordem dos elementos não múltiplos.
 */
public class Ex1 {
    public static void main(String[] args) {
        Pilha<Integer> p = new Pilha<>(100);
        int n, cont = 0;
        char resp;
        Scanner s = new Scanner(System.in);

        do {// leitura dos números
            System.out.print("Deseja fornecer um nro (S/N): ");
            resp = s.next().toUpperCase().charAt(0);
            if (resp == 'S') {
                System.out.print("Forneça o " + ++cont + "o nro: ");
                n = s.nextInt();
                p.push(n);
            }
        } while (resp == 'S');

        // INSERIR O SEU CÓDIGO AQUI
        Pilha<Integer> aux = new Pilha<>(100);

        while (!p.isEmpty()) {
            int x = p.pop();

            if(x%3 != 0) {
                aux.push(x);
            }
        }

        // Devolvendo os elementos e mantendo ordem original
        // Se fosse só para exibir os elementos não múltiplos, não precisaria desse
        // laço. Bastaria exibir no laço de cima e nem precisaríamos da pilha auxiliar.
        while (!aux.isEmpty()) {
            p.push(aux.pop());
            System.out.print(p.top()+" ");
        }
    }
}