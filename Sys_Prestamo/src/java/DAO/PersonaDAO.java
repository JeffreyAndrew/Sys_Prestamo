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
    private ResultSet rs;
    private String sql;
    private Statement st;
    private ResultSet rs;

    @Override
    public boolean create(PersonaDTO e) {
        boolean m = false;
        sql = "INSERT INTO PERSONA(NOMBRE,APELLIDOS,DNI,ID_ROL,CELULAR,CORREO) VALUES(?,?,?,?,?,?)";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setInt(3, e.getDni());
            ps.setInt(4, e.getIdRol());
            ps.setInt(5, e.getTelefono());
            ps.setString(6, e.getCorreo());
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
        List<PersonaDTO> lista = new ArrayList();
        PersonaDTO dto = new PersonaDTO();
        sql = "SELECT * FROM PERSONA WHERE IDPERSONA=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto.setIdPersona(rs.getInt("idPersona"));
                dto.setNombre(rs.getString("NOMBRE"));
                dto.setApellidos(rs.getString("APELLIDOS"));
                dto.setDni(rs.getInt("DNI"));
                dto.setTelefono(rs.getInt("CELULAR"));
                dto.setCorreo(rs.getString("CORREO"));
                dto.setIdRol(rs.getInt("IDROL"));
                lista.add(dto);
            }
        } catch (Exception ex) {
            System.out.println("Error al listar datos de una persona "+ex);
        }
        return lista;
    }

    public String getRol(int id){
        String m="";
        sql = "SELECT NOMBRE FROM ROL WHERE IDROL=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                m=rs.getString("NOMBRE");
            }
        } catch (Exception ex) {
            System.out.println("Error al obtener Rol "+ex);
            return null;
        }        
        return m;
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

    public int buscarIDPersona(int dni){   
        int a = 0;
        sql = " SELECT persona.idPersona from persona "+" WHERE persona.dni = ?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            a=rs.getInt("idPersona");
        } catch (Exception e) {
            System.out.println("Error al buscar persona " + e);
        }
        return a;
    }
    
    @Override
    public List<PersonaDTO> readall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
            producto.setIdPersona(rs.getInt("IDPERSONA"));
            producto.setIdRol(rs.getInt("IDROL"));
            producto.setNombre(rs.getString("NOMBRE"));
            producto.setApellidos(rs.getString("APELLIDOS"));
            producto.setDni(rs.getInt("DNI"));
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
