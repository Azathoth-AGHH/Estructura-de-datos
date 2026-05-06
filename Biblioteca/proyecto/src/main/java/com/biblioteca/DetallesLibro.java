package com.biblioteca;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DetallesLibro {

    @FXML private Label lblIsbn, lblTitulo, lblAutor, lblAnio, lblEstado;
    @FXML private Button btnAccion;
    @FXML private ImageView imgPortada;

    private Libro libroActual;

    /**
     * Inicializa los datos del libro en la pantalla.
     * Llamar siempre DESPUÉS de setLibro() o junto con él.
     */
    public void initData(Libro libro) {
        this.libroActual = libro;

        lblIsbn.setText(libro.getIsbn());
        lblTitulo.setText(libro.getTitulo());
        lblAutor.setText(libro.getAutor());
        lblAnio.setText(String.valueOf(libro.getAnioPublicacion()));
        lblEstado.setText(libro.getEstado().substring(0, 1).toUpperCase() + libro.getEstado().substring(1));

        boolean disponible = "disponible".equals(libro.getEstado());
        lblEstado.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: " + (disponible ? "#27ae60" : "#e74c3c") + ";");

        // Cargar imagen de portada
        if (imgPortada != null) {
            cargarPortada(libro.getIsbn());
        }

        actualizarInterfazBoton();
    }

    private void cargarPortada(String isbn) {
        // 1. Directorio externo persistente (portadas/)
        String rutaExterna = GestionBiblioteca.getInstancia().getRutaPortada(isbn);
        if (rutaExterna != null) {
            try {
                Image imagen = new Image(rutaExterna);
                if (!imagen.isError()) {
                    imgPortada.setImage(imagen);
                    return;
                }
            } catch (Exception ignored) { }
        }
        // 2. Fallback: recursos empaquetados
        try {
            var stream = getClass().getResourceAsStream("/com/biblioteca/portadas/" + isbn + ".png");
            if (stream != null) {
                Image imagen = new Image(stream);
                if (!imagen.isError()) imgPortada.setImage(imagen);
            }
        } catch (Exception ignored) { }
    }

    public void setLibro(Libro libro) {
        this.libroActual = libro;
        actualizarInterfazBoton();
    }

    private void actualizarInterfazBoton() {
        if (libroActual == null || btnAccion == null) return;
        if (libroActual.getEstado().equals("disponible")) {
            btnAccion.setText("Prestar");
            btnAccion.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;");
        } else {
            btnAccion.setText("Devolver");
            btnAccion.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;");
        }
    }

    @FXML
    void manejarAccionBoton(ActionEvent event) {
        if (libroActual == null) return;
        String usuario = "Usuario Actual"; // Se puede reemplazar con el usuario del login

        GestionBiblioteca.getInstancia().conmutarEstadoLibro(libroActual.getIsbn(), usuario);

        // Refrescar etiqueta de estado y botón
        boolean disponible = "disponible".equals(libroActual.getEstado());
        lblEstado.setText(disponible ? "Disponible" : "Prestado");
        lblEstado.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: " + (disponible ? "#27ae60" : "#e74c3c") + ";");
        actualizarInterfazBoton();
    }

    @FXML
    void Volver() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("principalPanel.fxml"));
            Stage stage = (Stage) lblIsbn.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            System.err.println("Error al regresar: " + e.getMessage());
        }
    }
}
