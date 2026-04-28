/**
 * Programa de prueba para Selection Sort
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        int[] datos = {64, 25, 12, 22, 11};
        
        for (int dato : datos) {
            lista.insertar(dato);
        }
        
        System.out.print("Lista original: ");
        lista.mostrar();
        
        lista.ordenarSeleccion();
        
        System.out.print("Lista ordenada: ");
        lista.mostrar();
    }
}