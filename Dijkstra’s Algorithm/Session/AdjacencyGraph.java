package Session;

import java.util.*;

public class AdjacencyGraph<T> implements Graph<T> {
    private Map<T, Vertex<T>> vertices;

    public AdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void addValue(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(T value) {
        return vertices.containsKey(value);
    }

    @Override
    public void connectDirected(T value, T... values) {
        Vertex<T> vertex = vertices.get(value);
        for(T neighborValue : values) {
            Vertex<T> neighbor = vertices.get(neighborValue);
            vertex.addNeighbor(neighbor);
        }
    }

    @Override
    public void connectUndirected(T value, T... values) {
        Vertex<T> vertex = vertices.get(value);
        
        for(T neighborValue : values) {
            Vertex<T> neighbor = vertices.get(neighborValue);
            vertex.addNeighbor(neighbor);
            neighbor.addNeighbor(vertex);
        }
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public boolean breadthFirstSearch(T start, T end) {
        Vertex<T> startVertex = vertices.get(start);
        Vertex<T> endVertex = vertices.get(end);

        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while(queue.size() > 0) {
            Vertex<T> v = queue.poll();
            if(v == endVertex) {
                return true;
            } else {
                for(Vertex<T> neighbor : v.getNeighbors()) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<T> breadthFirstPath(T start, T end) {
        Vertex<T> startVertex = vertices.get(start);
        Vertex<T> endVertex = vertices.get(end);

        Queue<Vertex<T>> queue = new LinkedList<>();
        Map<Vertex<T>, Vertex<T>> visited = new HashMap<>();

        queue.add(startVertex);
        visited.put(startVertex, null);

        while(queue.size() > 0) {
            Vertex<T> v = queue.poll();
            if(v == endVertex) {
                List<T> path = new LinkedList<>();
                Vertex<T> p = endVertex;
                while(p != null) {
                    path.add(0, p.getValue());
                    p = visited.get(p);
                }
                return path;
            } else {
                for(Vertex<T> neighbor : v.getNeighbors()) {
                    if(!visited.containsKey(neighbor)) {
                        visited.put(neighbor, v);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    @Override
    public boolean depthFirstSearch(T start, T end) {
        //create an empty set
        Set<Vertex<T>> visited = new HashSet<>();
        //Add the start vertex to it
        Vertex<T> startVertex = vertices.get(start);
        Vertex<T> endVertex = vertices.get(end);
        visited.add(startVertex);
        //Call visit DFS with the start vertex and the set
        visitDFS(startVertex, visited);
        //return true if the end vertex is in the set.
        return visited.contains(endVertex);
    }

    private void visitDFS(Vertex<T> vertex, Set<Vertex<T>> visited){
        //Iterate over vertex neighbors
        for(Vertex<T> neighbor : vertex.getNeighbors()) {
            //For each neighbor if it's not already in the set.
            if(!visited.contains(neighbor)){
                //Add it and make a recursive call to Visit DFS With the neighbor.
                visited.add(neighbor);
                visitDFS(neighbor, visited);
            } 
        }
    } 

    @Override
    public List<T> depthFirstPath(T start, T end) {
        Vertex<T> startVertex = vertices.get(start);
        Set<Vertex<T>> visited = new HashSet<>();
        visited.add(startVertex);
        Vertex<T> endVertex = vertices.get(end);
        return visitDFSPath(startVertex, endVertex, visited); 
    }
    
    private List<T> visitDFSPath(Vertex<T> vertex, Vertex<T> end, Set<Vertex<T>> visited) {
        //If the vertex is the goal. We're going to add it to the path and return the path
        if (vertex == end){ 
            List<T> path = new LinkedList<>();
            path.add(vertex.getValue());
            return path;
        }else{
        //for each neighbor that's not already in the set. We add the neighbor to the set and then we recursively call visitDFS
            for(Vertex<T> neighbor : vertex.getNeighbors()) {
                if(!visited.contains(neighbor)){ visited.add(neighbor);
                    List<T> path = visitDFSPath(neighbor, end, visited);
                    //If that returns a path that is not know that means we found a path to the goal somewhere down that line.
                    if(path != null){
                        //the vertex will be added to the path and return the path
                        path.add(0, vertex.getValue());
                        return path; 
                    } 
                } 
            }
            return null; 
        } 
    }
}
