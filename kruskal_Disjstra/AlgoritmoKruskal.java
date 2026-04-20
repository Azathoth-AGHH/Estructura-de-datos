import java.util.*;

// Clase para representar las aristas del grafo
class Arista implements Comparable<Arista> {
    char origen, destino;
    int peso;

    public Arista(char origen, char destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.peso - otra.peso;
    }

    @Override
    public String toString() {
        return origen + " - " + destino + " (" + peso + ")";
    }
}

public class AlgoritmoKruskal {

    static class UnionFind {
        Map<Character, Character> padre = new HashMap<>();

        public UnionFind(List<Character> vertices) {
            for (char v : vertices) {
                padre.put(v, v);
            }
        }

        public char encontrar(char i) {
            if (padre.get(i) == i)
                return i;
            return encontrar(padre.get(i));
        }

        public void unir(char i, char j) {
            char raizI = encontrar(i);
            char raizJ = encontrar(j);
            padre.put(raizI, raizJ);
        }
    }

    public static void ejecutarKruskal(List<Character> vertices, List<Arista> aristas) {
        List<Arista> mst = new ArrayList<>();
        // 1. Ordenar las aristas por peso de menor a mayor
        Collections.sort(aristas);

        UnionFind uf = new UnionFind(vertices);

        System.out.println("--- Pasos del Algoritmo de Kruskal ---");
        int costoTotal = 0;

        for (Arista arista : aristas) {
            char raizOrigen = uf.encontrar(arista.origen);
            char raizDestino = uf.encontrar(arista.destino);

            // 2. Si no forman un ciclo, se agrega al MST
            if (raizOrigen != raizDestino) {
                mst.add(arista);
                uf.unir(raizOrigen, raizDestino);
                costoTotal += arista.peso;
                System.out.println("Agregada: " + arista);
            } else {
                System.out.println("Descartada (forma ciclo): " + arista);
            }
        }

        System.out.println("\n--- Árbol de Expansión Mínima (MST) ---");
        for (Arista a : mst) {
            System.out.println(a);
        }
        System.out.println("Costo total del MST: " + costoTotal);
    }

    public static void main(String[] args) {
        List<Character> vertices = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G');
        
        List<Arista> aristas = new ArrayList<>();
        aristas.add(new Arista('A', 'B', 7));
        aristas.add(new Arista('A', 'D', 5));
        aristas.add(new Arista('B', 'C', 8));
        aristas.add(new Arista('B', 'D', 9));
        aristas.add(new Arista('B', 'E', 7));
        aristas.add(new Arista('C', 'E', 5));
        aristas.add(new Arista('D', 'E', 15));
        aristas.add(new Arista('D', 'F', 6));
        aristas.add(new Arista('E', 'F', 8));
        aristas.add(new Arista('E', 'G', 9));
        aristas.add(new Arista('F', 'G', 11));

        ejecutarKruskal(vertices, aristas);
    }
}