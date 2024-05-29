/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/*
 * This class provides examples for checking if binary trees are perfect using the BinaryNode class.
 */
public class BinaryNodePerfect {
    /**
     * Main method for testing if binary trees are perfect.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1 (Not Perfect Tree)
        BinaryNode perfectRoot = new BinaryNode(1);
        perfectRoot.BinaryInsert(2);
        perfectRoot.BinaryInsert(3);
        perfectRoot.BinaryInsert(4);
        perfectRoot.BinaryInsert(5);
        perfectRoot.BinaryInsert(6);
        perfectRoot.BinaryInsert(7);
        System.out.println("Is tree 1 perfect? " + perfectRoot.isPerfect());

        // Example 2 (Perfect Tree)
        BinaryNode notPerfectRoot = new BinaryNode(5);
        notPerfectRoot.BinaryInsert(2);
        notPerfectRoot.BinaryInsert(1);
        notPerfectRoot.BinaryInsert(3);
        notPerfectRoot.BinaryInsert(7);
        notPerfectRoot.BinaryInsert(6);
        notPerfectRoot.BinaryInsert(9);
        System.out.println("Is tree 2 perfect? " + notPerfectRoot.isPerfect());
    }
}
