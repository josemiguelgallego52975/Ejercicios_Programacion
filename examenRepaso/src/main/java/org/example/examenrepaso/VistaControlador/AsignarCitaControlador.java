package org.example.examenrepaso.VistaControlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.examenrepaso.Controlador.CitaControlador;
import org.example.examenrepaso.Utilidades.BDConection;
import org.example.examenrepaso.Utilidades.Validaciones;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class AsignarCitaControlador {

    @FXML
    private ChoiceBox <String> dniPaciente;
    @FXML
    private ChoiceBox <String> tratamiento;
    @FXML
    private TextField hora;
    @FXML
    private DatePicker fecha;

    @FXML
    private void initialize(){
        String dniSql="SELECT dni FROM pacientes";
        String tratamientoSql="SELECT id FROM tratamientos";
        try {
            BDConection bdConection = new BDConection();
            BDConection.abrirConexion();
            PreparedStatement ps= BDConection.con.prepareStatement(dniSql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                dniPaciente.getItems().add(rs.getString("dni"));
            }

        }catch(Exception e){
            System.out.println("Error al mostrar el dni del paciente" + e);
        }

        try {
            BDConection bdConection = new BDConection();
            BDConection.abrirConexion();
            PreparedStatement ps= BDConection.con.prepareStatement(tratamientoSql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                tratamiento.getItems().add(rs.getString("id"));
            }

        }catch(Exception e){
            System.out.println("Error al mostrar la descripcion del paciente" + e);
        }

        fecha.setDayCellFactory(picker -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (date != null && date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #eeeeee; -fx-text-fill: #808080;");
                }
            }
        });

    }

    @FXML
    public void onAceptar(ActionEvent event) throws Exception {
        try {
            String dni=dniPaciente.getValue();
            int id=Integer.parseInt(tratamiento.getValue());
            String hor=hora.getText();
            LocalDate fech=fecha.getValue();
            Validaciones.validarHora(hor);

            CitaControlador.crearCita(fech, hor,dni, id);

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Error al mostrar el alta de paciente");
            alert.showAndWait();
            e.printStackTrace(); // <--- ESTO te dirá la línea exacta y la causa real en la consola
            throw new Exception("Error en al crear la Cita");
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
