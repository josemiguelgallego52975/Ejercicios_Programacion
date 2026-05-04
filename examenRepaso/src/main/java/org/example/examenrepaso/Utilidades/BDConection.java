package org.example.examenrepaso.Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDConection {
    public static  Connection con;
    public static void abrirConexion() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/"+"repasoEva3";
        con = DriverManager.getConnection(url, "root", "usbw");

    }

}
