/**
 * Estructura tipo ArrayList para Quick Sort
 * Necesita acceso aleatorio para el particionado
 */
public class ListaArray {
    private int[] elementos;
    private int tamanio;
    
    public ListaArray(int capacidad) {
        this.elementos = new int[capacidad];
        this.tamanio = 0;
    }
    
    public void insertar(int dato) {
        if (tamanio < elementos.length) {
            elementos[tamanio] = dato;
            tamanio++;
        }
    }
    
    public void mostrar() {
        for (int i = 0; i < tamanio; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Quick Sort: elige un pivote, particiona el array en elementos
     * menores y mayores al pivote, y ordena recursivamente las particiones
     * Complejidad promedio: O(n log n)
     */
    public void ordenarQuick() {
        quickSort(0, tamanio - 1);
    }
    
    private void quickSort(int bajo, int alto) {
        if (bajo < alto) {
            // Particiona y obtiene el indice del pivote
            int indicePivote = particionar(bajo, alto);
            
            // Ordena recursivamente las sublistas
            quickSort(bajo, indicePivote - 1);
            quickSort(indicePivote + 1, alto);
        }
    }
    
    /**
     * Reorganiza el subarray colocando el pivote en su posicion correcta
     * Elementos menores al pivote a la izquierda
     * Elementos mayores al pivote a la derecha
     */
    private int particionar(int bajo, int alto) {
        int pivote = elementos[alto];  // Ultimo elemento como pivote
        int i = bajo - 1;  // Indice del ultimo elemento menor que el pivote
        
        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (elementos[j] <= pivote) {
                i++;
                // Intercambia elementos[i] con elementos[j]
                int temp = elementos[i];
                elementos[i] = elementos[j];
                elementos[j] = temp;
            }
        }
        
        // Coloca el pivote en su posicion correcta
        int temp = elementos[i + 1];
        elementos[i + 1] = elementos[alto];
        elementos[alto] = temp;
        
        return i + 1;
    }
}