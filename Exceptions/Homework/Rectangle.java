/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * A rectangle shape.
 */
public class Rectangle extends Shape {
    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * The height of the rectangle.
     */
    private double height;


    /**
     * Creates a new rectangle.
     *
     * @param pos The position of the top left corner.
     * @param fillColor The fill color.
     * @param lineColor The outline color.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Position pos, String fillColor, String lineColor,
                     double width, double height) {
        super(pos, fillColor, lineColor);
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the width of the rectangle.
     * 
     * @param width the new width value to set.
     * @throws NegativeValueException if the specified width is negative.
     */
    public void setWidth(double width) throws NegativeValueException {
        if(width < 0) {
            throw new NegativeValueException("Width cannot be negative.");
        }
        this.width = width;
    }

    /**
     * Gets the width of the rectangle.
     * 
     * @return the width of the rectaangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the height of the rectangle.
     * 
     * @param height the new height value to set.
     * @throws NegativeValueException if the specified height is negative.
     */
    public void setHeight(double height) throws NegativeValueException {
        if(height < 0) {
            throw new NegativeValueException("Height cannot be negative");
        }
        this.height = height;
    }

    /**
     * Gets the height of the rectangle.
     * 
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Computes and returns the area of the rectangle.
     *
     * @return Returns the area of the rectangle.
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Computes and returns the perimeter of the rectangle.
     *
     * @return Returns the perimeter of the rectangle.
     */
    @Override
    public double perimeter() {
        return width*2 + height*2;
    }
}
