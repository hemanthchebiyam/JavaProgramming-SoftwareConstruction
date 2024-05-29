package Session;

import java.io.Serializable;
import java.util.Comparator;

public class CircleComparator implements Comparator<Circle>, Serializable{

    public static void main(String[] args) {
        Circle c1 = new Circle(new Position(0, 0), "Red", "Yellow", 9.4);
        Circle c2 = new Circle(new Position(0, 0), "Green", "Gray", 10);
        System.out.println((new CircleComparator()).compare(c1,c2));
    }

    @Override
    public int compare(Circle c1, Circle c2){
        return (int)Math.signum(c1.area() - c2.area());
    }
}
