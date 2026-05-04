package Vista;

import javax.swing.*;

public class MenuCompleto {
    public static void menuCompleto() {
        boolean w=false;
        do {
            try {
                String opcion=JOptionPane.showInputDialog("-----MENU COMPLETO-----\n Ingrese una opcion: \n1. Menu Titulares \n2. Menu Cuentas \n3. Salir");
                if (opcion.equals("")||opcion==null) {throw new Exception("Debe ingresar una opcion");}
                int opcion1=Integer.parseInt(opcion);
                switch (opcion1) {
                    case 1:
                        MenuTitulares.menuTitulares();
                        break;
                    case 2:
                        MenuCuentas.menuCuentas();
                        break;
                    case 3:
                        w=true;
                        JOptionPane.showMessageDialog(null, "Finalizando programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion no valida");

                }

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while(!w);
    }
}
