/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.PrestamoDAO;
import DTO.PrestamoDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class testPrestamo {

    static PrestamoDAO p = new PrestamoDAO();

    public static void main(String[] args) {
        det_prestamo(1);
    }

    public static void add() {
        Map<String, Object> c = new HashMap<>();
        c.put("idusuario", 1);
        c.put("persona", 1);
        c.put("fecha", "2016-08-28");
        c.put("lugar", "asd");
        int a= p.add(c);
        System.out.println(a);
    }
    public static void det_prestamo(int id){
        ArrayList<Map<String,?>> ab=p.listareq(id);
        for (int i = 0; i < ab.size(); i++) {
            System.out.println(ab.get(i).get("tipo").toString());
            System.out.println(ab.get(i).get("serie").toString());
        }
    }

}
