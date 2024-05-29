/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework05;

/**
 * This is a Java program for Homework 5 - Question 7.
 * This program counts the occurrences of a specific character in a given string.
 */
public class Question7 {
    /**
     * This is the main method of the program.
     * It initializes a string, a character to check for, and then calls the recursive 'countChar' method
     * to count the occurrences of the specified character in the string.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        // Initializing the input string and the character which needs to be checked
        String inputStr = "Hello, I am Hemanth Chebiyam!";
        char checkFor = 'h';
        
        // Calling the countChar method 
        int result = countChar(inputStr.toCharArray(), checkFor, 0);
        System.out.println("The character " + checkFor + " occurs " + result + " times in the string.");
    }
    /**
     * The 'countChar' method recursively counts the occurrences of a specific character in an array of characters.
     * @param arr is the character array to search for occurrences of the specific character.
     * @param specificChar is the character to count occurrences of.
     * @param index is the current index being checked in the character array.
     * @return the count of occurrences of the specific character.
     */
    public static int countChar (char[] arr, char specificChar, int index) {
        if (index == arr.length) {
            return 0; // This is the base case. If the index reached the end of the array, return 0.
        } 
        // If the current character matches the specific character (case-insensitive),
        // increment the count and continue checking the next character.
        else if (Character.toLowerCase(arr[index]) == Character.toLowerCase(specificChar)) {
            return 1 + countChar(arr, specificChar, index + 1); // 
        }
        // If the current character doesn't match, continue checking the next character. 
        else {
            return countChar(arr, specificChar, index + 1);
        }

    }
}
