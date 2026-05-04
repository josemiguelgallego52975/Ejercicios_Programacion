package Vista;

import Controler.TitularController;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class MenuTitulares {
    private TitularController titularController;
    public MenuTitulares()
    {
            /*
            Creación del controlador para manejar la lógica de negocio
            relacionada con los titulares.
             */
        titularController = new TitularController();
    }
    public void mostrarMenu() {
        boolean w = false;
        do {
            try {
                String opcion;
                opcion = JOptionPane.showInputDialog("-----MENU-----\n" +
                        "1. Añadir Titular\n" +
                        "2. Modificar Titular\n" +
                        "3. Borrar Titular\n" +
                        "4. Listar Titular\n" +
                        "5. Listar Titular por Nombre\n" +
                        "6. Buscar por ID\n" +
                        "7. Buscar por DNI\n" +
                        "0. Salir"

                );
                if (opcion.equals("") || opcion == null) {
                    throw new Exception("No puede dejar en blanco este apartado, ingrese una opcion");
                }
                int opcion1 = Integer.parseInt(opcion);
                switch (opcion1) {
                    case 1:
                        crearTitular();
                        break;
                    case 2:
                        modificarTitular();
                        break;
                    case 3:
                        borrarTitular();
                        break;
                    case 4:
                        listarTitulares();
                        break;
                    case 5:
                        listarPorNombre();
                        break;
                    case 6:
                            buscarPorId();
                        break;
                    case 7:
                        buscarPorDni();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        w = true;
                        break;
                    default:
                        throw new Exception("Opcion invalida, ingrese una opcion valida");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (!w);
    }
        private void crearTitular()
        {
            System.out.println("\n--- CREAR TITULAR ---");
            try
            {
                // Solicitar el dni y el nombre del titular al usuario
                String dni = EntradaDatos.leerTexto( "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
                if (dni != null) {
                    // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                    String nombre = EntradaDatos.leerTexto( "Introduce nombre: ", "^[A-Za-z ]+$");
                    if (nombre != null) {
                        // Llamar al controlador para crear el titular
                        titularController.crearTitular(dni, nombre);
                        // Mensaje para que el usuario sepa que se ha creado correctamente
                        System.out.println("Titular creado correctamente.");
                    }
                }
            }
            catch (Exception e)
            {
                // Mensaje para el usuario para que sepa que ha habido un error al crear el titular
                System.out.println("Problemas creando el titular");
            }

        }

        private void borrarTitular() {
            System.out.println("\n--- BORRAR TITULAR ---");
            try
            {
                // id o dni? Se puede hacer de las dos formas.
                int id = EntradaDatos.leerEntero( "Introduce id del titular a borrar: ");
                if (id != -1)
                {
                    // Si es -1, ya hemos mostrado un mensaje de error en la función leerEntero, así que no hace falta mostrar otro aquí.
                    // LLamar al controlador para borrar el titular por ID
                    int n= titularController.borrarTitular(id);
                    if (n==1)
                    {
                        // Mensaje para que el usuario sepa que se ha borrado correctamente
                        System.out.println("Titular borrado correctamente.");
                    }
                    else {
                        // Mensaje para el usuario para que sepa que no se ha encontrado el titular con el ID proporcionado
                        System.out.println("No se encontró ningún titular con el ID proporcionado.");
                    }

                }

            }
            catch (Exception e)
            {
                // Mensaje para el usuario para que sepa que ha habido un error al borrar el titular
                System.out.println("Problemas borrando el titular");
            }
        }

        private Titular buscarPorDni() {
            System.out.println("\n--- BUSCAR TITULAR POR DNI ---");
            String dni = EntradaDatos.leerTexto("Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
            if (dni != null) {
                // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                // Variable global?
                Titular titular = titularController.buscarPorDni(dni);
                if (titular != null) {
                    System.out.println("Titular encontrado: " + titular);
                } else {
                    System.out.println("No se encontró ningún titular con el DNI proporcionado.");
                }
                return titular;
                // Encontrado o no, no tiene porque ser un error por lo que no pongo try
            }
            return null;
        }

        private void listarPorNombre() {
            System.out.println("\n--- BUSCAR TITULAR POR NOMBRE ---");
            String nombre = EntradaDatos.leerTexto("Introduce nombre: " , "^[A-Za-z ]+$");
            if (nombre != null) {
                // Variable global?
                StringBuilder sb= titularController.buscarPorNombre(nombre);
                if (!sb.isEmpty()) {
                    System.out.println(sb.toString());
                } else {
                    System.out.println("No se encontró ningún titular con el nombre proporcionado.");
                }
            }
        }

        private Titular buscarPorId() {
            System.out.println("\n--- BUSCAR TITULAR POR ID ---");
            int id = EntradaDatos.leerEntero( "Introduce ID: ");
            if (id != -1) {
                // Si es -1, ya hemos mostrado un mensaje de error en la función leerEntero, así que no hace falta mostrar otro aquí.
                // Variable global?
                Titular titular = titularController.buscarPorId(id);
                if (titular != null) {
                    System.out.println("Titular encontrado: " + titular);
                } else {
                    System.out.println("No se encontró ningún titular con el ID proporcionado.");
                }
                return titular;
            }
            return null;
        }


        private void modificarTitular() {
            JOptionPane.showMessageDialog(null,"\n--- MODIFICAR TITULAR ---");
            Titular titular = buscarPorDni();
            if (titular != null) {
                String nuevoNombre = EntradaDatos.leerTexto( "Introduce nuevo nombre: ", "^[A-Za-z ]+$");
                if (nuevoNombre != null) {
                    // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                    titularController.modificarTitular(titular, nuevoNombre);
                    System.out.println("Titular modificado correctamente.");
                }
            }
        }

        private void listarTitulares() {
            JOptionPane.showMessageDialog(null,"\n--- LISTADO DE TITULARES ---");
            List<Titular> titulares = titularController.listarTitulares();

            if (titulares.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"No hay titulares registrados.");
            } else
            {
                for (Titular t : titulares) {
                    JOptionPane.showMessageDialog(null,t);
                }
            }

            // Más puro
            JOptionPane.showMessageDialog(null,"\n--- LISTADO DE TITULARES (FORMA PURA) ---");
            StringBuilder sb = titularController.listarTitulares2();
            JOptionPane.showMessageDialog(null,sb);
        }


}
