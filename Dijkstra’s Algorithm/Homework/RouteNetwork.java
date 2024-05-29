/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents a network of airports and their connections with associated costs.
 */
public class RouteNetwork {
    private final WeightedAdjacencyGraph<String> graph;

    
    //Constructs a new RouteNetwork with an underlying weighted adjacency graph.
    public RouteNetwork() {
        this.graph = new WeightedAdjacencyGraph<>();
    }

    /**
     * The main method that demonstrates the usage of the RouteNetwork class.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        RouteNetwork routeNetwork = new RouteNetwork();

        // Add airports and connections to the graph
        routeNetwork.addAirport("ATL");
        routeNetwork.addAirport("DCA");
        routeNetwork.addAirport("LAX");
        routeNetwork.addAirport("MCO");
        routeNetwork.addAirport("ORD");
        routeNetwork.addAirport("PDX");
        routeNetwork.addAirport("ROC");
        routeNetwork.addAirport("SFO");

        routeNetwork.connectAirports("ATL", "LAX", 31);
        routeNetwork.connectAirports("ATL", "ROC", 22);
        routeNetwork.connectAirports("DCA", "LAX", 36);
        routeNetwork.connectAirports("DCA", "ROC", 10);
        routeNetwork.connectAirports("DCA", "SFO", 25);
        routeNetwork.connectAirports("LAX", "MCO", 31);
        routeNetwork.connectAirports("LAX", "ORD", 35);
        routeNetwork.connectAirports("LAX", "PDX", 21);
        routeNetwork.connectAirports("LAX", "SFO", 10);
        routeNetwork.connectAirports("MCO", "ROC", 24);
        routeNetwork.connectAirports("ORD", "PDX", 26);
        routeNetwork.connectAirports("ORD", "ROC", 15);
        routeNetwork.connectAirports("ORD", "SFO", 37);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the source airport code: ");
        String sourceAirportCode = scanner.next().toUpperCase(); // Convert to uppercase for consistency
        System.out.print("Enter the destination airport code: ");
        String destinationAirportCode = scanner.next().toUpperCase();

        List<String> shortestPath = routeNetwork.dijkstrasShortestPath(sourceAirportCode, destinationAirportCode);
        int totalCost = routeNetwork.calculateTotalCost(shortestPath);

        System.out.print("Lowest cost path: ");
        for (int i=0; i < shortestPath.size(); i++) {
            System.out.print(shortestPath.get(i));
            if (i < shortestPath.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(", " + totalCost * 10 + " dollars."); // Multiply by 10 to convert to dollars
    }

    /**
     * Adds an airport to the network.
     *
     * @param airportCode The code representing the airport.
     */
    public void addAirport(String airportCode) {
        graph.addValue(airportCode);
    }

    /**
     * Connects two airports with a given cost, creating an edge in the graph.
     *
     * @param sourceAirportCode      The code representing the source airport.
     * @param destinationAirportCode The code representing the destination airport.
     * @param cost                   The cost associated with the connection.
     */
    public void connectAirports(String sourceAirportCode, String destinationAirportCode, int cost) {
        graph.connect(sourceAirportCode, destinationAirportCode, cost);
        graph.connect(destinationAirportCode, sourceAirportCode, cost);
    }

    /**
     * Finds the shortest path between two airports using Dijkstra's algorithm.
     *
     * @param sourceAirportCode      The code representing the source airport.
     * @param destinationAirportCode The code representing the destination airport.
     * @return The shortest path as a list of airport codes.
     */
    public List<String> dijkstrasShortestPath(String sourceAirportCode, String destinationAirportCode) {
        return graph.dijkstrasShortestPath(sourceAirportCode, destinationAirportCode);
    }

    /**
     * Calculates the total cost of a given path in the network.
     *
     * @param path The path for which the total cost is calculated.
     * @return The total cost of the path.
     */
    public int calculateTotalCost(List<String> path) {
        int totalCost = 0;

        Map<String, Vertex<String>> vertices = graph.getVertices();

        for (int i = 0; i < path.size() - 1; i++) {
            String fromAirportCode = path.get(i);
            String toAirportCode = path.get(i + 1);

            Vertex<String> fromVertex = vertices.get(fromAirportCode);
            if (fromVertex != null) {
                for (Edge<String> edge : fromVertex.getEdges()) {
                    if (edge.getTo().getValue().equals(toAirportCode)) {
                        totalCost += edge.getWeight();
                        break;
                    }
                }
            }
        }
        return totalCost;
    }
}