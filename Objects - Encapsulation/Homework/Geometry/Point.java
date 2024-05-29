/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework.Geometry;

/**
 * This is a Java program for Homework 7 - Question 2.
 * The Point class represents a point in a two-dimensional Cartesian coordinate system.
 * It contains an abscissa (X-coordinate) and an ordinate (Y-coordinate).
 */
public class Point {
    Double abscissa; // The X-coordinate of the point
    Double ordinate; // The Y-coordinate of the point

    /**
     * Constructs a Point object with the specified abscissa and ordinate coordinates.
     * 
     * @param abscissa is the X-coordinate of the point.
     * @param ordinate is the Y-coordinate of the point.
     */
    public Point(Double abscissa, Double ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }
}
