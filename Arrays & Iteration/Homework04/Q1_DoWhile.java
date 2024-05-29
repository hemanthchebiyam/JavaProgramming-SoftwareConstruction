/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework04;

import java.util.Scanner;

/**
 * This is a Java program for Homework 4 - Question 1.
 * This program uses a do-while loop to take two numbers as input from the user and prints their sum. 
 * It asks if the user wants to perform the operation again and loops accordingly.
 */
public class Q1_DoWhile {
    /**
     * This is the main method of the program.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean repeat = true;

        do {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double sum = num1 + num2;
            System.out.println("Sum: " + sum);

            System.out.print("Do you want to perform the operation again? (1 for Yes, 0 for No): ");
            int choice = scanner.nextInt();

            repeat = (choice == 1);
        } while (repeat);

        System.out.println("Program terminated.");
    }
}
