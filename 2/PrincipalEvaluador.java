import java.util.Scanner;

public class PrincipalEvaluador {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        EvaluadorPolaco evaluador = new EvaluadorPolaco();
        int opcion;

        do {
            System.out.println("\n--- EVALUADOR RPN (Pilas) ---");
            System.out.println("1. Evaluar expresión");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            if (opcion == 1) {
                System.out.print("Ingresa la expresión (ej. 3 4 +): ");
                String exp = leer.nextLine();
                try {
                    double res = evaluador.evaluar(exp);
                    System.out.println(">>> Resultado: " + res);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } while (opcion != 2);
        
        System.out.println("Programa finalizado.");
        leer.close();
    }
}