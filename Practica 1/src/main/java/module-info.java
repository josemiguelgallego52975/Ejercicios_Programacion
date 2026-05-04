module com.example.practica_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.practica_1 to javafx.fxml;
    exports com.example.practica_1;
}