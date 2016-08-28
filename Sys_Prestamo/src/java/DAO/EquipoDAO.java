/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.EquipoDTO;
import Interfaces.Operaciones;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CESAR
 */
public class EquipoDAO implements Operaciones<EquipoDTO>{

    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;
    private String sql;
    

    @Override
    public boolean create(EquipoDTO e) {
        boolean m = false;
        sql = "INSERT INTO equipo(idEquipo,nombre,serie,tipo) VALUES(NULL,?,?,?)";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(0, e.getNombre());
            ps.setString(1, e.getSerie());
            ps.setString(2, e.getTipo());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception p) {
            System.out.println("Error al Crear equipo " + p);
        }
        return m;
    }

    @Override
    public List<EquipoDTO> read(int key) {
        List<EquipoDTO> lista = new ArrayList();
        EquipoDTO dto = new EquipoDTO();
        sql = "select * from equipo where idEquipo= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setIdEquipo(rs.getInt("idEquipo"));
                dto.setNombre(rs.getString("nombre"));
                dto.setSerie(rs.getString("serie"));
                dto.setTipo(rs.getString("tipo"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        sql = "delete from equipo where idequipo= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return m;
    }

    @Override
    public boolean update(EquipoDTO e) {
        boolean m = false;
        sql = "update equipo set nombre= ? ,serie= ? ,tipo= ? where idequipo= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(0, e.getNombre());
            ps.setString(1, e.getSerie());
            ps.setString(2, e.getTipo());
            ps.setInt(3, e.getIdEquipo());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return m;
    }

    @Override
    public List<EquipoDTO> readall() {
        List<EquipoDTO> lista = new ArrayList();
        sql = "select * from rol";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EquipoDTO dto = new EquipoDTO();
                dto.setIdEquipo(rs.getInt("idequipo"));
                dto.setNombre(rs.getString("nombre"));
                dto.setSerie(rs.getString("serie"));
                dto.setTipo(rs.getString("tipo"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }
    
}
