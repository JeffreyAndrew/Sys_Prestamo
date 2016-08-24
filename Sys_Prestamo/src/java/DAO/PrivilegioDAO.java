/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PrivilegioDTO;
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
public class PrivilegioDAO implements Operaciones<PrivilegioDTO> {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private Connection cn;

    @Override
    public boolean create(PrivilegioDTO e) {
        boolean m = false;
        sql = "insert into privilegio (idprivilegio,nombre,estado) values ( NULL , ? , ? )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(0, e.getNombre());
            ps.setString(1, e.getEstado());
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
    public PrivilegioDTO read(int key) {
        PrivilegioDTO dto = new PrivilegioDTO();
        sql = "select * from privilegio where idprivilegio= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setIdprivilegio(rs.getInt("idprivilegio"));
                dto.setNombre(rs.getString("nombre"));
                dto.setEstado("estado");
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return dto;
    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        sql = "delete from privilegio where idprivilegio= ? ";
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
    public boolean update(PrivilegioDTO e) {
        boolean m = false;
        sql = "update privilegio set nombre= ? , estado= ? where idprivilegio= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(0, e.getNombre());
            ps.setString(1, e.getEstado());
            ps.setInt(2, e.getIdprivilegio());
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
    public List<PrivilegioDTO> readall() {
        List<PrivilegioDTO> lista = new ArrayList();
        sql = "select * from privilegio";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PrivilegioDTO dto = new PrivilegioDTO();
                dto.setIdprivilegio(rs.getInt("idprivilegio"));
                dto.setNombre(rs.getString("nombre"));
                dto.setEstado("estado");
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

}
