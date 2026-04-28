/**
 * Estructura tipo ArrayList para Shell Sort
 * Necesita acceso por indice para trabajar con gaps
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
     * Shell Sort: mejora del Insertion Sort usando gaps (intervalos)
     * Comienza con gap grande y lo reduce gradualmente
     * La secuencia de gaps es: n/2, n/4, ..., 1
     */
    public void ordenarShell() {
        // Itera sobre diferentes tamanios de gap
        for (int gap = tamanio / 2; gap > 0; gap /= 2) {
            
            // Aplica Insertion Sort con el gap actual
            for (int i = gap; i < tamanio; i++) {
                int temp = elementos[i];
                int j;
                
                // Desplaza elementos ordenados con el gap
                for (j = i; j >= gap && elementos[j - gap] > temp; j -= gap) {
                    elementos[j] = elementos[j - gap];
                }
                
                elementos[j] = temp;
            }
        }
    }
}