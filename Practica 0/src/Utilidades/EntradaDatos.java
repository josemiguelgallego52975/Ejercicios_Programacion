package Utilidades;

import javax.swing.*;
import java.util.Scanner;

public class EntradaDatos {
    // Forma parte de la vista, pero es tan común que la pongo aquí para no repetir código.
    public static int leerEntero( String mensaje) {
        int num = 0;
        boolean error = true;
        try {
            num = 0;
            do
            {

                try {
                    num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                    // También se puede con nextInt pero así me ahorro el limpiar el buffer después.
                    error = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"Error: introduce un número entero válido.");
                }
            }
            while (error);
            return num;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error leyendo el número: " + e.getMessage());
            return -1;
        }
    }

    public static String leerTexto( String mensaje,String expresionRegular) {
        try
        {
            String texto;
            do
            {
                texto = JOptionPane.showInputDialog(null,mensaje);
                if (!texto.matches(expresionRegular))
                {
                    JOptionPane.showMessageDialog(null,"Error: formato no válido. Inténtalo de nuevo.");
                }
            } while (!texto.matches(expresionRegular));
            return texto;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error leyendo el texto: " + e.getMessage());
            return "";
        }
    }
}
