/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.ArrayList;

/**
 * Represents a patron in a library system.
 */
public class Patron {
    
    String Id;
    String Name;
    ArrayList<String> BookLog;
    double fines;
    
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public ArrayList<String> getBookLog() {
        return BookLog;
    }
    public void setBookLog(ArrayList<String> bookLog) {
        BookLog = bookLog;
    }
    public double getFines() {
        return fines;
    }
    public void setFines(double fines) {
        this.fines = fines;
    }

    /**
     * Adds a book to the patron's book log.
     *
     * @param bookName The name of the book to add.
     */
    public void addBook(String Name){
        this.BookLog.add(Name);
    }

    /**
     * Removes a book from the patron's book log.
     *
     * @param bookName The name of the book to remove.
     */
    public void removeBook(String Name){
        this.BookLog.remove(Name);
    }

    /**
     * Returns a string representation of the patron including ID and name.
     *
     * @return A string representation of the patron.
     */
    @Override
    public String toString(){
        return "The Patron with ID: " + getId() + ", the Name: " + getName();
    }

    /**
     * Generates a hash code for the patron based on ID.
     *
     * @return The hash code for the patron.
     */
    @Override
    public int hashCode(){
        int hash = 0;

        char[] chars = this.getId().toUpperCase().toCharArray();
        for(int i = 0;i < 3; i++)
            hash = hash * 26 + (chars[i] - 65);
        
        for(int i = 3; i < chars.length; i++)
            hash = hash * 10 + (chars[i] - 48);
        
        return hash;
    }

}
