/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;
/**
 * Custom exception class to represent the situation where a negative value is not allowed.
 * This exception is thrown when a negative value is encountered in the program.
 */
public class NegativeValueException extends Exception{
    
    /**
     * Constructs a new NegativeValueException with the specified error message.
     *
     * @param message the error message for the exception
     */
    public NegativeValueException(String message){
        super(message);
    }
}
