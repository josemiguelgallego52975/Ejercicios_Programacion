import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<String> listaAlumnos= new ArrayList<>();
    private static ArrayList<String> listaasignaturas = new ArrayList<>();
    private static ArrayList<Double> notas;
    private static int opcion;
    private static double sumaProg, contadorProg, mediaProg=0;
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Vamos a recopilar todas las notas de los alumnos de 141ga en sus asignaturas");
        solicitarSiHayMasAlumnos();
    }

    public static void solicitarSiHayMasAlumnos() {
        boolean w=false;
        do {

            if (listaAlumnos.size() == 0) {
                do {
                    try {
                        String alumno= JOptionPane.showInputDialog("Debe introducir el nombre del alumno");
                        Pattern pat = Pattern.compile("^[A-Z][a-z]{1,}$");
                        Matcher mat = pat.matcher(alumno);
                        if (!mat.matches()) {
                            throw new Exception("El nombre es incorrecto, La primera debe de ser mayuscula y las demas minusculas");
                        }
                        listaAlumnos.add(0, alumno);
                        w=true;

                    }catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Debe introducir el nombre");
                    }
                }while (!w);
            }else {
                opcion = JOptionPane.showConfirmDialog(null, "Quiere continuar añadiendo alumnos?", "Continuar?", JOptionPane.YES_NO_OPTION);
            }

        }while (opcion==JOptionPane.NO_OPTION);
    }

    public static void solicitarAsignaturas() {
        solicitarProgramacion();
        solicitarEd();
        solicitarBd();
        solicitarIpei();
        solicitarSos();
        solicitarIngles();
        solicitarLm();
        solicitarDigi();
    }
    public static void solicitarProgramacion() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene programacion?", "Programacion", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    contadorProg ++;
                    listaasignaturas.add(0, "Programacion");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en programacion?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    sumaProg=nota+sumaProg;
                    w=true;
                }else  if (si==JOptionPane.NO_OPTION){
                    w=true;
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);


    }
    public static void solicitarEd() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene Ed?", "Ed", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    listaasignaturas.add(0, "Ed");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en ED?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    w=true;
                }else if (si==JOptionPane.NO_OPTION) {
                    w=true;
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);

    }
    public static void solicitarBd() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene Bd?", "Bd", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    listaasignaturas.add(0, "Bd");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en BD?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    w=true;
                }else  if (si==JOptionPane.NO_OPTION){
                    w=true;
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }
    public static void solicitarIpei() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene Ipei?", "Ipei", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    listaasignaturas.add(0, "Ipei");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en Ipei?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    w=true;
                } else if (si==JOptionPane.NO_OPTION) {
                    w=true;
                }

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }
    public static void solicitarSos() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene Sos?", "Sos", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    listaasignaturas.add(0, "Sos");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en Sos?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    w=true;
                } else if (si==JOptionPane.NO_OPTION) {
                    w=true;
                }

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }
    public static void solicitarIngles() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene Ingles?", "Ingles", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    listaasignaturas.add(0, "Ingles");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en Ingles?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    w=true;
                } else if (si==JOptionPane.NO_OPTION) {
                    w=true;
                }

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }
    public static void solicitarLm() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene Lm?", "LM", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    listaasignaturas.add(0, "Lm");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en Lm?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    w=true;
                } else if (si==JOptionPane.NO_OPTION) {
                    w=true;
                }

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }
    public static void solicitarDigi() {
        boolean w=false;
        do {
            try {
                int si=JOptionPane.showConfirmDialog(null, "El alumno "+listaAlumnos.get(0)+" tiene Digi?", "Digi", JOptionPane.YES_NO_OPTION);
                if (si==JOptionPane.YES_OPTION) {
                    listaasignaturas.add(0, "Digi");
                    double nota=Double.parseDouble(JOptionPane.showInputDialog("Cual es la nota del alumno en Digi?"));
                    if (nota<0 || nota>10) {
                        throw new NumberFormatException("La nota puede ser negativa ni mayor que 10 ");
                    }
                    notas.add(0, nota);
                    w=true;
                } else if (si==JOptionPane.NO_OPTION) {
                    w=true;
                }

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (!w);
    }
    public static void mostrarMedias() {
        for (int i = 0; i < listaAlumnos.size(); i++) {
            for (int j = 0; j < listaasignaturas.size(); j++) {

            }
        }
    }
}