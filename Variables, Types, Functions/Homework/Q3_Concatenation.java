/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework;
import java.util.Scanner;

/**
 * This is a Java Program for Homework 2 - Question 3
 * This program takes 3 different parameters and concatenates them to print a single string.
 */

public class Q3_Concatenation {
    /**
     * Concatenates three different parameters into a single string.
     * 
     * @param param1 is the first parameter of String type.
     * @param param2 is the second parameter of boolean type.
     * @param param3 is the third parameter of int type.    
     * @return a string which is the concatenated value of all three parameters.
     */

    public static String Concatenate(String param1, boolean param2, int param3) {

        return param1+param2+param3;

    }
    /**
     * This is the main method and it prompts the user for 
     * input for three different parameter types
     * and it calls the function "Concatenate" which prints the concatenated string of all these three parameters.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Input the String parameter: ");
        String param1 = scn.nextLine();

        System.out.print("Input the boolean parameter: ");
        boolean param2 = scn.nextBoolean();

        System.out.print("Input the integer parameter: ");
        int param3 = scn.nextInt();

        System.out.println("The concatenated string is: " + Concatenate(param1, param2, param3));
    }


    
}
