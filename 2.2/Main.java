import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("--- Configuración del Árbol ---");
        System.out.print("¿Cual es la profundidad maxima deseada?: ");
        int profMax = sc.nextInt();
        
        int maxNodos = (int) Math.pow(2, profMax) - 1;
        System.out.println("Puedes ingresar hasta " + maxNodos + " nodos.");

        for (int i = 0; i < maxNodos; i++) {
            System.out.print("Valor nodo " + (i + 1) + " (o 0 para terminar): ");
            int valor = sc.nextInt();
            if (valor == 0) break; 
            arbol.insertar(valor);
        }

        String opcion = "";
        // El bucle sigue activo para permitir múltiples consultas
        while (true) {
            System.out.print("\n(1:Pre, 2:In, 3:Post) o 't' para salir: ");
            opcion = sc.next();

            if (opcion.equalsIgnoreCase("t")) {
                System.out.println("Programa finalizado.");
                break;
            }

            System.out.print("Resultado: ");
            switch (opcion) {
                case "1" -> arbol.preorden(arbol.raiz);
                case "2" -> arbol.inorden(arbol.raiz);
                case "3" -> arbol.postorden(arbol.raiz);
                default -> System.out.print("Opcion no reconocida.");
            }
            System.out.println(); 
        }
        sc.close();
    }
}