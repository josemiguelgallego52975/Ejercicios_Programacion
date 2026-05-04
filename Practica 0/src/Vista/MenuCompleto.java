package Vista;

import javax.swing.*;

public class MenuCompleto {}
/*
    public void mostrarMenu() {
        boolean w = false;
            do {
                try {
                    String opcion;
                    opcion = JOptionPane.showInputDialog("-----MENU PRINCIPAL-----\n" +
                            "1. Menu Titulares\n" +
                            "2. Menu Cuentas\n" +
                            "3. Menu Movimientos\n" +
                            "0. Salir"
                    );
                    if (opcion.equals("") || opcion == null) {
                        throw new Exception("No puede dejar en blanco este apartado, ingrese una opcion");
                    }
                    int opcion1 = Integer.parseInt(opcion);
                    switch (opcion1) {
                        case 1:
                            MenuTitulares menuTitulares = new MenuTitulares();
                            menuTitulares.mostrarMenu();
                            break;
                        case 2:
                            MenuCuentas menuCuentas = new MenuCuentas();
                            menuCuentas.mostrarMenu();
                            break;
                        case 3:
                            MenuMovimientos menuMovimientos = new MenuMovimientos();
                            menuMovimientos.mostrarMenu();
                            break;
                        case 0:
                            w = true;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida. Inténtalo de nuevo.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            } while (!w);
    }

}*/
