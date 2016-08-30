/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.RolDTO;
import Interfaces.Operaciones;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin-david.orrego
 */
public class RolDAO implements Operaciones<RolDTO> {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private Connection cn;

    @Override
    public boolean create(RolDTO e) {
        boolean m = false;
        sql = "insert into rol (idrol,rol) values ( NULL , ? )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(0, e.getNombre());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al crear rol "+ex);
        }
        return m;
    }

    @Override
    public List<RolDTO> read(int key) {
        List<RolDTO> lista = new ArrayList();
        sql = "select * from rol where idrol= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                RolDTO dto = new RolDTO();
                dto.setIdrol(rs.getInt("idrol"));
                dto.setNombre(rs.getString("nombre"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            System.out.println("Error al listar Rol "+ex);
        }
        return lista;
    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        sql = "delete from rol where idrol= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al eliminar Rol "+ex);
        }
        return m;
    }

    @Override
    public boolean update(RolDTO e) {
        boolean m = false;
        sql = "update rol set rol= ? where idrol= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(0, e.getNombre());
            ps.setInt(1, e.getIdrol());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al editar Rol "+ex);
        }
        return m;
    }

    @Override
    public List<RolDTO> readall() {
        List<RolDTO> lista = new ArrayList();
        sql = "SELECT * FROM ROL";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RolDTO dto = new RolDTO();
                dto.setIdrol(rs.getInt("idrol"));
                dto.setNombre(rs.getString("nombre"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            System.out.println("Error al listar roles "+ex);
        }
        return lista;
    }
    
    public ResultSet list(){
        ResultSet rm=null;
        sql="SELECT * FROM ROL";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rm = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al listar Roles por ResultSet "+e);
        }
        return rm;
    }

}
