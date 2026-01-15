import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        double radio=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el radio del circunferencia"));
        Circunferencia c =new Circunferencia(radio);
        JOptionPane.showMessageDialog(null,"La longuitud de la circunferencia es: "+c.calcularRadio());
        JOptionPane.showMessageDialog(null,"El area de la circunferencia es: "+c.calcularArea());
        JOptionPane.showMessageDialog(null,"El volumen de la circunferencia es: "+c.calcularVolume());
    }
}