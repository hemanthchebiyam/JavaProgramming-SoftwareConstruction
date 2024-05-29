/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */

package Homework;
import java.util.Scanner;
import java.lang.String;

/**
 * This is a Java program for Homework 3 - Question 4.
 * This program converts an inputted date from one format to another and adds a suffix to the day accordingly.
 */
public class Q4_DateFormat {
    /**
     * This is the main method of the program.
     * It prompts the user to enter a date in the specified format and prints the date in the converted format.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date in the format YYYY/MM/DD: ");
        String inputDate = scanner.nextLine();
        
        String formattedDate = convertDate(inputDate);
        
        System.out.println("Formatted date: " + formattedDate);
        
        scanner.close();
    }

    /**
     * The convertDate method converts the date from "YYYY/MM/DD" format to "Month Day(suffix), Year" format.
     * 
     * @param inputDate is the input date in "YYYY/MM/DD" format.
     * @return the modified date in "Month Day(suffix), Year" format.
     */
    public static String convertDate(String inputDate) {
        // Split the input date into parts using '/' as the delimiter.
        String[] parts = inputDate.split("/");
        
        // Checking if the input date has three parts (year, month, day).
        if (parts.length != 3) {
            return "Invalid date format";
        }
        
        // Parse the year, month, and day from the parts.
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        // Getting the month name and day suffix.
        String monthName = getMonthName(month);
        String daySuffix = getDaySuffix(day);
        
        // Returning the date in the new format.
        return monthName + " " + day + daySuffix + ", " + year;
    }

    /**
     * The getMonthName method retrieves the name of the month for a given month number using switch-case statements.
     * 
     * @param month is the numeric representation of the month.
     * @return the name of the month or "Invalid month" if the input is not within the specified range.
     */
    public static String getMonthName(int month) {
        switch (month) {
            case 1: 
                return "January";
            case 2: 
                return "February";
            case 3: 
                return "March";
            case 4: 
                return "April";
            case 5: 
                return "May";
            case 6: 
                return "June";
            case 7: 
                return "July";
            case 8: 
                return "August";
            case 9: 
                return "September";
            case 10: 
                return "October";
            case 11: 
                return "November";
            case 12: 
                return "December";
            default: 
                return "Invalid month";
        }
    }

    /**
     * The getDaySuffix method determines the appropriate suffix for a given day.
     * 
     * @param day is the specific day of the month.
     * @return the suffix of the day or "Invalid day" if the input is not within the specified range.
     */
    public static String getDaySuffix(int day) {
        if (day < 1 || day > 31)
            return "Invalid day";
        switch (day) {
            case 11:
            case 12:
            case 13:
                return "th";
        }
        
        switch (day % 10) {
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
