/**
 * Lista enlazada simple con algoritmo Insertion Sort
 */
public class ListaEnlazada {
    Nodo cabeza;
    
    public ListaEnlazada() {
        this.cabeza = null;
    }
    
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
    
    public void mostrar() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
    
    /**
     * Insertion Sort: construye la lista ordenada insertando cada elemento 
     * en la posicion correcta. Comparable a ordenar cartas en la mano.
     * Complejidad: O(n²) peor caso, O(n) mejor caso
     */
    public void ordenarInsercion() {
        if (cabeza == null || cabeza.siguiente == null) return;
        
        Nodo actual = cabeza.siguiente;
        
        while (actual != null) {
            int valorActual = actual.dato;
            Nodo busqueda = cabeza;
            
            // Busca la posicion donde insertar el valor actual
            while (busqueda != actual && busqueda.dato <= valorActual) {
                busqueda = busqueda.siguiente;
            }
            
            // Desplaza los elementos para hacer espacio
            if (busqueda != actual) {
                int tempDato = busqueda.dato;
                busqueda.dato = valorActual;
                
                busqueda = busqueda.siguiente;
                while (busqueda != null && busqueda != actual.siguiente) {
                    int siguienteDato = busqueda.dato;
                    busqueda.dato = tempDato;
                    tempDato = siguienteDato;
                    busqueda = busqueda.siguiente;
                }
            }
            
            actual = actual.siguiente;
        }
    }
}