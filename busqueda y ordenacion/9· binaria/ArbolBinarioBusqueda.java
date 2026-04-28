/**
 * Arbol Binario de Busqueda: cada nodo tiene a la izquierda
 * valores menores y a la derecha valores mayores
 * La busqueda es O(log n) en arbol balanceado
 */
public class ArbolBinarioBusqueda {
    NodoABB raiz;
    
    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }
    
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }
    
    private NodoABB insertarRecursivo(NodoABB nodo, int dato) {
        if (nodo == null) {
            return new NodoABB(dato);
        }
        
        if (dato < nodo.dato) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        }
        // Si es igual, no inserta (sin duplicados)
        
        return nodo;
    }
    
    public void mostrarEnOrden() {
        inOrden(raiz);
        System.out.println();
    }
    
    private void inOrden(NodoABB nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.derecho);
        }
    }
    
    /**
     * Busqueda binaria en ABB: compara con el nodo actual
     * Si es menor busca en subarbol izquierdo
     * Si es mayor busca en subarbol derecho
     */
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(NodoABB nodo, int valor) {
        // Caso base: no encontrado
        if (nodo == null) {
            return false;
        }
        
        // Caso base: encontrado
        if (valor == nodo.dato) {
            return true;
        }
        
        // Busca en el subarbol correspondiente
        if (valor < nodo.dato) {
            return buscarRecursivo(nodo.izquierdo, valor);
        } else {
            return buscarRecursivo(nodo.derecho, valor);
        }
    }
}