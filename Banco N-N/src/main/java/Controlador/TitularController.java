package Controlador;

import DAO.TitularDAO;
import Modelo.Titular;

import java.util.List;

public class TitularController {
    public static void crearTitular(String nombre,String dni) {
        Titular titular = new Titular(dni, nombre);
        TitularDAO.insertarTitular(titular);
    }
    public static Titular buscarTitularPorDni(String dni) {
        return TitularDAO.buscarTitularPorDni(dni);
    }

    public static void modificarTitular(Titular titular, String nuevoNombre) {

        titular.setNombre(nuevoNombre);
        TitularDAO.modificarTitular(titular);
    }

    public static void borrarTitular(int id) throws Exception{

        TitularDAO.borrarTitular(id);
    }

    public static StringBuilder listarTitulares() {
        List<Titular> lista = TitularDAO.listarTitular();
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public static StringBuilder buscarTitularPorNombre(String nombre)
    {
        List<Titular> lista = TitularDAO.buscarTitularPorNombre(nombre);
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public static String buscarPorId(int id) {
        Titular t = TitularDAO.buscarTitularPorId(id);
        if (t == null) {
            return "No se encontró el titular con ID: " + id;
        }
        return t.toString();
    }
}
