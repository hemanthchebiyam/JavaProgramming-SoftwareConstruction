/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * Represents a key-value pair used in a map data structure.
 *
 * @param <K> The type of keys in the entry.
 * @param <V> The type of values in the entry.
 */
public class Entry <K,V>{
    
    private K key;
    private V value;
    
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Constructs a new Entry object with the specified key and value.
     *
     * @param key   The key of the entry.
     * @param value The value associated with the key.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    

}
