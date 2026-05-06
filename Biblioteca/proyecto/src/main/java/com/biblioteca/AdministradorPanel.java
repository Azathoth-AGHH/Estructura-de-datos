package com.biblioteca;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AdministradorPanel {

    private File archivoSeleccionado;

    // Form fields
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private TextField txtAnio;
    @FXML private TextField txtISBN;
    @FXML private Label lblRutaImagen;
    @FXML private Button btnBusqueda;

    // Loan fields
    @FXML private TextField txtIsbnPrestamo;
    @FXML private TextField txtUsuarioPrestamo;
    @FXML private Label lblResultadoPrestamo;

    // Table
    @FXML private TableView<Libro> tablaLibros;
    @FXML private TableColumn<Libro, String> colIsbn;
    @FXML private TableColumn<Libro, String> colTitulo;
    @FXML private TableColumn<Libro, String> colAutor;
    @FXML private TableColumn<Libro, String> colEstado;
    @FXML private TableColumn<Libro, Void> colEliminar;

    @FXML
    public void initialize() {
        // Wire table columns
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Color estado column
        colEstado.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(String estado, boolean empty) {
                super.updateItem(estado, empty);
                if (empty || estado == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(estado.substring(0, 1).toUpperCase() + estado.substring(1));
                    setStyle("-fx-text-fill: " + ("disponible".equals(estado) ? "#27ae60" : "#e74c3c") + "; -fx-font-weight: bold;");
                }
            }
        });

        // Columna de eliminar con botón por fila
        colEliminar.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("✕ Eliminar");
            {
                btn.setStyle(
                    "-fx-background-color: #c0392b;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 5;" +
                    "-fx-cursor: hand;" +
                    "-fx-padding: 4 10;"
                );
                btn.setOnAction(event -> {
                    Libro libro = getTableView().getItems().get(getIndex());
                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("Eliminar libro");
                    confirm.setHeaderText("¿Seguro que quieres eliminar este libro?");
                    confirm.setContentText(libro.getTitulo());
                    confirm.showAndWait().ifPresent(r -> {
                        if (r == ButtonType.OK) {
                            GestionBiblioteca.getInstancia().eliminarLibro(libro.getIsbn());
                            actualizarTabla();
                        }
                    });
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        actualizarTabla();
    }

    private void actualizarTabla() {
        ObservableList<Libro> datos = FXCollections.observableArrayList(
            GestionBiblioteca.getInstancia().getListaLibros()
        );
        tablaLibros.setItems(datos);
    }

    @FXML
    void irABusqueda() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/biblioteca/principalPanel.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnBusqueda.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error: No se encontró el archivo FXML de búsqueda.");
            e.printStackTrace();
        }
    }

    @FXML
    void agregarLibro() {
        try {
            String titulo  = txtTitulo.getText().trim();
            String autor   = txtAutor.getText().trim();
            String isbn    = txtISBN.getText().trim();
            String anioTxt = txtAnio.getText().trim();

            if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || anioTxt.isEmpty()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios.");
                return;
            }

            if (GestionBiblioteca.getInstancia().buscarPorIsbn(isbn) != null) {
                mostrarAlerta("ISBN duplicado", "Ya existe un libro con ese ISBN.");
                return;
            }

            int anio;
            try {
                anio = Integer.parseInt(anioTxt);
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "El año debe ser un número válido.");
                return;
            }

            Libro nuevoLibro = new Libro(titulo, autor, anio, isbn);
            GestionBiblioteca.getInstancia().agregarLibro(nuevoLibro);

            // Guardar imagen en el directorio persistente (portadas/ junto al ejecutable)
            if (archivoSeleccionado != null) {
                boolean ok = GestionBiblioteca.getInstancia().guardarPortada(archivoSeleccionado, isbn);
                if (!ok) {
                    mostrarAlerta("Advertencia", "El libro se guardó pero no se pudo copiar la imagen.");
                }
            }

            mostrarAlerta("Éxito", "Libro añadido correctamente.");
            limpiarCampos();
            archivoSeleccionado = null;
            lblRutaImagen.setText("Sin imagen seleccionada");
            actualizarTabla();

        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo guardar: " + e.getMessage());
        }
    }

    @FXML
    void seleccionarImagen(javafx.event.ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Portada");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.png", "*.jpeg"));
        File file = fc.showOpenDialog(txtTitulo.getScene().getWindow());
        if (file != null) {
            archivoSeleccionado = file;
            lblRutaImagen.setText("Imagen: " + file.getName());
        }
    }

    @FXML
    void realizarPrestamo() {
        if (txtIsbnPrestamo == null || txtUsuarioPrestamo == null) return;
        String isbn    = txtIsbnPrestamo.getText().trim();
        String usuario = txtUsuarioPrestamo.getText().trim();
        if (isbn.isEmpty() || usuario.isEmpty()) {
            lblResultadoPrestamo.setText("⚠ ISBN y usuario son obligatorios.");
            lblResultadoPrestamo.setStyle("-fx-text-fill: #e67e22;");
            return;
        }
        String resultado = GestionBiblioteca.getInstancia().realizarPrestamo(isbn, usuario);
        lblResultadoPrestamo.setText(resultado);
        lblResultadoPrestamo.setStyle("-fx-text-fill: " + (resultado.contains("registrado") ? "#27ae60" : "#e74c3c") + ";");
        actualizarTabla();
        txtIsbnPrestamo.clear();
        txtUsuarioPrestamo.clear();
    }

    @FXML
    void devolverLibro() {
        String resultado = GestionBiblioteca.getInstancia().devolverLibro();
        if (lblResultadoPrestamo != null) {
            lblResultadoPrestamo.setText(resultado);
            lblResultadoPrestamo.setStyle("-fx-text-fill: " + (resultado.contains("devuelto") ? "#27ae60" : "#e74c3c") + ";");
        }
        actualizarTabla();
    }

    @FXML
    void generarReporte() {
        String nombreArchivo = "reporte_biblioteca_" + java.time.LocalDate.now() + ".txt";
        GestionBiblioteca.getInstancia().generarReporte(nombreArchivo);
        mostrarAlerta("Reporte generado", "El reporte fue guardado como:\n" + nombreArchivo);
    }

    private void limpiarCampos() {
        txtTitulo.clear();
        txtAutor.clear();
        txtISBN.clear();
        txtAnio.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }
}
