/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to test the functionality of the HashMap implementation.
 */
public class HashMapTest {
    
    /**
     * The main method to test the HashMap implementation.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        
        // Creating a new HashMap with an initial capacity of 10.
        Map<String, String>map = new HashMap<>(10);

        // Adding key-value pairs to the map.
        map.put("ABC1234","Hemanth");
        map.put("DFT589", "Alex");
        map.put("LKO946","Ryan");
        map.put("FHT258","Kate");

        // Iterating over the keys in the map and printing key-value pairs.
        for(String key : map.keySet())
            System.out.println(key + " is " + map.get(key));

    }
}
