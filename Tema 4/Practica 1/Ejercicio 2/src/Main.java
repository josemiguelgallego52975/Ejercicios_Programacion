import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Crea una agenda con los datos de los alumnos de clase. De cada
        alumno guarda su codigo, nombre, domicilio y tel ´ efono. Una vez ´
        introducido sus datos, se visualizaran los datos del alumno que co- ´
        rresponda con un codigo tecleado.*/
        boolean w = false;

        do {
            try {
                int codigo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del alumno (solo pude introduccir numeros)"));

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }
}