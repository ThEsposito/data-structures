package B_stacks.exercises;

import B_stacks.Pilha;

import java.util.Scanner;

/*
Escrever um Programa que empilha uma sequência de
valores numéricos inteiros positivos até o momento em que o
valor 999 for digitado. Neste momento, o conteúdo da pilha
deverá ser distribuído em outras duas pilhas. Uma delas conterá
apenas os valores ímpares, e a outra apenas os valores pares.
Apresente ao final o total de elementos da Pilha original, o total
da Pilha de números pares e o da Pilha de números ímpares.
 */
public class Ex2 {
    public static void main(String[] args) {
        Pilha<Integer> p = new Pilha<>(100);
        Scanner sc = new Scanner(System.in);

        int n;
        do{
            n = sc.nextInt();
            if(n>0){
                p.push(n);
            } else {
                System.out.println("O valor tem que ser positivo, né irmão.");
            }
        } while(n!=999);

        Pilha<Integer> pares = new Pilha<>(100);
        Pilha<Integer> impares = new Pilha<>(100);

        while(!p.isEmpty()){
            int x = p.pop();
            if(x%2 == 0){
                pares.push(x);
            } else {
                impares.push(x);
            }
        }


        System.out.print("Elementos pares: ");
        while(!pares.isEmpty()){
            System.out.println(pares.pop()+" ");
        }
        System.out.print("Elementos pares: ");
        while(!impares.isEmpty()){
            System.out.println(impares.pop()+" ");
        }
        System.out.println("Qtde de valores pares: "+pares.size());
        System.out.println("Qtde de valores ímpares: "+impares.size());
        System.out.println("Tamanho da pilha original: "+pares.size()+impares.size());
    }
}
