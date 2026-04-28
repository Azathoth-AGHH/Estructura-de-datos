/**
 * Programa de prueba para Bubble Sort
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        int[] datos = {64, 34, 25, 12, 22, 11, 90};
        
        for (int dato : datos) {
            lista.insertar(dato);
        }
        
        System.out.print("Lista original: ");
        lista.mostrar();
        
        lista.ordenarBurbuja();
        
        System.out.print("Lista ordenada: ");
        lista.mostrar();
    }
}