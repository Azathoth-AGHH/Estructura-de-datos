/**
 * MaxHeap: arbol binario completo donde cada padre es mayor que sus hijos
 * Se implementa con un array para eficiencia
 * Para un nodo en indice i:
 *   - Padre: (i-1)/2
 *   - Hijo izquierdo: 2*i+1
 *   - Hijo derecho: 2*i+2
 */
public class MaxHeap {
    private int[] heap;
    private int tamanio;
    
    public MaxHeap(int capacidad) {
        this.heap = new int[capacidad];
        this.tamanio = 0;
    }
    
    public void insertar(int valor) {
        if (tamanio < heap.length) {
            heap[tamanio] = valor;
            tamanio++;
        }
    }
    
    public void mostrar() {
        for (int i = 0; i < tamanio; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Heap Sort: construye un maxHeap y extrae el maximo repetidamente
     * Complejidad: O(n log n)
     */
    public void ordenarHeap() {
        // Construye el maxHeap desde el ultimo nodo no hoja
        for (int i = tamanio / 2 - 1; i >= 0; i--) {
            heapifyAbajo(i, tamanio);
        }
        
        // Extrae elementos uno por uno del heap
        for (int i = tamanio - 1; i > 0; i--) {
            // Mueve la raiz (maximo) al final
            intercambiar(0, i);
            
            // Restaura la propiedad de heap en el heap reducido
            heapifyAbajo(0, i);
        }
    }
    
    // Restaura la propiedad de heap hacia abajo
    private void heapifyAbajo(int indice, int tamanioHeap) {
        int mayor = indice;
        int izquierdo = 2 * indice + 1;
        int derecho = 2 * indice + 2;
        
        // Compara con el hijo izquierdo
        if (izquierdo < tamanioHeap && heap[izquierdo] > heap[mayor]) {
            mayor = izquierdo;
        }
        
        // Compara con el hijo derecho
        if (derecho < tamanioHeap && heap[derecho] > heap[mayor]) {
            mayor = derecho;
        }
        
        // Si el mayor no es el padre, intercambia y continua
        if (mayor != indice) {
            intercambiar(indice, mayor);
            heapifyAbajo(mayor, tamanioHeap);
        }
    }
    
    private void intercambiar(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}