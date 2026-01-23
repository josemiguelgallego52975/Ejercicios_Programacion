package Model;

import java.time.LocalDate;

public class Mascota {
    private String raza;
    private String nombre;
    private String fechaNacimiento;
    private String peso;
    private String sexo;
    private String longitud;
    private String color;


    private Cliente duenno;
    private Veterinario v;

    public Mascota(String raza, String nombre, String fechaNacimiento, String peso, String sexo, String longitud, String color) {
        this.raza = raza;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.sexo = sexo;
        this.longitud = longitud;
        this.color = color;
    }
}
