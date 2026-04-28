/**
 * Programa de prueba para Busqueda Hash
 */
public class BusquedaHashDemo {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash(7);
        
        // Inserciones
        tabla.insertar(10, "Juan");
        tabla.insertar(20, "Maria");
        tabla.insertar(15, "Pedro");
        tabla.insertar(7, "Ana");
        tabla.insertar(17, "Luisa");  // Colision con 10
        tabla.insertar(31, "Diego");  // Colision con 10 y 17
        
        System.out.println("Tabla Hash completa:");
        tabla.mostrar();
        
        // Busquedas
        System.out.println("\nBusquedas:");
        String resultado = tabla.buscar(17);
        System.out.println("Buscar clave 17: " + (resultado != null ? resultado : "No encontrado"));
        
        resultado = tabla.buscar(7);
        System.out.println("Buscar clave 7: " + (resultado != null ? resultado : "No encontrado"));
        
        resultado = tabla.buscar(99);
        System.out.println("Buscar clave 99: " + (resultado != null ? resultado : "No encontrado"));
    }
}