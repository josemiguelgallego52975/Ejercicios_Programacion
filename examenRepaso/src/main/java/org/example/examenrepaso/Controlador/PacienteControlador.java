package org.example.examenrepaso.Controlador;

import org.example.examenrepaso.DAO.PacienteDAO;
import org.example.examenrepaso.Modelo.Paciente;

import java.time.LocalDate;

public class PacienteControlador {



    public static void crearPaciente(String dni, String nombre, String direccion, String telefono, LocalDate fechaNacimiento) throws Exception {
        try{
            Paciente paciente = new Paciente(dni, nombre, direccion, telefono, fechaNacimiento);
            PacienteDAO.crearPaciente(paciente);
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }


}
