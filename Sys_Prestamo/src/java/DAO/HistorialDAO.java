/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import config.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Igor
 */
public class HistorialDAO {
    
    public static String[][] listarHistoProduct() {
        conexion oConexion = new conexion();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT A.*,B. VECES_PRESTADO FROM(\n" +
                  "SELECT PRES.IDPRESTAMO,E.IDEQUIPO,E.MARCA,PRES.FECHAPRESTAMO,PRES.FECHADEVOLUCION,PRES.COMENTARIOD\n" +
                  "FROM EQUIPO AS E, PRESTAMO AS PRES,DET_EQUIPO AS DETEQUI,DET_PRESTAMO AS DETPRES\n" +
                  "WHERE PRES.IDPRESTAMO=DETPRES.IDPRESTAMO AND DETPRES.IDDET_EQUIPO=DETEQUI.IDDET_EQUIPO AND DETEQUI.IDEQUIPO=E.IDEQUIPO) AS A\n" +
                  "INNER JOIN(\n" +
                  "SELECT IDDET_EQUIPO,COUNT(IDDET_EQUIPO) VECES_PRESTADO FROM DET_PRESTAMO GROUP BY IDDET_EQUIPO) AS B\n" +
                  "ON B.IDDET_EQUIPO=A.IDEQUIPO;");      

        String resultadoHistoProduct[][]=null;
        try {
    
            ResultSet rs = oConexion.query(sql.toString());
            //ResultSetMetaData rsmd = rs.getMetaData(); para obtener cantidad de columnas
            //int columnsNumber = rsmd.getColumnCount(); para obtener cantidad de columnas
            rs.last();
            int rows  = rs.getRow();
            rs.beforeFirst();
            int contador=0;
            resultadoHistoProduct=new String[rows][7];
            while(rs.next()){
            resultadoHistoProduct[contador][0]=(rs.getString("IDPRESTAMO"));
            resultadoHistoProduct[contador][1]=(rs.getString("IDEQUIPO"));
            resultadoHistoProduct[contador][2]=(rs.getString("MARCA"));
            resultadoHistoProduct[contador][3]=(rs.getString("FECHAPRESTAMO"));
            resultadoHistoProduct[contador][4]=(rs.getString("FECHADEVOLUCION"));
            resultadoHistoProduct[contador][5]=(rs.getString("COMENTARIOD"));
            resultadoHistoProduct[contador][6]=(rs.getString("VECES_PRESTADO"));
             
            contador++;
            }
        } catch (SQLException e) {
        } finally{
           
        }
        return resultadoHistoProduct;
      
    } 
    
    
}
