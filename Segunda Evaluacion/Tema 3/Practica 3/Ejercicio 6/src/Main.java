import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    private static String opcion;
    private static String[] animalesAceptados;
    private static ArrayList<Map<String,String>>animalesRescatados;
    public static void main(String[] args) {
        try{
            declararArrays();
            mostrarMenu();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    public static void declararArrays(){
        animalesRescatados=new ArrayList<>();
        animalesAceptados=new String[]{"perro","gato","conejo","loro","tortuga"};
    }
    public static void mostrarMenu(){
        boolean w=false;
        do {
            opcion=JOptionPane.showInputDialog(null,"-----MENU-----\n" +
                    "a) Ver especies aceptadas.\n" +
                    "b) Agregar un nuevo animal al listado de rescatados.\n" +
                    "c) Asignar un cuidador a un animal.\n" +
                    "d) Pasar un animal a la cola de espera de adopcion. ´\n" +
                    "e) Adoptar un animal.\n" +
                    "f) Lista todos los animales y sus cuidadores actuales.\n" +
                    "g) Salir"
            );
            opcion=opcion.toLowerCase();
            switch (opcion){
                case "a":
                    mostrarEspeciesAceptadas();
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
                    JOptionPane.showMessageDialog(null,"El progama ha finalizado", "Programa Finalizado", JOptionPane.INFORMATION_MESSAGE);
                    w=true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"La opcion no es valida","Error",JOptionPane.ERROR_MESSAGE);

            }

        }while(!w);
    }
    public static void mostrarEspeciesAceptadas(){
        JOptionPane.showMessageDialog(null,"Estos son los animales que se aceptan en la clinica: Perros, Gatos, Loros, Conejos, y Tortugas","Especies",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void añadirAnimalRescatado(){
        boolean w=false;
        String animal;
        String cuidador;
        do {
            try{
                animal=JOptionPane.showInputDialog("Introduce el nombre del animal: ","Animal");
                animal=animal.toLowerCase();
                validarAnimal(animal, w);
                if(w==false){
                    JOptionPane.showMessageDialog(null, "");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void validarAnimal(String Animal, boolean w){
        for(int i=0;i< animalesAceptados.length();i++){
            if(animalesAceptados[i].equals(Animal)){
                w=true;
                return;
            }

        }
    }
}