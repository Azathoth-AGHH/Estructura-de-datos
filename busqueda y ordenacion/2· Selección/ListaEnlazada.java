/**
 * Lista enlazada simple con algoritmo Selection Sort
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
     * Selection Sort: busca el minimo en la parte no ordenada y lo coloca al inicio
     * Intercambia solo los valores, no los nodos completos
     * Complejidad: O(n²)
     */
    public void ordenarSeleccion() {
        Nodo actual = cabeza;
        
        while (actual != null) {
            // Busca el nodo con el valor minimo desde la posicion actual
            Nodo minimo = actual;
            Nodo temp = actual.siguiente;
            
            while (temp != null) {
                if (temp.dato < minimo.dato) {
                    minimo = temp;
                }
                temp = temp.siguiente;
            }
            
            // Intercambia los valores si encontro un minimo diferente
            if (minimo != actual) {
                int tempDato = actual.dato;
                actual.dato = minimo.dato;
                minimo.dato = tempDato;
            }
            
            actual = actual.siguiente;
        }
    }
}