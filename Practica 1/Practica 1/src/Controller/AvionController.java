package Controller;

import DAO.AvionDAO;
import Modelo.Avion;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvionController {
    private static AvionDAO avionDAO;

    public AvionController(){
        avionDAO = new AvionDAO();
    }

    public static void crearAvion(String codVuelo, LocalDate fechaSalida, String destino, String procedencia){
        Avion avion= new Avion(codVuelo, fechaSalida, destino, procedencia);
        avionDAO.insertar(avion);
    }

    public static boolean modificarVuelo(String codVuelo, LocalDate fechaSalidaNueva) throws Exception {
        Avion avion= new Avion(codVuelo.toUpperCase(), fechaSalidaNueva);
        return avionDAO.modificarVuelo(avion);
    }

    public static boolean borrarAvion(String codVuelo) throws Exception {
        return avionDAO.borrarCodVuelo(codVuelo);
    }

    public static String buscarPorCodigo(String codVuelo) throws Exception {
        List<Avion> lista=AvionDAO.buscarPorCodigo(codVuelo);
        String codigo;
        for (int i=0; i<lista.size();i++) {
            codigo="-----DATOS VUELO-----\n Codigo de Vuelo: "+lista.get(i).getCodVuelo()+
                    "\nFecha de Salida: "+lista.get(i).getFechaSalida()+
                    "\nDestino: "+ lista.get(i).getDestino()+
                    "\nOrigen: "+lista.get(i).getProcedencia();

            return codigo;
        }
        return null;
    }

    public static String buscarPorDestino(String destino) throws Exception {
        List<Avion> lista=AvionDAO.buscarPorDestino(destino);
        String mensaje="-----VUELOS CON DESTINO "+destino.toUpperCase()+"-----";
        for (int i=0; i<lista.size();i++) {
            int e=0;
            e++;
            mensaje=mensaje+"\nVuelo "+e+": \nCodigo de Vuelo: "+lista.get(i).getCodVuelo()+"\nFecha de Salida: "+lista.get(i).getFechaSalida()+"\nProcedencia: "+lista.get(i).getProcedencia()+"\n-----------------------";
            if(e==lista.size()){return mensaje;}
        }
        return null;
    }

    public static String buscarPorOrigen(String destino) throws Exception {
        List<Avion> lista=AvionDAO.buscarPorOrigen(destino);
        String mensaje="-----VUELOS CON ORIGEN "+destino.toUpperCase()+"-----";
        for (int i=0; i<lista.size();i++) {
            int e=0;
            e++;
            mensaje=mensaje+"\nVuelo "+e+": \nCodigo de Vuelo: "+lista.get(i).getCodVuelo()+"\nFecha de Salida: "+lista.get(i).getFechaSalida()+"\nDestino: "+lista.get(i).getDestino()+"\n-----------------------";
            if(e==lista.size()){return mensaje;}
        }
        return null;
    }

    public static String buscarPorPasajero(String dni) throws Exception {
        List<Avion> lista=AvionDAO.buscarPorPasajero(dni);
        String mensaje;
        for (int i=0; i<lista.size();i++) {
            mensaje="-----VUELO DEL PASAJERO CON DNI "+dni+"-----\nCodigo de Vuelo: "+lista.get(i).getCodVuelo()+"\nFecha de Salida: "+lista.get(i).getFechaSalida()+"\nDestino: "+lista.get(i).getDestino()+"\nOrigen: "+lista.get(i).getProcedencia();
            return  mensaje;
        }
        return null;
    }

    public static String buscarPorFecha(LocalDate fechaSalida, String fecha) throws Exception {
        List<Avion> lista = AvionDAO.buscarPorFecha(fechaSalida);
        String mensaje="-----VUELOS EL DIA "+fecha+"-----" ;
        for (int i=0; i<lista.size();i++) {
            int e=0;e++;
            mensaje=mensaje+"\nVuelo "+e+": \nCodigo de Vuelo: "+lista.get(i).getCodVuelo()+ "\nDestino: "+lista.get(i).getDestino()+"\nOrigen: "+lista.get(i).getProcedencia()+"\n----------------";
            if(e==lista.size()){return mensaje;}
        }
        return null;
    }


}
