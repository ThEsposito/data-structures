// Em java, a alocação de memória é dinâmica: !
/*
Num programa, reserva-se espeço em memoria para a execução do program, dividida em duas partes:
 - Stack: Espaço reservado para guardar as chamadas de função e variáveis locais *do programa*
 - Heap: Espaço livre para armazenar os dados das variáveis (tá certo isso?).
*/

import java.util.Scanner;

public class Exemplo1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] consumos = new int[5]; 
        // S.O aloca (na heap) 40 bytes na memória (4 do int * 10) e retorna
        // um ponteiro. 
        // A variável de referência consumos agora faz REFERÊNCIA ao endereço de
        // memória contido no Heap. 
        // A variável de referência fica na stack.

        // Não temos acesso ao heap diretamente, então se perdemos a referência a uma variável
        // (de referência) perdemos o acesso àquele endereço de memória.


        // Como vetor, em java, é um objeto, temos acesso diretamente ao tamanho dele (um atributo), 
        // sem precisar ficar usando esse valor diretamente, como era em C.
        for(int i=0; i<consumos.length; i++){
            System.out.printf("Digite o consumo do %do setor: ", (i+1));
            consumos[i] = sc.nextInt();
        }

        // Detale: no foreach, consumo é apenas uma cópia da respectiva posição do vetor
        // Portanto, se alterarmos consumo, o vetor original permanece inalterado

        // Outro detalhe: se consumo fosse um objeto, e alterarmos ela para outro, o vetor
        // permanece fazendo referencia pro mesmo lugar em memória. Só o consumo é alterado e 
        // passa a fazer referencia pra outro objeto.
        // No entanto, se trocarmos uma variavel de consumo, o valor original será alterado, já
        // que está fazendo referencia pra mesma parte da memoria e alteramos diretamente lá;
        int qtdeAnomalos = 0;
        for(int consumo:consumos){
            if(consumo > 5000){
                qtdeAnomalos++;
                System.out.printf("Consumo anômalo: %d\n", consumo);
            }
        }

        System.out.printf("Quantidade de consumos anômalos: %d\n", qtdeAnomalos);
        sc.close();
    }

    // Dá pra ver o endereço de memória de uma var de referência?:
    /*
    Tentanto printar o vetor, podemos ver o hashCode. No entanto, ele é o endereço de memória
    da JVM.
    */
}