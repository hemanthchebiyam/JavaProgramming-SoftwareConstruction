/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework05;

import java.util.Scanner;

/**
 * This is a Java program for Homework 5 - Question 5.
 * This program calculates the result of raising a base number to a non-negative exponent using recursion.
 */
public class Question5 {
    /**
     * This is the main method of the program.
     * It takes user input for the base and exponent, calculates the result by calling the recursive 'Power' function, and displays it.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();

        int exponent;
        // Using a do-while loop to prompt user to enter only non-negative values of exponent.
        do {
            System.out.print("Enter the exponent (non-negative): ");
            exponent = scanner.nextInt();
        } while (exponent < 0);
        
        System.out.println(number + " raised to the power of " + exponent + " = " + Power(number, exponent));
    }
    /**
     * The 'Power' method recursively calculates the result of raising a number to a given exponent.
     * @param number is the base number.
     * @param exponent is the non-negative exponent.
     * @return the result of raising the base number to the power of the exponent.
     */
    public static long Power(int number, int exponent) {
        if (exponent == 0) {
            return 1; // This is the base case. Any number raised to the power of 0 is 1.
        } else {
            return number * Power(number, exponent - 1); // Recursively calculate the power.
        }
    }
}
