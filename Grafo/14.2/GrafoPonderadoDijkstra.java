public class GrafoPonderadoDijkstra {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 10000000;
    private Vertice[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private DistPar[] sPath;      // array de distancias cortas
    private int currentVert;
    private int startToCurrent;

    public GrafoPonderadoDijkstra() {
        vertexList = new Vertice[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertice(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;   // grafo dirigido
    }

    // ======================== ALGORITMO DIJKSTRA ========================
    public void path(int start) {
        int nTree = 0;
        vertexList[start].isInTree = true;
        sPath = new DistPar[MAX_VERTS];

        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[start][j];
            sPath[j] = new DistPar(start, tempDist);
        }

        while (nTree < nVerts - 1) {
            int minDist = INFINITY;
            currentVert = 0;
            for (int j = 1; j < nVerts; j++) {
                if (!vertexList[j].isInTree && sPath[j].distance < minDist) {
                    minDist = sPath[j].distance;
                    currentVert = j;
                }
            }

            vertexList[currentVert].isInTree = true;
            nTree++;
            startToCurrent = sPath[currentVert].distance;

            for (int j = 0; j < nVerts; j++) {
                if (vertexList[j].isInTree) continue;
                int currentToFringe = adjMat[currentVert][j];
                int startToFringe = startToCurrent + currentToFringe;
                int sPathDist = sPath[j].distance;

                if (currentToFringe == INFINITY) continue;
                if (startToFringe < sPathDist) {
                    sPath[j].parentVert = currentVert;
                    sPath[j].distance = startToFringe;
                }
            }
        }
    }

    // Muestra el camino más corto desde el vértice inicial a todos los demás
    public void displayPaths() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");
            if (sPath[j].distance == INFINITY)
                System.out.print("inf");
            else
                System.out.print(sPath[j].distance);
            int parent = sPath[j].parentVert;
            System.out.print("(" + vertexList[parent].label + ") ");
        }
        System.out.println();
    }
}