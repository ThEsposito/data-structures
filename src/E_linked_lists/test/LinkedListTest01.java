package E_linked_lists.test;

import E_linked_lists.LinkedList;

public class LinkedListTest01 {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<Integer>();

        int[] ids1 = {5, 2, 15, 7, 35, 77, 81, 15, 12, 115, 17, 135, 177, 181};

        // Insere o vetor ids1 no final da lista
        for(int i = 0; i < ids1.length; ++i) lista.addLast(ids1[i]);
        System.out.println(lista);

        // Verifica se o 35 está na lista
        int valor = 35;
        if (lista.search(valor) !=  null)
            System.out.printf("Valor: %d, existe na lista%n", lista.search(valor).getData());
        else
            System.out.printf("Valor: %d, não existe na lista%n", valor);

        // Remove o elemento 12 da lista
        System.out.println("Remoção do 12: ");
        lista.remove(12);
        System.out.println(lista);

        // Percorre a lista e apresenta os dados
        System.out.print("L: [ ");
        int tam = lista.getSize();
        for(int pos = 0; pos < tam; pos++) {
            if (pos != tam)
                System.out.print(String.format("%2do: %d, ", pos, lista.get(pos).getData().intValue()));
            else
                System.out.print(String.format("%2do:%d ", pos, lista.get(pos).getData().intValue()));
        }
        System.out.println("]");

        // Insere um elemento em posição definida
        lista.insert(200, 10);
        System.out.println(lista);
    }
}
