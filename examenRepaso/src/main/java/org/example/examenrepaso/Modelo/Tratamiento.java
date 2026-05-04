package org.example.examenrepaso.Modelo;

public class Tratamiento {
    private int idTratamiento;
    private String descripcion;
    private float precio;
    private int duracion;

    public Tratamiento(int idTratamiento, String descripcion, float precio, int duracion) {
        this.idTratamiento = idTratamiento;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
    }
    public int getIdTratamiento() {
        return idTratamiento;
    }
    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
