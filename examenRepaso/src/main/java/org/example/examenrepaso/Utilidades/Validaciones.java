package org.example.examenrepaso.Utilidades;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    public static void validarDni(String dni) throws Exception {
        if(dni.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el dni");
            alert.setContentText("El dni no puede ser vacio.");
            alert.showAndWait();
            throw new Exception("Error en el dni");
        }
        Pattern pattern= Pattern.compile("^[0-9]{8}[A-ZÑña-z]$");
        Matcher matcher= pattern.matcher(dni);
        if(!matcher.matches()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el formato del dni");
            alert.setContentText("El dni debe tener 8 dígitos seguidos de una letra mayúscula o minúscula.");
            alert.showAndWait();
            throw new Exception("Error en el formato del dni");
        }
    }

    public static void validarNombre(String nombre) throws Exception {
        if(nombre.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el nombre");
            alert.setContentText("El nombre no puede ser vacio.");
            alert.showAndWait();
            throw new Exception("Error en el nombre");
        }
    }

    public static void validarTelefono(String telefono) throws Exception {


        Pattern pattern= Pattern.compile("^[0-9]{9}$");
        Matcher matcher= pattern.matcher(telefono);
        if(!matcher.matches()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el formato del telefono");
            alert.setContentText("El telefono debe tener 9 dígitos.");
            alert.showAndWait();
            throw new Exception("Error en el formato del telefono");
        }
    }

    public static void validarDireccion(String direccion) throws Exception {
        if(direccion.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el direccion");
            alert.setContentText("El direccion debe tener una direccion.");
            alert.showAndWait();
            throw new Exception("Error en el direccion");
        }
    }

    public static void validarHora(String hora) throws Exception {

        Pattern pattern =Pattern.compile("^[0-9]{2}:[0-9]{2}$");
        Matcher matcher= pattern.matcher(hora);
        if(!matcher.matches()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el formato del hora");
            alert.setContentText("El formato del hora debe ser HH:MM.");
            alert.showAndWait();
            throw new Exception("Error en el formato del hora");
        }
    }

}
