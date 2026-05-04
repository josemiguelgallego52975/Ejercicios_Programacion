module org.example.examenrepaso {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.examenrepaso to javafx.fxml;
    exports org.example.examenrepaso;
    opens org.example.examenrepaso.VistaControlador to javafx.fxml;
    exports org.example.examenrepaso.VistaControlador;
    opens org.example.examenrepaso.Controlador to javafx.fxml;
    exports org.example.examenrepaso.Controlador;


}