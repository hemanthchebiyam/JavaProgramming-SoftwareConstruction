/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package homework;

import java.util.Arrays;
import java.util.Random;

/**
 * This is a Java program for Homework 6 - Question 2.
 * It demonstrates the merge sort algorithm by sorting a randomly generated array of integers.
 */
public class Question2 {
    /**
     * This is the main method of the program. 
     * It generates a random array of integers,
     * sorts it using the 'mergeSort' method, and prints the original and sorted arrays.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        
        int[] arr = generateRandomArray(10);
        System.out.println("Original Array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    /**
     * The 'mergeSort' method sorts an integer array using the Merge Sort algorithm.
     * @param array is the array to be sorted.
     */
    public static void mergeSort(int[] array) {
        
        if (array.length <= 1) {
            return; // Base case: If the array has 0 or 1 elements, it is already sorted.
        }

        // Split the array into two halves
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves back together
        merge(array, left, right);
    }

    /**
     * The 'merge' method merges two sorted arrays into a single sorted array.
     * @param result is the array where the merged elements will be stored.
     * @param left is the left sorted subarray.
     * @param right is the right sorted subarray.
     */
    private static void merge(int[] result, int[] left, int[] right) {
        
        int i = 0; // Index for the left array
        int j = 0; // Index for the right array
        int k = 0; // Index for the result array

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        // Copy any remaining elements from both left and right subarrays
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
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
