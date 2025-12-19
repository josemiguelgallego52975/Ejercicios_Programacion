import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String[] meses = {
                "enero", "febrero", "marzo", "abril", "mayo", "junio",
                "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };

        boolean correcto = false; // Solo usamos para controlar el bucle

        do {
            String mesUsuario = JOptionPane.showInputDialog(
                    null,
                    "Introduce un mes en letra:"
            );

            if (mesUsuario == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            mesUsuario = mesUsuario.toLowerCase().trim();

            try {
                boolean encontrado = false;

                for (String mes : meses) {
                    if (mes.equals(mesUsuario)) {
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    throw new Exception("Mes no válido");
                }

                // Si llega aquí, es correcto
                correcto = true;
                JOptionPane.showMessageDialog(null, "¡Mes correcto!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            }

        } while (!correcto);




    }
}