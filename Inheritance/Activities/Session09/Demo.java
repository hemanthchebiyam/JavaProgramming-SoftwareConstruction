package Session09;

class Demo{
    public static void main(String[] args){
        Position p = new Position(3,8);
        Circle c1= new Circle(p,"red","blue",3.5);
        System.out.println(c1);
        System.out.println("Area="+c1.getArea());
        System.out.println("Perimeter="+c1.getPerimeter());

    }
}









