package Session;

import java.util.HashSet;
import java.util.Set;

class Vertex<T> {

    private T value;
    
    //set of vertices
    private Set<Vertex<T>> neighbors;
    
    //Constructor
    Vertex(T value) {
        this.value = value;
        neighbors = new HashSet<>();
    }

    T getValue() {
        return value;
    }

    //Add neighbor to my Set of neighbors
    void addNeighbor(Vertex<T> neighbor) {
        neighbors.add(neighbor);
    }

    //Return the set of neighbors, get the vertices to which this vertex is connected.
    Set<Vertex<T>> getNeighbors() {
        return neighbors;
    }
}
