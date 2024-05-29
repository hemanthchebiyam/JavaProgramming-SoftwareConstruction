/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.ArrayList;

/**
 * Represents a library containing a list of patrons and their associated books.
 */
public class Library {
    
    // List of patrons in the library.
    ArrayList <Patron> listOfPatrons = new ArrayList<Patron>();

    /**
     * Adds a patron to the library.
     *
     * @param p The patron to be added.
     */
    public void addPatron(Patron p){
        listOfPatrons.add(p);
    }

    /**
     * Retrieves the name of a patron based on their ID.
     *
     * @param Id The ID of the patron.
     * @return The name of the patron if found, otherwise "Patron not found!".
     */
    public String getPatron(String Id){
        for(Patron i: listOfPatrons)
            if(i.getId().equals(Id))
                return i.getName();
        
        return "Patron not found!";
    }

    /**
     * Adds a book to a patron's book log based on their ID.
     *
     * @param Id    The ID of the patron.
     * @param title The title of the book to be added.
     */
    public void addBook(String Id, String title){
        for(Patron i: listOfPatrons){
            if(i.getId().equals(Id)){
                i.getBookLog().add(title);
                break;
            }
        }
    }
}
