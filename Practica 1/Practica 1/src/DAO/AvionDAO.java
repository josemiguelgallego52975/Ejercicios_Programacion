package DAO;

import Controller.AvionController;
import Modelo.Avion;
import Utilidades.BDConnection;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvionDAO {
    public static void insertar(Avion avion){
        String sql = "INSERT INTO avion (codVuelo, fechaSalida, destino, procedencia) VALUES (?, ?, ?, ?)";
        try
        {
            Connection conn = BDConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, avion.getCodVuelo());
            ps.setDate(2, java.sql.Date.valueOf(avion.getFechaSalida()));
            ps.setString(3, avion.getDestino());
            ps.setString(4, avion.getProcedencia());
            ps.executeUpdate();

            /*
                Mensaje para nosotros. No para el usuario final.
                En un proyecto real, esto se manejaría con logs o se mostraría en la interfaz de usuario.
             */

            JOptionPane.showMessageDialog(null, " (DAO)Avion insertado correctamente.");
            BDConnection.closeConnection();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null," (DAO)Error al insertar el avion: " + e.getMessage());
        }

    }
    public static boolean borrarCodVuelo(String texto) throws Exception {
        String sql = "DELETE FROM avion WHERE codVuelo = ?";

        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, texto);

            int filasBorradas = ps.executeUpdate();

            if (filasBorradas > 0) {
                JOptionPane.showMessageDialog(null, "(DAO) ¡Éxito! El avión con código " + texto + " ha sido eliminado.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "(DAO) No se pudo borrar: El código '" + texto + "' no existe en la base de datos.");
                return false;
            }

        } catch (SQLException e) {
            throw new Exception("(DAO) Error técnico al intentar borrar: " + e.getMessage());
        }
    }



    public static boolean modificarVuelo(Avion avion) throws  Exception {
        String sql = "UPDATE avion SET fechaSalida = ? WHERE codVuelo = ?";
        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDate(1, java.sql.Date.valueOf(avion.getFechaSalida()));
            ps.setString(2, avion.getCodVuelo());
            int filasBorradas = ps.executeUpdate();
            if (filasBorradas > 0) {
                JOptionPane.showMessageDialog(null, " (DAO) Vuelo modificado correctamente.");
            }else {
                JOptionPane.showMessageDialog(null, "(DAO) No se ha encontrado ningun vuelo con el codigo: " + avion.getCodVuelo());
            }
            return true;



        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "(DAO) Error al modificar el vuelo: " + e.getMessage());
            return false;
        }
    }

    public static List<Avion> buscarPorCodigo(String codVuelo) throws Exception {
        String sql = "SELECT * FROM avion WHERE codVuelo = ?";
        try (Connection conn = BDConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codVuelo);
            ResultSet rs = ps.executeQuery();
            List<Avion> lista = new ArrayList<>();
            while(rs.next()){
                Avion avion = new Avion(
                        rs.getString("codVuelo"),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia"));
                lista.add(avion);
            }
            return lista;
        } catch (Exception e) {
        throw new Exception("(DAO) Error al buscar el vuelo: " + e.getMessage());
        }
    }

    public static List<Avion> buscarPorDestino(String destino) throws Exception {
        String sql = "SELECT * FROM avion WHERE destino = ?";
        try (Connection conn = BDConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();
            List<Avion> lista = new ArrayList<>();
            while(rs.next()){
                Avion avion = new Avion(
                        rs.getString("codVuelo"),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia"));
                lista.add(avion);
            }
            return lista;
        }catch(Exception e){
            throw new Exception("(DAO) Error al buscar el vuelo por destino: " + e.getMessage());
        }
    }

    public static List<Avion> buscarPorOrigen(String destino) throws Exception {
        String sql = "SELECT * FROM avion WHERE procedencia = ?";
        try (Connection conn = BDConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();
            List<Avion> lista = new ArrayList<>();
            while(rs.next()){
                Avion avion = new Avion(
                        rs.getString("codVuelo"),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia"));
                lista.add(avion);
            }
            return lista;
        }catch(Exception e){
            throw new Exception("(DAO) Error al buscar el vuelo por origen: " + e.getMessage());
        }
    }

    public static List<Avion> buscarPorPasajero(String dni) throws Exception {
        String sql = "SELECT * FROM pasajero WHERE dni = ?";
        try (Connection conn = BDConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            List<Avion> lista = new ArrayList<>();
            while (rs.next()) {
                String codVuelo = rs.getString("codVuelo");
                lista=buscarPorCodigo(codVuelo);
            }
            return  lista;
        }catch(Exception e){
            throw new Exception("(DAO) Error al buscar el vuelo por pasajero: " + e.getMessage());
        }
    }

    public static List<Avion> buscarPorFecha(LocalDate fechaSalida) throws Exception{
        String sql = "SELECT * FROM avion WHERE fechaSalida = ?";
        try(Connection conn= BDConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setDate(1, Date.valueOf(fechaSalida));
            ResultSet rs = ps.executeQuery();
            List<Avion> lista = new ArrayList<>();
            while(rs.next()){
                Avion avion = new Avion(
                        rs.getString("codVuelo"),
                        rs.getDate("fechaSalida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia"));
                lista.add(avion);
            }
            return lista;
        }catch(Exception e){
            throw new Exception("(DAO) Error al buscar el vuelo por fecha: " + e.getMessage());
        }
    }

}
