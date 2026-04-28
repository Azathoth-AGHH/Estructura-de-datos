/**
 * Lista enlazada con busqueda secuencial
 * Recorre elemento por elemento hasta encontrar el valor
 * Complejidad: O(n)
 */
public class ListaBusqueda {
    Nodo cabeza;
    
    public ListaBusqueda() {
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
     * Busqueda secuencial: recorre la lista secuencialmente
     * comparando cada elemento con el valor buscado
     * Retorna la posicion o -1 si no encuentra
     */
    public int buscar(int valor) {
        Nodo temp = cabeza;
        int posicion = 0;
        
        while (temp != null) {
            if (temp.dato == valor) {
                return posicion;
            }
            temp = temp.siguiente;
            posicion++;
        }
        
        return -1;  // No encontrado
    }
}