package org.example.examenrepaso.VistaControlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.examenrepaso.Controlador.CitaControlador;
import org.example.examenrepaso.Controlador.PacienteControlador;
import org.example.examenrepaso.Controlador.TratamientoControlador;
import org.example.examenrepaso.Utilidades.Validaciones;

import java.io.IOException;

public class ConsultarCitaControlador {

    @FXML
    private RadioButton dni;
    @FXML
    private RadioButton tratamiento;
    @FXML
    private TextField mensaje;
    @FXML
    private TextArea mostrarCita ;


    @FXML
    public void onAceptar(ActionEvent event) throws IOException {
        try {
            if (dni.isSelected()) {
                String dni = mensaje.getText();
                Validaciones.validarDni(dni);

                String mens=CitaControlador.buscarDni(dni);
                mostrarCita.setText(mens);
                mostrarCita.setEditable(false);
            }else  if (tratamiento.isSelected()) {
                int id =Integer.parseInt(mensaje.getText());

                String mens= TratamientoControlador.buscarTratamiento(id);
                mostrarCita.setText(mens);
                mostrarCita.setEditable(false);

            }
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            throw  new IOException();
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
    }}
