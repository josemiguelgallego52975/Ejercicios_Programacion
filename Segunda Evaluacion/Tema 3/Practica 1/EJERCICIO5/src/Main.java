import javax.swing.*;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        // Pedir texto
        String texto = JOptionPane.showInputDialog("Introduce un texto:");



        texto = texto.toLowerCase();

        // Array para contar letras a-z (26) + ñ (posición 26)
        int[] contador = new int[27];

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'a' && c <= 'z') {
                // posición 0 = a, 1 = b, 2 = c…
                contador[c - 'a']++;
            } else if (c == 'ñ') {
                contador[26]++; // ñ la guardamos en la última posición
            }
        }

        // Construimos el mensaje
        StringBuilder resultado = new StringBuilder("Recuento de letras:\n\n");

        for (int i = 0; i < 26; i++) {
            if (contador[i] > 0) {
                resultado.append((char) ('a' + i))
                        .append(" : ")
                        .append(contador[i])
                        .append("\n");
            }
        }

        // Mostrar ñ si aparece
        if (contador[26] > 0) {
            resultado.append("ñ : ").append(contador[26]).append("\n");
        }

        // Mostrar ventana final
        JOptionPane.showMessageDialog(null, resultado.toString());*/


        //Echo por el profesor falta el final

        try {
            char[] alfabeto={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            int[] tcont = new int[26];

//            for (int i = 0; i < 26; i++) {
//                JOptionPane.showMessageDialog(null, 'a' +i);
//            }

            inicialContador(tcont);
            entradaDatos(alfabeto, tcont);
        }catch (Exception e) {}

    }

    private static void inicialContador(int[] tcont) {
        Arrays.fill(tcont, 0);
    }

    private static void entradaDatos(char[] alfabeto, int[] tcont) throws Exception {
        int y;
        String texto=JOptionPane.showInputDialog(null,"Ingrese el texto").toLowerCase();

        for (int x = 0; x < alfabeto.length; x++) {
            y = Arrays.binarySearch(alfabeto, texto.charAt(x));
            if (y != -1) {
                tcont[y]=tcont[y]+1;
            }
        }
    }

    private static void salidaDatos(char[] alfabeto, int[] tcont) throws Exception {

        StringBuilder resultados = new StringBuilder();
        for (int x = 0; x < tcont.length; x++) {
            if (tcont[x] != 0) {
                resultados.append(alfabeto[x]).append(" - ").append(tcont[x]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, "La frecuencia de las letras es: \n\n"+resultados);

        Arrays.stream(tcont).filter(x->x!=0).forEach(y->{});

    }
}