package Vista;

import javax.swing.*;

public class MenuCompleto {

    public static void menuCompleto(){
    boolean w= false;
    do {
        try {
            String opcion = JOptionPane.showInputDialog("-----MENU-----\nSeleccione una opción:\n1. Vuelos\n2. Pasajeros\n3. Otras Operaciones\n0. Salir");
            if (opcion.equals("") || opcion == null) {
                throw new Exception("No puede dejar en blanco este apartado, ingrese una opcion");
            }
            int opcion1 = Integer.parseInt(opcion);
            switch (opcion1) {
                case 1:
                    MenuAvion.menuAvion();
                    break;
                case 2:
                    MenuPasajero.menuPasajero();
                    break;
                case 3:
                    MenuOpcion.menuOpcion();
                    break;
                case 0:
                    w = true;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa. ¡Hasta luego!");
                    break;
                default:
                    throw new Exception("Opción no válida. Por favor, ingrese una opción del 1 al 4.");
            }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (!w) ;
    }
}
