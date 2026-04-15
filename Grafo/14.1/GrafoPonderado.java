public class GrafoPonderado {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertice[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int currentVert;
    private int nTree;
    private PriorityQ thePQ;

    public GrafoPonderado() {
        vertexList = new Vertice[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;
        thePQ = new PriorityQ();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertice(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;   // grafo no dirigido
    }

    // ======================== ALGORITMO PRINCIPAL: MST ========================
    public void mstw() {
        currentVert = 0;                  // empezamos en el vértice 0
        while (nTree < nVerts - 1) {      // mientras no estén todos los vértices en el árbol
            vertexList[currentVert].isInTree = true;
            nTree++;

            // Insertar todas las aristas adyacentes al vértice actual en la PriorityQ
            for (int j = 0; j < nVerts; j++) {
                if (j == currentVert) continue;
                if (vertexList[j].isInTree) continue;
                int distance = adjMat[currentVert][j];
                if (distance == INFINITY) continue;
                putInPQ(j, distance);
            }

            if (thePQ.size() == 0) {
                System.out.println(" GRAFO NO CONECTADO");
                return;
            }

            // Sacamos la arista de menor peso
            AristaPonderada theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;

            // Mostramos la arista que se añadió al MST
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }

        // Desmarcamos todos los vértices para posibles usos futuros
        for (int j = 0; j < nVerts; j++)
            vertexList[j].isInTree = false;
    }

    // Método auxiliar que inserta (o actualiza) aristas en la PriorityQ
    private void putInPQ(int newVert, int newDist) {
        int queueIndex = thePQ.find(newVert);
        if (queueIndex != -1) {
            AristaPonderada tempEdge = thePQ.peekN(queueIndex);
            int oldDist = tempEdge.distance;
            if (oldDist > newDist) {
                thePQ.removeN(queueIndex);
                thePQ.insert(new AristaPonderada(currentVert, newVert, newDist));
            }
        } else {
            thePQ.insert(new AristaPonderada(currentVert, newVert, newDist));
        }
    }
}