package D_deques.exercicios;

/*
Fazer um programa em Java que leia uma frase e imprima-a com as
palavras invertidas. Exemplo: A frase ‘um por todos e todos por um’,
deverá ficar ‘mu rop sodot e sodot rop mu’. Utilize um DEQUE durante a
operação de inversão.
 */

import D_deques.Deque;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite sua frase: ");
        String frase = sc.nextLine();

        Deque<Character> d = new Deque<>(frase.length());
        /*
        Aqui estamos usando um deque como se fosse uma pilha!
        Para isso, basta retirar os elementos pela mesma extremidade em que
        eles foram inseridos! Dessa forma, ele vira um LIFO.
         */
        for(int i = 0; i < frase.length(); i++){
            d.enqueueRight(frase.charAt(i));;
        }

        while(!d.isEmpty()) System.out.print(d.dequeueRight());

        System.out.println();
        sc.close();
    }
}
