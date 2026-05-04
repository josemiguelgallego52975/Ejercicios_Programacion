package org.example.examenrepaso.VistaControlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.examenrepaso.Controlador.PacienteControlador;
import org.example.examenrepaso.Utilidades.Validaciones;

import java.io.IOException;
import java.time.LocalDate;

public class AltaPacienteControlador {

    @FXML
    private TextField dni;
    @FXML
    private TextField nombre;
    @FXML
    private TextField direccion;
    @FXML
    private TextField telefono;
    @FXML
    private DatePicker fechaNacimiento;

    public AltaPacienteControlador() {
    }

    @FXML
    public void initialize() {
        fechaNacimiento.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date != null && date.isAfter(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #eeeeee; -fx-text-fill: #808080;");
                }
            }
        });
    }

    @FXML
    public void onAceptar(ActionEvent event) throws IOException {
        try {
            String dni = this.dni.getText();
            String nombre = this.nombre.getText();
            String direccion = this.direccion.getText();
            String telefono = this.telefono.getText();
            LocalDate fechaNacimiento = this.fechaNacimiento.getValue();
            Validaciones.validarDni(dni);
            Validaciones.validarNombre(nombre);
            Validaciones.validarDireccion(direccion);
            Validaciones.validarTelefono(telefono);

            try {
                PacienteControlador.crearPaciente(dni,  nombre, direccion, telefono, fechaNacimiento);
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Error al crear Paciente");
                alert.showAndWait();
                throw new IOException();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Paciente Salvo");
            alert.setHeaderText("Paciente Salvo");
            alert.setContentText("Paciente creado correctamente");
            alert.showAndWait();


        }catch (Exception e){
            System.out.println("Error al cargar los datos");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar los datos");
            alert.setContentText("Se ha producido un error al cargar los datos");
            alert.showAndWait();
        }
    }

    @FXML
    public void onCancelar(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/examenrepaso/Menu.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage viejo = (Stage)((Button)event.getSource()).getScene().getWindow();
            viejo.close();
        }catch (Exception e){
            System.out.println("Error al volver a la vista inicial");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al volver a la vista inicial");
            alert.setContentText("Se ha producido un error al volver a la vista inicial");
            alert.showAndWait();
        }
    }



}
