import java.util.LinkedList;

public class HistorialNavegacion {
    private LinkedList<String> paginas = new LinkedList<>();
    private int indiceActual = -1;

    // Método para visitar una nueva página
    public void visitarPagina(String url) {
        // Si estamos en medio del historial e ingresamos una nueva URL, eliminamos lo que sigue
        while (paginas.size() > indiceActual + 1) {
            paginas.removeLast();
        }
        paginas.add(url);
        indiceActual++;
        System.out.println("Visitando: " + url);
    }

    // Método para retroceder en el historial
    public void retroceder() {
        if (indiceActual > 0) {
            indiceActual--;
            System.out.println("Retrocediste a: " + paginas.get(indiceActual));
        } else {
            System.out.println("No hay más páginas atrás en el historial.");
        }
    }

    // Método para avanzar en el historial
    public void avanzar() {
        if (indiceActual < paginas.size() - 1) {
            indiceActual++;
            System.out.println("Avanzaste a: " + paginas.get(indiceActual));
        } else {
            System.out.println("No hay más páginas adelante.");
        }
    }

    public void mostrarEstado() {
        System.out.println("\n--- ESTADO DEL HISTORIAL ---");
        for (int i = 0; i < paginas.size(); i++) {
            if (i == indiceActual) {
                System.out.println("[" + paginas.get(i) + "] <--- Estás aquí");
            } else {
                System.out.println(" " + paginas.get(i));
            }
        }
        System.out.println("----------------------------");
    }
}