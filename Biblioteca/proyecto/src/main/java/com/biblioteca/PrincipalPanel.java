package com.biblioteca;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalPanel {

    @FXML private TextField txtFiltro;
    @FXML private Button btnAdmin;
    @FXML private FlowPane contenedorLibros;

    @FXML
    public void initialize() {
        mostrarLibrosEnTarjetas(GestionBiblioteca.getInstancia().getListaLibros());
    }

    @FXML
    void buscarLibro() {
        String filtro = txtFiltro.getText().trim();
        List<Libro> resultados;

        if (filtro.isEmpty()) {
            resultados = GestionBiblioteca.getInstancia().getListaLibros();
        } else {
            resultados = GestionBiblioteca.getInstancia().buscarPorCriterio(filtro);
        }

        mostrarLibrosEnTarjetas(resultados);
    }

    private void mostrarLibrosEnTarjetas(List<Libro> libros) {
        contenedorLibros.getChildren().clear();

        if (libros.isEmpty()) {
            Label vacio = new Label("No se encontraron libros.");
            vacio.setStyle("-fx-text-fill: #999999; -fx-font-size: 14px;");
            contenedorLibros.getChildren().add(vacio);
            return;
        }

        for (Libro libro : libros) {
            VBox tarjeta = new VBox(8);
            tarjeta.setStyle(
                "-fx-background-color: white;" +
                "-fx-padding: 0 0 14 0;" +
                "-fx-border-color: #E0D8C4;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.10), 10, 0, 0, 4);" +
                "-fx-cursor: hand;"
            );
            tarjeta.setPrefWidth(185);
            tarjeta.setAlignment(Pos.TOP_CENTER);

            StackPane contenedorImagen = new StackPane();
            contenedorImagen.setPrefHeight(220);
            contenedorImagen.setPrefWidth(185);
            contenedorImagen.setStyle("-fx-background-color: #E8E0CC; -fx-background-radius: 10 10 0 0;");

            ImageView img = new ImageView();
            img.setFitHeight(220);
            img.setFitWidth(185);
            img.setPreserveRatio(false);

            String rutaExterna = GestionBiblioteca.getInstancia().getRutaPortada(libro.getIsbn());
            if (rutaExterna != null) {
                try {
                    Image imagen = new Image(rutaExterna);
                    if (!imagen.isError()) img.setImage(imagen);
                } catch (Exception ignored) { }
            } else {
                try {
                    String ruta = "/com/biblioteca/portadas/" + libro.getIsbn() + ".png";
                    var stream = getClass().getResourceAsStream(ruta);
                    if (stream != null) {
                        Image imagen = new Image(stream);
                        if (!imagen.isError()) img.setImage(imagen);
                    }
                } catch (Exception ignored) { }
            }

            img.setStyle("-fx-background-radius: 10 10 0 0;");

            boolean disponible = "disponible".equals(libro.getEstado());
            Label badge = new Label(disponible ? "✓ Disponible" : "✗ Prestado");
            badge.setStyle(
                "-fx-background-color: " + (disponible ? "#27ae60" : "#e74c3c") + ";" +
                "-fx-text-fill: white;" +
                "-fx-padding: 3 9;" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12;"
            );
            StackPane.setAlignment(badge, Pos.TOP_LEFT);
            StackPane.setMargin(badge, new javafx.geometry.Insets(8));

            contenedorImagen.getChildren().addAll(img, badge);

            Label titulo = new Label(libro.getTitulo());
            titulo.setStyle(
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #1A3A2A;" +
                "-fx-text-alignment: center;" +
                "-fx-padding: 4 10 0 10;"
            );
            titulo.setWrapText(true);
            titulo.setAlignment(Pos.CENTER);
            titulo.setPrefWidth(165);

            Label autor = new Label(libro.getAutor());
            autor.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #777777;" +
                "-fx-text-alignment: center;" +
                "-fx-padding: 0 10;"
            );
            autor.setWrapText(true);
            autor.setAlignment(Pos.CENTER);
            autor.setPrefWidth(165);

            Label anio = new Label(String.valueOf(libro.getAnioPublicacion()));
            anio.setStyle(
                "-fx-background-color: #F0EBE0;" +
                "-fx-text-fill: #7A6A50;" +
                "-fx-font-size: 10px;" +
                "-fx-padding: 2 10;" +
                "-fx-background-radius: 8;"
            );

            tarjeta.setOnMouseClicked(event -> irADetalles(libro));
            tarjeta.getChildren().addAll(contenedorImagen, titulo, autor, anio);
            contenedorLibros.getChildren().add(tarjeta);
        }
    }

    private void irADetalles(Libro libro) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detallesLibro.fxml"));
            Parent root = loader.load();

            DetallesLibro controller = loader.getController();
            controller.initData(libro);
            controller.setLibro(libro);

            Stage stage = (Stage) contenedorLibros.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.err.println("Error al cambiar a la vista de detalles: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void irAPanelAdmin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("loginAdmin.fxml"));
            Stage stage = (Stage) btnAdmin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al navegar al login admin: " + e.getMessage());
        }
    }
}
