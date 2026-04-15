import java.io.*;
import java.util.*;

public class GestionBiblioteca {
    // Estructuras de datos solicitadas en el proyecto
    private LinkedList<Libro> listaLibros;       // Lista Enlazada
    private Queue<Prestamo> colaPrestamos;       // Cola (FIFO)
    private HashMap<String, Libro> mapaIsbn;     // HashMap para búsqueda rápida

    public GestionBiblioteca() {
        this.listaLibros = new LinkedList<>();
        this.colaPrestamos = new LinkedList<>(); 
        this.mapaIsbn = new HashMap<>();
    }

    // --- GESTIÓN DE LIBROS ---
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        mapaIsbn.put(libro.getIsbn(), libro);
    }

    public boolean eliminarLibro(String isbn) {
        Libro libro = mapaIsbn.get(isbn);
        if (libro != null) {
            listaLibros.remove(libro);
            mapaIsbn.remove(isbn);
            return true;
        }
        return false;
    }

    public Libro buscarPorIsbn(String isbn) {
        return mapaIsbn.get(isbn);
    }

    public List<Libro> buscarPorCriterio(String filtro) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro l : listaLibros) {
            if (l.getTitulo().toLowerCase().contains(filtro.toLowerCase()) || 
                l.getAutor().toLowerCase().contains(filtro.toLowerCase())) {
                resultados.add(l);
            }
        }
        return resultados;
    }

    // --- PRÉSTAMOS Y DEVOLUCIONES (Lógica de Cola) ---
    public String realizarPrestamo(String isbn, String usuario) {
        Libro libro = mapaIsbn.get(isbn);
        if (libro == null) return "Libro no encontrado.";
        
        if (libro.getEstado().equals("disponible")) {
            libro.setEstado("prestado");
            Prestamo nuevoPrestamo = new Prestamo(libro, usuario);
            colaPrestamos.add(nuevoPrestamo);
            return "Préstamo registrado.";
        }
        return "El libro ya está prestado.";
    }

    public String devolverLibro() {
        if (colaPrestamos.isEmpty()) return "No hay préstamos pendientes.";

        Prestamo prestamoActual = colaPrestamos.poll(); // Saca al primero (FIFO)
        Libro libro = prestamoActual.getLibro();
        libro.setEstado("disponible");
        
        return "Libro '" + libro.getTitulo() + "' devuelto por " + prestamoActual.getNombreUsuario();
    }

    // --- REPORTES (Uso de ArrayList y Archivos TXT) ---
    public void generarReporte(String nombreArchivo) {
        ArrayList<Libro> disponibles = new ArrayList<>();
        ArrayList<Libro> prestados = new ArrayList<>();

        for (Libro l : listaLibros) {
            if (l.getEstado().equals("disponible")) {
                disponibles.add(l);
            } else {
                prestados.add(l);
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("--- REPORTE DE BIBLIOTECA ---");
            writer.println("Fecha: " + java.time.LocalDate.now());
            
            writer.println("\nLIBROS DISPONIBLES:");
            for (Libro l : disponibles) writer.println(l.toString());

            writer.println("\nLIBROS PRESTADOS:");
            for (Libro l : prestados) writer.println(l.toString());
            
        } catch (IOException e) {
            System.err.println("Error al guardar el reporte: " + e.getMessage());
        }
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }
}