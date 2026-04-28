/**
 * Programa de prueba para Merge Sort
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        int[] datos = {38, 27, 43, 3, 9, 82, 10};
        
        for (int dato : datos) {
            lista.insertar(dato);
        }
        
        System.out.print("Lista original: ");
        lista.mostrar();
        
        lista.ordenarMerge();
        
        System.out.print("Lista ordenada: ");
        lista.mostrar();
    }
}