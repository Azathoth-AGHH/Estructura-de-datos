package com.biblioteca;

import java.time.LocalDate;

public class Prestamo {
    private final Libro libro;
    private final String nombreUsuario;
    private final LocalDate fechaPrestamo;

    public Prestamo(Libro libro, String nombreUsuario) {
        this.libro = libro;
        this.nombreUsuario = nombreUsuario;
        this.fechaPrestamo = LocalDate.now();
    }

    public Libro getLibro() { return libro; }
    public String getNombreUsuario() { return nombreUsuario; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
}