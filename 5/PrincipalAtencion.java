import java.util.Scanner;

public class PrincipalAtencion {
    public static void main(String[] args) {
        AtencionCliente sistema = new AtencionCliente();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU DE ATENCION ---");
            System.out.println("1. Recibir llamada");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver total en cola");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            if (opcion == 1) {
                System.out.print("Nombre del cliente: ");
                String nom = sc.nextLine();
                System.out.print("Motivo: ");
                String mot = sc.nextLine();
                sistema.registrarLlamada(nom, mot);
            } else if (opcion == 2) {
                sistema.atenderSiguiente();
            } else if (opcion == 3) {
                System.out.println("Clientes esperando: " + sistema.totalPendientes());
            }

        } while (opcion != 4);

        System.out.println("Sistema cerrado.");
        sc.close();
    }
}