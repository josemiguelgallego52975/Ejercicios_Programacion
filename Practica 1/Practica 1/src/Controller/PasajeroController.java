package Controller;

import DAO.PasajeroDAO;
import Modelo.Pasajero;

import java.util.List;

public class PasajeroController {
    public static void crearPasajero(String dni, String nombre, String numero, String codVuelo) throws Exception {
        Pasajero pasajero = new Pasajero(dni, nombre, numero, codVuelo);
        PasajeroDAO.crearPasajero(pasajero);
    }

    public static boolean buscarCodVuelo(String codVuelo) throws Exception {
        return PasajeroDAO.buscarCodVuelo(codVuelo);
    }

    public static void borrarPasajero(String dni) throws Exception {
        PasajeroDAO.borrarPasajero(dni);
    }

    public static void modificarPasajero(String dni, String numero) throws Exception {
        Pasajero pasajero = new Pasajero(dni, numero);
        PasajeroDAO.modificarPasajero(pasajero);
    }

    public static String buscarPorDni(String dni) throws Exception {
        List<Pasajero> lista = PasajeroDAO.buscarPorDni(dni);
        String mensaje;
        for (int i = 0; i < lista.size(); i++) {
            mensaje="-----DATOS PASAJERO-----\nDni: "+lista.get(i).getDni()+"\nNombre: "+lista.get(i).getNombre()+"\nNumero: "+lista.get(i).getNumero()+"\nCodVuelo: "+lista.get(i).getCodVuelo();
            return mensaje;
        }
        return null;
    }

    public static String mostrarPasajeroVuelo(String codVuelo) throws Exception {
        List<Pasajero> lista=PasajeroDAO.buscarPorCodigo(codVuelo);
        String mensaje="-----PASAJEROS DEL VUELO "+codVuelo.toUpperCase()+"-----\n";
        for (int i = 0; i < lista.size(); i++) {
            int e=0;e++;
            mensaje = mensaje + "Pasajero "+e+":\nDni: "+lista.get(i).getDni()+"\nNombre: "+ lista.get(i).getNombre()+"\nTelefono: "+ lista.get(i).getNumero()+"\n---------------";
            if(e==lista.size()){return mensaje;}
        }
        return null;
    }

}
