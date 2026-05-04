package org.example.examenrepaso.Modelo;

import java.time.LocalDate;

public class Cita {
        private LocalDate fecha;
        private String hora;
        private int idTratamiento;
        private String dniPaciente;

        public LocalDate getFecha() {
            return fecha;
        }
        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }
        public String getHora() {
            return hora;
        }
        public void setHora(String hora) {
            this.hora = hora;
        }
        public int getIdTratamiento() {
            return idTratamiento;
        }
        public void setIdTratamiento(int idTratamiento) {
            this.idTratamiento = idTratamiento;
        }
        public String getDniPaciente() {
            return dniPaciente;
        }
        public void setDniPaciente(String dniPaciente) {
            this.dniPaciente = dniPaciente;
        }

    public Cita(LocalDate fecha, String hora, int idTratamiento, String dniPaciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.idTratamiento = idTratamiento;
        this.dniPaciente = dniPaciente;
    }
}
