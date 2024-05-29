/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */

package homework;

//Importing the Scanner class
import java.util.Scanner;

/**
 * This is a Java Program for Homework 2 - Question 1
 * The program converts temperature from Fahrenheit to Kelvin
 * It takes an input from user in Fahrenheit and converts it into Kelvin using the following formula:
 * K = 5/9 (F - 32) + 273
 */
public class Q1_TemperatureConverter {

    /**
     * The ConvertTemp method contains the code to convert Fahrenheit to Kelvin.
     * 
     * @param F is the temperature in Fahrenheit given as input by user
     * @return the converted temperature in Kelvin 
     */

    public static double ConvertTemp(double F){
        
        double K = ((5.0/9.0) * (F - 32) + 273);
        System.out.println(F + " degrees Fahrenheit is " + K + " degrees Kelvin");
        return K;

    }

    /**
     * This is the main method 
     * It will prompt the user for temperature input and
     * it calls the ConvertTemp function
     * which will display the converted Kelvin temperature.
     * 
     * @param args is the standard command-line argument.
     */

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the temperature in Fahrenheit: ");
        double F = scanner.nextDouble();
        
        ConvertTemp(F);
        
        
    }
}
