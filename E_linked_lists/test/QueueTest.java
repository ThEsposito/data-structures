package E_linked_lists.test;
import E_linked_lists.Queue;

public class QueueTest {

    public static void main(String[] args) {
        // Criando uma instância da fila
        Queue<Integer> queue = new Queue<>();

        // Testando a operação de verificação de fila vazia
        System.out.println("Fila está vazia? " + queue.isEmpty()); // Esperado: true

        // Enfileirando elementos
        System.out.println("Enfileirando elementos 10, 20, 30...");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Verificando o tamanho da fila
        System.out.println("Tamanho da fila: " + queue.getSize()); // Esperado: 3

        // Mostrando o primeiro e último elemento
        System.out.println("Frente da fila: " + queue.front()); // Esperado: 10
        System.out.println("Final da fila: " + queue.rear());  // Esperado: 30

        // Desenfileirando o primeiro elemento
        System.out.println("Desenfileirando elemento: " + queue.dequeue()); // Esperado: 10

        // Verificando o tamanho após o dequeue
        System.out.println("Tamanho da fila após desenfileirar: " + queue.getSize()); // Esperado: 2

        // Mostrando o primeiro e último elemento novamente
        System.out.println("Frente da fila agora: " + queue.front()); // Esperado: 20
        System.out.println("Final da fila agora: " + queue.rear());  // Esperado: 30

        // Testando se a fila está vazia após as operações
        System.out.println("Fila está vazia? " + queue.isEmpty()); // Esperado: false

        // Desenfileirando os outros elementos
        System.out.println("Desenfileirando elemento: " + queue.dequeue()); // Esperado: 20
        System.out.println("Desenfileirando elemento: " + queue.dequeue()); // Esperado: 30

        // Verificando se a fila está vazia agora
        System.out.println("Fila está vazia agora? " + queue.isEmpty()); // Esperado: true
    }
}
