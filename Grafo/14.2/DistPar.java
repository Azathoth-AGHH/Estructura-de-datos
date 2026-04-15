public class DistPar {
    public int distance;   // distancia desde el vértice origen
    public int parentVert; // vértice anterior en el camino

    public DistPar(int pv, int d) {
        distance = d;
        parentVert = pv;
    }
}