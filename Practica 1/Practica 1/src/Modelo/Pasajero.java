package Modelo;

public class Pasajero {
    private static String dni;
    private static String nombre;
    private static String numero;
    private static String codVuelo;

    public static String getDni() {
        return dni;
    }

    public static void setDni(String dni) {
        Pasajero.dni = dni;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Pasajero.nombre = nombre;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        Pasajero.numero = numero;
    }

    public static String getCodVuelo() {
        return codVuelo;
    }

    public static void setCodVuelo(String codVuelo) {
        Pasajero.codVuelo = codVuelo;
    }

    public Pasajero() {}

    public Pasajero (String dni, String numero){
        this.dni = dni;
        this.numero = numero;
    }

    public Pasajero(String dni, String nombre, String numero, String codVuelo) {
        this.dni = dni;
        this.nombre = nombre;
        this.numero = numero;
        this.codVuelo = codVuelo;
    }
}
