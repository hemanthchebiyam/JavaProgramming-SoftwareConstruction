package Session09;

public class Circle  extends Shape {
    double radius;

    public Circle(Position p, String outlinecolor, String fillcolor, double radius) {
        super(p, outlinecolor, fillcolor);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return "Circle" +"\n"+
                "radius=" + radius +
                ", x=" + p.getX() +
                ", y=" + p.getY() +
                ", color='" + fillcolor + '\'' +
                ", outlinecolor='" + outlinecolor + '\'';
    }
}
class main_circle{
    public static void main(String[] args){
        Position p = new Position(3,8);

        Circle c1= new Circle(p,"red","blue",3.5);
        System.out.println(c1);
        System.out.println("Area="+c1.getArea());
        System.out.println("Perimeter="+c1.getPerimeter());

    }
}
