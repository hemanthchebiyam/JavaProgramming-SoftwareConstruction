/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;
import java.util.Scanner;
import java.util.Random;

/**
 * This is a Java program for Homework 3 - Question 3.
 * This program generates a random number between 1 and 10 and gives the user 3 chances to guess the number.
 */

public class Q3_GuessingGame {

    private static int numberOfGuesses = 0; //Initializing a global int for number of guesses made.
    private static final int maxGuesses = 3; // Up to 3 guesses allowed for the user.
    
    /**
     * The function "tryGuess" attempts to guess a pseudo-randomly generated number and 
     * gives the user some feedback with each guess, regarding a higher, lower or a correct guess.
     * 
     * @param randomNumber is the randomly generated number to be guessed.
     * @param userGuess is the user's guess.
     * @return true if the guess is correct, and false otherwise.
     */

    public static boolean tryGuess(int randomNumber, int userGuess) {
        if (userGuess < randomNumber) {
            System.out.println("Too low!");
            return false;
        } else if (userGuess > randomNumber) {
            System.out.println("Too high!");
            return false;
        } else {
            System.out.println("Correct!");
            return true;
        }
    }
    /**
     * This is the main method of the program.
     * It generates a random number between 1 and 10 using java.util.Random class.
     * It tells the user if they have guessed correctly or not within the 3 guesses.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        //Generating a random number between 1 and 10 (both included)
        int randomNumber = rnd.nextInt(10) + 1; // Adding 1 so that even 10 can be considered when generating a random number.

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("You have 3 guesses to find the random number between 1 and 10");
        
        makeGuess(randomNumber); //Calls the makeGuess method to start the guessing process
    }
    
    /**
     * The makeGuess method recursively handles the user's guesses until they run out of guesses or guess correctly.
     * @param randomNumber is the randomly generated number to be guessed.
     */
    public static void makeGuess(int randomNumber) {
        Scanner scanner = new Scanner(System.in);
        
        if (numberOfGuesses < maxGuesses) {
            System.out.print("Take a guess: ");
            int userGuess = scanner.nextInt();
            
            if (tryGuess(randomNumber, userGuess)) {
                System.out.println("Yay! You guessed correctly.");
            } else {
                numberOfGuesses++;
                makeGuess(randomNumber); // Recursively call makeGuess for another guess
            }
        } else {
            System.out.println("Oops! No more guesses left. The correct number was: " + randomNumber + ".");
        }
        
    }
}