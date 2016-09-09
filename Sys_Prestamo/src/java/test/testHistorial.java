/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.HistorialDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class testHistorial {

    static HistorialDAO hD = new HistorialDAO();

    public static void main(String[] args) {
        listarA();
    }

    public static void listarA() {
        String[][] datos = hD.listarHistoDocent(2);
        try {
            for (int i = 0; i < datos.length; i++) {
                int a = 0;
                while (datos[i][a] != null) {
                    System.out.println(datos[i][a]);
                    a++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public static String[][] LlenarArray() {//prueba
        String[][] ad = new String[9][10];
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    ad[i][j] = "Hola " + i + " : " + j;
                }
            }
        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return ad;
    }

}
