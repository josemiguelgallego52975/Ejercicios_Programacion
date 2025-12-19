import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] matriz = new int [4][4];
        solicitarMatriz(matriz);

    }

    private static void solicitarMatriz(int[][] matriz) {
        boolean w=false;
        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[y].length; x++) {
                do{
                    try{
                        String numero=JOptionPane.showInputDialog("Introduce los digitos de la matirz (4x4) uno a uno");
                        Pattern pat = Pattern.compile("^[0-9]{1,}$");
                        Matcher mat = pat.matcher(numero);
                        if (!mat.matches()){
                            throw new Exception();
                        }
                        w=true;

                        matriz[x][y] = Integer.parseInt(numero);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: entrada no válida");
                    }
                }while(!w);


            }
        }
    }

    private static void mostrarMenu() {

    }
}