import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio_2 {
    private static int cuantosNumeroAleatorio;
    public static void ejercicio_2(String[] args) {
        //Ejercicio 2

        String cuantosNumeros;

        boolean w=false;
        do {
            cuantosNumeros= JOptionPane.showInputDialog("Intoduzca cuantos numeros quieres que se generen.");
            Pattern pat = Pattern.compile("^[1-9][0-9]{1,50}$ || ^[1-9]$");
            Matcher m = pat.matcher(cuantosNumeros);
            if (m.matches()) {
                cuantosNumeroAleatorio=Integer.parseInt(cuantosNumeros);
                w=true;
            }
        }while(!w);

        double numeroAleatorio[]= new double[cuantosNumeroAleatorio];

        for (int i = 0; i < numeroAleatorio.length; i++){
            String numeros = JOptionPane.showInputDialog("Introduce el número " + (i + 1) + ":");
        }
    }

}
