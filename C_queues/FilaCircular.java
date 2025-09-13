package C_queues;

public class FilaCircular <T> {
    private static final int DEFAULT_SIZE = 25;
    private T[] arr;
    private int inicio;
    private int fim;
    private int qtde;

    public FilaCircular(int size){
        this.arr = (T[]) new Object[size];
        this.qtde = 0;
        this.inicio = 0;
        this.fim = 0;
    }

    public FilaCircular(){
        this(DEFAULT_SIZE);
    }

    public boolean isEmpty(){
        return qtde==0;
    }

    public boolean isFull(){
        return this.qtde == arr.length;
    }

    // LEMBRE-SE!!! O mod é a chave pra implementação de uma fila circular!!!!!
    public void enqueue(T e) throws RuntimeException{
        if(this.isFull()) throw new RuntimeException();
        qtde++;
        this.arr[this.fim++] = e;

        // Se o fim ultrapassar os limites do array, retorna para o indice 0
        // Aí, basta não permitirmos que incluam mais um elemento caso o fim sobrescreva o elemento do início
        fim = (fim) % this.arr.length;
    }

    public T dequeue() throws RuntimeException {
        if(this.isEmpty()) throw new RuntimeException("Fila cheia");
        T aux = arr[inicio++];

        // Se o início, na linha de cima, tiver ultrapassado os indices do arr, volta pro zero tbem
        inicio = inicio % arr.length; 
        qtde--;

        return aux;
    }

    public T front() throws RuntimeException {
        if(this.isEmpty()) throw new RuntimeException("Fila vazia");
        return arr[inicio];
    }

    public T rear() throws RuntimeException {
        if(this.isEmpty()) throw new RuntimeException("Pilha cheia");
        int idxUltimo;
        if(this.fim == 0) idxUltimo = arr.length -1;
        else idxUltimo = fim-1;
        return arr[idxUltimo];
    }

    public int size() {
        return this.qtde;
    }
}