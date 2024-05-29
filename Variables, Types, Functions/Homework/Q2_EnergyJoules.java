/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework;
import java.util.Scanner;
/**
 * This is a Java Program for Homework 2 - Question 2
 * This program calculates the energy "E" (in Joules) using the formula E = mc^2, 
 * where "c" is the speed of light in a vacuum (in meters/second),
 * and "m" is the mass (in grams).
 */

public class Q2_EnergyJoules {

    /**
     * The function "CalculateEnergy" calculates the energy from mass
     * by using the formula E=mc^2
     * @param m is the mass in grams
     * @return the calculated energy in Joules
     */
    public static double CalculateEnergy(double m) {
        double c = 299792458; //This constant c is the speed of light in meters/second
        double E = m * c * c; //Using the formula E=mc^2
        System.out.println("The energy in Joules is: " + E);
        return E;
    }
    /**
     * This is the main method and it prompts the user for
     * weight input in grams and it calls the CalculateEnergy function
     * which will display the Energy in Joules.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("Input the weight in grams: ");
        double m = scn.nextDouble();

        CalculateEnergy(m);

    } 
}
