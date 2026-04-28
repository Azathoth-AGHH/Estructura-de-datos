/**
 * Lista enlazada simple con algoritmo Merge Sort
 * Algoritmo de division y conquista: divide, ordena recursivamente y mezcla
 * Complejidad: O(n log n)
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
    
    // Metodo publico que inicia el ordenamiento
    public void ordenarMerge() {
        cabeza = mergeSort(cabeza);
    }
    
    // Divide la lista recursivamente hasta tener elementos individuales
    private Nodo mergeSort(Nodo inicio) {
        // Caso base: lista vacia o con un elemento
        if (inicio == null || inicio.siguiente == null) {
            return inicio;
        }
        
        // Encuentra el punto medio con la tecnica de dos punteros
        Nodo medio = encontrarMedio(inicio);
        Nodo mitadDerecha = medio.siguiente;
        medio.siguiente = null;  // Divide la lista en dos
        
        // Ordena recursivamente cada mitad
        Nodo izquierda = mergeSort(inicio);
        Nodo derecha = mergeSort(mitadDerecha);
        
        // Mezcla las dos mitades ordenadas
        return mezclar(izquierda, derecha);
    }
    
    // Encuentra el nodo medio usando puntero lento y rapido
    private Nodo encontrarMedio(Nodo inicio) {
        if (inicio == null) return null;
        
        Nodo lento = inicio;
        Nodo rapido = inicio.siguiente;
        
        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
        }
        
        return lento;
    }
    
    // Mezcla dos listas ordenadas en una sola lista ordenada
    private Nodo mezclar(Nodo izquierda, Nodo derecha) {
        // Casos base
        if (izquierda == null) return derecha;
        if (derecha == null) return izquierda;
        
        Nodo resultado;
        
        // Compara los primeros elementos de cada lista
        if (izquierda.dato <= derecha.dato) {
            resultado = izquierda;
            resultado.siguiente = mezclar(izquierda.siguiente, derecha);
        } else {
            resultado = derecha;
            resultado.siguiente = mezclar(izquierda, derecha.siguiente);
        }
        
        return resultado;
    }
}