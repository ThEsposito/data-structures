package B_stacks;

import java.util.EmptyStackException;

public class PilhaGenerica <T> {
    private static final int DEFAULT_SIZE = 100;
    private T[] arr;
    private int top;

    public PilhaGenerica(int size){
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    public PilhaGenerica(){
        this.arr = (T[]) new Object[DEFAULT_SIZE];
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top>=(arr.length-1);
    }

    public void push(T element) throws StackOverflowError {
        if(this.isFull()) throw new StackOverflowError();
        this.arr[++top] = element;
    }

    public T pop() throws EmptyStackException{
        if(this.isEmpty()) throw new EmptyStackException();
        return arr[top--];
    }

    public T top() throws EmptyStackException{
        if(this.isEmpty()) throw new EmptyStackException();
        return arr[top];
    }
}