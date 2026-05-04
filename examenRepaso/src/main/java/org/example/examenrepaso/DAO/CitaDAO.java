package org.example.examenrepaso.DAO;

import javafx.scene.control.Alert;
import org.example.examenrepaso.Modelo.Cita;
import org.example.examenrepaso.Utilidades.BDConection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CitaDAO {
    public static String mensaje="\n";
    public static void crearCita(Cita cita) throws Exception {
        String sql= "INSERT INTO citas(dni, idTratamiento, fecha, hora) values(?,?,?,?)";
        try {
            BDConection bdConection = new BDConection();
            BDConection.abrirConexion();
            PreparedStatement ps =BDConection.con.prepareStatement(sql);
            ps.setString(1,cita.getDniPaciente());
            ps.setInt(2,cita.getIdTratamiento());
            ps.setDate(3, java.sql.Date.valueOf(cita.getFecha()));
            ps.setString(4, cita.getHora());
            int e=ps.executeUpdate();
            if(e==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("No se pudo registrar la cita");
                alert.showAndWait();
                throw new Exception("Error al insertar");
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setHeaderText("Succes");
                alert.setContentText("Cita registrado correctamente");
                alert.showAndWait();
                System.out.println("Cita registrado correctamente");
            }
            ps.close();

        }catch(Exception e){
            e.printStackTrace(); // <--- ESTO te dirá la línea exacta y la causa real en la consola
            throw new Exception("Error en al crear la Cita");
        }
    }

    public static String buscarDni(String dni) {
        String sql= "SELECT * FROM citas WHERE dni = ?";
        try {
            BDConection bdConection = new BDConection();
            BDConection.abrirConexion();
            PreparedStatement ps =BDConection.con.prepareStatement(sql);
            ps.setString(1,dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mensaje =mensaje+ "DNI: " + rs.getString("dni") +
                        " | Tratamiento: " + rs.getInt("idTratamiento") +
                        " | Fecha: " + rs.getString("fecha") +
                        " | Hora: " + rs.getString("hora") + "\n";
            }
            return  mensaje;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("No se pudo buscar la cita");
            alert.showAndWait();
            e.printStackTrace();
            return null;
        }
    }
}
