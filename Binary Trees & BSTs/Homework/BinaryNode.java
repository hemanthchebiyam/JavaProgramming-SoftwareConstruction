/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * Represents a node in a binary tree.
 */
public class BinaryNode {
    private int value;
    private BinaryNode leftNode;
    private BinaryNode rightNode;
    
    // Constructor for creating a BinaryNode with a specified value.
    public BinaryNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * Performs an infix traversal of the binary tree rooted at this node, applying a visitor.
     *
     * @param visitor The visitor to apply during traversal.
     */
    public void infixTraversal(Visitor visitor){
        if(leftNode != null)
            leftNode.infixTraversal(visitor);
        visitor.visit(this);
        if(rightNode != null)
            rightNode.infixTraversal(visitor);
    }

    /**
     * Checks if the binary tree rooted at this node contains the specified target value.
     *
     * @param target The value to search for.
     * @return True if the target value is found, false otherwise.
     */
    public Boolean search(int target){
        if(target==this.value)
            return true;
        else{
            Boolean found = false;
            if(leftNode != null)
                found = leftNode.search(target);
            if(!found && rightNode != null)
                found = rightNode.search(target);
            return found;
        }
    }

    /**
     * Inserts a new value into the binary tree rooted at this node.
     *
     * @param value The value to insert.
     */
    public void BinaryInsert(int value){
        if(value < this.value){
            if(leftNode == null)
                this.leftNode = new BinaryNode(value);
            else
                leftNode.BinaryInsert(value);
        }else {
            if(rightNode == null)
                this.rightNode = new BinaryNode(value);
            else
                rightNode.BinaryInsert(value);
        }
    }

    /**
     * Performs a binary search in the tree rooted at this node for the specified target value.
     *
     * @param target The value to search for.
     * @return True if the target value is found, false otherwise.
     */
    public Boolean BinarySearch(int target){
        if(target == value)
            return true;
        else
            if(target < value)
                return (leftNode != null && leftNode.BinarySearch(target));
            else
                return (rightNode != null && rightNode.BinarySearch(target));
    }

    /**
     * Calculates the height of the binary tree rooted at this node.
     *
     * @return The height of the tree.
     */
    public int height(){
        return Math.max(getHeight(leftNode), getHeight(rightNode));
    }

    private int getHeight(BinaryNode node){
        if(node == null){
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.leftNode), getHeight(node.rightNode));
        }
    }

    /* public int height(){
        if(this == null){
            return 0;
        } else {
            int leftHeight = (leftNode != null) ? leftNode.height() : 0;
            int rightHeight = (rightNode != null) ? rightNode.height() : 0;

            return 1 + Math.max(leftHeight, rightHeight);
        }
    } */

    /**
     * Checks if the binary tree rooted at this node is perfect.
     *
     * @return True if the tree is perfect, false otherwise.
     */
    public boolean isPerfect() {
        int height = height();
        int expectedNodes = (int) Math.pow(2, height + 1) - 1;
        int actualNodes = countNodes(this);

        return actualNodes == expectedNodes;
    }

    private int countNodes(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeftNode()) + countNodes(node.getRightNode());
    }

    /**
     * Counts the number of leaf nodes in the binary tree rooted at this node.
     *
     * @return The number of leaf nodes.
     */
    public int leaves() {
        return countLeaves(this);
    }

    private int countLeaves(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            return 1; // Node is a leaf
        }
        return countLeaves(node.getLeftNode()) + countLeaves(node.getRightNode());
    }

    /**
     * Checks if two BinaryNode objects are equal.
     *
     * @param obj The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BinaryNode otherNode = (BinaryNode) obj;

        // Compare current node values
        if (this.value != otherNode.value) {
            return false;
        }

        // Recursively compare left and right subtrees
        if (this.leftNode != null && !this.leftNode.equals(otherNode.leftNode)) {
            return false;
        }

        if (this.rightNode != null && !this.rightNode.equals(otherNode.rightNode)) {
            return false;
        }

        return true;
    }

    /**
     * Main method for testing the BinaryNode class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(2);
        BinaryNode left = new BinaryNode(3);
        BinaryNode right = new BinaryNode(7);

        BinaryNode ll = new BinaryNode(9);
        BinaryNode lr = new BinaryNode(4);
        BinaryNode rr = new BinaryNode(6);
        BinaryNode rl = new BinaryNode(1);

        root.setLeftNode(left);
        root.setRightNode(right);
        left.setLeftNode(ll);
        left.setRightNode(lr);
        right.setLeftNode(rl);
        right.setRightNode(rr);

        Visitor visitor = new StringifyVisitor();
        root.infixTraversal(visitor);

        System.out.println("The tree: " + visitor);

        System.out.println("Check the value 11: " + root.search(11));
        System.out.println("Check the value 9: " + root.search(9));
    }
}
