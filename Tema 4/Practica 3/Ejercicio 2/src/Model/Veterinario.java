package Model;

public class Veterinario extends Persona {
    private String dni;
    private int numSeg;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumSeg() {
        return numSeg;
    }

    public void setNumSeg(int numSeg) {
        this.numSeg = numSeg;
    }

    public Veterinario(String nombre, String direccion, String telefono, String dni, int numSeg) {
        super(nombre, direccion, telefono);
        this.dni = dni;
        this.numSeg = numSeg;
    }
}
