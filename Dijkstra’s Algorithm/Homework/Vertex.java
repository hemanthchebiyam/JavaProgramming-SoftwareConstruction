/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.HashSet;
import java.util.Set;

class Vertex<T> {

    private T value;
    //set of vertices
    private Set<Edge<T>>edges;
    
    //Constructor
    Vertex(T value) {
        this.value = value;
        edges = new HashSet<>();
    }

    T getValue() {
        return value;
    }

    //Add neighbor to my Set of neighbors
    void addNeighbor(Vertex<T>neighbor, int weight) {
        Edge<T> edge = new Edge<>(this, neighbor, weight);
        edges.add(edge);
    }

    //Return the set of neighbors, get the vertices to which this vertex is connected.
    Set<Vertex<T>> getNeighbors() {
        //we are iterating over the edges getting each neighbor vertex out of the edge throwing it in a set, returning the set
        Set<Vertex<T>> neighbors = new HashSet<>();
        for(Edge<T> edge : edges){
            neighbors.add(edge.getTo());
        }
        return neighbors;
    }

    Set<Edge<T>> getEdges() { return edges; }
}
