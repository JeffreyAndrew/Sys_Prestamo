/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
        readallEquipo();
    }
    
    static void conex() {
        cx = conexion.getConexion();
        if (cx != null) {
            System.out.println("Exito al conectar");
        } else {
            System.out.println("Error al conectar");
        }
    }
    static void readallEquipo(){
        EquipoDAO eqdao=new EquipoDAO();
        System.out.println(eqdao.readall().get(0).getNombre());
    }
}
