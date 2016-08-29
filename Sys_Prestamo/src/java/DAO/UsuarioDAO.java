/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PersonaDTO;
import DTO.UsuarioDTO;
import Interfaces.Operaciones;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alum.fial1
 */
public class UsuarioDAO implements Operaciones<UsuarioDTO> {

    private PreparedStatement ps;
    private Connection cn;
    private String sql;
    private ResultSet rs;
    private final String SQL_READALL = "SELECT * FROM usuario";
    private final String SQL_READ = "SELECT * FROM usuario WHERE idUsuario=?";
    private final String DELETE = "DELETE FROM usuario WHERE idUsuario=?";

    public PersonaDTO validar(String user, String pass) {
        PersonaDTO m = new PersonaDTO();
        sql = "SELECT P.nombre,P.idPersona,P.apellidos,P.dni,P.idRol,P.facultad, P.escuela,P.celular,P.correo "
                + "FROM usuario U,persona P "
                + "WHERE U.usuario=? AND U.clave=? "
                + "AND U.idPersona=P.idPersona";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setIdpersona(Integer.parseInt(rs.getString("idPersona")));
                m.setIdrol(Integer.parseInt(rs.getString("idRol")));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellidos"));
                m.setDNI(Integer.parseInt(rs.getString("dni")));
                m.setFacultad(rs.getString("facultad"));
                m.setEscuela(rs.getString("escuela"));
                m.setCorreo(rs.getString("correo"));
                m.setTelefono(Integer.parseInt(rs.getString("celular")));
            }

        } catch (SQLException | NumberFormatException e) {
            m = null;
            System.out.println("Error al Validar Usuario");
        }
        return m;
    }

    @Override
    public boolean create(UsuarioDTO e) {
        boolean m = false;
        sql = "INSERT INTO usuario (idPersona,usuario,clave) VALUES(?,?,?)";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getIdpersona());
            ps.setString(2, e.getUser());
            ps.setString(3, e.getPassword());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception p) {
            System.out.println("Error al Crear Persona " + p);
        }
        return m;
    }

    @Override
    public List<UsuarioDTO> read(int key) {
        List<UsuarioDTO> list = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(SQL_READ);
            ps.setInt(1, (int) key);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDTO us = new UsuarioDTO();
                us.setIdusuario(rs.getInt("idUsuario"));
                us.setUser(rs.getString("usuario"));
                us.setPassword(rs.getString("clave"));
                list.add(us);

            }

        } catch (Exception e) {

        }
        return list;

    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(DELETE);
            ps.setInt(1, key);
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al eliminar usuario " + ex);
        }
        return m;
    }

    @Override
    public boolean update(UsuarioDTO e) {
        boolean m = false;
        sql = "UPDATE FROM USUARIO SET USER=? AND PASSWORD=?";
        try {
            UsuarioDTO u = new UsuarioDTO();
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getUser());
            ps.setString(2, e.getPassword());
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al Actualizar Usuario " + ex);
        }
        return m;
    }

    @Override
    public List<UsuarioDTO> readall() {

        List<UsuarioDTO> list = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDTO us = new UsuarioDTO();
                us.setIdusuario(rs.getInt("idUsuario"));
                us.setUser(rs.getString("usuario"));
                us.setPassword(rs.getString("clave"));
                list.add(us);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return list;
    }

}
