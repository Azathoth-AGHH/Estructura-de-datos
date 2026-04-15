import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private String nombreUsuario;
    private LocalDate fechaPrestamo;

    public Prestamo(Libro libro, String nombreUsuario) {
        this.libro = libro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = LocalDate.now();
    }

    public Libro getLibro() { return libro; }
    public String getNombreUsuario() { return nombreUsuario; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
}