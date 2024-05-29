package Session09;

public class Rectangle extends Shape{

    double height;
    double width;

    public Rectangle(Position p, double height, double width, String fillcolor, String outlinecolor){
        super(p,fillcolor,outlinecolor);
        this.height=height;
        this.width=width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    @Override
    public double getArea(){

        return height*width;
    }

    @Override
    public double getPerimeter(){
        return 2*(height+width);
    }

    @Override
    public String toString() {
        return "x=" + p.getX() +
                ", y=" + p.getY() +
                ", fillColor='" + fillcolor + '\'' +
                ", lineColor='" + outlinecolor + '\'';
    }


    public static void main(String[] args){
        Position p = new Position(4,9);

        Rectangle r1= new Rectangle(p,3.4,5.6,"blue","red");
        System.out.println(r1);
        System.out.println("Area="+r1.getArea());
        System.out.println("Perimeter="+r1.getPerimeter());

    }
}
