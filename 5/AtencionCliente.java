import java.util.LinkedList;
import java.util.Queue;

// Clase para el objeto Llamada
class Llamada {
    String cliente;
    String motivo;

    public Llamada(String cliente, String motivo) {
        this.cliente = cliente;
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Motivo: " + motivo;
    }
}

// Clase para la lógica del sistema
public class AtencionCliente {
    // Usamos Queue para el comportamiento FIFO (Primero en entrar, primero en salir)
    private Queue<Llamada> cola = new LinkedList<>();

    public void registrarLlamada(String nombre, String razon) {
        cola.add(new Llamada(nombre, razon));
        System.out.println("Llamada de " + nombre + " puesta en espera.");
    }

    public void atenderSiguiente() {
        if (!cola.isEmpty()) {
            Llamada atendida = cola.poll();
            System.out.println("Atendiendo a: " + atendida);
        } else {
            System.out.println("No hay llamadas en espera.");
        }
    }

    public int totalPendientes() {
        return cola.size();
    }
}