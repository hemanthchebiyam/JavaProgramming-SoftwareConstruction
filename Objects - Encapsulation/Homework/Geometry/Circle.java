/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework.Geometry;

/**
 * This is a Java program for Homework 7 - Question 2.
 * The Circle class represents a circle in a two-dimensional Cartesian coordinate system.
 * It contains a center Point and a radius.
 */
public class Circle {
    public Point center; // The center Point of the circle
    public Double radius; // The radius of the circle

    /**
     * Constructs a Circle object with the specified center Point and radius.
     *
     * @param center The center Point of the circle.
     * @param radius The radius of the circle.
     */
    public Circle(Point center, Double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Calculates the perimeter of the circle using the formula: 2 * Pi * radius.
     *
     * @return The perimeter of the circle.
     */
    public Double perimeter() {
        return 2 * 3.14159265359 * radius; // Using an approximate value of Pi
    }

    /**
     * Calculates the area of the circle using the formula: Pi * radius^2.
     *
     * @return The area of the circle.
     */
    public Double area() {
        return 3.14159265359 * radius * radius; // Using an approximate value of Pi
    }

    /**
     * Checks if a given Point is inside the circle.
     *
     * @param point The Point to be tested for its location relative to the circle.
     * @return True if the Point is inside or on the circle, false otherwise.
     */
    public boolean testAppartenance(Point point) {
        Double distanceSquared = (point.abscissa - center.abscissa) * (point.abscissa - center.abscissa)
                + (point.ordinate - center.ordinate) * (point.ordinate - center.ordinate);
        return distanceSquared <= radius * radius;
    }

    /**
     * Displays the perimeter and area of the circle.
     */
    public void display() {
        System.out.println("Circle perimeter: " + perimeter());
        System.out.println("Circle area: " + area());
    }
}
