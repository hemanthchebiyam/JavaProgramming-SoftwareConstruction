/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework05;

/**
 * This is a Java program for Homework 5 - Question 2.
 * It uses a recursive method to print a string multiple times instead of an iterative method.
 */
public class Question2 {
    
//Uncomment main method to run and test the program
/*  public static void main(String[] args) {
        sign(3);
    }
*/  
    /**
     * This method uses a recursive method instead of an iterative method.
     * @param n is the number of times the string "No Parking" will be displayed.
     */
    public static void sign(int n) {
        if (n > 0) {
            System.out.println("No Parking");
            sign(n-1);
        }    
    }
}
