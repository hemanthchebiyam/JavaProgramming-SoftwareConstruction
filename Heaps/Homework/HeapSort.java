/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.Random;
/**
 * The HeapSort class demonstrates the usage of the ArrayHeap class for sorting an array of random numbers.
 */
public class HeapSort {
    /**
     * The main method executes the steps of generating random numbers, creating a heap, and sorting the numbers.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Step 1: Generate randomly 50 numbers that range between 0 and 100
        int[] randomNumbers = new int[50];
        Random random = new Random();

        // Step 2: Create a heap and add unique numbers to it
        ArrayHeap heap = new ArrayHeap();

        System.out.print("Generated Numbers: \n");
        for (int i = 0; i < 50; i++) {
            // Generate a random number between 0 and 100
            int randomNumber;
            boolean isDuplicate;
            do {
                randomNumber = random.nextInt(101);

                // Check if the number already exists in the array up to the current index
                isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (randomNumbers[j] == randomNumber) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            randomNumbers[i] = randomNumber;
            heap.add(randomNumber);
            // Print the numbers as they are added to the heap
            System.out.print(randomNumber + " ");
        }

        System.out.println("\n\nHeap content: ");
        // Step 4: Print the content of the heap using the toString method
        System.out.println(heap.toString());

        // Step 5: Construct an array to host the numbers as they are removed from the heap
        int[] sortedNumbers = new int[randomNumbers.length];

        // Step 6: Remove numbers from the heap and store them in the array
        for (int i = 0; i < sortedNumbers.length; i++) {
            sortedNumbers[i] = heap.remove();
        }

        // Verify that the numbers in the array are ordered
        System.out.println("\nSorted Numbers: ");
        for (int i = 0; i < sortedNumbers.length; i++) {
            System.out.print(sortedNumbers[i] + " ");
        }
    }
}
