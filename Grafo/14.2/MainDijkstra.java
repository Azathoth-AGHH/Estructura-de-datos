public class MainDijkstra {
    public static void main(String[] args) {
        GrafoPonderadoDijkstra theGraph = new GrafoPonderadoDijkstra();

        theGraph.addVertex('A');  // 0
        theGraph.addVertex('B');  // 1
        theGraph.addVertex('C');  // 2
        theGraph.addVertex('D');  // 3
        theGraph.addVertex('E');  // 4

        theGraph.addEdge(0, 1, 50);   // A→B
        theGraph.addEdge(0, 3, 80);   // A→D
        theGraph.addEdge(1, 2, 60);   // B→C
        theGraph.addEdge(1, 3, 90);   // B→D
        theGraph.addEdge(2, 4, 40);   // C→E
        theGraph.addEdge(3, 4, 70);   // D→E

        System.out.print("Caminos más cortos desde A: ");
        theGraph.path(0);          // ← algoritmo Dijkstra desde A
        theGraph.displayPaths();
    }
}