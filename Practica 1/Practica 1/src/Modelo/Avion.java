package Modelo;

import java.time.LocalDate;

public class Avion {
    private static String codVuelo;
    private static LocalDate fechaSalida;
    private static String destino;
    private static String procedencia;

    public static String getCodVuelo() {
        return codVuelo;
    }

    public static void setCodVuelo(String codVuelo) {
        Avion.codVuelo = codVuelo;
    }

    public static LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public static void setFechaSalida(LocalDate fechaSalida) {
        Avion.fechaSalida = fechaSalida;
    }

    public static String getDestino() {
        return destino;
    }

    public static void setDestino(String destino) {
        Avion.destino = destino;
    }

    public static String getProcedencia() {
        return procedencia;
    }

    public static void setProcedencia(String procedencia) {
        Avion.procedencia = procedencia;
    }

    public Avion(String codCVuelo, String destino) {
        this.codVuelo = codVuelo;
        this.destino = destino;
    }

    public Avion(String codVuelo, LocalDate fechaSalida) {
        this.codVuelo = codVuelo;
        this.fechaSalida = fechaSalida;
    }

    public Avion(String codVuelo, LocalDate fechaSalida, String destino, String procedencia) {
        this.codVuelo = codVuelo;
        this.fechaSalida = fechaSalida;
        this.destino = destino;
        this.procedencia = procedencia;
    }
}
