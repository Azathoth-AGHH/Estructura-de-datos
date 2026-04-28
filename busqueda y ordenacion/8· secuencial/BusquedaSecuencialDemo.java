/**
 * Programa de prueba para Busqueda Secuencial
 */
public class BusquedaSecuencialDemo {
    public static void main(String[] args) {
        ListaBusqueda lista = new ListaBusqueda();
        int[] datos = {10, 25, 30, 45, 50, 60, 75, 80};
        
        for (int dato : datos) {
            lista.insertar(dato);
        }
        
        System.out.print("Lista: ");
        lista.mostrar();
        
        int valorBuscado = 50;
        int posicion = lista.buscar(valorBuscado);
        
        if (posicion != -1) {
            System.out.println("Valor " + valorBuscado + " encontrado en posicion " + posicion);
        } else {
            System.out.println("Valor " + valorBuscado + " no encontrado");
        }
        
        valorBuscado = 55;
        posicion = lista.buscar(valorBuscado);
        
        if (posicion != -1) {
            System.out.println("Valor " + valorBuscado + " encontrado en posicion " + posicion);
        } else {
            System.out.println("Valor " + valorBuscado + " no encontrado");
        }
    }
}