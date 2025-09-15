package C_queues;

public class FilaCircular <T> {
    private static final int DEFAULT_SIZE = 100;
    private final T[] arr;
    private int inicio;
    private int fim;
    private int qtde;

    public FilaCircular(int size){
        arr = (T[]) new Object[size];
        int inicio = 0;
        int fim = 0;
        int qtde = 0;
    }

    public FilaCircular(){
        arr = (T[]) new Object[DEFAULT_SIZE];
        int inicio = 0;
        int fim = 0;
        int qtde = 0;
    }

    // Tá certo isso aqui????
    public boolean isFull(){
        return qtde==arr.length;
    }

    public boolean isEmpty(){
        return qtde == 0;
    }

    public void enqueue(T e) throws RuntimeException{
        if(isFull()) throw new RuntimeException("Fila cheia");

        arr[fim] = e;
        fim = (fim+1)%arr.length;
        qtde++;
    }

    public T dequeue() throws RuntimeException{
        if(isEmpty()) throw new RuntimeException("Fila vazia");

        T result = arr[inicio];
        qtde--;
        inicio = (inicio+1)%arr.length;
        return result;
    }

    public T front() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Fila vazia");
        return arr[inicio];
    }

    public T rear() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Fila vazia");
        return arr[fim];
    }

    public int size() {
        return this.qtde;
    }
}