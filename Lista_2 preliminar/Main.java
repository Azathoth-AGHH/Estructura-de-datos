public class Main {
    public static void main(String[] args) {
        
        ListaEnlazada lista = new ListaEnlazada();

        // Creamos la lista inicial del ejercicio
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(25);
        lista.insertarAlFinal(40);

        System.out.println("=== LISTA ORIGINAL ===");
        lista.imprimir();
        // lista.imprimirConPosiciones();   // descomenta si quieres ver posiciones

        System.out.println("\nInsertando 4 al inicio...\n");

        // Operación solicitada: insertar al inicio
        lista.insertarAlInicio(4);

        System.out.println("=== LISTA FINAL ===");
        lista.imprimir();
        // lista.imprimirConPosiciones();   // descomenta si quieres ver posiciones

        // Ejemplo adicional: insertar más elementos
        System.out.println("\nInsertando más elementos al inicio...");
        lista.insertarAlInicio(99);
        lista.insertarAlInicio(77);
        
        lista.imprimir();
    }
}