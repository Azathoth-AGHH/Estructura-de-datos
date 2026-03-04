import java.util.Scanner;

public class PrincipalVerificador {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        VerificadorParentesis verificador = new VerificadorParentesis();
        int opcion;

        do {
            System.out.println("\n--- VERIFICADOR DE SÍMBOLOS ({[]}) ---");
            System.out.println("1. Validar expresión de código");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            if (opcion == 1) {
                System.out.println("Ingresa la línea de código a validar:");
                String codigo = leer.nextLine();

                if (verificador.esBalanceado(codigo)) {
                    System.out.println(">>> RESULTADO: La expresión es CORRECTA.");
                } else {
                    System.out.println(">>> RESULTADO: La expresión es INCORRECTA.");
                }
            }
        } while (opcion != 2);

        System.out.println("Programa finalizado.");
        leer.close();
    }
}