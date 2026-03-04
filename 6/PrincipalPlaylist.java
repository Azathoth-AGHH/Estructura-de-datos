import java.util.Scanner;

public class PrincipalPlaylist {
    public static void main(String[] args) {
        PlaylistDinamica miPlaylist = new PlaylistDinamica();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- REPRODUCTOR CUUT ---");
            System.out.println("1. Agregar canción a la fila");
            System.out.println("2. Ver fila completa (Playlist)");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer para poder escribir texto después

            if (opcion == 1) {
                System.out.print("Escribe el nombre de la canción y artista: ");
                String nuevaCancion = sc.nextLine();
                miPlaylist.agregar(nuevaCancion);
            } else if (opcion == 2) {
                miPlaylist.mostrarFila();
            }

        } while (opcion != 3);

        System.out.println("Reproductor cerrado. ¡Nos vemos, Tlacua!");
        sc.close();
    }
}