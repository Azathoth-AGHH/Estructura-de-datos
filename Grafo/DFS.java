// Clase que implementa DFS
public class DFS {

    // Método público
    public void runDFS(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.getVertices()];

        System.out.println("Recorrido DFS:");
        dfsRecursive(graph, startVertex, visited);
    }

    // Método recursivo
    private void dfsRecursive(Graph graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recorremos vecinos
        for (Integer neighbor : graph.getAdjList()[vertex]) {
            if (!visited[neighbor]) {
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }
}