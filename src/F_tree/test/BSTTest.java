package F_tree.test;

import F_tree.BinarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(6);
        tree.insert(-1);

        System.out.println("Search 4: "+tree.contains(4));
        System.out.println("Search 6: "+tree.contains(6));
        try {
            System.out.println("Min: " + tree.findMin());
            System.out.println("Max: " + tree.findMax());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
    }
}
