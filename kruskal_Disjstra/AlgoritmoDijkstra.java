import java.util.*;

class NodoAdyacente {
    char nombre;
    int peso;

    public NodoAdyacente(char nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }
}

public class AlgoritmoDijkstra {

    public static void ejecutarDijkstra(Map<Character, List<NodoAdyacente>> grafo, char inicio, char fin) {
        Map<Character, Integer> distancias = new HashMap<>();
        Map<Character, Character> predecesores = new HashMap<>();
        PriorityQueue<NodoAdyacente> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.peso));

        for (char nodo : grafo.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        
        distancias.put(inicio, 0);
        pq.add(new NodoAdyacente(inicio, 0));

        System.out.println("--- Pasos del Algoritmo de Dijkstra ---");

        while (!pq.isEmpty()) {
            char actual = pq.poll().nombre;

            if (actual == fin) break;

            for (NodoAdyacente vecino : grafo.get(actual)) {
                int nuevaDistancia = distancias.get(actual) + vecino.peso;

                if (nuevaDistancia < distancias.get(vecino.nombre)) {
                    // Estilo "Agregada/Actualizada"
                    System.out.println("Actualizado: " + Character.toUpperCase(actual) + " - " + 
                                       Character.toUpperCase(vecino.nombre) + " (" + nuevaDistancia + ")");
                    distancias.put(vecino.nombre, nuevaDistancia);
                    predecesores.put(vecino.nombre, actual);
                    pq.add(new NodoAdyacente(vecino.nombre, nuevaDistancia));
                } else {
                    // Estilo "Descartada/Omitida"
                    System.out.println("Omitido (camino mayor): " + Character.toUpperCase(actual) + " - " + 
                                       Character.toUpperCase(vecino.nombre) + " (" + nuevaDistancia + ")");
                }
            }
        }

        imprimirResumenFinal(predecesores, distancias, inicio, fin);
    }

    private static void imprimirResumenFinal(Map<Character, Character> predecesores, Map<Character, Integer> distancias, char inicio, char fin) {
        System.out.println("\n--- Solución de Camino más Corto (" + Character.toUpperCase(inicio) + " a " + Character.toUpperCase(fin) + ") ---");
        
        if (distancias.get(fin) == Integer.MAX_VALUE) {
            System.out.println("No se encontró camino.");
            return;
        }

        List<String> pasosCamino = new ArrayList<>();
        char paso = fin;
        while (predecesores.containsKey(paso)) {
            char previo = predecesores.get(paso);
            // Buscamos el peso de la arista individual para el resumen
            pasosCamino.add(Character.toUpperCase(previo) + " - " + Character.toUpperCase(paso));
            paso = previo;
        }
        Collections.reverse(pasosCamino);

        for (String s : pasosCamino) {
            System.out.println(s);
        }

        System.out.println("Distancia total: " + distancias.get(fin));
    }

    public static void main(String[] args) {
        Map<Character, List<NodoAdyacente>> grafo = new HashMap<>();
        char[] nodos = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'z'};
        for (char n : nodos) grafo.put(n, new ArrayList<>());

        grafo.get('a').add(new NodoAdyacente('b', 16));
        grafo.get('a').add(new NodoAdyacente('c', 10));
        grafo.get('a').add(new NodoAdyacente('d', 5));
        grafo.get('b').add(new NodoAdyacente('c', 2));
        grafo.get('b').add(new NodoAdyacente('f', 4));
        grafo.get('b').add(new NodoAdyacente('g', 6));
        grafo.get('c').add(new NodoAdyacente('b', 2));
        grafo.get('c').add(new NodoAdyacente('d', 4));
        grafo.get('c').add(new NodoAdyacente('f', 12));
        grafo.get('c').add(new NodoAdyacente('e', 10));
        grafo.get('d').add(new NodoAdyacente('c', 4));
        grafo.get('d').add(new NodoAdyacente('e', 15));
        grafo.get('e').add(new NodoAdyacente('f', 3));
        grafo.get('e').add(new NodoAdyacente('z', 5));
        grafo.get('f').add(new NodoAdyacente('g', 8));
        grafo.get('f').add(new NodoAdyacente('e', 3));
        grafo.get('f').add(new NodoAdyacente('z', 16));
        grafo.get('g').add(new NodoAdyacente('z', 7));

        ejecutarDijkstra(grafo, 'a', 'z');
    }
}