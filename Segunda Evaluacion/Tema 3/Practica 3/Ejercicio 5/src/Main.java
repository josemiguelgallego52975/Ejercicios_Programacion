
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String [] meses;
    private static Map<String,Map<Integer,Double>> gastos;
    private static int totalGastado=0;
    private static boolean w;
    public static void main(String[] args) {
     try {
         solicitarFunciones();
         solicitarMeses();
     }catch (Exception e){
         JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
     }
    }
    public static void solicitarFunciones(){
        gastos = new HashMap<>();
        meses= new String[]{"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre"
                ,"octubre","noviembre","diciembre"};
    }
    public static void solicitarMeses(){
        String mes;


        do {
            w=false;
            do {
                mes=JOptionPane.showInputDialog("Ingrese el mes en que a tenido gastos: ");
                mes=mes.toLowerCase();
                validarMes(mes, w);
                if(w==false){
                    JOptionPane.showMessageDialog(null,"El mes que ha metido es incorrecto, no existe","Error",JOptionPane.ERROR_MESSAGE);
                }
            }while(!w);
        }
    }
    public static void validarMes(String mes, boolean w){
        for(int i=0;i<meses.length;i++){
            if(meses[i].equals(mes)){
                w =true;
            }
        }
    }

}