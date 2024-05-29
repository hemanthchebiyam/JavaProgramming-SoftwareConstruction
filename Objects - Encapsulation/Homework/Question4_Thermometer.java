/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * This is a Java program for Homework 7 - Question 4.
 * This class represents a thermometer that can measure temperature in Celsius, Fahrenheit, and Kelvin scales.
 */
public class Question4_Thermometer {
    private double temperatureCelsius; // Temperature in Celsius

    // Parameterless constructor, initializes temperature to 37°C
    public Question4_Thermometer() {
        this.temperatureCelsius = 37.0;
    }

    /**
     * Method to set temperature in Celsius.
     * @param celsius is the temperature in celsius.
     */
    public void setTemperatureCelsius(double celsius) {
        this.temperatureCelsius = celsius;
    }

    
    /**
     * Method to set temperature in Fahrenheit.
     * @param fahrenheit is the temperature in fahrenheit.
     */
    public void setTemperatureFahrenheit(double fahrenheit) {
        // Convert Fahrenheit to Celsius and set the temperature
        this.temperatureCelsius = (fahrenheit - 32) * 5/9;
    }

    /**
     * Method to set temperature in Kelvin.
     * @param kelvin is the temperature in kelvin.
     */
    public void setTemperatureKelvin(double kelvin) {
        // Convert Kelvin to Celsius and set the temperature
        this.temperatureCelsius = kelvin - 273.15;
    }

    /**
     * Gets the temperature in Celsius.
     *
     * @return Temperature in Celsius.
     */
    public double getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    /**
     * Converts and gets the temperature in Fahrenheit.
     *
     * @return Temperature in Fahrenheit.
     */
    public double getTemperatureFahrenheit() {
        // Convert Celsius to Fahrenheit and return the temperature
        return (this.temperatureCelsius * 9/5) + 32;
    }

    /**
     * Converts and gets the temperature in Kelvin.
     *
     * @return Temperature in Kelvin.
     */
    public double getTemperatureKelvin() {
        // Convert Celsius to Kelvin and return the temperature
        return this.temperatureCelsius + 273.15;
    }

    /**
     * Overrides the toString method to display the temperature in all three scales.
     *
     * @return A string representation of the temperature in Celsius, Fahrenheit, and Kelvin.
     */
    @Override
    public String toString() {

        // Using String.format to create a formatted string with temperature values in Celsius, Fahrenheit, and Kelvin.
        return String.format("Temperature: %.2f°C | %.2f°F | %.2fK",
            this.temperatureCelsius,
            this.getTemperatureFahrenheit(),
            this.getTemperatureKelvin());
    }

    /**
     * The main method demonstrates the functionality of the Question4_Thermometer class.
     *
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        Question4_Thermometer thermometer = new Question4_Thermometer();

        // Set and print temperature in different scales
        thermometer.setTemperatureCelsius(100);
        System.out.println(thermometer);

        thermometer.setTemperatureFahrenheit(-4);
        System.out.println(thermometer);

        thermometer.setTemperatureKelvin(34);
        System.out.println(thermometer);
    }
}
