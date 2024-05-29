/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework;
/**
 * This is a Java program for Homework 6 - Question 3.
 * It demonstrates the sorting an array of country names and their populations alphabetically.
 */
public class Question3 {
    /**
     * This is the main method of the program. 
     * I am using the selection sort algorithm to alphabetically sort countries along with their corresponding populations.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        // Arrays of country names and populations
        String[] countryNames = {"United States of America", "Argentina", "India", "Brazil", "Estonia"};
        int[] populations = {20143850, 12054760, 150876190, 96450320, 3469760};
        
        // Combine country names and populations into a single array
        String[] combined = new String[countryNames.length];
        for (int i = 0; i < countryNames.length; i++) {
            combined[i] = countryNames[i] + " - " + populations[i];
        }
        // Sort the country names alphabetically
        SelectionSort(combined);

        // Print the sorted list
        System.out.println("Sorted List of Countries:");
        for (String entry : combined) {
            String[] parts = entry.split(" - ");
            String country = parts[0];
            int population = Integer.parseInt(parts[1]);
            System.out.println("Country: " + country + ", Population: " + population);
        }
    }
    /**
     * The 'SelectionSort' method sorts a string array in alphabetical order using the selection sort algorithm.
     * @param array is the string array to be sorted.
     */
    public static void SelectionSort(String[] array) {
        
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
        
            // Find the index of the minimum element
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the current element (at index i).
            swap(array, i, minIndex);
        }
    }
    /**
    * The 'swap' method swaps two elements in a string array.
    *
    * @param array is the array in which the elements will be swapped.
    * @param i is the index of the first element.
    * @param j is the index of the second element.
    */
    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

