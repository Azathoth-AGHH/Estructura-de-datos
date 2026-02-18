import java.util.Scanner;

/**
 * Programa que pide números al usuario para calcular su factorial.
 * - Escribe "s" o "S" para salir
 * - Si es número negativo → mensaje claro
 * - Si no es número válido → pide de nuevo
 */
public class Principal {

    public static void main(String[] args) {
        
        FactorialRecursivo fact = new FactorialRecursivo();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=====================================");
        System.out.println("   CALCULADORA DE FACTORIAL RECURSIVO");
        System.out.println("=====================================");
        System.out.println("Ingresa un número para calcular su factorial");
        System.out.println("Escribe 's' o 'S' para salir del programa");
        System.out.println("-------------------------------------\n");
        
        while (true) {
            System.out.print("Número o 's' para salir: ");
            String entrada = scanner.nextLine().trim();  // leemos toda la línea
            
            // Verificamos si quiere salir
            if (entrada.equalsIgnoreCase("s")) {
                System.out.println("\n¡Gracias por usar el programa! Hasta luego.");
                break;
            }
            
            // Intentamos convertir a número entero
            try {
                int numero = Integer.parseInt(entrada);
                
                // Calculamos
                long resultado = fact.calcular(numero);
                
                // Mostramos resultado
                System.out.println(numero + "! = " + resultado);
                
                // Advertencia para números grandes (long se desborda después de 20!)
                if (numero >= 20) {
                    System.out.println("Nota: para números > 20 el resultado puede no ser exacto (límite de long)");
                }
                
            } catch (NumberFormatException e) {
                // No es un número válido
                System.out.println("¡Error! Ingresa un número entero válido o 's' para salir.");
                
            } catch (IllegalArgumentException e) {
                // Es negativo (capturamos el mensaje del método calcular)
                System.out.println("¡Error! " + e.getMessage());
            }
            
            System.out.println("-------------------------------------\n");
        }
        
        scanner.close();
    }
}