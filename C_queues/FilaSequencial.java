package C_queues;

class FilaSequencial <T> {
    private static final int DEFAULT_SIZE = 50;
    private T[] arr;
    private int inicio;
    private int fim;
    
    FilaSequencial(int size) throws IllegalArgumentException{
        if(size<=1) throw new IllegalArgumentException();
        T = (T[]) new Object[size];
        this.inicio = 0;
        this.fim = 0;
    }

    public boolean isEmpty(){
        return inicio==fim; // que é igual à arr.length - 1 (eu acho)
    }

    public boolean isFull(){
        return this.inicio == (arr.length-1)        ;
    }

    public void enqueue(T e) throws RuntimeException {
        if(this.isFull()) throw new RuntimeException();
        arr[fim++] = e;
    }

    public T dequeue() throws RuntimeException{
        if(this.isEmpty) throw new RuntimeException();
        return arr[inicio++];
    }

    public T front() throws RuntimeException{
        if(this.isEmpty) throw new RuntimeException();
        return arr[inicio];
    }

    public T rear() throws RuntimeException{
        if(this.isEmpty) throw new RuntimeException();
        return arr[fim];
    }

    // TOME CUIDADO!! Se estiver cheia tambem vai retornar zero!!!!!
    public int elementCount() {
        if(this.isEmpty()) return 0;

        return this.fim-this.inicio;
    }
}