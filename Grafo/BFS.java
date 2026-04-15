import java.util.*;

// Clase que implementa BFS
public class BFS {

    // Método principal
    public void runBFS(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.getVertices()];

        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("\nRecorrido BFS:");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Integer neighbor : graph.getAdjList()[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}