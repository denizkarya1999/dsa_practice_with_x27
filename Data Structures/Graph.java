import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.put(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // Uncomment this for undirected graph
    }

    // Remove an edge between two vertices
    public void removeEdge(int src, int dest) {
        adjList.get(src).remove(Integer.valueOf(dest));
        adjList.get(dest).remove(Integer.valueOf(src)); // Uncomment this for undirected graph
    }

    // Remove a vertex from the graph
    public void removeVertex(int vertex) {
        List<Integer> neighbors = adjList.get(vertex);
        for (Integer neighbor : neighbors) {
            adjList.get(neighbor).remove(Integer.valueOf(vertex));
        }
        adjList.remove(vertex);
    }

    // Print the graph
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        // Print the graph
        System.out.println("Graph:");
        graph.printGraph();

        // Remove an edge
        graph.removeEdge(1, 3);
        System.out.println("\nGraph after removing edge between 1 and 3:");
        graph.printGraph();

        // Remove a vertex
        graph.removeVertex(2);
        System.out.println("\nGraph after removing vertex 2:");
        graph.printGraph();
    }
}