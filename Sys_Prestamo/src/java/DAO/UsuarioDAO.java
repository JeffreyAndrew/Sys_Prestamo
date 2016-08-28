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

    public PersonaDTO validar(String user, String pass) {
        PersonaDTO m = new PersonaDTO();
        sql = "SELECT P.NOMBRE,P.IDPERSONA,P.APELLIDOS,P.DNI,P.IDROL,P.FACULTAD,P.ESCUELA,P.CELULAR,P.CORREO "
                + "FROM USUARIO U,PERSONA P "
                + "WHERE U.USER=? AND U.PASSWORD=? "
                + "AND U.IDPERSONA=P.IDPERSONA";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setIdpersona(Integer.parseInt(rs.getString("IDPERSONA")));
                m.setIdrol(Integer.parseInt(rs.getString("IDROL")));
                m.setNombre(rs.getString("NOMBRE"));
                m.setApellido(rs.getString("APELLIDOS"));
                m.setDNI(Integer.parseInt(rs.getString("DNI")));
                m.setCorreo(rs.getString("CORREO"));
                m.setTelefono(Integer.parseInt(rs.getString("CELULAR")));
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
        sql = "INSERT INTO USUARIO (IDPERSONA,USER,PASSWORD) VALUES(?,?,?)";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        sql = "DELETE FROM USUARIO WHERE IDUSUARIO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario " + e);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
