/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework05;

import java.util.Scanner;
/**
 * This is a Java program for Homework 5 - Question 6.
 * This program prompts the user to enter a string, converts it to lowercase,
 * and then checks whether it is a palindrome using a recursive method.
 */
public class Question6 {
    /**
     * This is the main method of the program.
     * It asks the user to input a string and checks whether it is a palindrome or not by calling the recursive function "Palindrome".
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a string
        // System.out.print("Enter a string: ");
        //String input = scanner.nextLine().toLowerCase(); // Converting the input to lowercase to check for palindrome. 
        String input = "A man, a plan, a canal, Panama";
        String input1 = input.toLowerCase();
        
        // I used this link for reference to write the below line of code: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#replaceAll-java.lang.String-java.lang.String-
        String input2 = input1.replaceAll("[^A-Za-z]", ""); // Using Regular expression to remove non-letter characters from the input.

        if (Palindrome(input2)) {
            System.out.println(input + " is a Palindrome!");
        } else {
            System.out.println(input + " is not a Palindrome.");
        }
    }
    /**
     * The 'Palindrome' method recursively checks whether a given string is a palindrome or not.
     * @param str is the string to be checked for a palindrome.
     * @return true if the string is a palindrome, and false if not.
     */
    public static boolean Palindrome (String str) {
        if (str.length() <= 1) {
            return true; // This is the base case. If the string has 0 or 1 character, it is a palindrome.
        } else if (str.charAt(0) == str.charAt(str.length() - 1)) {
            String subStr = str.substring(1, str.length() - 1);
            return Palindrome(subStr); // If the first and last characters are equal, check the substring between them.
        } else {
            return false; // If the characters are not equal, it's not a palindrome.
        }

    }
}
