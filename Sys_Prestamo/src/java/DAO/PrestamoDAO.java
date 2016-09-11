/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.EquipoDTO;
import DTO.PrestamoDTO;
import config.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LEANDRO
 */
public class PrestamoDAO {

    private String sql;
    private Connection cn;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    public int add(Object t) {
        int p = 0;
        sql = "{CALL REG_PRESTAMO(?, ?, ?, ?)}";
        Map<String, Object> m = (Map<String, Object>) t;
        try {
            cn = conexion.getConexion();
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.parseInt(m.get("idusuario").toString()));
            cs.setInt(2, Integer.parseInt(m.get("persona").toString()));
            cs.setString(3, m.get("hora").toString());
            cs.setString(4, m.get("lugar").toString());
            rs = cs.executeQuery();
            while (rs.next()) {
                p = rs.getInt("idPRESTAMO");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar prestamo " + e);
        }
        return p;
    }

    public boolean removeeq(int p, int e) {
        boolean m = false;
        sql = "DELETE FROM DET_PRESTAMO WHERE IDPRESTAMO=? AND IDDET_EQUIPO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, p);
            ps.setInt(2, e);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al quitar equipo del prestamo " + ex);
        }
        return m;
    }

    public ArrayList<Map<String, ?>> listared() {
        sql = "SELECT D.IDDET_EQUIPO,E.IDEQUIPO,D.CODIGO,D.DESCRIPCION,E.MARCA,E.SERIE,E.TIPO "
                + " FROM DET_EQUIPO D,EQUIPO E WHERE ESTADO=1 AND D.IDEQUIPO=E.IDEQUIPO;";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("iddet", rs.getInt("IDDET_EQUIPO"));
                m.put("idequipo", rs.getInt("IDEQUIPO"));
                m.put("codigo", rs.getString("CODIGO"));
                m.put("descripcion", rs.getString("DESCRIPCION"));
                m.put("marca", rs.getString("MARCA"));
                m.put("serie", rs.getString("SERIE"));
                m.put("tipo", rs.getString("TIPO"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Equipos Disponibles " + e);
            return null;
        }
        return lista;
    }

    public ArrayList<Map<String, ?>> listardp(int idprestamo) {
        sql = "SELECT * FROM PRESTAMO PR,PERSONA P "
                + "WHERE P.IDPERSONA=PR.IDPERSONA "
                + "AND PR.IDPRESTAMO=?";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idprestamo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("fprestamo", rs.getString("fechaPRESTAMO"));
                m.put("hprestamo", rs.getString("horaPRESTAMO"));
                m.put("hlimite", rs.getString("horaLIMITE"));
                m.put("comentariop", rs.getString("COMENTARIOP"));
                m.put("persona", rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar detalles del Prestamo " + e);
            return null;
        }
        return lista;
    }

    public boolean addeqprestamo(int p, int e) {
        boolean m = false;
        sql = "INSERT INTO DET_PRESTAMO (idPRESTAMO ,idDET_EQUIPO,ESTADO) VALUES(?,?,1)";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, p);
            ps.setInt(2, e);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error al agregar Equipo al Prestamo " + ex);
        }
        return m;
    }

    public boolean changeestatus(String a, int e) {
        boolean m = false;
        sql = "UPDATE DET_EQUIPO SET ESTADO=? WHERE IDDET_EQUIPO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, a);
            ps.setInt(2, e);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error cambiar estado de un equipo " + ex);
        }
        return m;
    }

    public boolean changecom(String com, int id) {
        boolean m = false;
        sql = "UPDATE PRESTAMO SET COMENTARIOP=? WHERE IDPRESTAMO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, com);
            ps.setInt(2, id);
            int r = ps.executeUpdate();
            if (r > 0) {
                m = true;
            }
        } catch (Exception ex) {
            System.out.println("Error comentar el prestamo " + ex);
        }
        return m;
    }

    public ArrayList<Map<String, ?>> listareq(int idprestamo) {
        sql = "SELECT D.IDDET_EQUIPO,E.IDEQUIPO,E.CODIGO,E.DESCRIPCION,EQ.MARCA,EQ.SERIE,EQ.TIPO "
                + "FROM DET_PRESTAMO D,DET_EQUIPO E,EQUIPO EQ "
                + "WHERE D.IDPRESTAMO=" + idprestamo + " "
                + "AND E.IDDET_EQUIPO=D.IDDET_EQUIPO "
                + "AND EQ.IDEQUIPO=E.IDEQUIPO "
                + "AND D.ESTADO=1;";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("iddet", rs.getInt("IDDET_EQUIPO"));
                m.put("idequipo", rs.getInt("IDEQUIPO"));
                m.put("codigo", rs.getString("CODIGO"));
                m.put("descripcion", rs.getString("DESCRIPCION"));
                m.put("marca", rs.getString("MARCA"));
                m.put("serie", rs.getString("SERIE"));
                m.put("tipo", rs.getString("TIPO"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Equipos del Prestamo " + e);
            return null;
        }
        return lista;
    }

    public ArrayList<Map<String, ?>> listdh() {
        sql = "SELECT DISTINCT(P.IDPERSONA),P.NOMBRE,P.APELLIDOS,P.DNI "
                + "FROM PERSONA P LEFT OUTER JOIN PRESTAMO E  "
                + "ON P.IDPERSONA=E.IDPERSONA "
                + "WHERE P.IDROL=3 "
                + "AND (E.IDPERSONA IS NULL) "
                + "OR (P.IDPERSONA IS NULL OR E.ESTADO=0);";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("idpersona", rs.getInt("IDPERSONA"));
                m.put("persona", rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS"));
                m.put("dni", rs.getString("DNI"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Docentes habilitados " + e);
            return null;
        }
        return lista;
    }

    public ArrayList<Map<String, ?>> listd(int id) {
        sql = "SELECT * FROM PERSONA WHERE IDPERSONA=?";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("persona", rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS"));
                m.put("dni", rs.getString("DNI"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Docente " + e);
            return null;
        }
        return lista;
    }

    public ArrayList<Map<String, ?>> listdc() {
        sql = "SELECT DISTINCT(T.IDPRESTAMO),P.IDPERSONA,P.NOMBRE,P.APELLIDOS,P.DNI "
                + "FROM PERSONA P,ROL R,PRESTAMO T "
                + "WHERE P.IDROL=R.IDROL  "
                + "AND R.IDROL=3 "
                + "AND T.IDPERSONA=P.IDPERSONA "
                + "AND T.ESTADO=1;";
        ArrayList<Map<String, ?>> lista = new ArrayList<>();
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("idprestamo", rs.getInt("IDPRESTAMO"));
                m.put("idpersona", rs.getInt("IDPERSONA"));
                m.put("persona", rs.getString("NOMBRE") + " " + rs.getString("APELLIDOS"));
                m.put("dni", rs.getString("DNI"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar Docentes con prestamo activo " + e);
            return null;
        }
        return lista;
    }

    public boolean returnEq(int id) {
        boolean m = false;
        sql = "{CALL RETURN_EQU(?)}";
        try {
            cn = conexion.getConexion();
            cs = cn.prepareCall(sql);
            cs.setInt(1, id);
            cs.executeUpdate();
            m = true;
        } catch (Exception e) {
            System.out.println("Error al devolver Equipo " + e);
            m = false;
        }
        return m;
    }

    public boolean returnloan(int id) {
        boolean m = false;
        sql = "UPDATE PRESTAMO SET ESTADO=0 WHERE IDPRESTAMO=?";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int a = ps.executeUpdate();
            if (a > 0) {
                m = true;
            }
        } catch (Exception e) {
            System.out.println("Error al devolver Prestamo " + e);
        }
        return m;
    }

    public List<PrestamoDTO> buscarPrestamo(String cadena) {
        conexion oConexion = new conexion();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PRESTAMO WHERE FECHAPRESTAMO LIKE '").append(cadena);
        sql.append("%'");
        List<PrestamoDTO> list = new ArrayList<PrestamoDTO>();
        try {
            ResultSet rs = oConexion.query(sql.toString());
            while (rs.next()) {
                PrestamoDTO prestamo = new PrestamoDTO();

                prestamo.setIdPrestamo(rs.getInt("IDPRESTAMO"));
                prestamo.setIdUsuario(rs.getInt("IDUSUARIO"));
                prestamo.setPersonaRes(rs.getInt("PERSONARES"));
                prestamo.setFechaPrestamo(rs.getString("FECHAPRESTAMO"));
                prestamo.setFechaDevolucion(rs.getString("FECHADEVOLUCION"));
                prestamo.setLugar(rs.getString("LUGAR"));
                prestamo.setComentariop(rs.getString("COMENTARIOP"));
                prestamo.setComentariod(rs.getString("COMENTARIOD"));
                prestamo.setEstado(rs.getString("ESTADO"));

                list.add(prestamo);
            }
        } catch (SQLException e) {
        } finally {

        }
        return list;
    }

    public List<EquipoDTO> deudafechas(Date menor, Date mayor) {
        List<EquipoDTO> deudas = new ArrayList<>();
        sql = "SELECT * from det_prestamo, equipo,prestamo where prestamo.idPrestamo= det_prestamo.idPrestamo AND prestamo.fechaPrestamo >= ? AND prestamo <= ?; ";
        try {
            cn = conexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, String.valueOf(menor));
            ps.setString(2, String.valueOf(mayor));
            rs = ps.executeQuery();
            while (rs.next()) {
                EquipoDTO eqDTO = new EquipoDTO();
                eqDTO.setIdEquipo(rs.getInt("idEquipo"));
                eqDTO.setMarca(rs.getString("marca"));
                eqDTO.setSerie(rs.getString("serie"));
                eqDTO.setTipo(rs.getString("tipo"));
                deudas.add(eqDTO);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar equipos " + e);
        }
        return deudas;
    }
}
