package E_linked_lists;

public class DNode<T extends Comparable<T>> {
    T data;
    DNode<T> left;
    DNode<T> right;

    public DNode(T data, DNode<T> left, DNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public DNode<T> getLeft() {
        return left;
    }

    public void setLeft(DNode<T> left) {
        this.left = left;
    }

    public DNode<T> getRight() {
        return right;
    }

    public void setRight(DNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
