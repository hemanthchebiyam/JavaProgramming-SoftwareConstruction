package Session09;

public class Shape {

    Position p;
    String fillcolor;
    String outlinecolor;

    public Shape( Position p, String fillcolor, String outlinecolor){
        this.p = p;
        this.fillcolor=fillcolor;
        this.outlinecolor=outlinecolor;
    }
    public double getArea(){
        return 0;
    }
    public double getPerimeter(){
        return 0;
    }

    public void move(double x, double y){
        this.p.setX(x);
        this.p.setY(y);
    }
}


