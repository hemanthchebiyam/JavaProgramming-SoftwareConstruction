/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * This is a Java program for Homework 7 - Question 3.
 * This class represents chemical elements and provides information about their properties.
 * Each element has a name, symbol, atomic number, and atomic weight.
 */
public class Question3_Elements {
    private String name;
    private String symbol;
    private int atomicNumber;
    private double atomicWeight;

    /**
     * Constructs a new Question3_Elements object with the specified properties.
     * 
     * @param name is the name of the chemical element.
     * @param symbol is the symbol of the chemical element.
     * @param atomicNumber is the atomic number of the chemical element.
     * @param atomicWeight is the atomic weight of the chemical element.
     */
    public Question3_Elements(String name, String symbol, int atomicNumber, double atomicWeight) {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }

    // Accessor methods (getters)

    /**
     * Gets the name of the chemical element.
     * @return the name of the chemical element.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the symbol of the chemical element.
     * @return the symbol of the chemical element.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets the atomic number of the chemical element.
     * @return The atomic number of the chemical element.
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }
    
    /**
     * Gets the atomic weight of the chemical element.
     * @return The atomic weight of the chemical element.
     */
    public double getAtomicWeight() {
        return atomicWeight;
    }

    // Mutator methods (setters)

    /**
     * Sets the name of the chemical element.
     * @param name The new name of the chemical element.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the symbol of the chemical element.
     * @param symbol The new symbol of the chemical element.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Sets the atomic number of the chemical element.
     * @param atomicNumber The new atomic number of the chemical element.
     */
    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    /**
     * Sets the atomic weight of the chemical element.
     * @param atomicWeight The new atomic weight of the chemical element.
     */
    public void setAtomicWeight(double atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    /**
     * Returns a string representation of the Question3_Elements object.
     *
     * @return A string containing the name, symbol, atomic number, and atomic weight of the element.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\nSymbol: " + symbol + "\nAtomic Number: " + atomicNumber + "\nAtomic Weight: " + String.format("%.3f", atomicWeight) + "\n";
    }

    /**
     * The main method creates instances of chemical elements and prints their information.
     *
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {

        // Creating instances of chemical elements
        Question3_Elements hydrogen = new Question3_Elements("Hydrogen", "H", 1, 1.008);
        Question3_Elements helium = new Question3_Elements("Helium", "He", 2, 4.0026);
        Question3_Elements lithium = new Question3_Elements("Lithium", "Li", 3, 6.94);
        Question3_Elements beryllium = new Question3_Elements("Beryllium", "Be", 4, 9.012);
        Question3_Elements boron = new Question3_Elements("Boron", "B", 5, 10.811);
        Question3_Elements carbon = new Question3_Elements("Carbon", "C", 6, 12.011);
        Question3_Elements nitrogen = new Question3_Elements("Nitrogen", "N", 7, 14.006);
        Question3_Elements oxygen = new Question3_Elements("Oxygen", "O", 8, 15.999);
        Question3_Elements fluorine = new Question3_Elements("Fluorine", "F", 9, 18.998);
        Question3_Elements neon = new Question3_Elements("Neon", "Ne", 10, 20.180);

        // Printing the elements
        System.out.println(hydrogen);
        System.out.println(helium);
        System.out.println(lithium);
        System.out.println(beryllium);
        System.out.println(boron);
        System.out.println(carbon);
        System.out.println(nitrogen);
        System.out.println(oxygen);
        System.out.println(fluorine);
        System.out.println(neon);
    }
}

