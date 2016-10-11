/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PersonaDTO;
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
                + "id_docente,fecha_reserva,fecha_inicio,fecha_fin,dia,hora_ini,hora_fin)"
                + " VALUES (NULL, ? , ? , (SELECT CURDATE()) , ? , ? , ? , TIME_FORMAT(?,'%T'), TIME_FORMAT(?,'%T') )";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getId_usuario());
            ps.setInt(2, e.getId_docente());
            ps.setString(3, e.getFecha_inicio());
            ps.setString(4, e.getFecha_fin());
            ps.setString(5, e.getDia().toUpperCase());
            ps.setString(6, e.getHora_ini());
            ps.setString(7, e.getHora_fin());
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
        sql = "select id_reserva,id_usuario,"
                + "id_docente,fecha_reserva,date_format(fecha_inicio,'%Y/%m/%d') as 'fecha_inicio',date_format(fecha_fin,'%Y/%m/%d') as 'fecha_fin',dia,"
                + "time_format(hora_ini,'%H:%i') as 'hora_ini',time_format(hora_fin,'%H:%i')  as 'hora_fin' from reserva where id_reserva= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setId_reserva(rs.getInt("id_reserva"));
                dto.setId_usuario(rs.getInt("id_usuario"));
                dto.setId_docente(rs.getInt("id_docente"));
                dto.setFecha_reserva(rs.getString("fecha_reserva"));
                dto.setFecha_inicio(rs.getString("fecha_inicio"));
                dto.setFecha_fin(rs.getString("fecha_fin"));
                dto.setDia(rs.getString("dia"));
                dto.setHora_ini(rs.getString("hora_ini"));
                dto.setHora_fin(rs.getString("hora_fin"));
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
        sql = "update reserva set id_usuario= ? ,id_docente= ? ,fecha_reserva= (SELECT CURRENT_DATE()) ,fecha_inicio= ? ,fecha_fin= ? ,dia= ?,hora_ini= TIME_FORMAT(?,'%T'),hora_fin= TIME_FORMAT(?,'%T') where id_reserva= ? ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getId_usuario());
            ps.setInt(2, e.getId_docente());
            ps.setString(3, e.getFecha_inicio());
            ps.setString(4, e.getFecha_fin());
            ps.setString(5, e.getDia().toUpperCase());
            ps.setString(6, e.getHora_ini());
            ps.setString(7, e.getHora_fin());
            ps.setInt(8, e.getId_reserva());
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
                dto.setFecha_reserva(rs.getString("fecha_reserva"));
                dto.setFecha_inicio(rs.getString("fecha_inicio"));
                dto.setFecha_fin(rs.getString("fecha_fin"));
                dto.setDia(rs.getString("dia"));
                dto.setHora_ini(rs.getString("hora_ini"));
                dto.setHora_fin(rs.getString("hora_fin"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

    public List<PersonaDTO> docvalidated() {
        List<PersonaDTO> lista = new ArrayList();
        sql = "SELECT P.IDPERSONA,P.NOMBRE,P.APELLIDOS,P.DNI "
                + "FROM PERSONA P LEFT OUTER JOIN PRESTAMO E "
                + "ON P.IDPERSONA=E.IDPERSONA "
                + "WHERE P.IDROL=3 "
                + "AND (E.IDPERSONA IS NULL) "
                + "OR (P.IDPERSONA IS NULL OR E.ESTADO=0);";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PersonaDTO pdto = new PersonaDTO();
                pdto.setIdPersona(rs.getInt("IDPERSONA"));
                pdto.setNombre(rs.getString("NOMBRE"));
                pdto.setApellidos(rs.getString("APELLIDOS"));
                pdto.setDni(rs.getInt("DNI"));
                lista.add(pdto);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

    public List<Integer> counteq(int key) {
        List<Integer> lista = new ArrayList();
        sql = "select count(det_reserva.id_reserva) as numero from "
                + "det_reserva where det_reserva.id_reserva= ?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt("numero"));
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

    public List<Integer> especifiedread(ReservaDTO e) {
        List<Integer> lista = new ArrayList();
        sql = "select id_reserva from reserva where id_usuario=? and id_docente=? and fecha_reserva=(SELECT CURRENT_DATE()) and "
                + "fecha_inicio=? and fecha_fin=? and dia=? and hora_ini=TIME_FORMAT(?,'%T') and hora_fin=TIME_FORMAT(?,'%T')";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getId_usuario());
            ps.setInt(2, e.getId_docente());
            ps.setString(3, e.getFecha_inicio());
            ps.setString(4, e.getFecha_fin());
            ps.setString(5, e.getDia().toUpperCase());
            ps.setString(6, e.getHora_ini());
            ps.setString(7, e.getHora_fin());
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt("id_reserva"));
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return lista;
    }

}
