/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Det_EquipoDTO;
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
            ps.setInt(1, e.getIdEquipo());
            ps.setInt(2, e.getCodigo());
            ps.setString(3, e.getDescripcion().toUpperCase());
            ps.setString(4, e.getEstado());
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
            ps.setInt(1, key);
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
    public List<Det_EquipoDTO> readByCode(int key) {
        List<Det_EquipoDTO> lista = new ArrayList();
        sql = "select * from det_equipo where codigo= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
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
            ps.setInt(1, key);
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
            ps.setInt(1, e.getIdEquipo());
            ps.setInt(2, e.getCodigo());
            ps.setString(3, e.getDescripcion().toUpperCase());
            ps.setString(4, e.getEstado());
            ps.setInt(5, e.getIdDet_Equipo());
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

    public ArrayList especifiedreadall() {
        ArrayList lista3=new ArrayList();
        List<Det_EquipoDTO> lista = new ArrayList();
        List<EquipoDTO> lista2 = new ArrayList();
        sql = "select * from det_equipo a,equipo b where a.idequipo=b.idequipo";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EquipoDTO dto2 = new EquipoDTO();
                Det_EquipoDTO dto = new Det_EquipoDTO();
                dto.setIdDet_Equipo(rs.getInt("iddet_equipo"));
                dto.setIdEquipo(rs.getInt("idequipo"));
                dto.setCodigo(rs.getInt("codigo"));
                dto.setEstado(rs.getString("estado"));
                dto.setDescripcion(rs.getString("descripcion"));
                dto2.setIdEquipo(rs.getInt("idequipo"));
                dto2.setMarca(rs.getString("marca"));
                dto2.setSerie(rs.getString("serie"));
                dto2.setTipo(rs.getString("tipo"));
                lista.add(dto);
                lista2.add(dto2);
            }
            lista3.add(lista);
            lista3.add(lista2);
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista3;
    }
}
