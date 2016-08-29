/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PrestamoDTO;
import config.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LEANDRO
 */
public class PrestamoDAO {

    private String sql;
    private Connection cn;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    public int add(Object t) {
        int p = 0;
        sql = "{CALL REG_PRESTAMO(?, ?, ?, ?)}";
        Map<String, Object> m = (Map<String, Object>) t;
        try {
            cn = conexion.getConexion();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.parseInt(m.get("idusuario").toString()));
            cs.setInt(2, Integer.parseInt(m.get("persona").toString()));
            cs.setString(3, m.get("fecha").toString());
            cs.setString(4, m.get("lugar").toString());
            rs = cs.executeQuery();
            while (rs.next()) {
                p = rs.getInt("idPRESTAMO");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar prestamo " + e);
        }
        return p;
    }

    public boolean removeeq(int p,int e) {
        boolean m = false;
        sql = "DELETE FROM DET_PRESTAMO WHERE IDPRESTAMO=? AND IDDET_EQUIPO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, p);
            ps.setInt(2, e);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al quitar equipo del prestamo " + ex);
        }
        return m;
    }
    
    public ArrayList<Map<String, ?>> listared() {
        sql = "SELECT D.IDDET_EQUIPO,E.IDEQUIPO,D.CODIGO,D.DESCRIPCION,E.MARCA,E.SERIE,E.TIPO "
                + " FROM DET_EQUIPO D,EQUIPO E WHERE ESTADO=1 AND D.IDEQUIPO=E.IDEQUIPO;";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("iddet", rs.getInt("IDDET_EQUIPO"));
                m.put("idequipo", rs.getInt("IDEQUIPO"));
                m.put("codigo", rs.getString("CODIGO"));
                m.put("descripcion", rs.getString("DESCRIPCION"));
                m.put("marca", rs.getString("MARCA"));
                m.put("serie", rs.getString("SERIE"));
                m.put("tipo", rs.getString("TIPO"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Equipos Disponibles " + e);
            return null;
        }
        return lista;
    }

    public boolean addeqprestamo(int p, int e) {
        boolean m = false;
        sql = "INSERT INTO DET_PRESTAMO (idPRESTAMO ,idDET_EQUIPO) VALUES(?,?)";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, p);
            ps.setInt(2, e);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al agregar Equipo al Prestamo " + ex);
        }
        return m;
    }
    
    public boolean changeestatus(String a,int e) {
        boolean m = false;
        sql = "UPDATE DET_EQUIPO SET ESTADO=? WHERE IDDET_EQUIPO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, a);
            ps.setInt(2, e);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error cambiar estado de un equipo " + ex);
        }
        return m;
    }

    public boolean changecom(String com,int id){
        boolean m=false;
        sql = "UPDATE PRESTAMO SET COMENTARIOP=? WHERE IDPRESTAMO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, com);
            ps.setInt(2, id);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error comentar el prestamo " + ex);
        }
        return m;
    }
    
    public ArrayList<Map<String, ?>> listareq(int idprestamo) {
        sql = "SELECT D.IDDET_EQUIPO,E.IDEQUIPO,E.CODIGO,E.DESCRIPCION,EQ.MARCA,EQ.SERIE,EQ.TIPO "
                + "FROM DET_PRESTAMO D,DET_EQUIPO E,EQUIPO EQ "
                + "WHERE IDPRESTAMO="+idprestamo+" "
                + "AND E.IDDET_EQUIPO=D.IDDET_EQUIPO "
                + "AND EQ.IDEQUIPO=E.IDEQUIPO;";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("iddet", rs.getInt("IDDET_EQUIPO"));
                m.put("idequipo", rs.getInt("IDEQUIPO"));
                m.put("codigo", rs.getString("CODIGO"));
                m.put("descripcion", rs.getString("DESCRIPCION"));
                m.put("marca", rs.getString("MARCA"));
                m.put("serie", rs.getString("SERIE"));
                m.put("tipo", rs.getString("TIPO"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Equipos del Prestamo " + e);
            return null;
        }
        return lista;
    }
    
    
    
    
    public List<PrestamoDTO> buscarPrestamo(String cadena) {
        conexion oConexion = new conexion();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PRESTAMO WHERE FECHAPRESTAMO LIKE '").append(cadena);
        sql.append("%'");
        List<PrestamoDTO> list = new ArrayList<PrestamoDTO>();
        try {
            ResultSet rs = oConexion.query(sql.toString());
            while(rs.next()){
            PrestamoDTO prestamo = new PrestamoDTO();
            
            prestamo.setIdPrestamo(rs.getInt("IDPRESTAMO"));
            prestamo.setIdUsuario(rs.getInt("IDUSUARIO"));
            prestamo.setPersonaRes(rs.getInt("PERSONARES"));
            prestamo.setFechaPrestamo(rs.getString("FECHAPRESTAMO"));
            prestamo.setFechaDevolucion(rs.getString("FECHADEVOLUCION"));
            prestamo.setLugar(rs.getString("LUGAR"));
            prestamo.setComentariop(rs.getString("COMENTARIOP"));
            prestamo.setComentariod(rs.getString("COMENTARIOD"));
            prestamo.setEstado(rs.getString("ESTADO"));
           
            list.add(prestamo);
            }
        } catch (SQLException e) {
        } finally{
           
        }
        return list;
    }

}
