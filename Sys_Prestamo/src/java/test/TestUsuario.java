/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import DAO.UsuarioDAO;


/**
 *
 * @author CESAR
 */
public class TestUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        eliminar();
    }
    static void eliminar(){
        UsuarioDAO uO = new UsuarioDAO();
        if (uO.delete(2)) {
            System.out.println("Aqui esta bien");
        }else{
            System.out.println("error");
        }
    }
    
   
}
