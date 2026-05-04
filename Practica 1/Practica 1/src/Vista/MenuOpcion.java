package Vista;

import Controller.AvionController;
import Controller.PasajeroController;
import Modelo.Avion;
import Utilidades.EntradaDatos;

import javax.swing.*;
import java.time.LocalDate;

public class MenuOpcion {
    public static void menuOpcion() {
        boolean w=false;
        do {
            try {
                String opcion=JOptionPane.showInputDialog("-----MENU OTRAS OPCIONES------\nIngrese una opcion:\n1. Datos de vuelo por codigo.\n2. Datos de pasajero por dni.\n3. Vuelos por destino.\n4. Vuelos por origen.\n 5.Vuelo por pasajero.\n 6.Pasajeros de un vuelo.\n7. Vuelos por fecha.\n0. Salir.");
                if(opcion.equals("")||opcion==null) {throw new Exception("No pude dejar en blanco este apartado, ingrese una opcion");}
                int opcion1=Integer.parseInt(opcion);
                switch (opcion1) {
                    case 1:
                        buscarVueloPorCodigo();
                        break;
                    case 2:
                        buscarPasajeroPorDni();
                        break;
                    case 3:
                        buscarVuelosPorDestino();
                        break;
                    case 4:
                        buscarVuelosPorOrigen();
                        break;
                    case 5:
                        buscarVueloPorPasajero();
                        break;
                    case 6:
                        mostrarPasajerosDeVuelo();
                        break;
                    case 7:
                        buscarVueloPorFecha();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        w=true;
                        break;
                    default:
                        throw new Exception("Debe de ingresar una opcion correcta.");
                }

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }

    public static void buscarVueloPorFecha(){
        boolean w=false;
        LocalDate fechaSalida;
        do {
            try {
                String fecha=JOptionPane.showInputDialog("Ingrese la fecha que quiere saber que vuelos hay: ");
                fechaSalida=EntradaDatos.validarFecha(fecha);
                String mensaje=AvionController.buscarPorFecha(fechaSalida, fecha);
                if (mensaje==null) {throw new Exception("No se ha encontrado ningun vuelo ese dia.");}
                JOptionPane.showMessageDialog(null,mensaje);
                w=true;
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
    }

    public static void mostrarPasajerosDeVuelo() {
        boolean w=false;
        do {
            try {
                String codVuelo=JOptionPane.showInputDialog("Ingrese codigo de vuelo del vuelo que quiere saber sus pasajeros: ");
                String mensaje=PasajeroController.mostrarPasajeroVuelo(codVuelo);
                if (mensaje==null) {throw new Exception("No se ha podido encontrar pasajeros de ese vuelo.");}
                JOptionPane.showMessageDialog(null,mensaje);
                w=true;
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
    }

    public static void buscarVueloPorPasajero() {
        boolean w=false;
        do {
            try {
                String dni=JOptionPane.showInputDialog("Ingrese el DNI del pasajero que quiere saber que vuelo va a realizar: ").toUpperCase();
                w=EntradaDatos.validarDni(dni);
                String mensaje=AvionController.buscarPorPasajero(dni);
                if(mensaje==null) {throw new Exception("No se ha encontrado ningun pasajero con ese DNI.");}
                JOptionPane.showMessageDialog(null,mensaje);
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
    }

    public static void buscarVuelosPorOrigen() {
        boolean w=false;
        do {
            try {
                String origen=JOptionPane.showInputDialog("Ingrese el origen del vuelo que quiere buscar: ");
                w=EntradaDatos.validarTexto(origen);
                String mensaje=AvionController.buscarPorOrigen(origen);
                JOptionPane.showMessageDialog(null, mensaje);
                w=true;
            }catch(Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());}
        }while(!w);
    }

    public static void buscarVuelosPorDestino() {
        boolean w=false;
        do {
            try {
                String destino=JOptionPane.showInputDialog("Ingrese el destino del vuelo que quiere buscar: ");
                w=EntradaDatos.validarTexto(destino);
                String mensaje=AvionController.buscarPorDestino(destino);
                JOptionPane.showMessageDialog(null, mensaje);
                w=true;
            }catch(Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());}
        }while(!w);
    }

    public static void buscarVueloPorCodigo() {
        boolean w=false;
        String codVuelo;
        do {
            try {
                codVuelo=JOptionPane.showInputDialog("Ingrese el codigo del vuelo del vuelo que quiere saber los datos(AEA1-XXXX): ").toUpperCase();
                String mensaje= AvionController.buscarPorCodigo(codVuelo);
                if(mensaje==null){throw new Exception("No se encontro el vuelo");}
                JOptionPane.showMessageDialog(null,mensaje);
                w=true;
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
    }

    public static void buscarPasajeroPorDni() {
        boolean w=false;
        String dni;
        do {
            try {
                dni=JOptionPane.showInputDialog("Introduzca el DNI del pasajero que quiere saber sus datos: ").toUpperCase();
                String mensaje= PasajeroController.buscarPorDni(dni);
                if (mensaje==null) {throw new Exception("No se encontro el pasajero");}
                JOptionPane.showMessageDialog(null,mensaje);
                w=true;
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
    }
}
