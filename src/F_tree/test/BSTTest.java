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
        tree.insert(12);

/*
            5
          /    \
         3      8
       /  \    /  \
      1    4  7    9
     /       /      \
   -1       6       12
*/

        System.out.println("Search 4: "+tree.contains(4));
        System.out.println("Search 6: "+tree.contains(6));
        try {
            System.out.println("Min: " + tree.findMin());
            System.out.println("Max: " + tree.findMax());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.print("Pre-order: ");
        tree.preOrderTraversal();

        System.out.print("In-order: ");
        tree.inOrderTraversal();

        System.out.print("Post-order: ");
        tree.postOrderTraversal();

        System.out.println("Level Order: ");
        tree.levelOrderTraversal();

        System.out.println("Is this a BST?: "+tree.isBst());

        System.out.println("Nodes: " + tree.size());

        System.out.println("To Ordered List: " + tree.toOrdererList());

    }
}
