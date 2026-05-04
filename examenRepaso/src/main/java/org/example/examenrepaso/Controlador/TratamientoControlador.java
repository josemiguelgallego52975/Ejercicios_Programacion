package org.example.examenrepaso.Controlador;

import org.example.examenrepaso.DAO.TratamientoDAO;

public class TratamientoControlador {
    public static String buscarTratamiento(int id) {
        String mens= TratamientoDAO.buscarTratamiento(id);
        return mens;

    }
}
