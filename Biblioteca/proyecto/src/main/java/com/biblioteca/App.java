package com.biblioteca;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Seed some sample books so the UI is not empty on first run
        GestionBiblioteca g = GestionBiblioteca.getInstancia();
        if (g.getListaLibros().isEmpty()) {
            g.agregarLibro(new Libro("", "", 0000, ""));
        }

        Parent root = loadFXML("principalPanel");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("De Libros — Biblioteca Digital");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
