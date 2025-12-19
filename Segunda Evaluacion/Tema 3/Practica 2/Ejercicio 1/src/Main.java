import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int continuar;
    public static void main(String[] args) {

        ArrayList<Double> lista = new ArrayList<>();
        do {
            try {
                double numero=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero que quiere añadir."));
                lista.add(numero);
                continuar= JOptionPane.showConfirmDialog(null, "Quiere continuar añadiendo numeros?","Continuar?",JOptionPane.YES_NO_OPTION);

            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(continuar== JOptionPane.YES_OPTION);
        menu(lista);

    }
    public static void menu(ArrayList<Double> lista) {
        String opcion;
        do {
            opcion=JOptionPane.showInputDialog("-----MENU-----\n" +
                    "a) Visualizar el valor maximo y el minimo\n" +
                    "b) Solicitar un numero y buscarlo. Muestra un mensaje indicando si lo has encontrado o no.\n" +
                    "c) Solicitar un numero, buscarlo y borrarlo. Sino se encuentra muestra un mensaje de error.\n" +
                    "d) Convertir el arrayList en un array.\n" +
                    "e) Si no esta vacio, mostrar el numero de elementos que contiene. ´\n" +
                    "f) Insertar un nuevo elemento por el final.\n" +
                    "g) Insertar un nuevo elemento en la posicion que te indique el usuario.\n" +
                    "h) Borrar un elemento de una posicion concreta. ´\n" +
                    "i) Calcular la suma y la media aritmetica de los valores contenidos. ´\n" +
                    "j) Finalizar."
            );
            opcion.toLowerCase();

            switch (opcion) {
                case "a" :
                    valorMaxMin(lista);
                    break;
                case "b" :
                    buscarNumeroIgual(lista);
                    break;
                case "c" :
                    borrarNumero(lista);
                    break;
                case "d" :
                    crearArray(lista);
                    break;
                case "e" :
                    ensenarLista(lista);
                    break;
                case "f" :
                    insertarElementoFinal(lista);
                    break;
                case "g" :
                    insertarElemento(lista);
                    break;
                case "h":
                    eliminarElemento(lista);
                    break;
                case "i" :
                    calcularMedia(lista);
                    break;
                case "j" :
                    JOptionPane.showMessageDialog(null,"El programa a finalizado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Introduce un opcion valida(solo la letra a, b, c ...)");
                    break;
            }

        }while(!opcion.equals("j"));
    }

    public static void valorMaxMin(ArrayList<Double> lista){
        double min= 100;
        double max= 0;
        for (int i = 0; i <lista.size(); i++) {
            if (min > lista.get(i)) {
                min = lista.get(i);
            }else if (max < lista.get(i)) {
                max = lista.get(i);
            }
        }
    }

    public static void buscarNumeroIgual(ArrayList<Double> lista){
        double buscar= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero que quiere buscar?"));

        if(lista.contains(buscar)){
            JOptionPane.showMessageDialog(null, "El numero que habia indicado si estaba");
        }else {
            JOptionPane.showMessageDialog(null ,"El numero que habia indicado no estaba");
        }
    }

    public static void borrarNumero(ArrayList<Double> lista){
        double buscar= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero que quiere borrar?"));

        if(lista.contains(buscar)){
            lista.remove(buscar);
            JOptionPane.showMessageDialog(null, "El numero que habia indicado ha sido borrado.");

        }else {
            JOptionPane.showMessageDialog(null ,"El numero que habia indicado no estaba");
        }
    }

    public static void crearArray(ArrayList<Double> lista){
        double array []= new double[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            array[i] = lista.get(i);
        }

        JOptionPane.showMessageDialog(null, "El array a sido creado correctamente");
    }

    public static void ensenarLista(ArrayList<Double> lista){
        for (int i = 0; i < lista.size(); i++) {
            JOptionPane.showMessageDialog(null, "El numero en la posicion "+(1+i)+" es "+lista.get(i));
        }
    }

    public static void insertarElementoFinal(ArrayList<Double> lista){
        try {
            double numero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero que quiere insertar"));
            lista.add((lista.size()+1), numero);
            JOptionPane.showMessageDialog(null, "Se ha añadido correctamente");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void insertarElemento(ArrayList<Double> lista){

        try {
            double numero;
            int posicion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del numero que quiere insertar"));
            if (posicion > lista.size()) {
                JOptionPane.showMessageDialog(null, "La posicion que a indicado no esta disponible ya que es mayor al tamaño de la lista");
            }else if(posicion < 0){
                JOptionPane.showMessageDialog(null, "El numero no pude ser negativo");
            }else {
                numero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero que quiere insertar"));
                lista.add(posicion, numero);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void eliminarElemento(ArrayList<Double> lista){

        try{
            int posicion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del numero que quiere borrar"));
            if (posicion > lista.size()) {
                JOptionPane.showMessageDialog(null, "La posicion que a indicado no esta disponible ya que es mayor al tamaño de la lista");
            }else if(posicion < 0){
                JOptionPane.showMessageDialog(null, "El numero no pude ser negativo");
            }else{
                lista.remove(posicion);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void calcularMedia(ArrayList<Double> lista){

        double  media=0;
        double numero, suma=0;

        for (int i = 0; i < lista.size(); i++) {
            numero=lista.get(i);
            suma=numero+suma;
        }
        media = suma/lista.size();
        JOptionPane.showMessageDialog(null, "El media es: "+media);
    }
}