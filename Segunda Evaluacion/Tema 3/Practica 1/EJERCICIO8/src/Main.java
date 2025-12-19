import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int alumnos, asignaturas;
    private static int array [][];

    public static void main(String[] args) {
        solicitarAlumnos();
    }

    public static void solicitarAlumnos() {
        boolean w=false;
        do {
            try {
                alumnos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de alumnos:"));

                if (alumnos < 0) {
                    throw  new NumberFormatException();
                }

                w=true;

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "El numero debe de ser mayor que 0 y debe de estar en digitos enteros(7, 4, 8   7.5 estaria mal)");
            }
        }while(!w);

        solicitarAsignaturas();
    }

    public static void solicitarAsignaturas() {
        boolean w=false;
        do {
            try {

                asignaturas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de asignaturas:"));
                if (asignaturas < 0) {
                    throw  new NumberFormatException();
                }
                w=true;

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "El numero debe de ser mayor que 0 y debe de estar en digitos");
            }
        }while(!w);
        array =new int[alumnos][asignaturas];
        solicitarNotas();
    }

    public static void solicitarNotas() {
        boolean w=false;
        int notaAlta=0;
        int notaBaja=10;
        int suma = 0;
        int media;
        for (int x = 0; x < alumnos; x++) {
            for (int y = 0; y < asignaturas; y++) {
                do{
                    try{
                        int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce las nota del alumno: "+x+"de la asignatura: "+y));

                        if (numero<0 || numero>10){
                            throw new NumberFormatException();
                        }
                        w=true;
                        if(numero<notaBaja){notaBaja=numero;}
                        if (notaAlta<numero){notaAlta=numero;}

                        suma=suma+numero;

                        array[x][y] = numero;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: entrada no válida, la nota debe ser mayor que 0 y menor que 10, y estar en digito");
                    }
                }while(!w);


            }
            media=suma/asignaturas;
            JOptionPane.showMessageDialog(null, "La media del alumno "+x+" es: "+media);
        }
    }

    public static void mostrarMediasDeAsignaturasYNotaAltaBaja(int notaAlta, int notaBaja) {
        int media=0;
        int suma=0;
        for (int x = 0; x < asignaturas; x++) {
            for (int y = 0; y < alumnos; y++) {
                suma=suma+array[x][y];
            }
            media=suma/alumnos;
            JOptionPane.showMessageDialog(null, "La media de la asignatura "+x+" es: "+media);
        }

        JOptionPane.showMessageDialog(null, "La nota mas alta a sido de : "+notaAlta+" y la mas baja a sido de: "+notaBaja);


    }


}