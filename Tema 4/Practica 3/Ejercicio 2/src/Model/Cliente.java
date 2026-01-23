package Model;

public class Cliente extends Persona {
    Mascota mascota;

    public Cliente(String nombre, String direccion, String telefono, Mascota mascota) {
        super(nombre, direccion, telefono);
        this.mascota = mascota;
    }
}
