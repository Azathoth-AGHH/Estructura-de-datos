public class MainMST {
    public static void main(String[] args) {
        GrafoPonderado theGraph = new GrafoPonderado();

        theGraph.addVertex('A');  // 0
        theGraph.addVertex('B');  // 1
        theGraph.addVertex('C');  // 2
        theGraph.addVertex('D');  // 3
        theGraph.addVertex('E');  // 4
        theGraph.addVertex('F');  // 5

        theGraph.addEdge(0, 1, 6);   // AB
        theGraph.addEdge(0, 3, 4);   // AD
        theGraph.addEdge(1, 2, 10);  // BC
        theGraph.addEdge(1, 3, 7);   // BD
        theGraph.addEdge(1, 4, 7);   // BE
        theGraph.addEdge(2, 3, 8);   // CD
        theGraph.addEdge(2, 4, 5);   // CE
        theGraph.addEdge(2, 5, 6);   // CF
        theGraph.addEdge(3, 4, 12);  // DE
        theGraph.addEdge(4, 5, 7);   // EF

        System.out.print("Árbol de expansión mínimo: ");
        theGraph.mstw();             // ← algoritmo principal
        System.out.println();
    }
}