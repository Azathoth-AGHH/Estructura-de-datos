/**
 * Programa de prueba para Busqueda Binaria en ABB
 */
public class BusquedaBinariaDemo {
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        int[] datos = {50, 30, 70, 20, 40, 60, 80};
        
        for (int dato : datos) {
            abb.insertar(dato);
        }
        
        System.out.print("Arbol en orden: ");
        abb.mostrarEnOrden();
        
        int valorBuscado = 40;
        if (abb.buscar(valorBuscado)) {
            System.out.println("Valor " + valorBuscado + " encontrado");
        } else {
            System.out.println("Valor " + valorBuscado + " no encontrado");
        }
        
        valorBuscado = 55;
        if (abb.buscar(valorBuscado)) {
            System.out.println("Valor " + valorBuscado + " encontrado");
        } else {
            System.out.println("Valor " + valorBuscado + " no encontrado");
        }
    }
}