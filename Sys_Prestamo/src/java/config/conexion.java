/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alum.fial1
 */
public class conexion {

    private static final String URL="";
    private static final String USER = "root";
    private static final String PASS = "root";
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
}
