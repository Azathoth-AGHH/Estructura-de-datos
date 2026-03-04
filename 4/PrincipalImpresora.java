import java.util.PriorityQueue;

// --- CLASE 1: El objeto que vamos a imprimir ---
class TrabajoImpresion implements Comparable<TrabajoImpresion> {
    String nombre;
    int prioridad; 
    int paginas;

    public TrabajoImpresion(String nombre, int prioridad, int paginas) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.paginas = paginas;
    }

    // Lógica de prioridad: el número menor (1) sale antes que el mayor (3)
    @Override
    public int compareTo(TrabajoImpresion otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }
}

// --- CLASE 2: La lógica del servidor ---
class ServidorDeImpresion {
    private PriorityQueue<TrabajoImpresion> cola = new PriorityQueue<>();

    public void agregar(String nom, int prio, int pags) {
        cola.add(new TrabajoImpresion(nom, prio, pags));
        System.out.println("Encolado: " + nom + " (Prioridad: " + prio + ")");
    }

    public void imprimirTodo() {
        System.out.println("\n--- INICIANDO COLA DE IMPRESIÓN ---");
        while (!cola.isEmpty()) {
            TrabajoImpresion t = cola.poll();
            System.out.println("IMPRIMIENDO: " + t.nombre + " | Prioridad: " + t.prioridad + " | Páginas: " + t.paginas);
        }
        System.out.println("--- FIN DEL PROCESO ---");
    }
}

// --- CLASE 3: La clase principal con el Main ---
public class PrincipalImpresora {
    public static void main(String[] args) {
        ServidorDeImpresion servidor = new ServidorDeImpresion();

        servidor.agregar("Reporte Ventas", 2, 5);
        servidor.agregar("CONTRATO URGENTE", 1, 2);
        servidor.agregar("Tesis", 3, 20);
        servidor.agregar("Acta de reunión", 2, 3);
        servidor.agregar("URGENTE: Cheque", 1, 1);

        // Ejecutar proceso
        servidor.imprimirTodo();
    }
}