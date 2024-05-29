/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/*
 * This class implements the Visitor interface to create a string representation of a binary tree.
 */
public class StringifyVisitor implements Visitor{

    // The StringBuilder used to build the string representation of the binary tree.
    StringBuilder builder;

    // Constructs a StringifyVisitor with an empty StringBuilder.
    public StringifyVisitor() {
        builder = new StringBuilder();
    }

    /**
     * Visits a BinaryNode and appends its value to the StringBuilder.
     *
     * @param node The BinaryNode being visited.
     */
    @Override
    public void visit(BinaryNode node) {
        this.builder.append(node.getValue());
        this.builder.append(" ");
    }

    /**
     * Returns the string representation of the binary tree.
     *
     * @return The string representation of the binary tree.
     */
    @Override
    public String toString(){
        return builder.toString();
    }
    
}
