/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework05;

import java.util.Scanner;

/**
 * This is a Java program for Homework 5 - Question 3.
 * This program recursively multiples two integers by performing repeated addition.
 */
public class Question3 {
    /**
     * This is the main method of the program.
     * It takes two integers as input from the user and calls the recursive function 'multiply' to display the product of the two integers.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int x = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int y = scanner.nextInt();

        int result = multiply(x, y);
        System.out.println(x + " * " + y + " = " + result);
    }

    /**
     * The 'multiply' method recursively calculates the product of two integers.
     * It handles the base case when input is zero.
     * It also handles the cases where the integer y is negative.
     * @param x is the first integer.
     * @param y is the second integer.
     * @return the product of x and y.
     */
    public static int multiply(int x, int y) {
        if (x == 0 || y == 0) {
            return 0; // This is the base case, anything multiplied by 0 is 0.
        } else if (y < 0) {
            return -multiply(x, -y); // This handles a negative input for y.
        } else {
            return x + multiply(x, y - 1); // Recursively calling multiply and adding the result to x.
        }
    }
}
