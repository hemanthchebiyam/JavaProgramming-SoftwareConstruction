/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework;

import java.util.Arrays;
import java.util.Random;
/**
 * This is a Java program for Homework 6 - Question 1.
 * It demonstrates the selection sort algorithm
 * to sort an array of integers in descending order.
 */
public class Question1 {
    
    /**
     * This is the main method of the program.
     * It generates a random array of 10 integers,
     * sorts it in descending order using the 'selectionSortDescending' method, 
     * and prints the original and sorted arrays.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
        System.out.println("Original Array: " + Arrays.toString(arr));
        selectionSortDescending(arr);
        System.out.println("Sorted Array (Descending): " + Arrays.toString(arr));
    }

    /**
     * The 'selectionSortDescending' method sorts an array of integers in descending order using the selection sort algorithm.
     * @param array is the array to be sorted.
     */
    public static void selectionSortDescending(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            
            // Find the index of the maximum element in the remaining unsorted portion of the array.
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap the maximum element with the current element (at index i).
            swap(array, i, maxIndex);
        }
    }

    /**
     * The 'swap' method swaps two elements in an integer array.
     * @param array is the array in which the elements will be swapped.
     * @param i is the index of the first element.
     * @param j is the index of the second element.
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * The 'generateRandomArray' method generates an array of random integers with the specified size, 
     * where each integer is between 0 and 99.
     * @param size is the size of the random array to be generated.
     * @return an array of random integers.
     */
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100); // Generate random integers between 0 and 99
        }
        return arr;
    }  
}
