public class BusquedaBinaria {

    /**
     * Busca recursivamente en un arreglo ordenado.
     */
    public int buscar(int[] arreglo, int objetivo, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return -1;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        
        if (arreglo[medio] == objetivo) {
            return medio;
        }
        
        if (arreglo[medio] > objetivo) {
            return buscar(arreglo, objetivo, izquierda, medio - 1);
        } else {
            return buscar(arreglo, objetivo, medio + 1, derecha);
        }
    }
    
    /**
     * Versión simplificada: solo pasas arreglo y objetivo
     */
    public int buscar(int[] arreglo, int objetivo) {
        if (arreglo == null || arreglo.length == 0) {
            return -1;
        }
        return buscar(arreglo, objetivo, 0, arreglo.length - 1);
    }
}