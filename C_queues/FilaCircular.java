package C_queues;

public class FilaCircular <T> {
    private static final int DEFAULT_SIZE = 100;
    private final T[] arr;
    private int inicio;
    private int fim;
    private int qtde;

    public FilaCircular(int size){
        arr = (T[]) new Object[size];
        this.inicio = 0;
        this.fim = 0;
        this.qtde = 0;
    }

    public FilaCircular(){
        this(DEFAULT_SIZE);
    }

    public boolean isFull(){
        return qtde==arr.length;
    }

    public boolean isEmpty(){
        return qtde == 0;
    }

    public void enqueue(T e) throws RuntimeException{
        if(isFull()) throw new RuntimeException("Fila cheia");

        arr[fim] = e;
        fim = ++fim % arr.length;
        qtde++;
    }

    public T dequeue() throws RuntimeException{
        if(isEmpty()) throw new RuntimeException("Fila vazia");

        T result = arr[inicio];
        qtde--;
        inicio = ++inicio % arr.length;
        return result;
    }

    public T front() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Fila vazia");
        return arr[inicio];
    }

    public T rear() throws RuntimeException {
        if(isEmpty()) throw new RuntimeException("Fila vazia");

        // Índice para o último elemento da fila
        int pfinal;

        if(this.fim == 0) pfinal = arr.length - 1;
        else pfinal = this.fim - 1;

        return this.arr[pfinal];
    }

    public int size() {
        return this.qtde;
    }
    // TODO: exercício 6
    public void invert() throws RuntimeException{
        if(this.isEmpty()) throw new RuntimeException("Fila vazia");

        // i aponta para o primeiro elemento e j para o último
        int i = this.inicio;
        int j;

        if(this.fim == 0) j = arr.length - 1;
        else j = this.fim-1;

        T temp;

        // A segunda condição serve para quando o i e o j se cruzam, mas permanecem diferentes
        while(i != j && (i-1)%arr.length != j){
            temp = this.arr[i];
            this.arr[i] = this.arr[j];
            this.arr[j] = temp;

            i = ++i % arr.length;
            if(j==0) j = arr.length - 1;
            else j--;
        }
    }

    // TODO: exercício 7
    public void dequeuePosEven() {

    }
}