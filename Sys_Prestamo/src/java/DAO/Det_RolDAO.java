/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Det_RolDTO;
import config.conexion;
import Interfaces.Operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin-david.orrego
 */
public class Det_RolDAO implements Operaciones<Det_RolDTO> {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private Connection cn;

    @Override
    public boolean create(Det_RolDTO e) {
        boolean m = false;
        sql = "insert into privilegio_has_rol (id_has_rol,idrol,idprivilegio) values ( NULL , ? , ? )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, e.getIdrol());
            ps.setInt(0, e.getIdprivilegio());
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
    public Det_RolDTO read(int key) {
        Det_RolDTO dto = new Det_RolDTO();
        sql = "select * from privilegio_has_rol where id_has_rol= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setIddetalle(rs.getInt("id_has_rol"));
                dto.setIdrol(rs.getInt("idrol"));
                dto.setIdprivilegio(rs.getInt("idprivilegio"));
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return dto;
    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        sql = "delete from privilegio_has_rol where id_has_rol= ? ";
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
    public boolean update(Det_RolDTO e) {
        boolean m = false;
        sql = "update privilegio_has_rol set idrol= ? , idprivilegio= ? where id_has_rol= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, e.getIdrol());
            ps.setInt(1, e.getIdprivilegio());
            ps.setInt(2, e.getIddetalle());
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
    public List<Det_RolDTO> readall() {
        List<Det_RolDTO> lista = new ArrayList();
        sql = "select * from privilegio_has_rol";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Det_RolDTO dto = new Det_RolDTO();
                dto.setIddetalle(rs.getInt("id_has_rol"));
                dto.setIdrol(rs.getInt("idrol"));
                dto.setIdprivilegio(rs.getInt("idprivilegio"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

}
