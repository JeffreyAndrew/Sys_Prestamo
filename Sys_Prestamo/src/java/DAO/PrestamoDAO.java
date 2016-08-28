/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PrestamoDTO;
import Interfaces.Operaciones;
import config.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author LEANDRO
 */
public class PrestamoDAO implements Operaciones<PrestamoDTO> {

    private String sql;
    private Connection cn;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    @Override
    public boolean create(PrestamoDTO p) {
        sql = "INSERT INTO PRESTAMO (idPrestamo ,idUsuario,PersonaRes,fechaPrestamo,fechaDevolucion,lugar,comentariop,comentariod,estado) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);

            int r = ps.executeUpdate();
            return r > 0;
        } catch (Exception e) {
            System.out.println("Error al agregar Prestamo " + e);
            return false;
        }
    }

    @Override
    public List<PrestamoDTO> read(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PrestamoDTO e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrestamoDTO> readall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
