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

    public List<PersonaDTO> validar(String user, String pass) {
        PersonaDTO m = new PersonaDTO();
        List<PersonaDTO> lista = new ArrayList<>();
        sql = "SELECT P.nombre,P.idPersona,P.apellidos,P.dni,P.idRol,P.celular,P.correo,P.sexo "
                + " FROM usuario U,persona P "
                + " WHERE U.usuario=? AND U.clave=? "
                + " AND U.idPersona=P.idPersona";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setIdPersona(Integer.parseInt(rs.getString("idPersona")));
                m.setIdRol(Integer.parseInt(rs.getString("idRol")));
                m.setNombre(rs.getString("nombre"));
                m.setApellidos(rs.getString("apellidos"));
                m.setDni(Integer.parseInt(rs.getString("dni")));
                m.setCorreo(rs.getString("correo"));
                m.setTelefono(Integer.parseInt(rs.getString("celular")));
                m.setSexo(rs.getString("sexo"));
                lista.add(m);
            }

        } catch (Exception e) {
            System.out.println("Error al Validar Usuario " + e);
            return null;
        }
        return lista;
    }

    @Override
    public boolean create(UsuarioDTO e) {
        boolean m = false;
        sql = "INSERT INTO usuario (idUsuariO,idPersona,usuario,clave) VALUES(NULL,?,?,?)";
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
            System.out.println("Error al Crear Usuario " + p);
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
        sql = "UPDATE USUARIO SET USUARIO=? ,CLAVE=? WHERE IDPERSONA=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getUser());
            ps.setString(2, e.getPassword());
            ps.setInt(3, e.getIdpersona());
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
                us.setIdpersona(rs.getInt("idPersona"));
                us.setUser(rs.getString("usuario"));
                us.setPassword(rs.getString("clave"));
                list.add(us);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        return list;
    }

    public ResultSet list(int user) {
        ResultSet rst=null;
        sql = "SELECT * FROM USUARIO WHERE IDPERSONA=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, user);
            rst = ps.executeQuery();
            if (rst.next()==false) {
                rst=null;
            }else{
                rst = ps.executeQuery();
            }
        } catch (Exception e) {
            System.out.println("Error al listar datos de Usuario por RS " + e);
            rst=null;
        }
        return rst;
    }

}
