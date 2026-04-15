import java.util.*;

// Clase que representa el grafo
public class Graph {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;

        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Agregar arista
    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    // Obtener lista de adyacencia
    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

    // Obtener número de vértices
    public int getVertices() {
        return vertices;
    }

    // Imprimir grafo
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertice " + i + ": ");
            for (Integer node : adjList[i]) {
                System.out.print(node + " -> ");
            }
            System.out.println();
        }
    }
}