/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PrestamoDTO;
import Interfaces.Operaciones;
import config.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LEANDRO
 */
public class PrestamoDAO implements Operaciones<PrestamoDTO> {

    private String sql;
    private Connection cn;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public boolean create(PrestamoDTO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDTO> read(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PrestamoDTO e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDTO> readall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int add(Object t){
        int p=0;
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
                p= rs.getInt("idPRESTAMO");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar prestamo "+e);
        }
        return p;
    }

    public ArrayList<Map<String, ?>> listared() {
        sql = "SELECT D.IDDET_EQUIPO,E.IDEQUIPO,D.CODIGO,D.DESCRIPCION,E.NOMBRE,E.SERIE,E.TIPO "
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
                m.put("nombre", rs.getString("NOMBRE"));
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
    

}
