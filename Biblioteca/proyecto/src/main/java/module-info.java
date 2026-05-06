module com.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    // Esta línea es CRÍTICA para que la navegación funcione
    opens com.biblioteca to javafx.fxml; 
    
    exports com.biblioteca;
}