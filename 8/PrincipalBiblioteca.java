import java.util.Scanner;

public class PrincipalBiblioteca {
    public static void main(String[] args) {
        Biblioteca sistema = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1. Prestar libro");
            System.out.println("2. Devolver libro");
            System.out.println("4. Ver préstamos de usuario");
            System.out.println("6. Libros populares");
            System.out.println("7. Registrarse");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch(opcion) {
                case 1:
                    System.out.print("ID Usuario: "); String id = sc.nextLine();
                    System.out.print("ISBN: "); String isbn = sc.nextLine();
                    sistema.prestarLibro(id, isbn);
                    break;
                case 2:
                    System.out.print("ID Usuario: "); String idD = sc.nextLine();
                    System.out.print("ISBN: "); String isbnD = sc.nextLine();
                    sistema.devolverLibro(idD, isbnD);
                    break;
                case 4:
                    System.out.print("ID Usuario: "); String idV = sc.nextLine();
                    sistema.verPrestamos(idV);
                    break;
                case 6:
                    sistema.mostrarPopulares();
                    break;
                case 7:
                    System.out.print("Tu ID: "); String nId = sc.nextLine();
                    System.out.print("Nombre: "); String nNom = sc.nextLine();
                    sistema.registrarUsuario(new Usuario(nId, nNom, "n/a", "n/a"));
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}