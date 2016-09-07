/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.Det_EquipoDAO;
import DAO.EquipoDAO;
import DAO.PrestamoDAO;
import DTO.EquipoDTO;
import config.conexion;
import java.sql.Connection;

/**
 *
 * @author USER
 */
public class testTools {

    public static Connection cx;

    public static void main(String[] args) {
        conex();
    }

    static void conex() {
        cx = conexion.getConexion();
        if (cx != null) {
            System.out.println("Exito al conectar");
        } else {
            System.out.println("Error al conectar");
        }
    }

    /*static void deleteEquipo() {
        Det_EquipoDAO eqdao = new Det_EquipoDAO();
        if (eqdao.delete(2)) {
            System.out.println("Aqui esta bien");
        }else{
            System.out.println("error");
        }
    }*/
    static void readspecificequipo(){
        EquipoDTO eqdto=new EquipoDTO("Laptop", "Envy 15", "Laptop");
        EquipoDAO eqdao=new EquipoDAO();
        System.out.println(eqdao.especifiedread(eqdto).size());
    }
    
}
