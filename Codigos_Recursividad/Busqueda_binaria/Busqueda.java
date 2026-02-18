public class Busqueda{
    public int buscar(int[] arreglo, int inicio, int fin, int objetivo){// Método de búsqueda binaria recursiva
        if (inicio > fin) {// Si el índice de inicio es mayor que el índice de fin, significa que el elemento no se encontró
            return -1;// Si el índice de inicio es mayor que el índice de fin, significa que el elemento no se encontró
        }

        int medio = inicio + (fin - inicio) / 2;// Calcula el índice del elemento en el medio del arreglo
        if (arreglo[medio] == objetivo) {// Si el elemento en el medio es igual al objetivo, devuelve la posición
            return medio;// Si el elemento en el medio es igual al objetivo, devuelve la posición
        } else if (arreglo[medio] > objetivo) {// Si el elemento en el medio es mayor que el objetivo, busca en la mitad izquierda
            return buscar(arreglo, inicio, medio - 1, objetivo);// Busca en la mitad izquierda
        } else {// Si el elemento en el medio es menor que el objetivo, busca en la mitad derecha
            return buscar(arreglo, medio + 1, fin, objetivo);// Busca en la mitad derecha
        }
    }
}