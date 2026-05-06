package com.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GestionBiblioteca {

    private static GestionBiblioteca instancia;

    // Estructuras de datos solicitadas en el proyecto
    private final LinkedList<Libro> listaLibros;       // Lista Enlazada
    private final Queue<Prestamo> colaPrestamos;       // Cola (FIFO)
    private final HashMap<String, Libro> mapaIsbn;     // HashMap para búsqueda rápida

    private final String ARCHIVO_DATOS    = "libros.txt";
    private final String ARCHIVO_PRESTAMOS = "prestamos.txt";

    // Directorio donde se guardan las portadas (junto al jar / directorio de ejecución)
    public static final String DIR_PORTADAS = "portadas";

    // Constructor privado
    private GestionBiblioteca() {
        this.listaLibros   = new LinkedList<>();
        this.colaPrestamos = new LinkedList<>();
        this.mapaIsbn      = new HashMap<>();
        new File(DIR_PORTADAS).mkdirs(); // Crea el directorio si no existe
        cargarDesdeArchivo();
        cargarPrestamos();
    }

    // Método público para obtener la instancia (Singleton)
    public static GestionBiblioteca getInstancia() {
        if (instancia == null) {
            instancia = new GestionBiblioteca();
        }
        return instancia;
    }

    // --- GESTIÓN DE LIBROS ---
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        mapaIsbn.put(libro.getIsbn(), libro);
        guardarEnArchivo();
    }

    public boolean eliminarLibro(String isbn) {
        Libro libro = mapaIsbn.get(isbn);
        if (libro != null) {
            listaLibros.remove(libro);
            mapaIsbn.remove(isbn);
            guardarEnArchivo();
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
                l.getAutor().toLowerCase().contains(filtro.toLowerCase()) ||
                l.getIsbn().toLowerCase().contains(filtro.toLowerCase())) {
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
            guardarEnArchivo();
            guardarPrestamos();
            return "Préstamo registrado.";
        }
        return "El libro ya está prestado.";
    }

    public String devolverLibro() {
        if (colaPrestamos.isEmpty()) return "No hay préstamos pendientes.";

        Prestamo prestamoActual = colaPrestamos.poll(); // Saca al primero (FIFO)
        Libro libro = prestamoActual.getLibro();
        libro.setEstado("disponible");
        guardarEnArchivo();
        guardarPrestamos();

        return "Libro '" + libro.getTitulo() + "' devuelto por " + prestamoActual.getNombreUsuario();
    }

    // --- REPORTES (Uso de ArrayList y Archivos TXT) ---
    public void generarReporte(String nombreArchivo) {
        ArrayList<Libro> disponibles = new ArrayList<>();
        ArrayList<Libro> prestados   = new ArrayList<>();

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
            writer.println("Total libros: " + listaLibros.size());

            writer.println("\nLIBROS DISPONIBLES (" + disponibles.size() + "):");
            for (Libro l : disponibles) writer.println("  " + l.toString());

            writer.println("\nLIBROS PRESTADOS (" + prestados.size() + "):");
            for (Libro l : prestados) writer.println("  " + l.toString());

            writer.println("\nPRÉSTAMOS EN COLA (" + colaPrestamos.size() + "):");
            for (Prestamo p : colaPrestamos) {
                writer.println("  ISBN: " + p.getLibro().getIsbn()
                    + " | Título: " + p.getLibro().getTitulo()
                    + " | Usuario: " + p.getNombreUsuario()
                    + " | Fecha: " + p.getFechaPrestamo());
            }

        } catch (IOException e) {
            System.err.println("Error al guardar el reporte: " + e.getMessage());
        }
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public Queue<Prestamo> getColaPrestamos() {
        return colaPrestamos;
    }

    // --- IMAGEN DE PORTADA ---
    /**
     * Guarda la imagen de portada en el directorio persistente "portadas/"
     * junto al ejecutable. Devuelve true si tuvo éxito.
     */
    public boolean guardarPortada(File archivoOrigen, String isbn) {
        try {
            new File(DIR_PORTADAS).mkdirs();
            String extension = archivoOrigen.getName().toLowerCase().endsWith(".jpg") ? ".jpg" : ".png";
            Path destino = Paths.get(DIR_PORTADAS, isbn + extension);
            Files.copy(archivoOrigen.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar portada: " + e.getMessage());
            return false;
        }
    }

    /**
     * Devuelve la ruta de la portada de un libro si existe, o null.
     */
    public String getRutaPortada(String isbn) {
        for (String ext : new String[]{".png", ".jpg", ".jpeg"}) {
            File f = new File(DIR_PORTADAS + File.separator + isbn + ext);
            if (f.exists()) return f.toURI().toString();
        }
        return null;
    }

    // --- PERSISTENCIA ---
    public void guardarEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_DATOS))) {
            for (Libro l : listaLibros) {
                // Guardamos: ISBN,Título,Autor,Año,Estado
                writer.println(l.getIsbn() + "," +
                               l.getTitulo() + "," +
                               l.getAutor() + "," +
                               l.getAnioPublicacion() + "," +
                               l.getEstado());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar en TXT: " + e.getMessage());
        }
    }

    public void cargarDesdeArchivo() {
        File archivo = new File(ARCHIVO_DATOS);
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            listaLibros.clear();
            mapaIsbn.clear();
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",", 5); // limit=5 para tolerar comas en título/autor
                if (datos.length == 5) {
                    Libro libro = new Libro(datos[1], datos[2], Integer.parseInt(datos[3].trim()), datos[0]);
                    libro.setEstado(datos[4]);
                    listaLibros.add(libro);
                    mapaIsbn.put(libro.getIsbn(), libro);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }

    /** Persiste la cola de préstamos en un archivo separado */
    public void guardarPrestamos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_PRESTAMOS))) {
            for (Prestamo p : colaPrestamos) {
                writer.println(p.getLibro().getIsbn() + "," +
                               p.getNombreUsuario() + "," +
                               p.getFechaPrestamo());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar préstamos: " + e.getMessage());
        }
    }

    /** Carga la cola de préstamos desde archivo (se llama después de cargar libros) */
    public void cargarPrestamos() {
        File archivo = new File(ARCHIVO_PRESTAMOS);
        if (!archivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            colaPrestamos.clear();
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",", 3);
                if (datos.length >= 2) {
                    Libro libro = mapaIsbn.get(datos[0]);
                    if (libro != null) {
                        Prestamo p = new Prestamo(libro, datos[1]);
                        colaPrestamos.add(p);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar préstamos: " + e.getMessage());
        }
    }

    public void conmutarEstadoLibro(String isbn, String usuario) {
        Libro libro = mapaIsbn.get(isbn); // Usa tu HashMap para buscar rápido

        if (libro != null) {
            if (libro.getEstado().equalsIgnoreCase("disponible")) {
                libro.setEstado("prestado");
                colaPrestamos.add(new Prestamo(libro, usuario));
            } else {
                libro.setEstado("disponible");
                // Quitar de la cola el préstamo correspondiente
                colaPrestamos.removeIf(p -> p.getLibro().getIsbn().equals(isbn));
            }
            guardarEnArchivo();  // Actualiza el TXT
            guardarPrestamos();  // Actualiza la cola
        }
    }
}
