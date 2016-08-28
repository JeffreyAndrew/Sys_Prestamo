/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.EquipoDAO;
import DTO.EquipoDTO;

/**
 *
 * @author CESAR
 */
public class test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readspecificequipo();
    }
    static void readspecificequipo(){
        EquipoDTO eqdto=new EquipoDTO("Laptop", "Envy 15", "Laptop");
        EquipoDAO eqdao=new EquipoDAO();
        System.out.println(eqdao.especifiedread(eqdto).size());
    }
    
}
