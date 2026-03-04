import java.util.Scanner;
import java.util.Stack;

public class SistemaEditor {
    // Pilas para manejar las palabras 
    private Stack<String> pilaDeshacer = new Stack<>();
    private Stack<String> pilaRehacer = new Stack<>();
    private Scanner leer = new Scanner(System.in);

    public void ejecutar() {
        int opcion;
        do {
            System.out.println("\n--- EDITOR DE TEXTO (Pilas) ---");
            mostrarTexto();
            System.out.println("1. Escribir palabra");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Escribe la palabra: ");
                    String palabra = leer.nextLine();
                    escribir(palabra);
                    break;
                case 2:
                    deshacer();
                    break;
                case 3:
                    rehacer();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void escribir(String palabra) {
        pilaDeshacer.push(palabra);
        pilaRehacer.clear(); // Al escribir algo nuevo, se limpia la opción de rehacer 
    }

    private void deshacer() {
        if (!pilaDeshacer.isEmpty()) {
            pilaRehacer.push(pilaDeshacer.pop());
        } else {
            System.out.println("No hay nada para deshacer.");
        }
    }

    private void rehacer() {
        if (!pilaRehacer.isEmpty()) {
            pilaDeshacer.push(pilaRehacer.pop());
        } else {
            System.out.println("No hay nada para rehacer.");
        }
    }

    private void mostrarTexto() {
        System.out.print("CONTENIDO ACTUAL: ");
        if (pilaDeshacer.isEmpty()) {
            System.out.println("[Vacío]");
        } else {
            // Mostramos el contenido de la pila como una frase
            for (String s : pilaDeshacer) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejecutamos el sistema 
        SistemaEditor editor = new SistemaEditor();
        editor.ejecutar();
    }
}