package Vista;

import Modelo.Titular;
import Utilidades.EntradaDatos;
import Controlador.TitularController;

import javax.swing.*;

public class MenuTitulares {

    public static void menuTitulares() {
        boolean w=false;
        do {
            try {
                String opcion=JOptionPane.showInputDialog("-----MENU TITULARES-----\n Ingrese una opcion: \n1. Crear Titular \n2. Eliminar Titular \n3. Modificar Titular \n4. Listar Titulares \n5. Listar titulares por nombre\n6. Buscar por ID\n7. Buscar por DNI\n0. Salir");
                int opcion1=Integer.parseInt(opcion);
                switch (opcion1) {
                    case 1:
                        crearTitular();
                        break;
                    case 2:
                        eliminarTitular();
                        break;
                    case 3:
                        modificarTitular();
                        break;
                    case 4:
                        listarTitulares();
                        break;
                    case 5:
                        listarTitularesPorNombre();
                        break;
                    case 6:
                        buscarPorId();
                        break;
                    case 7:
                        buscarPorDni();
                        break;
                    case 0:
                        w=true;
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while(!w);


    }

    public static void crearTitular() {
        boolean w=false;
        String nombre;
        String dni;
        do {
            try {
                nombre= JOptionPane.showInputDialog("Ingrese el nombre del titular: ");
                if (nombre.equals("")||nombre==null) {throw new Exception("Debe ingresar un nombre");}
                dni= JOptionPane.showInputDialog("Ingrese el DNI del titular: ").toUpperCase();
                EntradaDatos.validarDni(dni);
                w=true;
                TitularController.crearTitular(nombre,dni);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while (!w);
    }

    public static void eliminarTitular() {
        boolean w=false;
        String nombre;
        int id;
        do {

            try {
                String texto = JOptionPane.showInputDialog("Ingrese el id del titular a eliminar: ").toUpperCase();
                if (texto.equals("") || texto == null) {throw new Exception("Debe ingresar un id");}
                id = Integer.parseInt(texto);
                w = true;
                TitularController.borrarTitular(id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while  (!w);
    }

    public static void modificarTitular() throws Exception {
        Titular titular = buscarPorDni();
        if (titular != null) {
            String nuevoNombre = JOptionPane.showInputDialog(null, "Introduce nuevo nombre: ", "^[A-Za-z ]+$");
            if (nuevoNombre != null) {
                // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                TitularController.modificarTitular(titular, nuevoNombre);
                JOptionPane.showInputDialog(null,"Titular modificado correctamente.");
            }
        }

    }
    public static void listarTitularesPorNombre() throws Exception {
        String nombre = JOptionPane.showInputDialog( "Introduce nombre: ");
        if (nombre.equals("")||nombre==null) {throw new Exception("Debe ingresar un nombre");}
        else  {
            // Variable global?
            StringBuilder sb = TitularController.buscarTitularPorNombre(nombre);
            if (!sb.isEmpty()) {
                JOptionPane.showMessageDialog(null,sb.toString());
            } else {
                JOptionPane.showMessageDialog(null,"No se encontró ningún titular con el nombre proporcionado.");
            }
        }
    }
    public static void listarTitulares() {
        StringBuilder sb = TitularController.listarTitulares();
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null,sb);
        } else {
            JOptionPane.showMessageDialog(null,"No hay titulares registrados.");
        }
    }
    private static void buscarPorId() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce ID: "));
        if (id != -1) {
            String s = TitularController.buscarPorId(id);
            JOptionPane.showMessageDialog(null, s);
        }
    }
    public static Titular buscarPorDni() throws Exception {
        String dni;
        try {
            dni = JOptionPane.showInputDialog(null, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
            if (dni != null)
            {
                Titular titular = TitularController.buscarTitularPorDni(dni);
                if (titular != null) {
                    JOptionPane.showInputDialog(null,"Titular encontrado: " + titular);
                } else {
                    JOptionPane.showInputDialog(null,"No se encontró ningún titular con el DNI proporcionado.");
                }
                return titular;
            }
            return null;
        }catch (Exception e){
            throw new Exception("Error");
        }

    }
}
