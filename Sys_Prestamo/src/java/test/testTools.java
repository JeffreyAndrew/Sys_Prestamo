/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.Det_EquipoDAO;
import DAO.EquipoDAO;
import config.conexion;
import java.sql.Connection;

/**
 *
 * @author USER
 */
public class testTools {

    public static Connection cx;

    public static void main(String[] args) {
        deleteEquipo();
    }

    static void conex() {
        cx = conexion.getConexion();
        if (cx != null) {
            System.out.println("Exito al conectar");
        } else {
            System.out.println("Error al conectar");
        }
    }

    static void deleteEquipo() {
        Det_EquipoDAO eqdao = new Det_EquipoDAO();
        if (eqdao.delete(2)) {
            System.out.println("Aqui esta bien");
        }else{
            System.out.println("error");
        }
    }
}
