package Vista;

import Controller.AvionController;
import Controller.PasajeroController;
import Modelo.Pasajero;
import Utilidades.EntradaDatos;

import javax.swing.*;

public class MenuPasajero {
    public static void menuPasajero(){
        boolean w = false;
        do {
            try {
                String opcion = JOptionPane.showInputDialog("-----MENU PASAJERO-----\nSelecciona una opcion:\n1. Alta a Pasajero\n2. Baja a Pasajero\n3. Modificar a Pasajero\n0. Salir");
                if (opcion.equals("")||opcion==null) {throw new Exception("No lo pude dejar en blanco, seleccione una opcion");}
                int opcion1= Integer.parseInt(opcion);
                switch (opcion1) {
                    case 1:
                        altaPasajero();
                        break;
                    case 2:
                        bajaPasajero();
                        break;
                    case 3:
                        modificarPasajero();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Volviendo al inicio...");
                        w = true;
                        break;
                    default:
                        throw new Exception("Opcion invalida, seleccione una opcion correcta");
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
    }

    public static void modificarPasajero(){
        boolean w = false;
        String dni,numero;
        do {
            try {
                dni=JOptionPane.showInputDialog("Ingrese el DNI del pasajero que desea modificar").toUpperCase();
                w=EntradaDatos.validarDni(dni);
                numero=JOptionPane.showInputDialog("Ingrese el nuevo numero del pasajero");
                w=EntradaDatos.validarNumero(numero);
                PasajeroController.modificarPasajero(dni, numero);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }

    public static void bajaPasajero(){
        boolean w = false;
        String dni;
        do {
            try {
                dni=JOptionPane.showInputDialog("Ingrese el DNI del pasajero que desea eliminar").toUpperCase();
                w=EntradaDatos.validarDni(dni);
                PasajeroController.borrarPasajero(dni);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);

    }

    public static void altaPasajero(){
        boolean w,dw,nbw,nmw,cvw = false;
        String dni, nombre, numero, codVuelo;
        do {
            try {
                do {
                    dni=JOptionPane.showInputDialog("Ingrese el DNI del pasajero");
                    dw=EntradaDatos.validarDni(dni.toUpperCase());
                }while(!dw);
                do {
                    nombre=JOptionPane.showInputDialog("Ingrese el nombre del pasajero");
                    nbw=EntradaDatos.validarTexto(nombre);
                }while(!nbw);
                do {
                    numero=JOptionPane.showInputDialog("Ingrese el numero del pasajero");
                    nmw=EntradaDatos.validarNumero(numero);
                }while(!nmw);
                do {
                    codVuelo=JOptionPane.showInputDialog("Ingrese el codigo de vuelo en que va el pasajero (AEA1-XXXX)");
                    cvw=EntradaDatos.validarCodVuelo(codVuelo);
                }while(!cvw);
                PasajeroController.crearPasajero(dni, nombre, numero, codVuelo);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            w=true;
        }while(!w);
    }
}
