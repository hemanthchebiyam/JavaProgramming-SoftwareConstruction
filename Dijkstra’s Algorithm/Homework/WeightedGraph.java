/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.*;

/**
 * Represents a weighted graph where nodes have associated values and edges have weights.
 *
 * @param <T> The type of values stored in the graph.
 */
public interface WeightedGraph<T> {
    /**
     * Adds a new value (node) to the graph.
     *
     * @param value The value to be added to the graph.
     */
    void addValue(T value);
    
    /**
     * Connects two values (nodes) in the graph with a weighted edge.
     *
     * @param value      The source value.
     * @param neighbor   The destination value.
     * @param weight     The weight of the edge connecting the source and destination values.
     */
    void connect(T value, T neighbor, int weight);
    
    /**
     * Finds the shortest path between two values using Dijkstra's algorithm.
     *
     * @param source      The source value.
     * @param destination The destination value.
     * @return A list representing the shortest path between the source and destination values.
     */
    List<T> dijkstrasShortestPath(T source, T destination);
}

