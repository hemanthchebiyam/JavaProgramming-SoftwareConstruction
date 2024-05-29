/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * Represents a basic implementation of a hash map.
 *
 * @param <K> The type of keys in the hash map.
 * @param <V> The type of values in the hash map.
 */
public class HashMap <K,V> implements Map <K,V>{

    Entry[] entries;
    int size;
    
    // Constructs a new HashMap with an initial capacity of 100 entries.
    public HashMap(Entry[] entries, int size) {
        entries = new Entry[100];
        this.size = 0;
    }

    // Computes the index in the hash map for a given key.
    int getIndex(K key){
        return Math.abs(key.hashCode()) % entries.length;
    }

    /**
     * Associates the specified value with the specified key in the hash map.
     *
     * @param key   The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     */
    @Override
    public void put(K key, V value) {
        //int hashcode = key.hashCode();
        int index = getIndex(key);
        Entry <K,V> entry = new Entry<>(key, value);
        entries[index] = entry;
        size++;
    }

    /**
     * Retrieves the value associated with the specified key in the hash map.
     *
     * @param key The key whose associated value is to be retrieved.
     * @return The value associated with the specified key, or null if the key is not found.
     */
    @Override
    public V get(K key) {
        //int hashcode = key.hashCode();
        int index = getIndex(key);
        Entry<K,V> entry = (Entry<K,V>)entries[index];
        return entry.getValue();
    }

    // Returns the number of key-value mappings in the hash map.
    @Override
    public int size() {
        return 0;
    }
    
}
