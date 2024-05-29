/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.Random;
import java.util.Arrays;

/**
 * This is a Java program for Homework 7 - Question 1.
 * It demonstrates the quicksort algorithm
 * to sort an array of integers in descending order.
 */
public class Question1_Quicksort {
    /**
     * This is the main method of the program.
     * It generates a random array of 10 integers,
     * sorts it in descending order using the 'quicksortDescending' method, 
     * and prints the original and sorted arrays.
     * @param args is the standard command-line argument.
     */
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10); // Change the size as needed
        System.out.println("Original Array:" + Arrays.toString(arr));
        
        quicksortDescending(arr, 0, arr.length - 1);
        
        System.out.println("Sorted Array (Descending Order):" + Arrays.toString(arr));
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
    
    /**
     * The "quicksortDescending" method performs Quicksort in descending order.
     * @param arr is the array to be sorted.
     * @param low is the index of the first element in the partition.
     * @param high is the index of the last element in the partition.
     */
    public static void quicksortDescending(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksortDescending(arr, low, pivotIndex - 1);
            quicksortDescending(arr, pivotIndex + 1, high);
        }
    }

    /**
     * The "partition" method partitions the array for Quicksort.
     * @param arr is the array to be partitioned.
     * @param low is the index of the first element in the partition.
     * @param high is the index of the last element in the partition.
     * @return the index of the pivot element after partitioning.
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
