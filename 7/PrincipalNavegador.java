import java.util.Scanner;

public class PrincipalNavegador {
    public static void main(String[] args) {
        HistorialNavegacion navegador = new HistorialNavegacion();
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Páginas iniciales de ejemplo
        navegador.visitarPagina("google.com");
        navegador.visitarPagina("github.com");
        navegador.visitarPagina("youtube.com");

        do {
            System.out.println("\n--- NAVEGADOR WEB ---");
            System.out.println("1. Visitar nueva URL");
            System.out.println("2. Retroceder");
            System.out.println("3. Avanzar");
            System.out.println("4. Ver historial completo");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la URL: ");
                    String url = sc.nextLine();
                    navegador.visitarPagina(url);
                    break;
                case 2:
                    navegador.retroceder();
                    break;
                case 3:
                    navegador.avanzar();
                    break;
                case 4:
                    navegador.mostrarEstado();
                    break;
            }
        } while (opcion != 5);

        System.out.println("Cerrando navegador.");
        sc.close();
    }
}