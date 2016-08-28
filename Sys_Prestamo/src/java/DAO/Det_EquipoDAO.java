/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Det_EquipoDTO;
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
public class Det_EquipoDAO implements Operaciones<Det_EquipoDTO> {

    private PreparedStatement ps;
    private Connection cn;
    private String sql;
    private ResultSet rs;

    @Override
    public boolean create(Det_EquipoDTO e) {
        boolean m = false;
        sql = "INSERT INTO det_equipo(iddet_equipo,idequipo,codigo,descripcion,estado) VALUES(NULL, ? , ? , ? , ? )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, e.getIdEquipo());
            ps.setInt(1, e.getCodigo());
            ps.setString(2, e.getDescripcion());
            ps.setString(3, e.getEstado());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception p) {
            System.out.println("Error al Crear det_equipo " + p);
        }
        return m;
    }

    @Override
    public List<Det_EquipoDTO> read(int key) {
        List<Det_EquipoDTO> lista = new ArrayList();
        sql = "select * from det_equipo where iddet_equipo= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                Det_EquipoDTO dto = new Det_EquipoDTO();
                dto.setIdDet_Equipo(rs.getInt("iddet_equipo"));
                dto.setIdEquipo(rs.getInt("idequipo"));
                dto.setCodigo(rs.getInt("codigo"));
                dto.setEstado(rs.getString("estado"));
                dto.setDescripcion(rs.getString("descripcion"));
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
        sql = "delete from det_equipo where iddet_equipo= ? ";
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
    public boolean update(Det_EquipoDTO e) {
        boolean m = false;
        sql = "update det_equipo set idequipo= ? ,codigo= ? ,descripcion= ? ,estado= ? where iddet_equipo= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, e.getIdEquipo());
            ps.setInt(1, e.getCodigo());
            ps.setString(2, e.getDescripcion());
            ps.setString(3, e.getEstado());
            ps.setInt(4, e.getIdDet_Equipo());
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
    public List<Det_EquipoDTO> readall() {
        List<Det_EquipoDTO> lista = new ArrayList();
        sql = "select * from det_equipo";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Det_EquipoDTO dto = new Det_EquipoDTO();
                dto.setIdDet_Equipo(rs.getInt("iddet_equipo"));
                dto.setIdEquipo(rs.getInt("idequipo"));
                dto.setCodigo(rs.getInt("codigo"));
                dto.setEstado(rs.getString("estado"));
                dto.setDescripcion(rs.getString("descripcion"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

}
