/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Det_PrestamoDTO;
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
public class Det_PrestamoDAO implements Operaciones<Det_PrestamoDTO> {

    private PreparedStatement ps;
    private Connection cn;
    private String sql;
    private ResultSet rs;

    @Override
    public boolean create(Det_PrestamoDTO e) {
        boolean m = false;
        sql = "INSERT INTO det_prestamo(idprestamo,iddet_equipo) VALUES( ? , ? )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getIdPrestamo());
            ps.setInt(2, e.getIdDet_Equipo());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception p) {
            System.out.println("Error al Crear det_prestamo " + p);
        }
        return m;
    }

    @Override
    public List<Det_PrestamoDTO> read(int key) {
        List<Det_PrestamoDTO> lista = new ArrayList();
        sql = "select * from det_prestamo where id_prestamo= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(0, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                Det_PrestamoDTO dto = new Det_PrestamoDTO();
                dto.setIdPrestamo(rs.getInt("idprestamo"));
                dto.setIdDet_Equipo(rs.getInt("iddet_equipo"));
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
        sql = "delete from det_prestamo where id_prestamo= ? ";
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
    public boolean update(Det_PrestamoDTO e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Det_PrestamoDTO> readall() {
        List<Det_PrestamoDTO> lista = new ArrayList();
        sql = "select * from det_prestamo";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Det_PrestamoDTO dto = new Det_PrestamoDTO();
                dto.setIdPrestamo(rs.getInt("idprestamo"));
                dto.setIdDet_Equipo(rs.getInt("iddet_equipo"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

}
