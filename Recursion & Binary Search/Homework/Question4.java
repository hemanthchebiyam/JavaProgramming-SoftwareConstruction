/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework05;

import java.util.Scanner;
/**
 * This is a Java program for Homework 5 - Question 4.
 * This program recursively adds integers from 1 to a user-entered integer.
 */
public class Question4 {
    /**
     * This is the main method.
     * It takes an integer as input from user and prints the sum of integers from 1 to that number 
     * by calling the recursive function 'calculatedSum'.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int n = scanner.nextInt();
        System.out.println("The sum of integers from 1 to " + n + " is: " + calculatedSum(n));
    }

    /**
     * The 'calculatedSum' method recusively calculates the sum of all integers from 1 up to the number passed as an argument.
     * @param n is the integer up to which the sum should be calculated.
     * @return the sum of integers from 1 to n, or 0 when n is either 0 or negative.
     */
    public static int calculatedSum(int n) {
        if (n <= 0) {
            return 0; // This is the base case, return 0 when n is 0 or negative.
        }
        else {
            return n + calculatedSum(n - 1); // Recursively calculate the sum of integers from 1 to n.
        }
    }
}
