/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */

package Homework;
import java.util.Scanner;

/**
 * This is a Java program for Homework 3 - Question 1.
 * This program prints the user's age category based on the age they have entered. 
 */

public class Q1_Age {

    /**
     * This is the main method of the program.
     * It takes the user input for age and determines the age group.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        
        // Creating a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompting user to enter the age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Determining the age category and displaying a message based on the table provided in the question
        if (age < 10)
            System.out.println("Is this your first program?");
        else if (age < 13)
            System.out.println("A tween!");
        else if (age < 20)
            System.out.println("A teen!");
        else if (age < 30)
            System.out.println("A twenty-something!");
        else 
            System.out.println("With age comes experience.");
    }
}
