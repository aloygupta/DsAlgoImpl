package testclasses;

import tree.Tree;
import tree.implementation.BSTIterative;
import tree.implementation.BSTRecursive;

public class TreeTest {

    public static void main(String[] args){

        Tree<Integer> tree = new BSTIterative<>();
        try {
            //small test data
            /* tree.insert(1);
           tree.insert(6);
           tree.insert(3);;*/


            //System.out.println("Height of tree: "+tree.getHeight());  // exception, empty BST
            tree.insert(56);
            tree.insert(44);
            tree.insert(23);
            tree.insert(90);
            tree.insert(51);
            //tree.insert(23);  // will throw exception

            tree.printValues(Tree.TraversalStyle.PREORDER);
            System.out.println();
            tree.printValues(Tree.TraversalStyle.INORDER);
            System.out.println();
            //tree.printValues(Tree.TraversalStyle.POSTORDER);
            //System.out.println();
            tree.printValues(Tree.TraversalStyle.LEVELORDER);
            System.out.println();
            System.out.println("Node count: "+tree.getNodeCount());
            System.out.println("Height of tree: "+tree.getHeight());

            System.out.println();
            System.out.println("Deleting 56");
            tree.deleteValue(56);
            //tree.deleteValue(9999); // will throw exception
            tree.printValues(Tree.TraversalStyle.INORDER);
            System.out.println();
            System.out.println("Node count: "+tree.getNodeCount());

            System.out.println("Min value: "+tree.getMin());
            System.out.println("Max value: "+tree.getMax());

            //tree.deleteTree();
            //tree.getMin();    // will throw exception, as tree is deleted

            System.out.println("Successor of 90: "+tree.getSuccessor(90));
            System.out.println("Successor of 23: "+tree.getSuccessor(23));
            System.out.println("Successor of 51: "+tree.getSuccessor(51));

            System.out.println("Height of tree: "+tree.getHeight());

            System.out.println("Is 44 in tree? "+tree.isInTree(44));
            System.out.println("Is 56 in tree? "+tree.isInTree(56));

            //System.out.println("Is BST? "+tree.isBinarySearchTree(Integer.MIN_VALUE,Integer.MAX_VALUE));

        } catch (Exception e) {
            e.printStackTrace();
            tree.printValues(Tree.TraversalStyle.INORDER);
            System.out.println();
            System.out.println("Node count: "+tree.getNodeCount());
        }
    }
}
