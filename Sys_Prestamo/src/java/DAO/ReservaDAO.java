/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ReservaDTO;
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
public class ReservaDAO implements Operaciones<ReservaDTO> {

    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;
    private String sql;

    @Override
    public boolean create(ReservaDTO e) {
        boolean m = false;
        sql = "INSERT INTO reserva(id_reserva,id_usuario,"
                + "id_docente,id_detequipo,fecha_reserva,fecha_inicio,fecha_fin,dia)"
                +" VALUES(NULL, ? , ? , ? , (SELECT SYSDATE()) , ? , ? , ? )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getId_usuario());
            ps.setInt(2, e.getId_docente());
            ps.setInt(3, e.getId_detequipo());
            ps.setString(4, e.getFecha_inicio());
            ps.setString(5, e.getFecha_fin());
            ps.setString(6, e.getDia().toUpperCase());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception p) {
            System.out.println("Error al Crear reserva " + p);
        }
        return m;
    }

    @Override
    public List<ReservaDTO> read(int key) {
        List<ReservaDTO> lista = new ArrayList();
        ReservaDTO dto = new ReservaDTO();
        sql = "select * from reserva where id_reserva= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setId_reserva(rs.getInt("id_reserva"));
                dto.setId_usuario(rs.getInt("id_usuario"));
                dto.setId_docente(rs.getInt("id_docente"));
                dto.setId_detequipo(rs.getInt("id_detequipo"));
                dto.setFecha_reserva(rs.getString("fecha_reserva"));
                dto.setFecha_inicio(rs.getString("fecha_inicio"));
                dto.setFecha_fin(rs.getString("fecha_fin"));
                dto.setDia(rs.getString("dia"));
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
        sql = "delete from reserva where id_reserva= ? ";
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
    public boolean update(ReservaDTO e) {
        boolean m = false;
        sql = "update reserva set id_usuario= ? ,id_docente= ? ,id_detequipo= ? ,fecha_reserva= (SELECT SYSDATE()) ,fecha_inicio= ? ,fecha_fin= ? ,dia= ? where id_reserva= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getId_usuario());
            ps.setInt(2, e.getId_docente());
            ps.setInt(3, e.getId_detequipo());
            ps.setString(4, e.getFecha_inicio());
            ps.setString(5, e.getFecha_fin());
            ps.setString(6, e.getDia().toUpperCase());
            ps.setInt(7, e.getId_reserva());
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
    public List<ReservaDTO> readall() {
        List<ReservaDTO> lista = new ArrayList();
        ReservaDTO dto = new ReservaDTO();
        sql = "select * from reserva";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setId_reserva(rs.getInt("id_reserva"));
                dto.setId_usuario(rs.getInt("id_usuario"));
                dto.setId_docente(rs.getInt("id_docente"));
                dto.setId_detequipo(rs.getInt("id_detequipo"));
                dto.setFecha_reserva(rs.getString("fecha_reserva"));
                dto.setFecha_inicio(rs.getString("fecha_inicio"));
                dto.setFecha_fin(rs.getString("fecha_fin"));
                dto.setDia(rs.getString("dia"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }
    
}
