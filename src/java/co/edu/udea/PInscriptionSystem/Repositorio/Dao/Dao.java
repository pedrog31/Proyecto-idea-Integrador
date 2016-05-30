/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.PInscriptionSystem.Repositorio.Dao;

import java.sql.*;

/**
 *
 * @author PedroGallego
 */
public class Dao {
    public Connection conexion;
    private final String userDb = "root";
    private final String passDb = "root";

    //Conectar a la Base de datos
    public void conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/PInscriptionSystemsDB", userDb, passDb);
    }
    //Desconectar a la Base de datos
    public void desconectar() throws SQLException, ClassNotFoundException {
        conexion.close();
    }

}
