package org.example.examenrepaso.VistaControlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuControlador {
    public void mostrarMenu() {
    }

    @FXML
    public void onAltaPaciente(ActionEvent event) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/examenrepaso/AltaPaciente.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage stageViejo = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageViejo.close();
        }catch(Exception e){
            System.out.println("Error al mostrar el alta de paciente"+ e.getMessage());
        }
    }

    @FXML
    public void onAsignarCita(ActionEvent event) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/examenrepaso/AsignarCita.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage stageViejo = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageViejo.close();
        }catch(Exception e){
            System.out.println("Error al mostrar el alta de paciente");
        }
    }

    @FXML
    public void onConsultarCita(ActionEvent event) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/examenrepaso/ConsultarCita.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage stageViejo = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageViejo.close();
        }catch(Exception e){
            System.out.println("Error al mostrar el alta de paciente");
        }
    }

    @FXML
    public void onFinalizar(ActionEvent event) throws IOException {
        try{
            Stage stageViejo = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageViejo.close();
        }catch(Exception e){
            System.out.println("Error al mostrar el alta de paciente");
        }
    }



}
