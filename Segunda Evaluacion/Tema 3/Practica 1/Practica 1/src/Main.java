import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int cuantosNumeroAleatorio;
    public static void main(String[] args) {
        /* Ejercicio 1
        double[] numero;
        numero = new double[10];
        for (int i = 0; i < numero.length; i++) {

            String numeros= JOptionPane.showInputDialog("Introduce el número " + (i + 1) + ":");
            numero[i] = Double.parseDouble(numeros);
        }

        double maximo = numero[0];
        double minimo = numero[0];
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] > maximo) {
                maximo = numero[i];
            }
            if (numero[i] < minimo) {
                minimo = numero[i];
            }
        }

        JOptionPane.showMessageDialog(null, "El numero es mas grande es: " + maximo + " y el mas pequeño es: "+minimo+".");
    */
    //Ejercicio 2

        String cuantosNumeros;

        boolean w=false;
        do {
            cuantosNumeros=JOptionPane.showInputDialog("Intoduzca cuantos numeros quieres que se generen.");
            Pattern pat = Pattern.compile("^[1-9][0-9]{1,50}$ || ^[1-9]$");
            Matcher m = pat.matcher(cuantosNumeros);
            if (m.matches()) {
                cuantosNumeroAleatorio=Integer.parseInt(cuantosNumeros);
                w=true;
            }
        }while(!w);

        double numeroAleatorio[]= new double[cuantosNumeroAleatorio];

        for (int i = 0; i < numeroAleatorio.length; i++) {

            String numeros= JOptionPane.showInputDialog("Introduce el número " + (i + 1) + ":");

        }

    }

}