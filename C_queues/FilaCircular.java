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

    public void invert() throws RuntimeException{
        if(this.isEmpty()) throw new RuntimeException("Fila vazia");

        // i aponta para o primeiro elemento e j para o último
        int i = this.inicio;
        int j;

        if(this.fim == 0) j = arr.length - 1;
        else j = this.fim-1;

        T temp;

        // A segunda condição serve para quando o i e o j se cruzam, mas permanecem diferentes
        while(i != j && (i + arr.length - 1) % arr.length != j){
            temp = this.arr[i];
            this.arr[i] = this.arr[j];
            this.arr[j] = temp;

            i = ++i % arr.length;
            if(j==0) j = arr.length - 1;
            else j--;
        }

        // Outra forma de implementar (mais simples e mais legível):
//        if(this.isEmpty()) throw new RuntimeException("Fila Vazia");
//
//        int i = this.inicio;
//        int j = (fim == 0) ? arr.length-1 : fim-1;
//
//        for(int k=0; k<qtde/2; k++){
//            T temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//
//            i = (i+1)%arr.length;
//            j = (j==0) ? arr.length - 1 : j-1;
//        }
    }

    /*
    Elaborar um método da classe fila circular que remova
    TODOS os elementos de ordem par da fila. Fazer um
    programa principal de teste.
    */
    public void dequeuePosEven() throws RuntimeException {
        if(this.isEmpty()) throw new RuntimeException("FIla vazia");

//        int i = inicio;
//        int ultimo = (fim == 0) ? arr.length - 1 : fim-1;
//
//        // Vou começar iterando pelo elemento logo após o início
//        int ordem = 2;
//        int newIdx = (inicio + 1)%arr.length;
//        while(i != ultimo){
//
//            ordem +=2;
//        }
        // Começa pelo 1o elemento do vetor (ordem 2)
        int elemtAtual;
        int novoIdx = this.inicio;

        for(int i=1; i<qtde; i+=2){

        }
    }
}