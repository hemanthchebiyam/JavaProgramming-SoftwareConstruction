package Session;

public class BinaryNode {
    private int value;
    private BinaryNode leftNode;
    private BinaryNode righNode;
    
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

    public BinaryNode getRighNode() {
        return righNode;
    }

    public void setRighNode(BinaryNode righNode) {
        this.righNode = righNode;
    }

    public void infixTraversal(Visitor visitor){
        if(leftNode != null)
            leftNode.infixTraversal(visitor);
        visitor.visit(this);
        if(righNode != null)
            righNode.infixTraversal(visitor);
    }

    public Boolean search(int target){
        if(target==this.value)
            return true;
        else{
            Boolean found = false;
            if(leftNode != null)
                found = leftNode.search(target);
            if(!found && righNode != null)
                found = righNode.search(target);
            return found;
        }
    }

    public void BinaryInsert(int value){
        if(value < this.value){
            if(leftNode == null)
                this.leftNode = new BinaryNode(value);
            else
                leftNode.BinaryInsert(value);
        }else {
            if(righNode == null)
                this.righNode = new BinaryNode(value);
            else
                righNode.BinaryInsert(value);
        }
    }

    public Boolean BinarySearch(int target){
        if(target == value)
            return true;
        else
            if(target < value)
                return (leftNode != null && leftNode.BinarySearch(target));
            else
                return (righNode != null && righNode.BinarySearch(target));
    }

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(2);
        BinaryNode left = new BinaryNode(3);
        BinaryNode right = new BinaryNode(7);

        BinaryNode ll = new BinaryNode(9);
        BinaryNode lr = new BinaryNode(4);
        BinaryNode rr = new BinaryNode(6);
        BinaryNode rl = new BinaryNode(1);

        root.setLeftNode(left);
        root.setRighNode(right);
        left.setLeftNode(ll);
        left.setRighNode(lr);
        right.setLeftNode(rl);
        right.setRighNode(rr);

        Visitor visitor = new StringifyVisitor();
        root.infixTraversal(visitor);

        System.out.println("The tree: " + visitor);

        System.out.println("Check the value 11: " + root.search(11));
        System.out.println("Check the value 9: " + root.search(9));
    }
}
