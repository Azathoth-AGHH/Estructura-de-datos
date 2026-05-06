package com.biblioteca;

import java.io.Serializable;

public class Libro implements Serializable {
    private final String titulo;
    private final String autor;
    private final int anioPublicacion;
    private final String isbn;
    private String estado; // "disponible" o "prestado"

    public Libro(String titulo, String autor, int anioPublicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.estado = "disponible"; // Estado inicial por defecto [cite: 21, 37]
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo; 
        }
    public String getAutor() {
         return autor; 
        }
    public int getAnioPublicacion() {
        return anioPublicacion;
        }
    public String getIsbn() { 
        return isbn; 
        }
    public String getEstado() { 
        return estado; 
        }
    public void setEstado(String estado) {
        this.estado = estado; 
        }

    @Override
    public String toString() {
        return String.format("ISBN: %s | Título: %s | Autor: %s | Año: %d | Estado: %s", 
                isbn, titulo, autor, anioPublicacion, estado);
    }
}