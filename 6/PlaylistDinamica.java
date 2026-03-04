import java.util.LinkedList;

public class PlaylistDinamica {
    // Usamos la librería LinkedList como pide el ejercicio 
    private LinkedList<String> lista = new LinkedList<>();

    // Constructor que mete las primeras 3 canciones de cajón
    public PlaylistDinamica() {
        lista.add("Life Eternal - Ghost");
        lista.add("Cum on Feel the Noize - Quiet Riot");
        lista.add("Hardstyle Warriors - Mix");
    }

    // Método para que el usuario agregue más
    public void agregar(String cancion) {
        lista.add(cancion);
        System.out.println(">>> \"" + cancion + "\" agregada a la fila.");
    }

    // Método para ver todas las canciones (la fila)
    public void mostrarFila() {
        System.out.println("\n--- FILA DE REPRODUCCIÓN ACTUAL ---");
        if (lista.isEmpty()) {
            System.out.println("La fila está vacía.");
        } else {
            int i = 1;
            for (String cancion : lista) {
                System.out.println(i + ". " + cancion);
                i++;
            }
        }
        System.out.println("-----------------------------------");
    }
}