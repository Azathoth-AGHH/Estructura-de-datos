/**
 * Programa de prueba para Heap Sort
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        int[] datos = {12, 11, 13, 5, 6, 7};
        
        for (int dato : datos) {
            heap.insertar(dato);
        }
        
        System.out.print("Array original: ");
        heap.mostrar();
        
        heap.ordenarHeap();
        
        System.out.print("Array ordenado: ");
        heap.mostrar();
    }
}