/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/*
 * This class provides examples for counting the number of leaves in binary trees using the BinaryNode class.
 */
public class BinaryNodeLeaf {
    /**
     * Main method for testing the counting of leaves in binary trees.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1
        BinaryNode root1 = new BinaryNode(1);
        root1.BinaryInsert(2);
        root1.BinaryInsert(3);
        root1.BinaryInsert(4);
        root1.BinaryInsert(5);
        root1.BinaryInsert(6);
        root1.BinaryInsert(7);
        System.out.println("Number of leaves in tree 1: " + root1.leaves());

        // Example 2
        BinaryNode root2 = new BinaryNode(5);
        root2.BinaryInsert(2);
        root2.BinaryInsert(1);
        root2.BinaryInsert(3);
        root2.BinaryInsert(7);
        root2.BinaryInsert(6);
        root2.BinaryInsert(9);
        System.out.println("Number of leaves in tree 2: " + root2.leaves());
    }
}
