package Dao;

import Utilidades.BDConnection;
import Modelo.*;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitularDAO {

    public void insertar(Titular titular) {
        String sql = "INSERT INTO titulares (dni, nombre) VALUES (?, ?)";

        try
        {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titular.getDni());
            ps.setString(2, titular.getNombre());
            ps.executeUpdate();

            /*
                Mensaje para nosotros. No para el usuario final.
                En un proyecto real, esto se manejaría con logs o se mostraría en la interfaz de usuario.
             */

            JOptionPane.showMessageDialog(null, " (DAO)Titular insertado correctamente.");
            BDConnection.closeConnection();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO)Error al insertar titular: " + e.getMessage());
        }
    }

    public int borrar(int id) throws Exception{
        String sql = "DELETE FROM titulares WHERE ID = ?";

        int n=0;
        try
        {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            n = ps.executeUpdate();

            if (n != 1) {
                JOptionPane.showMessageDialog(null," (DAO) Titular no borrado.");
                // Mensaje para el usuario
                throw new Exception(" No se encontró ningún titular con el ID proporcionado.");
            }
            else
            {
                JOptionPane.showMessageDialog(null," (DAO) Titular borrado correctamente.");
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO) Error al borrar titular: " + e.getMessage());
        }
        finally
        {
            BDConnection.closeConnection();
            return n;
        }
    }

    public Titular buscarPorId(int id) {
        String sql = "SELECT * FROM titulares WHERE id = ?";

        try {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
            }
            BDConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar titular: " + e.getMessage());
        }

        return null;
    }

    public Titular  buscarPorDni(String dni) {
        String sql = "SELECT * FROM titulares WHERE dni = ?";

        try {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
            }
            BDConnection.closeConnection();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO) Error al buscar titular por dni: " + e.getMessage());
        }

        return null;
    }

    public List<Titular>  buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM titulares WHERE nombre = ?";

        try {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            ArrayList<Titular> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                ));
            }

            BDConnection.closeConnection();
            return lista;

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"(DAO) Error al buscar titulares por nombre: " + e.getMessage());
        }

        return null;
    }

    public void modificar(Titular titular)  {
        String sql = "UPDATE titulares SET nombre = ? WHERE id = ?";

        try
        {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titular.getNombre());
            ps.setInt(2, titular.getId());
            int n = ps.executeUpdate();

            JOptionPane.showMessageDialog(null," (DAO) Titular modificado correctamente.");

            BDConnection.closeConnection();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO) Error al modificar titular: " + e.getMessage());
        }
    }

    public List<Titular> listarTodos() {
        List<Titular> lista = new ArrayList<>();
        String sql = "SELECT * FROM titulares";

        try (Connection conn = BDConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                ));
            }

            BDConnection.closeConnection();

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null," (DAO) Error al listar titulares: " + e.getMessage());
        }

        return lista;
    }
}

