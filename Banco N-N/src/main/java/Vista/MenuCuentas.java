package Vista;

import Controlador.CuentaController;
import Utilidades.EntradaDatos;

import javax.swing.*;

public class MenuCuentas {
    public static void menuCuentas(){
        boolean w=false;
        do {
            try {
                String opcion= JOptionPane.showInputDialog("-----MENU CUENTAS-----\n Ingrese una opcion: \n1. Crear Cuenta \n2. Eliminar Cuenta \n3. Modificar Cuenta \n4. Listar Cuentas \n5. Buscar cuenta por IBAN\n0. Salir");
                if (opcion.equals("")||opcion==null) {throw new Exception("Debe ingresar una opcion");}
                int opcion1=Integer.parseInt(opcion);
                switch (opcion1) {
                    case 1:
                        crearCuentas();
                        break;
                    case 2:
                        eliminarCuenta();
                        break;
                    case 3:
                        modificarCuenta();
                        break;
                    case 4:
                        listarCuentas();
                        break;
                    case 5:
                        buscarCuentaPorIban();
                        break;
                    case 0:
                        w=true;
                        JOptionPane.showMessageDialog(null, "Volviendo al menu completo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion no valida");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while (!w);
    }

    public static void crearCuentas(){
        boolean w=false;
        String iban;
        Double saldo;
        do {
            try {
                iban= JOptionPane.showInputDialog("Ingrese el iban de la cuenta: ").toUpperCase();
                EntradaDatos.validarIban(iban);
                String saldoStr= JOptionPane.showInputDialog("Ingrese el saldo de la cuenta: ");
                saldo= EntradaDatos.validarSaldo(saldoStr);
                w=true;
                CuentaController.crearCuenta(iban,saldo);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while (!w);
    }

    public static void eliminarCuenta(){
        boolean w=false;
        String iban;
        do {
            try {
                iban= JOptionPane.showInputDialog("Ingrese el iban de la cuenta que quiere borrar: ").toUpperCase();
                EntradaDatos.validarIban(iban);
                w=true;
                JOptionPane.showInputDialog(null, CuentaController.borrarCuenta(iban));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while (!w);
    }

    public static void modificarCuenta(){
        boolean w=false;
        String iban;
        Double saldo;
        do {
            try {
                iban=JOptionPane.showInputDialog("Ingrese el iban de la cuenta que quiere modificar: ").toUpperCase();
                EntradaDatos.validarIban(iban);
                String saldoStr= JOptionPane.showInputDialog("Ingrese el nuevo saldo de la cuenta: ");
                saldo= EntradaDatos.validarSaldo(saldoStr);
                w=true;
                CuentaController.modificarCuenta(iban,saldo);
                JOptionPane.showInputDialog(null, "Cuenta modificada correctamente");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while (!w);
    }

    public static void listarCuentas(){
        StringBuilder sb = CuentaController.listarTodasLasCuentas();
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null,sb);
        } else {
            JOptionPane.showMessageDialog(null,"No hay cuentas registradas.");
        }
    }

    public static void buscarCuentaPorIban(){
        boolean w=false;
        String iban;
        do {
            try {
                iban=JOptionPane.showInputDialog("Ingrese el iban de la cuenta que quiere buscar: ").toUpperCase();
                EntradaDatos.validarIban(iban);
                w=true;
                CuentaController.buscarPorIban(iban);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }while (!w);
    }
}
