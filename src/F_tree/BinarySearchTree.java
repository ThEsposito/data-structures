package F_tree;

import E_linked_lists.CircleLinkedList;
import E_linked_lists.Queue;

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

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.print('\n');
    }

    private void inOrderTraversalRec(Node root) {
        if(root == null) return;

        inOrderTraversalRec(root.left);
        System.out.printf("%d ",root.value);
        inOrderTraversalRec(root.right);
    }

    public void preOrderTraversal() {
        preOrderTraversalRec(root);
        System.out.print('\n');

    }

    private void preOrderTraversalRec(Node root) {
        if(root == null) return;

        System.out.printf("%d ",root.value);
        preOrderTraversalRec(root.left);
        preOrderTraversalRec(root.right);
    }

    public void postOrderTraversal(){
        postOrderTraversalRec(root);
        System.out.print('\n');
    }

    private void postOrderTraversalRec(Node root){
        if(root == null) return;
        postOrderTraversalRec(root.left);
        postOrderTraversalRec(root.right);
        System.out.printf("%d ",root.value);
    }

    public void levelOrderTraversal() {
        Queue<Node> q = new Queue<>();
        q.enqueue(root);

        while(!q.isEmpty()){
            Node root = q.dequeue();
            System.out.printf("%d ", root.value);

            if(root.left != null) q.enqueue(root.left);
            if(root.right != null) q.enqueue(root.right);
        }
        System.out.print('\n');
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

//    public int getHeight(){
//        return getHeightRecursive(root, 0) - 1;
//    }
//
//    private int getHeightRecursive(Node root, int i) {
//
//    }

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
