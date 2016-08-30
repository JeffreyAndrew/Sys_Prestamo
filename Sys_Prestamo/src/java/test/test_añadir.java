/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.PersonaDAO;
import DTO.PersonaDTO;
import java.util.ArrayList;
import java.util.List;
import config.conexion;

/**
 *
 * @author EXEBIO
 */
public class test_añadir {
private static PersonaDAO aO = new PersonaDAO();
   
    public static void main(String[] args) {
                crear();
    }
    public static void conex() {
        if (conexion.getConexion() != null) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }
    }
           public static void crear(){
           
           
          PersonaDTO ps= new PersonaDTO(4, "hanselpro2", "elpro", 03333, 04774, "correo@dsdfw");
        boolean p = aO.create(ps);
        if (p) {
            System.out.println("crear");
        } else {
            System.out.println("n0");
        }
    }

          
          
     
     
    
         
         
         
     }
