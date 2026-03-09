package F_tree;

import E_linked_lists.CircleLinkedList;
import E_linked_lists.LinkedList;

import java.util.List;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value){
        root = insertRecursively(root, value);
    }

    private Node insertRecursively(Node root, int value){
        if(root == null) return new Node(value);

        if(value < root.value) root.left = insertRecursively(root.left, value);
        else if(value > root.value) root.right = insertRecursively(root.right, value);

        return root;
    }

    public boolean contains(int value){
        return containsRec(this.root, value);
    }

    private boolean containsRec(Node root, int value){
        if(root == null) return false;
        if(root.value == value) return true;

        return value < root.value ? containsRec(root.left, value) : containsRec(root.right, value);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int findMin() throws Exception{
        if(isEmpty()) throw new Exception("Empty Tree!");

        Node current = root;
        while(current.left != null){
            current = current.left;
        }

        return current.value;
    }

    public int findMax() throws Exception {
        if (isEmpty()) throw new Exception("Empty Tree!");

        Node current = root;
        while(current.right != null) {
            current = current.right;
        }

        return current.value;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.print('\n');
    }

    private void inOrderRec(Node root) {
        if(root == null) return;

        inOrderRec(root.left);
        System.out.printf("%d ",root.value);
        inOrderRec(root.right);
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.print('\n');

    }

    private void preOrderRec(Node root) {
        if(root == null) return;

        System.out.printf("%d ",root.value);
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void postOrder(){
        postOrderRec(root);
        System.out.print('\n');
    }

    private void postOrderRec(Node root){
        if(root == null) return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.printf("%d ",root.value);
    }

    // It's just an exercise. Always return true.
    public boolean isBst() {
        return isBstRecursive(root);
    }

    private boolean isBstRecursive(Node root){
        if(root == null) return true;

        if(root.left != null && root.left.value > root.value) return false;
        if(root.right != null && root.right.value < root.value) return false;

        return isBstRecursive(root.left) && isBstRecursive(root.right);
    }

    public int size() {
        return sizeRecursive(root, 0);
    }

    private int sizeRecursive(Node root, int i) {
        if(root == null) return 0;

        int j = 1;
        j += sizeRecursive(root.left, i);
        j += sizeRecursive(root.right, i);

        return i+j;
    }

    public CircleLinkedList<Integer> toOrdererList(){
        CircleLinkedList<Integer> l = new CircleLinkedList<>();
        toOrderedListRecursive(root, l);
        return l;
    }

    private void toOrderedListRecursive(Node root, CircleLinkedList<Integer> list){
        if(root == null) return;

        toOrderedListRecursive(root.left, list);
        list.insertTail(root.value);
        toOrderedListRecursive(root.right, list);
    }

    private static class Node {
        int value;
        Node left, right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value){
            this.value = value;
        }
    }
}
