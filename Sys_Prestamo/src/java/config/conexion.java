/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leandro
 */
public class conexion {

    private static final String URL="jdbc:mysql://localhost:3306/gestionar_persona";
    private static final String USER = "root";
    private static final String PASS = "marvelous2601+";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static Connection cn = null;

    public static Connection getConexion() {
        try {
            if (cn==null) {
                Class.forName(DRIVER).newInstance();
                cn=DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (Exception e) {
            System.out.println("Error al Conectar "+e);
        }
        return cn;
    }
     public ResultSet query(String sql){
          
    Statement st;
    ResultSet rs = null;
        try {
            Connection conexion=this.getConexion();   
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    return rs;
    }
}
