/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;
import java.util.Scanner;

/**
 * This is a Java program for Homework 3 - Question 2.
 * This program allows the user to discuss either Music or Movies and provides responses based on their choices.
 */
public class Q2_MusicAndMovies {
    
    /**
     * This is the main method of the program.
     * I have used nested switch statements to handle the choice between Music or Movies and the subsequent choices within them. 
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Asking the user to choose a topic
        System.out.println("Would you like to discuss Music or Movies?");
        System.out.println("Enter 1 for Music");
        System.out.println("Enter 2 for Movies");

        int option = scanner.nextInt();

        
        switch (option) {
            // Asking if the user likes my favorite musician
            case 1:
                System.out.println("Do you like Metro Boomin? Enter 'Y' for yes and 'N' for no: ");
                scanner.nextLine();
                String response = scanner.nextLine();

                switch (response) {
                    case "Y": 
                        System.out.println("Good taste!");
                        break;

                    case "N": 
                        System.out.println("There is no accounting for taste!");
                        break;
                    // Handling the default case where the user input is invalid
                    default:
                        System.out.println("Wrong choice, please select either Y or N");
                        
                }
                break;
            // Asking the user about their favorite Star Wars episode
            case 2:
                System.out.println("Which Star Wars episode do you think was the best? Enter any episode number between 1 and 7: ");
                int episode = scanner.nextInt();
            
                switch (episode) {
                    case 1:
                    case 2:
                    case 3:
                        System.out.println("Um, no.");
                        break;
            
                    case 4:
                    case 5:
                        System.out.println("I agree!");
                        break;
            
                    case 6:
                    case 7:
                        System.out.println("I like those, too!");
                        break;
                    // Handling the default case where the user input is invalid
                    default:
                        System.out.println("Invalid episode number! Enter any episode number between 1 and 7");
                        break;
                }
                break;
        // Handling the default case where the user input is invalid
        default:
            System.out.println("Wrong choice, please select either 1 or 2");
        }
    }
}
