/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.*;
/**
 * Represents a weighted graph implementation using an adjacency list.
 *
 * @param <T> The type of values stored in the graph.
 */
public class WeightedAdjacencyGraph<T> implements WeightedGraph<T>{
    private final Map<T, Vertex<T>> vertices;

    /**
     * Gets the vertices of the graph.
     *
     * @return The map of vertices in the graph.
     */
    public Map<T, Vertex<T>> getVertices() {
        return vertices;
    }
    // Constructs a new WeightedAdjacencyGraph.
    public WeightedAdjacencyGraph() {
        vertices = new HashMap<>();
    }
    
    /**
     * Adds a new value (node) to the graph.
     *
     * @param value The value to be added to the graph.
     */
    @Override
    public void addValue(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        vertices.put(value, vertex);
    }
    
    /**
     * Connects two values (nodes) in the graph with a weighted edge.
     *
     * @param value1 The source value.
     * @param value2 The destination value.
     * @param weight The weight of the edge connecting the source and destination values.
     */
    @Override
    public void connect(T value1, T value2, int weight) {
        Vertex<T> from = vertices.get(value1);
        Vertex<T> to = vertices.get(value2);
        from.addNeighbor(to, weight);
    }
    
    /**
     * Finds the shortest path between two values using Dijkstra's algorithm.
     *
     * @param source      The source value.
     * @param destination The destination value.
     * @return A list representing the shortest path between the source and destination values.
     * @throws IllegalArgumentException if source or destination vertex is not found in the graph.
     */
    @Override
    public List<T> dijkstrasShortestPath(T source, T destination) {
        if (!vertices.containsKey(source) || !vertices.containsKey(destination)) {
            throw new IllegalArgumentException("Source or destination vertex not found in the graph");
        }

        Map<Vertex<T>, Integer> distance = new HashMap<>();
        Map<Vertex<T>, Vertex<T>> previous = new HashMap<>();
        PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        for (Vertex<T> vertex : vertices.values()) {
            distance.put(vertex, vertex == vertices.get(source) ? 0 : Integer.MAX_VALUE);
            previous.put(vertex, null);
            priorityQueue.offer(vertex);
        }

        while (!priorityQueue.isEmpty()) {
            Vertex<T> current = priorityQueue.poll();

            for (Edge<T> edge : current.getEdges()) {
                Vertex<T> neighbor = edge.getTo();
                int newDistance = distance.get(current) + edge.getWeight();

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    // Reorder the priority queue since distance has been updated
                    priorityQueue.remove(neighbor);
                    priorityQueue.offer(neighbor);
                }
            }
        }

        // Build and return the list of shortest path vertices
        List<T> shortestPath = new ArrayList<>();
        Vertex<T> current = vertices.get(destination);

        while (current != null) {
            shortestPath.add(current.getValue());
            current = previous.get(current);
        }

        Collections.reverse(shortestPath);

        return shortestPath;
    }
}

