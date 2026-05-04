package Utilidades;

import Controller.PasajeroController;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntradaDatos {
    public static boolean validarTexto(String texto) throws Exception {
        if (texto.equals("  ") || texto.equals("") || texto == null) {
            JOptionPane.showMessageDialog(null, "No puede dejar en blanco este apartado");
            return false;
        }

        Pattern patron = Pattern.compile("^[A-ZÁÉÚÍÓÑ][a-záéíúóñ ]{1,}$");
        Matcher mat = patron.matcher(texto);
        if (!mat.matches()){
            throw new Exception("Debe de ingresar un nombre (Ciudad/Pasajero) y solo puede ingresar letras, la primera mayuscula");
        }
        return true;
    }

    public static boolean validarNumero(String numero) throws Exception {
        if (numero.equals("") || numero == null) {JOptionPane.showMessageDialog(null,"No puede dejar en blanco este apartado");return false;}

        Pattern pattern=Pattern.compile("^[0-9]{9}$");
        Matcher mat=pattern.matcher(numero);
        if (!mat.matches()){
            JOptionPane.showMessageDialog(null, "Debe de introducir el numero del pasajero. (Ej: 654321987)");
            return false;
        }
        return true;
    }

    public static String crearCodVuelo() throws Exception {
        String sql = "SELECT MAX(codVuelo) FROM avion WHERE codVuelo LIKE 'AEA1-%'";
        String nuevoCodigo = "AEA1-0001";

        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next() && rs.getString(1) != null) {
                String ultimoCod = rs.getString(1);

                String parteNumerica = ultimoCod.substring(5);

                int numeroSiguiente = Integer.parseInt(parteNumerica) + 1;

                nuevoCodigo = "AEA1-" + String.format("%04d", numeroSiguiente);
            }
        } catch (SQLException e) {
            throw new Exception("Error al calcular el siguiente código: " + e.getMessage());
        }

        return nuevoCodigo;
    }

    public static LocalDate validarFecha(String fecha) throws Exception {
        if (fecha.equals("") || fecha == null) {
            throw new Exception( "No puede dejar en blanco este apartado, ingrese una opcion");
        }else  {
            LocalDate fechaSalida;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaSalida= LocalDate.parse(fecha, formatter);
                if (fechaSalida.isBefore(LocalDate.now())) {
                    throw new Exception("La fecha de salida no puede ser anterior a la fecha actual. Por favor, ingrese una fecha válida.");
                }
                return fechaSalida;
            } catch (DateTimeParseException e) {
                throw new Exception("Formato de fecha inválido. Por favor, ingrese la fecha en el formato DD/MM/YYYY.");
            }
        }

    }

    public static boolean validarDni(String dni) throws Exception {
        Pattern pat =Pattern.compile("^[0-9]{8}[A-Z]$");
        Matcher mat = pat.matcher(dni);
        if (!mat.matches()) {
            JOptionPane.showMessageDialog(null, "Debe de introduicir un dni correcto. (Ej: 12345678A)");
            return false;
        }else  {
            return true;
        }
    }
    public static boolean validarCodVuelo(String codVuelo) throws Exception {
        if (codVuelo.equals("") || codVuelo == null) {
            JOptionPane.showMessageDialog(null, "No puede dejar en blanco este apartado");
            return false;
        }
        return PasajeroController.buscarCodVuelo(codVuelo);
    }




}
