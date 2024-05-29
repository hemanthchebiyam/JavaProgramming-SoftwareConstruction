/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework04;

import java.util.Scanner;

/**
 * This is a Java program for Homework 4 - Question 3.
 * This program contains two arrays that store the name and population of 5 countries based on user input.
 * It prints each country's name and population and also calculates the average population of all countries.
 */
public class Q3_CountryPopulation {
    /**
     * This is the main method of the program.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        
        // Defining two arrays that are used to store the names of the countries and their populations.
        String [] countryNames = new String[5];
        int [] populations = new int[5];

        Scanner scanner = new Scanner(System.in);

        // This for loop takes the user input for country name and population and stores it in the array.
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the name of the " + (i + 1) + getSuffix(i + 1) + " country: "); // Takes the suffix for country number from the getSuffix method.
            countryNames[i] = scanner.nextLine();

            System.out.println(); // Printing an empty line space between the country name and population.

            System.out.print("Enter the population of " + countryNames[i] + ": ");
            populations[i] = scanner.nextInt();
            System.out.println();

            scanner.nextLine();
        }
        // This for loop is to print each country's name and population.
        for (int i = 0; i < 5; i++) {
            System.out.println("Country: " + countryNames[i] + ", Population: " + populations[i] + "\n");
        }
        // This for loop calculates the total population of the countries and that value is used to calculate the average population.
        int totalPop = 0;
        for (int i = 0; i < 5; i++) {
            totalPop += populations[i];
        }
        double avgPop = totalPop / 5;
        System.out.println("Average population of all 5 countries: " + avgPop + "\n");
    }

    /**
     * The getSuffix method is an extra method written to get the suffix 
     * for the country number when prompting the user to enter the name of the country.
     * @param number is the country number (1 to 5)
     * @return the suffix of the country number.
     */
    public static String getSuffix(int number) {
        switch(number) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
