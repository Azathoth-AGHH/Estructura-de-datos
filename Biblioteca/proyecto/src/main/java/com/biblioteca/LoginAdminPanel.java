package com.biblioteca;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginAdminPanel {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnEntrar;
    @FXML private Button btnAtras;

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "1234";

    @FXML
    void initialize() {}

    @FXML
    void entrarAdmin() {
        String user = txtUsuario.getText().trim();
        String pass = txtPassword.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Ingresa usuario y contraseña.");
            return;
        }

        if (ADMIN_USER.equals(user) && ADMIN_PASS.equals(pass)) {
            navegarA("administradorPanel", btnEntrar);
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Acceso denegado", "Usuario o contraseña incorrectos.");
            txtPassword.clear();
        }
    }

    @FXML
    void atras() {
        navegarA("principalPanel", btnAtras);
    }

    private void navegarA(String fxml, javafx.scene.Node nodo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml + ".fxml"));
            Stage stage = (Stage) nodo.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al navegar: " + e.getMessage());
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String msg) {
        Alert a = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}