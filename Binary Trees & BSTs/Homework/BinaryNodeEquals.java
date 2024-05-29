/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/*
 * This class provides examples for testing the equality of binary trees using the BinaryNode class.
 */
public class BinaryNodeEquals {

    /**
     * Main method for testing tree equality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1
        BinaryNode root1 = new BinaryNode(1);
        root1.BinaryInsert(2);
        root1.BinaryInsert(3);

        BinaryNode root2 = new BinaryNode(1);
        root2.BinaryInsert(2);
        root2.BinaryInsert(3);

        System.out.println("Are tree 1 and tree 2 equal? " + root1.equals(root2));

        // Example 2
        BinaryNode root3 = new BinaryNode(1);
        root3.BinaryInsert(5);
        root3.BinaryInsert(2);

        BinaryNode root4 = new BinaryNode(10);
        root4.BinaryInsert(5);
        root4.BinaryInsert(15);

        System.out.println("Are tree 3 and tree 4 equal? " + root3.equals(root4));
    }
}
