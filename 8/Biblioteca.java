import java.util.*;

class Libro {
    String isbn, titulo, autor, categoria;
    int anio, disponibles, prestadosContador;

    public Libro(String isbn, String titulo, String autor, int anio, String categoria, int disponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.categoria = categoria;
        this.disponibles = disponibles;
        this.prestadosContador = 0;
    }
}

class Usuario {
    String id, nombre, email, telefono;
    LinkedList<Libro> librosPrestados = new LinkedList<>();

    public Usuario(String id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
}

public class Biblioteca {
    ArrayList<Libro> catalogo = new ArrayList<>();
    LinkedList<Usuario> listaUsuarios = new LinkedList<>();

    // Constructor que carga los 15 libros automáticamente
    public Biblioteca() {
        catalogo.add(new Libro("101", "Clean Code", "Robert Martin", 2008, "Software", 5));
        catalogo.add(new Libro("102", "Java", "Deitel", 2020, "Programación", 3));
        catalogo.add(new Libro("103", "Estructuras de Datos", "Joyanes", 2015, "Computación", 4));
        catalogo.add(new Libro("104", "Cien años de soledad", "García Márquez", 1967, "Novela", 10));
        catalogo.add(new Libro("105", "Don Quijote", "Cervantes", 1605, "Clásico", 2));
        catalogo.add(new Libro("106", "El código Da Vinci", "Dan Brown", 2003, "Suspenso", 6));
        catalogo.add(new Libro("107", "El Principito", "Saint-Exupéry", 1943, "Infantil", 8));
        catalogo.add(new Libro("108", "1984", "George Orwell", 1949, "Distopía", 4));
        catalogo.add(new Libro("109", "El Hobbit", "J.R.R. Tolkien", 1937, "Fantasía", 12));
        catalogo.add(new Libro("110", "Orgullo y Prejuicio", "Jane Austen", 1813, "Romance", 3));
        catalogo.add(new Libro("111", "Crónica de una muerte", "García Márquez", 1981, "Novela", 7));
        catalogo.add(new Libro("112", "Rayuela", "Julio Cortázar", 1963, "Novela", 2));
        catalogo.add(new Libro("113", "Sapiens", "Harari", 2011, "Historia", 9));
        catalogo.add(new Libro("114", "La tregua", "Mario Benedetti", 1960, "Novela", 4));
        catalogo.add(new Libro("115", "Metamorfosis", "Kafka", 1915, "Clásico", 5));
    }

    public void registrarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public void prestarLibro(String idU, String isbn) {
        Usuario u = buscarUsuario(idU);
        Libro l = buscarLibro(isbn);

        if (u != null && l != null) {
            if (u.librosPrestados.size() >= 3) {
                System.out.println("Error: Límite de 3 libros alcanzado.");
            } else if (l.disponibles <= 0) {
                System.out.println("Error: No hay ejemplares disponibles.");
            } else {
                u.librosPrestados.add(l);
                l.disponibles--;
                l.prestadosContador++;
                System.out.println("Préstamo exitoso: " + l.titulo);
            }
        } else {
            System.out.println("Error: Usuario o Libro no encontrado.");
        }
    }

    public void devolverLibro(String idU, String isbn) {
        Usuario u = buscarUsuario(idU);
        if (u != null) {
            Libro encontrado = null;
            for (Libro l : u.librosPrestados) {
                if (l.isbn.equals(isbn)) {
                    encontrado = l;
                    break;
                }
            }
            if (encontrado != null) {
                u.librosPrestados.remove(encontrado);
                encontrado.disponibles++;
                System.out.println("Libro devuelto.");
            } else {
                System.out.println("El usuario no tiene ese libro.");
            }
        }
    }

    public void verPrestamos(String idU) {
        Usuario u = buscarUsuario(idU);
        if (u != null) {
            System.out.println("\nPréstamos de " + u.nombre + ":");
            for (Libro l : u.librosPrestados) {
                System.out.println("- " + l.titulo + " [" + l.isbn + "]");
            }
        }
    }

    public void mostrarPopulares() {
        System.out.println("\n--- MÁS POPULARES ---");
        catalogo.sort((a, b) -> Integer.compare(b.prestadosContador, a.prestadosContador));
        for (int i = 0; i < 5; i++) {
            System.out.println(catalogo.get(i).titulo + " (" + catalogo.get(i).prestadosContador + " préstamos)");
        }
    }

    private Usuario buscarUsuario(String id) {
        for (Usuario u : listaUsuarios) if (u.id.equals(id)) return u;
        return null;
    }

    private Libro buscarLibro(String isbn) {
        for (Libro l : catalogo) if (l.isbn.equals(isbn)) return l;
        return null;
    }
}