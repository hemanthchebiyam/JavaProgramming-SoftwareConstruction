/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework.Geometry;

import java.util.Scanner;

/**
 * This is a Java program for Homework 7 - Question 2.
 * The TestCircle class provides a program to test the Circle class.
 * It prompts the user to enter the coordinates of the center point and the radius of a circle,
 * as well as the coordinates of a point to test it belongs to the circle.
 */
public class TestCircle {

    /**
     * The main method that drives the test program.
     *
     * @param args The standard command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coordinates of the center point (x y):");
        Double centerX = scanner.nextDouble();
        Double centerY = scanner.nextDouble();

        System.out.println("Enter the radius of the circle:");
        Double radius = scanner.nextDouble();

        System.out.println("Enter the coordinates of the point to test (x y):");
        Double pointX = scanner.nextDouble();
        Double pointY = scanner.nextDouble();

        Point center = new Point(centerX, centerY);
        Circle circle = new Circle(center, radius);
        Point testPoint = new Point(pointX, pointY);

        // Check if the test point belongs to the circle
        if (circle.testAppartenance(testPoint)) {
            System.out.println("The point belongs to the circle.");
        } else {
            System.out.println("The point does not belong to the circle.");
        }

        // Display the perimeter and area of the circle
        circle.display();

        scanner.close();
    }
}
