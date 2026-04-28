/**
 * Programa de prueba para Shell Sort
 */
public class ShellSortDemo {
    public static void main(String[] args) {
        ListaArray lista = new ListaArray(10);
        int[] datos = {35, 33, 42, 10, 14, 19, 27, 44};
        
        for (int dato : datos) {
            lista.insertar(dato);
        }
        
        System.out.print("Lista original: ");
        lista.mostrar();
        
        lista.ordenarShell();
        
        System.out.print("Lista ordenada: ");
        lista.mostrar();
    }
}