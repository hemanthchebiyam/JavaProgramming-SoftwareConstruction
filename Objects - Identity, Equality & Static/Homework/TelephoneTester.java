/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * This is a Java program for Homework 8.
 * This class serves as a tester for the Telephone class, demonstrating its functionality.
 */
public class TelephoneTester {
    
    /**
     * The main method is the entry point of the program.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create three Telephone objects for testing
        Telephone phone1 = new Telephone();
        Telephone phone2 = new Telephone();
        Telephone phone3 = new Telephone(5550003);

        // Demonstrate dialing, disconnecting, and redialing calls
        System.out.println("Testing dial method:");
        phone1.dial(phone2.getPhoneNumber());
        phone1.dial(phone2.getPhoneNumber()); // Error: Call to this number is already in progress.
        phone1.dial(phone3.getPhoneNumber());
        phone1.displayRecentCalls(); 

        System.out.println("\nTesting disconnect method:");
        phone1.disconnect();
        phone1.disconnect(); // Error: No call in progress.
        phone1.displayRecentCallsHistory(); 

        System.out.println("\nTesting redial method:");
        phone1.redial();
        phone1.displayRecentCallsHistory(); 

        // Print the total number of calls made by all phones
        System.out.println("\nTotal calls made: " + Telephone.getTotalCalls());

        // Testing equality of two phones with the same phone number
        Telephone phone4 = new Telephone(phone1.getPhoneNumber());
        System.out.println("Are phone1 and phone4 equal? " + phone1.equals(phone4)); // Are phone1 and phone4 equal? true
    }
}
