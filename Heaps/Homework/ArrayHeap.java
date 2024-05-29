/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.Arrays;
/**
 * Implementation of the Heap interface using an array-based representation.
 */
public class ArrayHeap implements Heap{
    
    int[] array; // Internal array to store heap elements
    int size; // Current size of the heap

        // Default constructor to initialize an empty heap with a default capacity.
        public ArrayHeap() {
        this.array = new int[8];
        this.size = 0;
    }

        /**
         * Sifts a value up from the specified index in a heap.
         *
         * @param array The heap.
         * @param index The index to begin sifting up.
         */
        static void siftUp(int[] array, int index) {
            int parent = (index - 1) / 2;
            while(array[parent] > array[index]) {
                swap(array, index, parent);
                index = parent;
                parent = (index - 1) / 2;
            }
        }

        /**
         * Sifts a value down from the root in a heap.
         *
         * @param array The heap.
         * @param size The size of the heap.
         */
        static void siftDown(int[] array, int size) {
            int to = 0;
            int from;
            do {
                from = to;

                int left = 2 * from + 1;
                int right = left + 1;
                if(left < size && array[left] < array[to]) {
                    to = left;
                }

                if(right < size && array[right] < array[to]) {
                    to = right;
                }

                swap(array, from, to);

            } while(from != to);
        }

        /**
         * Swaps the values at the specified indexes.
         *
         * @param array The array in which the values should be swapped.
         * @param from The first index.
         * @param to The second index.
         */
        static void swap(int[] array, int from, int to) {
            if(from != to) {
                int tmp = array[from];
                array[from] = array[to];
                array[to] = tmp;
            }
        }

        @Override
        public void add(int value) {
            // Resize the array if necessary
            if(size==array.length){
                int[] newArray = Arrays.copyOf(array, size*2);
                this.array = newArray;
            }
            // Add the new value to the heap and perform sift-up operation
            this.array[size]=value;
            siftUp(this.array, size);
            size++;
        }

        @Override
        public int remove() {
                // Remove the root element, replace it with the last element, and perform sift-down operation
                int retVal = this.array[0];
                size--;
                this.array[0] = array[size];
                this.array[size] = 0;
                siftDown(this.array, size);
                return retVal;
        }

        @Override
        public int size() {
            return size;
        }

    // Added toString method to print the content of the heap
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]).append(" ");
        }
        return result.toString();
    }
}