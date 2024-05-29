/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;
/**
 * This interface defines the basic operations for a heap data structure.
 */
public interface Heap {
    void add(int value); // Adds a new element to the heap.
    int remove(); // Removes and returns the top element from the heap.
    int size(); // Returns the current size of the heap.

}
