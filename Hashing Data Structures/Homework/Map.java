/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * Represents a basic map interface with key-value pairs.
 *
 * @param <K> The type of keys in the map.
 * @param <V> The type of values in the map.
 */
public interface Map <K,V>{
    
    void put(K key, V value); // Associates the specified value with the specified key in the map.
    
    V get(K key); // Retrieves the value associated with the specified key in the map.
    
    int size(); // Returns the number of key-value mappings in the map.
}
