package org.example.examenrepaso.DAO;

import javafx.scene.control.Alert;
import org.example.examenrepaso.Controlador.PacienteControlador;
import org.example.examenrepaso.Modelo.Paciente;
import org.example.examenrepaso.Utilidades.BDConection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PacienteDAO {
    public static void crearPaciente(Paciente paciente) throws Exception {
        String sql= "INSERT INTO pacientes (dni, nombre, telefono, direccion, fechaNacimiento) VALUES (?, ?, ?, ?, ?)";
        try{
            BDConection bdConection = new BDConection();
            BDConection.abrirConexion();

            PreparedStatement ps= BDConection.con.prepareStatement(sql);
            ps.setString(1, paciente.getDni());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getTelefono());
            ps.setString(4, paciente.getDireccion());
            ps.setDate(5, java.sql.Date.valueOf(paciente.getFechaNacimiento()));

            int n=ps.executeUpdate();
            if(n==0){
                throw new Exception("Error al insertar Paciente");
            }else {
                System.out.println("Paciente insertado exitosamente");
            }
            ps.close();

        }catch(Exception e){
            throw new Exception("Error al crear Paciente");
        }
    }


}
