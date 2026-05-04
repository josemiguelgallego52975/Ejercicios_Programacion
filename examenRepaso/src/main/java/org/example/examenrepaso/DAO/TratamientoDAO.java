package org.example.examenrepaso.DAO;

import javafx.scene.control.Alert;
import org.example.examenrepaso.Utilidades.BDConection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TratamientoDAO {
    public static String mensaje="\n";
    public static String buscarTratamiento(int id) {
        String sql="select * from tratamientos where id = ?";
        try {
            BDConection con=new BDConection();
            BDConection.abrirConexion();
            PreparedStatement pst=con.con.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                mensaje=mensaje+"ID: "+rs.getString("id")+"DESCRIPCION: "+rs.getString("descripcion")+"PRECIO: "+rs.getString("precio")+"DURACION: "+rs.getString("DURACION");
            }
            return  mensaje;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("No se pudo buscar la cita");
            alert.showAndWait();
            e.printStackTrace();
            return null;
        }
    }
}
