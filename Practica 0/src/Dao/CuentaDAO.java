package Dao;

import Modelo.Cuenta;
import Utilidades.BDConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {
    public void insertarCuenta(Cuenta cuenta) {
        String sql = "INSERT INTO cuentas (iban, saldo) VALUES (?, ?)";

        try
        {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cuenta.getIban());
            ps.setDouble(2, cuenta.getSaldo());
            ps.executeUpdate();

            /*
                Mensaje para nosotros. No para el usuario final.
                En un proyecto real, esto se manejaría con logs o se mostraría en la interfaz de usuario.
             */

            JOptionPane.showMessageDialog(null, " (DAO)Cuenta insertada correctamente.");
            BDConnection.closeConnection();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO)Error al insertar cuenta: " + e.getMessage());
        }
    }

    public int borrarCuenta(int id) throws Exception{
        String sql = "DELETE FROM cuentas WHERE ID = ?";

        int n=0;
        try
        {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            n = ps.executeUpdate();

            if (n != 1) {
                JOptionPane.showMessageDialog(null," (DAO) Cuenta no borrada.");
                // Mensaje para el usuario
                throw new Exception(" No se encontró ninguna cuenta con el ID proporcionado.");
            }
            else
            {
                JOptionPane.showMessageDialog(null," (DAO) Cuenta borrada correctamente.");
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO) Error al borrar cuenta: " + e.getMessage());
        }
        finally
        {
            BDConnection.closeConnection();
            return n;
        }
    }

    public Cuenta buscarPorId(int id) {
        String sql = "SELECT * FROM cuentas WHERE id = ?";

        try {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cuenta(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                );
            }
            BDConnection.closeConnection();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, " (DAO) Error al buscar cuenta: " + e.getMessage());
        }

        return null;
    }

    public Cuenta buscarPorIban(String iban) {
        String sql = "SELECT * FROM cuentas WHERE iban = ?";

        try {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cuenta(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                );
            }
            BDConnection.closeConnection();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO) Error al buscar cuenta por iban: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Cuenta> buscarPorSaldo(Double saldo) {
        String sql = "SELECT * FROM cuentas WHERE saldo = ?";

        try {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, saldo);
            ResultSet rs = ps.executeQuery();

            ArrayList<Cuenta> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(new Cuenta(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                ));
            }

            BDConnection.closeConnection();
            return lista;

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"(DAO) Error al buscar cuentas por saldo: " + e.getMessage());
        }

        return null;
    }

    public void modificar(Cuenta cuenta)  {
        String sql = "UPDATE cuentas SET iban = ? WHERE id = ?";

        try
        {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, Cuenta.getIban());
            ps.setInt(2, Cuenta.getId());
            int n = ps.executeUpdate();

            JOptionPane.showMessageDialog(null," (DAO) Cuenta modificada correctamente.");

            BDConnection.closeConnection();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO) Error al modificar la cuenta: " + e.getMessage());
        }
    }

    public List<Cuenta> listarTodos() {
        List<Cuenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM cuentas";

        try (Connection conn = BDConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Cuenta(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                ));
            }

            BDConnection.closeConnection();

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null," (DAO) Error al listar cuentas: " + e.getMessage());
        }

        return lista;
    }
}
