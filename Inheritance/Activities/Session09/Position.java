package Session09;

public class Position {
        double x;
        double y;

        Position(double x,double y){
            this.x=x;
            this.y=y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
}
class main{
    public static void main(String[] args){
        Position p1= new Position(7,8);
        System.out.println(p1);
    }
}