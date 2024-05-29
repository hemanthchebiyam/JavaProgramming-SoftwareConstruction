/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework04;

/**
 * This is a Java program for Homework 4 - Question 2.
 * This program contains a for loop which displays all the numbers mentioned in the question.
 */
public class Q2_ForLoop {
    /**
     * This is the main method of the program.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        for (int i=0; i <= 1000; i+=10) {
            // Printing the numbers from 0 to 1000 in multiples of 10
            System.out.print(i + " "); // Using print instead of println to print the output in the same line, and adding a space between each number.
        }
    }
}
