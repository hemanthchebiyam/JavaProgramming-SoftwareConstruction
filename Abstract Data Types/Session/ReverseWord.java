package Session;

public class ReverseWord {
    
    public static void main(String[] args) {
        NodeStack <String> stack = new NodeStack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(" ABC after using Stack: ");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
