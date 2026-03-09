package F_tree;

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

        if(value < root.value) return insertRecursively(root.left, value);
        else if(value > root.value) return insertRecursively(root.right, value);

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
    }

    private void inOrderRec(Node root) {
        if(root == null) return;

        inOrderRec(root.left);
        System.out.printf("%d ",root.value);
        inOrderRec(root.right);
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if(root == null) return;

        System.out.printf("%d ",root.value);
        inOrderRec(root.left);
        inOrderRec(root.right);
    }

    public void postOrder(){
        postOrderRec(root);
    }

    private void postOrderRec(Node root){
        if(root == null) return;

        inOrderRec(root.left);
        inOrderRec(root.right);
        System.out.printf("%d ",root.value);

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
