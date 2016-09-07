/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.PersonaDAO;
import DTO.PersonaDTO;
import java.util.List;

/**
 *
 * @author LEANDRO
 */
public class testPersona {

    static PersonaDAO aO = new PersonaDAO();

    public static void main(String[] args) {
        vpersona(1);
    }

    public static void vpersona(int id){
        List<PersonaDTO> p=aO.read(id);
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i).getNombre());
            System.out.println(p.get(i).getApellidos());
        }    
    }
}
