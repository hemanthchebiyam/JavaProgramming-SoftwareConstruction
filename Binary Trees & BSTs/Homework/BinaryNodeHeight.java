/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/*
 * This class provides examples for calculating the height of binary trees using the BinaryNode class.
 */
public class BinaryNodeHeight {
    /**
     * Main method for testing the calculation of tree height.
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
        System.out.println("Height of tree 1: " + root1.height());

        // Example 2
        BinaryNode root2 = new BinaryNode(5);
        root2.BinaryInsert(2);
        root2.BinaryInsert(1);
        root2.BinaryInsert(3);
        root2.BinaryInsert(7);
        root2.BinaryInsert(6);
        root2.BinaryInsert(9);
        System.out.println("Height of tree 2: " + root2.height());
    }
}
