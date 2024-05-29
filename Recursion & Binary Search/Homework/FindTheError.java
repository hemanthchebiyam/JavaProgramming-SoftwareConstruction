/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework05;

/**
 * This is a Java program for Homework 5 - Question 1.
 * The error is found in the program and it has been mentioned in the comment below.
 */
public class FindTheError {
    //Stack overflow error due to infinite recursion without base case.
public static void main(String [] args){
    myMethod(0);
    }
    public static void myMethod(int num){
    System.out.println(num + " ");
    myMethod(num+1);
    }
    
}
