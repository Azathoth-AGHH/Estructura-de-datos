import java.util.LinkedList;
import java.util.Queue;

public class GestionHospital {
    private Queue<Paciente> colaPacientes;
    private int contadorTurnos;

    public GestionHospital() {
        this.colaPacientes = new LinkedList<>();
        this.contadorTurnos = 1;
    }

    public Paciente registrarPaciente(String nombre) {
        Paciente nuevo = new Paciente(nombre, contadorTurnos++);
        colaPacientes.add(nuevo);
        return nuevo;
    }

    public Paciente llamarSiguiente() {
        return colaPacientes.poll(); // Saca al primero en la fila
    }

    public boolean hayPacientes() {
        return !colaPacientes.isEmpty();
    }
}