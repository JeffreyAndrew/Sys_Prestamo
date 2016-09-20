/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Det_ReservaDTO;
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
public class Det_ReservaDAO implements Operaciones<Det_ReservaDTO> {

    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;
    private String sql;

    @Override
    public boolean create(Det_ReservaDTO e) {
        boolean m = false;
        sql = "INSERT INTO det_reserva(id_reserva,iddet_equipo)"
                + " VALUES( ? , ? )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getIdReserva());
            ps.setInt(2, e.getIdDet_Equipo());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception p) {
            System.out.println("Error al Crear det_reserva " + p);
        }
        return m;
    }

    @Override
    public List<Det_ReservaDTO> read(int key) {
        List<Det_ReservaDTO> lista = new ArrayList();
        Det_ReservaDTO dto = new Det_ReservaDTO();
        sql = "select * from det_reserva where id_reserva= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setIdReserva(rs.getInt("id_reserva"));
                dto.setIdDet_Equipo(rs.getInt("iddet_equipo"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            System.out.println("Error al leer det_reserva " + ex); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        sql = "delete from det_reserva where id_reserva= ? ";
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
    public boolean update(Det_ReservaDTO e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Det_ReservaDTO> readall() {
        List<Det_ReservaDTO> lista = new ArrayList();
        Det_ReservaDTO dto = new Det_ReservaDTO();
        sql = "select * from det_reserva ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setIdReserva(rs.getInt("id_reserva"));
                dto.setIdDet_Equipo(rs.getInt("iddet_equipo"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            System.out.println("Error al leer det_reserva " + ex); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }
    
    
}
