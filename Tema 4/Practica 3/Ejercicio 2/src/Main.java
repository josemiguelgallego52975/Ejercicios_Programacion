import Model.Cliente;
import Model.Gato;
import Model.Perro;
import Model.Veterinario;

import javax.swing.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public static void main(String[] args) {
        try {
            añadirDatos();
            menu();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void menu(){
        boolean w=false;
        do {
            String opcion;
            opcion=JOptionPane.showInputDialog("-----MENU-----\n" +
                    "a) Mostrar el numero de clientes que poseen un tipo de animal concreto.\n" +
                    "b) Datos personales del cliente a partir del nombre de mascota.\n" +
                    "c) Suponemos que es unico. ´\n" +
                    "d) Datos del veterinario a partir de los datos de una mascota.\n" +
                    "e) Datos de las mascotas de un cliente.\n" +
                    "f) Datos de las mascotas de un veterinario.\n" +
                    "g) Terminar.\n");
            opcion=opcion.toLowerCase();
            switch(opcion){
               case "a":
                   break;
               case "b":
                   break;
               case "c":
                   break;
               case "d":
                   break;
               case "e":
                   break;
               case "f":
                   break;
               case "g":
                   JOptionPane.showMessageDialog(null,"El programa a finalizado");
                   w=true;
                   break;
               default:
                   JOptionPane.showMessageDialog(null,"Opcion invalida, intentelo de nuevo");
            }
        }while (!w);

    }

    public static void añadirDatos(){
        veterinarioDatos();
        clienteDatos();

    }

    public static void veterinarioDatos(){
        int opcion;
        do {
            JOptionPane.showMessageDialog(null,"Debe de añadir los siguentes datos del veterinario:");

            String n = JOptionPane.showInputDialog("Nombre del veterinario:");
            String d = JOptionPane.showInputDialog("Direccion del veterinario:");
            String t = JOptionPane.showInputDialog("Telefono del veterinario:");
            String dn = JOptionPane.showInputDialog("DNI del veterinario:");
            int num = Integer.parseInt(JOptionPane.showInputDialog("Numero de seguridad del veterinario: (Solo se pueden meter numeros)"));

            Veterinario v1= new Veterinario(n, d,t, dn, num);
            veterinarios.add(v1);

            opcion=JOptionPane.showConfirmDialog(null,"Hay mas veterinarios?","Continuar",JOptionPane.YES_NO_OPTION);
        }while(opcion==JOptionPane.NO_OPTION);

    }

    public static void clienteDatos(){
        int opcion;
        do {

            JOptionPane.showMessageDialog(null,"Debe de añadir los siguentes datos del cliente:");

            String n = JOptionPane.showInputDialog("Nombre del cliente:");
            String d = JOptionPane.showInputDialog("Direccion del cliente:");
            String t = JOptionPane.showInputDialog("Telefono del cliente:");
            String raza = JOptionPane.showInputDialog("Raza de la mascota:");
            String nM = JOptionPane.showInputDialog("Nombre del mascota:");
            String fechaNacimiento = JOptionPane.showInputDialog("Fecha de nacimiento de la  mascota:");
            String peso = JOptionPane.showInputDialog("Peso de la mascota:");
            String sexo = JOptionPane.showInputDialog("Sexo de la mascota:");
            String Long=JOptionPane.showInputDialog("Longitud de la mascota:");
            String color = JOptionPane.showInputDialog("Color de la mascota:");
            int perro= JOptionPane.showConfirmDialog(null,"Su mascota es Perro?", "Tipo de Mascota" ,JOptionPane.YES_NO_OPTION);

            if(perro==JOptionPane.YES_OPTION){
                Perro m1= new Perro(raza, nM, fechaNacimiento, peso, sexo, Long,color);
                Cliente c1 = new Cliente(n,d,t, m1);
            }else if (perro==JOptionPane.NO_OPTION){
                Gato m1 = new Gato(raza, nM, fechaNacimiento, peso, sexo, Long,color);
                Cliente c1 = new Cliente(n,d,t, m1);
            }

            


            opcion=JOptionPane.showConfirmDialog(null,"Hay mas clientes?","Continuar",JOptionPane.YES_NO_OPTION);
        }while(opcion==JOptionPane.NO_OPTION);
    }



}