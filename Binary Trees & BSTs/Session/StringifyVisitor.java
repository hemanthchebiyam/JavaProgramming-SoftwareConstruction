package Session;

public class StringifyVisitor implements Visitor{

    StringBuilder builder;

    public StringifyVisitor() {
        builder = new StringBuilder();
    }

    @Override
    public void visit(BinaryNode node) {
        this.builder.append(node.getValue());
        this.builder.append(" ");
    }

    @Override
    public String toString(){
        return builder.toString();
    }
    
}
