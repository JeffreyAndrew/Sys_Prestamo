/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.Det_EquipoDAO;
import DAO.EquipoDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import DTO.EquipoDTO;
import DTO.ReservaDTO;

/**
 *
 * @author CESAR
 */
public class test2 {
    
        static ReservaDAO rdao = new ReservaDAO();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readdequipo();
    }

    static void readspecificequipo() {
        EquipoDTO eqdto = new EquipoDTO("Laptop", "Envy 15", "Laptop");
        EquipoDAO eqdao = new EquipoDAO();
        System.out.println(eqdao.especifiedread(eqdto).size());
    }

    static void readreserva() {
        ReservaDAO rdao = new ReservaDAO();
        UsuarioDAO udao = new UsuarioDAO();
        System.out.println(udao.read(rdao.readall().get(0).getId_usuario()).get(0).getUser());
    }

    static void crearreserva() {
        ReservaDTO rdto = new ReservaDTO();
        rdto.setDia("SUNDAY");
        rdto.setFecha_inicio("2016-05-06");
        rdto.setFecha_fin("2016-05-06");
        rdto.setId_detequipo(1);
        rdto.setId_docente(2);
        rdto.setId_usuario(1);
        if(rdao.create(rdto)){
            System.out.println("crear");
        } else {
            System.out.println("n0");
        };
    }
    static void readdequipo(){
        Det_EquipoDAO ddao=new Det_EquipoDAO();
        System.out.println(ddao.readByCode(123456).get(0).getCodigo());
    }
}
