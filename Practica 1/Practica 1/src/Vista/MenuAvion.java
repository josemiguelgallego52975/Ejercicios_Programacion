package Vista;

import Controller.AvionController;
import DAO.AvionDAO;
import Utilidades.EntradaDatos;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuAvion {
    public static void menuAvion(){
        boolean w = false;
        do {
            try {
                String opcion=JOptionPane.showInputDialog("-----MENU VUELOS-----\nIngresa una opcion\n1. Alta de Vuelo\n2. Baja de Vuelo\n3. Modificacion Vuelo\n0. Salir");
                if (opcion.equals("") || opcion == null) {throw new Exception("No puede dejar en blanco este apartado, ingrese una opcion");}
                int opcion1 = Integer.parseInt(opcion);
                switch (opcion1) {
                    case 1:
                        altaVuelo();
                        break;
                    case 2:
                        bajaVuelo();
                        break;
                    case 3:
                        modificacionVuelo();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        w = true;
                        break;
                    default:
                        throw new Exception("Opcion invalida, ingrese una opcion valida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }

    public static void altaVuelo(){
        boolean pw,fsw,dw = false;
        String codVuelo, procedencia, destino, fecha;
        LocalDate fechaSalida;

        try {
            String texto;
            codVuelo = EntradaDatos.crearCodVuelo();
            do {
                procedencia = JOptionPane.showInputDialog("Ingrese el origen del vuelo:");texto=procedencia;
                pw=EntradaDatos.validarTexto(texto);
            }while (!pw);
            do {
                destino = JOptionPane.showInputDialog("Ingrese el destino del vuelo:");texto=destino;
                dw=EntradaDatos.validarTexto(texto);
            }while (!dw);
            do {
                fecha = JOptionPane.showInputDialog("Ingrese la fecha del vuelo (DD/MM/YYYY):");
                try {
                    fechaSalida=EntradaDatos.validarFecha(fecha);
                    AvionController.crearAvion(codVuelo, fechaSalida, destino, procedencia);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                fsw=true;
            }while (!fsw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void bajaVuelo(){
        boolean w = false;
        do {
            try {
                String texto;
                String codVuelo = JOptionPane.showInputDialog("Ingrese el código del vuelo a eliminar:");texto=codVuelo;
                w= AvionController.borrarAvion(texto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }

    public static void modificacionVuelo(){
        boolean w = false;
        do {
            try {
                LocalDate fechaSalidaNueva;
                String codVuelo = JOptionPane.showInputDialog("Ingrese el código del vuelo que quiere modificar:");

                String fecha1 = JOptionPane.showInputDialog("Ingrese la nueva fecha del vuelo (DD/MM/YYYY):");
                EntradaDatos.validarTexto(fecha1);
                fechaSalidaNueva=EntradaDatos.validarFecha(fecha1);
                w = AvionController.modificarVuelo(codVuelo, fechaSalidaNueva);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);

    }


}
