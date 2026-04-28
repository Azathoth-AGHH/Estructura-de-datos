/**
 * Lista enlazada simple con algoritmo Bubble Sort
 */
public class ListaEnlazada {
    Nodo cabeza;
    
    public ListaEnlazada() {
        this.cabeza = null;
    }
    
    // Inserta al final de la lista
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevo;
    }
    
    // Muestra los elementos de la lista
    public void mostrar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
    
    /**
     * Bubble Sort: compara pares adyacentes y los intercambia si estan desordenados
     * Repite hasta que no haya intercambios
     * Complejidad: O(n²)
     */
    public void ordenarBurbuja() {
        if (cabeza == null || cabeza.siguiente == null) return;
        
        boolean intercambiado;
        do {
            intercambiado = false;
            Nodo actual = cabeza;
            Nodo anterior = null;
            Nodo siguiente = cabeza.siguiente;
            
            // Recorre la lista comparando pares adyacentes
            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    // Intercambia los nodos
                    intercambiado = true;
                    if (anterior != null) {
                        anterior.siguiente = siguiente;
                    } else {
                        cabeza = siguiente;
                    }
                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;
                    
                    anterior = siguiente;
                    siguiente = actual.siguiente;
                } else {
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.siguiente;
                }
            }
        } while (intercambiado);
    }
}