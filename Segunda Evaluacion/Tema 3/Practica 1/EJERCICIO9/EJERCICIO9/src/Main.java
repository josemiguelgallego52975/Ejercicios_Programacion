import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int[][][] grados;
    private static int ciudades, dias;
    public static void main(String[] args) {
       try{
           solicitarCiudades();
           solicitarDias();
           solicitarGrados();
           mostrarMediaDia();

       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }

    public static void solicitarCiudades(){
        boolean w=false;
        do {
            try{
                ciudades=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ciudades :"));
                if(ciudades<0){
                    throw  new NumberFormatException("El numero de ciudades no puede ser negativo");
                }
                w=true;

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
    }

    public static void solicitarDias(){
        boolean w=false;
        do {
            try{
                dias=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de dias :"));
                if(dias<0){
                    throw  new NumberFormatException("El numero de dias no puede ser negativo");
                }
                w=true;

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!w);
        grados=new int [ciudades][dias][3];
    }

    public static void solicitarGrados(){
        boolean w=false;
        double numeros,mediaCiudad,suma=0;
        for (int x=0; x<ciudades; x++) {
            for (int y=0; y<dias; y++) {
                for (int z=0; z<3; z++) {
                    do {
                        try{

                            numeros=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de grados que hacia en la ciudad "+(x+1)+" y en el dia :"+(y+1)));
                            suma=suma+numeros;
                            numeros=grados[x][y][z];
                            w=true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }while(!w);
                }

            }
            suma=suma/3;
            suma=suma/dias;
            mediaCiudad=suma/ciudades;
            JOptionPane.showMessageDialog(null, "La media de los grados es: "+mediaCiudad+ " en la ciudad: "+(x+1));
        }

    }

    public static void mostrarMediaDia(){
        int numeros, mediaDias,suma=0;
        for (int x=0; x<dias ; x++) {
            for (int y=0; y<ciudades; y++) {
                for (int z=0; z<3; z++) {
                    numeros=grados[x][y][z];
                    suma=suma+numeros;
                }

            }
            suma=suma/3;
            suma=suma/ciudades;
            mediaDias=suma/dias;
            JOptionPane.showMessageDialog(null, "La media de los grados es: "+mediaDias+ " del dia: "+(x+1));
        }
    }

}


