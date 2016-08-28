/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PersonaDTO;
import Interfaces.Operaciones;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alum.fial1
 */
public class PersonaDAO implements Operaciones<PersonaDTO> {

    private PreparedStatement ps;
    private Connection cn;
    private String sql;
    private Statement st;

    @Override
    public boolean create(PersonaDTO e) {
        boolean m = false;
        sql = "INSERT INTO PERSONA(NOMBRE,APELLIDOS,DNI,ID_ROL,FACULTAD,ESCUELA,CELULAR,CORREO) VALUES(?,?,?,?,?,?,?,?)";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setInt(3, e.getDNI());
            ps.setInt(4, e.getIdrol());
            ps.setString(5, e.getFacultad());
            ps.setString(6, e.getEscuela());
            ps.setInt(7, e.getTelefono());
            ps.setString(8, e.getCorreo());
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
    public List<PersonaDTO> read(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int key) {
        boolean m = false;
        sql = "DELETE FROM PERSONA WHERE IDPERSONA=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar persona " + e);
        }
        return m;
    }

    @Override
    public boolean update(PersonaDTO e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaDTO> readall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<PersonaDTO> buscarPersona(String cadena) {
        conexion oConexion = new conexion();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERSONA WHERE NOMBRE LIKE '").append(cadena);
        sql.append("%'");
        List<PersonaDTO> list = new ArrayList<PersonaDTO>();
        try {
            ResultSet rs = oConexion.query(sql.toString());
            while(rs.next()){
            PersonaDTO producto = new PersonaDTO();
            producto.setIdpersona(rs.getInt("IDPERSONA"));
            producto.setIdrol(rs.getInt("IDROL"));
            producto.setNombre(rs.getString("NOMBRE"));
            producto.setApellido(rs.getString("APELLIDOS"));
            producto.setDNI(rs.getInt("DNI"));
            producto.setTelefono(rs.getInt("CELULAR"));
            producto.setCorreo(rs.getString("CORREO"));
           
            list.add(producto);
            }
        } catch (SQLException e) {
        } finally{
           
        }
        return list;
    }
}
