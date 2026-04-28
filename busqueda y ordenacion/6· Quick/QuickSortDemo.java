/**
 * Programa de prueba para Quick Sort
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        ListaArray lista = new ListaArray(10);
        int[] datos = {10, 7, 8, 9, 1, 5};
        
        for (int dato : datos) {
            lista.insertar(dato);
        }
        
        System.out.print("Lista original: ");
        lista.mostrar();
        
        lista.ordenarQuick();
        
        System.out.print("Lista ordenada: ");
        lista.mostrar();
    }
}