package Controlador;

import DAO.CuentaDAO;
import Modelo.Cuenta;

import java.util.List;

public class CuentaController {
    public static void crearCuenta(String iban, Double saldo){
        Cuenta cuenta = new Cuenta(iban, saldo);
        CuentaDAO.crearCuenta(cuenta);

    }
    public static String borrarCuenta(String iban){
        return CuentaDAO.borrarCuenta(iban);
    }

    public static void modificarCuenta(String iban, Double saldo){
        Cuenta c = CuentaDAO.buscarCuentaPorId(iban);
        if (c != null) {
            c.setSaldo(saldo);
            CuentaDAO.modificarCuenta(c);
        }
    }

    public static Cuenta buscarPorIban(String iban) {
        return CuentaDAO.buscarCuentaPorId(iban);
    }
    public static StringBuilder listarTodasLasCuentas() {
        List<Cuenta> lista = CuentaDAO.listarCuentas();
        StringBuilder sb = new StringBuilder();
        for (Cuenta c : lista) {
            sb.append("IBAN: ").append(c.getIban())
                    .append(" | Saldo: ").append(c.getSaldo()).append("\n");
        }
        return sb;
    }

}
