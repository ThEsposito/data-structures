package D_deques;

public class Deque <T> {
    private static final int DEFAULT_SIZE = 100;
    private int inicio;
    private int fim;
    private int qtde;
    private T[] arr;

    public Deque(int size) {
        this.arr = (T[]) new Object[size];
        this.inicio = 0;
        this.fim = 0;
        this.qtde = 0;
    }

    public Deque() {
        this(DEFAULT_SIZE);
    }

    public boolean isEmpty() {
        return qtde == 0;
    }

    public boolean isFull() {
        return qtde == arr.length;
    }

    public void enqueueLeft(T e) throws RuntimeException {
        if (this.isFull()) throw new RuntimeException("Overflow: Deque cheio");

        this.qtde++;

        this.inicio = (inicio == 0) ? arr.length - 1 : inicio - 1;
        this.arr[inicio] = e;
    }

    public void enqueueRight(T e) throws RuntimeException {
        if (this.isFull()) throw new RuntimeException("Overflow: Deque cheio");

        this.qtde++;

        this.arr[fim++] = e;
        fim %= arr.length;
    }

    public T dequeueLeft() throws RuntimeException {
        if (this.isEmpty()) throw new RuntimeException("Underflow: Deque vazio");

        this.qtde--;

        T aux = arr[inicio];
        this.inicio = (inicio + 1) % arr.length;
        return aux;
    }

    public T dequeueRight() throws RuntimeException {
        if (this.isEmpty()) throw new RuntimeException("Underflow: Deque vazio");

        this.qtde--;

        this.fim = (fim == 0) ? arr.length - 1 : fim - 1;
        return arr[fim];
    }

    public T getLeft() throws RuntimeException {
        if(this.isEmpty()) throw new RuntimeException("Underflow: Deque vazio");

        return arr[inicio];
    }

    public T getRight() throws RuntimeException {
        if (this.isEmpty()) throw new RuntimeException("Underflow: Deque vazio");

        if(fim == 0) return arr[arr.length-1];
        else return arr[fim-1];
    }

    public int size() {
        return this.qtde;
    }
}