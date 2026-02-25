import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Paciente {
    private String nombre;
    private int turno;
    private String horaRegistro;

    public Paciente(String nombre, int turno) {
        this.nombre = nombre;
        this.turno = turno;
        // Formato de hora profesional
        this.horaRegistro = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    // Getters para la impresión profesional
    public String getNombre() { return nombre; }
    public int getTurno() { return turno; }
    public String getHoraRegistro() { return horaRegistro; }
}