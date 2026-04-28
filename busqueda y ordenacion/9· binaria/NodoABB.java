/**
 * Nodo para Arbol Binario de Busqueda
 * Hijo izquierdo: valores menores
 * Hijo derecho: valores mayores
 */
public class NodoABB {
    int dato;
    NodoABB izquierdo;
    NodoABB derecho;
    
    public NodoABB(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}