package Homework;

/**
 * Utility class that can be used to move or print shapes.
 */
public class ShapeMover {
    /**
     * Prints a shape, moves it to a new position, and then prints it again.
     *
     * @param shape The shape to move and print.
     * @param position The new position to which the shape should me moved.
     */
    public static void moveShape(Figure figure, Position position) {
        System.out.println("BEFORE MOVING");
        printFigure(figure);

        figure.move(position);

        System.out.println("AFTER MOVING");
        printFigure(figure);
    }

    /**
     * Prints the details about a shape including the class name, position,
     * area, perimeter, fill color, and outline.
     *
     * @param shape The shape to print.
     */
    public static void printFigure(Figure figure) {
        System.out.println("Shape: " + figure.getClass());
        System.out.println("  position: " + figure.getPos());
        System.out.println("  area: " + figure.area());
        System.out.println("  perimeter: " + figure.perimeter());
        System.out.println("  fill color: " + figure.getFillColor());
        System.out.println("  outline: " + figure.getLineColor() + "\n");
    }

    /**
     * Scales a figure by the given factor.
     *
     * @param figure The figure to scale.
     * @param factor The factor by which the figure should be scaled.
     */
    public static void scaleFigure(Figure figure, double factor) {
        System.out.println("BEFORE SCALING");
        printFigure(figure);

        figure.scale(factor);

        System.out.println("AFTER SCALING");
        printFigure(figure);
    }

    /**
     * Tests the move method with various different shapes.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main(String[] args) {
        
        Figure rectangle = new Rectangle(new Position(50, 50), "Brown",
                "Yellow", 100, 50);
        moveShape(rectangle, new Position(25, 75));
        scaleFigure(rectangle, 2.0); // Scale the rectangle by a factor of 2.0

        Figure circle = new Circle(new Position(0, 10), "Transparent",
                "Black", 150);
        moveShape(circle, new Position(10, 0));
        scaleFigure(circle, 0.8); // Scale the circle by a factor of 0.8

        Figure triangle = new Triangle(new Position(-30, -50), "Blue",
                "Orange", 125);
        moveShape(triangle, new Position(-100, -200));
        scaleFigure(triangle, 1.2); // Scale the triangle by a factor of 1.2
    }
}
