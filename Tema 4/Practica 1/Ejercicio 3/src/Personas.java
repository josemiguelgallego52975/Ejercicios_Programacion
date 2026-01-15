import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Personas {
    String nombre;
    int dia;
    int mes;
    int año;
    String direccion;
    int codigoPostal;
    String ciudad;
    LocalDate fechaNacimiento;
    LocalDate ahora;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Personas() {
    }

    public Personas(String nombre, int dia, int mes, int año, String direccion, int codigoPostal, String ciudad) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public int calcularEdad(){
        fechaNacimiento= LocalDate.of(dia,mes,año);
        ahora = LocalDate.now();

        Period period = Period.between(fechaNacimiento,ahora);
        return period.getYears();
    }

}
