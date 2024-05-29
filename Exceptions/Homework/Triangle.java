/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * An equilateral triangle shape.
 */
public class Triangle extends Shape {
    /**
     * Used to compute the area of an equilateral triangle.
     */
    private static final double CONSTANT = Math.sqrt(3) / 4.0d;

    /**
     * The length of one side of the triangle.
     */
    private double side;

    /**
     * Creates a new equilateral triangle.
     *
     * @param pos The position of the top left corner.
     * @param fillColor The fill color.
     * @param lineColor The outline color.
     * @param side The length of one side of the triangle.
     */
    public Triangle(Position pos, String fillColor, String lineColor,
                    double side) {
        super(pos, fillColor, lineColor);
        this.side = side;
    }

    /**
     * Sets the side of the triangle.
     * 
     * @param side the new side value to set.
     * @throws NegativeValueException if the specified side is negative.
     */
    public void setSide(double side) throws NegativeValueException {
        if(side < 0) {
            throw new NegativeValueException("Side length cannot be negative.");
        }
        this.side = side;
    }

    /**
     * Gets the side of the triangle.
     * 
     * @return the side of the triangle.
     */
    public double getSide() {
        return side;
    }

    /**
     * Computes and returns the area of the equilateral triangle.
     *
     * @return Returns the area of the equilateral triangle.
     */
    @Override
    public double area() {
        return CONSTANT * side * side;
    }

    /**
     * Computes and returns the perimeter of the equilateral triangle.
     *
     * @return Returns the perimeter of the equilateral triangle.
     */
    @Override
    public double perimeter() {
        return side * 3;
    }
}
