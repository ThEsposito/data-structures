package project;

import java.util.EmptyStackException;

public class Stack <T> {
    private static final int DEFAULT_ARR_SIZE = 50;
    private int top;
    private T[] arr;

    Stack (int size){
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    Stack(){
        this.arr = (T[]) new Object[DEFAULT_ARR_SIZE];
        this.top = -1;
    }

    public boolean isFull(){
        return top==(arr.length - 1);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(T e) throws StackOverflowError {
        if(isEmpty()) throw new StackOverflowError("A pilha estourou");
        
        arr[++top] = e;
    }

    public T pop() throws EmptyStackException {
        if(isFull()) throw new EmptyStackException();
        return arr[top--];
    }

    public T top() throws EmptyStackException {
        if(isFull()) throw new EmptyStackException();
        return arr[top];
    }
}
