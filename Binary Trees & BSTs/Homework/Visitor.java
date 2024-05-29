/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;
/*
 * This interface defines the contract for classes that visit nodes in a binary tree.
 */
public interface Visitor {
    /**
     * Visits a BinaryNode and performs specific actions defined by the implementing class.
     *
     * @param node The BinaryNode being visited.
     */
    public void visit(BinaryNode node);
    
}
