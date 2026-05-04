package DAO;

import Controller.PasajeroController;
import Modelo.Avion;
import Modelo.Pasajero;
import Utilidades.BDConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {
    public static void crearPasajero(Pasajero pasajero) throws Exception {
        String sql="INSERT INTO pasajero (dni, nombre, telefono, codVuelo) VALUES (?,?,?,?)";
        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getNumero());
            ps.setString(4, pasajero.getCodVuelo().toUpperCase());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "(DAO) Pasajero guardado correctamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(DAO) Error al insertar: " + e.getMessage());
        }
    }

    public static boolean buscarCodVuelo(String codVuelo) throws Exception {
        String sql = "SELECT COUNT(*) FROM avion WHERE codVuelo = ?";

        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codVuelo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt(1);
                    if(total>0){return true;}else {return false;}
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        return false;
    }

    public static void borrarPasajero(String dni) throws Exception {
       String sql = "DELETE FROM pasajero WHERE dni=?";
        try (Connection conn = BDConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);

            int filasBorradas = ps.executeUpdate();
            if(filasBorradas>0){
                JOptionPane.showMessageDialog(null, "(DAO) Pasajero eliminado correctamente.");
            }else {throw new Exception("(DAO) Error al borrar la pasajero, no exisste en la Base de Datos");}


        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void modificarPasajero(Pasajero pasajero) throws Exception {
        String sql ="UPADETE pasajero SET telefono=? WHERE dni=?";
        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pasajero.getNumero());
            ps.setString(1, pasajero.getDni());
            int filasModificados=ps.executeUpdate();
            if (filasModificados>0){
                JOptionPane.showMessageDialog(null, "(DAO) Pasajero modificado correctamente.");
            }else {throw new Exception("(DAO) Error al modificar al pasajero, no exisste en la Base de Datos");}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static List<Pasajero> buscarPorDni(String dni) throws Exception {
        String sql = "SELECT * FROM pasajero WHERE dni=?";
        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            List<Pasajero> lista = new ArrayList<>();
            while (rs.next()) {
                Pasajero pasajero = new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("codVuelo")
                );
                lista.add(pasajero);
            }
            return lista;
        }catch (Exception e){throw new Exception("(DAO) Error al buscar al pasajero, no existe en la Base de Datos");}
    }

    public static List<Pasajero> buscarPorCodigo(String codVuelo) throws Exception {
        String sql = "SELECT * FROM pasajero WHERE codVuelo = ?";
        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codVuelo);
            ResultSet rs = ps.executeQuery();
            List<Pasajero> lista = new ArrayList<>();
            while(rs.next()){
                Pasajero pasajero = new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("codVuelo"));
                lista.add(pasajero);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("(DAO) Error al buscar el vuelo: " + e.getMessage());
        }
    }
}
