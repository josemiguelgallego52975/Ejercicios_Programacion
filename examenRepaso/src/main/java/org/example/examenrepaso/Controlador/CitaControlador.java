package org.example.examenrepaso.Controlador;

import org.example.examenrepaso.DAO.CitaDAO;
import org.example.examenrepaso.Modelo.Cita;

import java.time.LocalDate;

public class CitaControlador {

    public static void crearCita(LocalDate fecha, String hora, String dni, int idTratamiento)throws Exception{
        Cita cita = new Cita(fecha, hora, idTratamiento, dni);
        CitaDAO.crearCita(cita);
    }
    public static String buscarDni(String dni) throws Exception {
        String mens=CitaDAO.buscarDni(dni);
        return mens;
    }
}
