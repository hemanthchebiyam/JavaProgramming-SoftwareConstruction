/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Java program for Homework 8.
 * The Telephone class represents a telephone object with the ability to dial calls,
 * disconnect calls, redial the last called number, display recent calls, and maintain
 * the total number of calls made.
 */
class Telephone {
    private static int totalCalls = 0; // Total number of calls made by all phones
    private static final String[] PHONE_TYPES = {"land line", "mobile", "satellite"};
    private static int nextPhoneNumber = 5550001; // Next available phone number

    private int phoneNumber; // Unique phone number for this telephone
    private String phoneType; // Type of the telephone (land line, mobile, or satellite)
    private List<Integer> recentCalls; // List to store recently dialed numbers
    private List<Integer> recentCallsHistory; // List to store the history of dialed numbers
    

    /**
     * Default constructor. Automatically assigns the next available phone number
     * and initializes phone type and recentCalls list.
     */
    public Telephone() {
        this.phoneNumber = nextPhoneNumber++;
        this.phoneType = PHONE_TYPES[0]; // Default to land line type
        this.recentCalls = new ArrayList<>();
        this.recentCallsHistory = new ArrayList<>();
    }

    /**
     * Parameterized constructor. Takes a specific phone number as a parameter and
     * initializes phone type and recentCalls list.
     *
     * @param phoneNumber The phone number to assign to this telephone.
     */
    public Telephone(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.phoneType = PHONE_TYPES[0]; // Default to land line type
        this.recentCalls = new ArrayList<>();
        this.recentCallsHistory = new ArrayList<>();
    }

    /**
     * Dials a phone number. If successful, adds the number to recentCalls list
     * and increments the total number of calls.
     *
     * @param number The phone number to dial.
     */
    public void dial(int number) {
        if (number == this.phoneNumber) {
            System.out.println("Error: Cannot call own number.");
        } else if (recentCalls.contains(number)) {
            System.out.println("Error: Call to this number is already in progress.");
        } else {
            System.out.println("Starting a call to number: " + number);
            recentCalls.add(number);
            recentCallsHistory.add(number); // Add the dialed number to history
            incrementTotalCalls(); // Increment total calls when a new call is made
        }
    }

    /**
     * Disconnects the ongoing call. If no call is in progress, prints an error message.
     */
    public void disconnect() {
        if (recentCalls.isEmpty()) {
            System.out.println("Error: No call in progress.");
        } else {
            int lastCall = recentCalls.remove(recentCalls.size() - 1);
            System.out.println("Call with number " + lastCall + " ended.");
        }
    }

    /**
     * Redials the last called number. If no call has been made yet, prints an error message.
     */
    public void redial() {
        if (recentCalls.isEmpty()) {
            System.out.println("Error: No number to redial.");
        } else {
            dial(recentCalls.get(recentCalls.size() - 1));
        }
    }

    /**
     * Displays the 10 most recently dialed numbers in reverse chronological order.
     * If fewer than 10 numbers have been dialed, prints only those numbers.
     */
    public void displayRecentCalls() {
        System.out.println("Recent calls:");
        for (int i = recentCalls.size() - 1; i >= 0; i--) {
            System.out.println(recentCalls.get(i));
        }
    }

    /**
     * Displays the entire history of dialed numbers.
     */
    public void displayRecentCallsHistory() {
        System.out.println("Recent calls history:");
        for (int i = 0; i < recentCallsHistory.size(); i++) {
            System.out.println(recentCallsHistory.get(i));
        }
    }

    /**
     * Gets the total number of phone calls made from any phone.
     *
     * @return The total number of calls made.
     */
    public static int getTotalCalls() {
        return totalCalls;
    }

    // Private method to increment total calls
    private static void incrementTotalCalls() {
        totalCalls++;
    }

    /**
    * Gets the phone number of the telephone.
    *
    * @return The phone number of the telephone.
    */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
    * Overrides the equals() method to compare Telephone objects based on their phone numbers.
    *
    * @param obj The object to compare with this Telephone.
    * @return true if the objects have the same phone number, false otherwise.
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Telephone otherPhone = (Telephone) obj;
    return phoneNumber == otherPhone.phoneNumber;
    }

    /**
     * Overrides the toString() method to provide a descriptive string representation
     * of the Telephone object.
     *
     * @return A string representation containing phone number, type, and recent calls.
     */
    @Override
    public String toString() {
        return "Phone Number: " + phoneNumber + ", Type: " + phoneType +
                ", Recent Calls: " + recentCalls.toString();
    }
}
