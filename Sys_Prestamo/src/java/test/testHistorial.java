/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.HistorialDAO;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class testHistorial {

    static HistorialDAO hD = new HistorialDAO();
    
    public static void main(String[] args) {
        listarA(2);
    }

    public static void listarA(int id) {
        ArrayList<String[][]> lista=hD.listarHistoDocent(id);
        /*for (int i = 0; i < lista.size(); i++) {
            System.out.println(i);
        }*/
        System.out.println("hola");
    }

}
