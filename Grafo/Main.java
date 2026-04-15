// Clase principal
public class Main {

    public static void main(String[] args) {

        // Crear grafo
        Graph graph = new Graph(5);

        // Agregar aristas
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Imprimir grafo
        graph.printGraph();

        // Ejecutar DFS
        DFS dfs = new DFS();
        dfs.runDFS(graph, 0);

        // Ejecutar BFS
        BFS bfs = new BFS();
        bfs.runBFS(graph, 0);
    }
}