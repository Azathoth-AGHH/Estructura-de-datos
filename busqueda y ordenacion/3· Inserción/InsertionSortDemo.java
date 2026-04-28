/**
 * Programa de prueba para Insertion Sort
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        int[] datos = {12, 11, 13, 5, 6};
        
        for (int dato : datos) {
            lista.insertar(dato);
        }
        
        System.out.print("Lista original: ");
        lista.mostrar();
        
        lista.ordenarInsercion();
        
        System.out.print("Lista ordenada: ");
        lista.mostrar();
    }
}