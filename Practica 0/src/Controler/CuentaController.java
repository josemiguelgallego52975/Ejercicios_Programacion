package Controler;

import Dao.CuentaDAO;
import Modelo.Cuenta;
import Modelo.Titular;

import java.util.List;

public class CuentaController {
    private CuentaDAO cuentaDAO;
    public CuentaController(){
        cuentaDAO = new CuentaDAO();
    }
    public void crearTitular(String iban, double saldo) {
        Cuenta cuenta = new Cuenta(iban, saldo);
        cuentaDAO.insertarCuenta(cuenta);
    }

    public int borrarTitular(int id) throws Exception{
        // Implementar método para borrar titular por ID
        return cuentaDAO.borrarCuenta(id);
    }

    public void modificarCuenta(Cuenta cuenta, String nuevoNombre) {
        // Implementar método para modificar titular por ID
        cuenta.setIban(nuevoNombre);
        cuentaDAO.modificar(cuenta);
    }

    public List<Cuenta> listarCuenta() {

        return cuentaDAO.listarTodos();
    }

    public StringBuilder listarCuenta1()
    {
        // Más puro
        List<Cuenta> lista = cuentaDAO.listarTodos();
        StringBuilder sb = new StringBuilder();
        for (Cuenta t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public StringBuilder buscarPorIban(String iban)
    {
        // Más puro
        Cuenta lista = cuentaDAO.buscarPorIban(iban);
        StringBuilder sb = new StringBuilder();
        for (Cuenta t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public Cuenta buscarPorId(int id) {

        return cuentaDAO.buscarPorId(id);
        // return titularDAO.buscarPorId(id).toString();
    }
}
