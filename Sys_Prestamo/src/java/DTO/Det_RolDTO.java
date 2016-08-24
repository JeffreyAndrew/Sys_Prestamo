/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author alum.fial1
 */
public class Det_RolDTO {
    
   private int iddetalle;
   private int idrol;
   private int idprivilegio;

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public int getIdprivilegio() {
        return idprivilegio;
    }

    public void setIdprivilegio(int idprivilegio) {
        this.idprivilegio = idprivilegio;
    }

    public Det_RolDTO(int iddetalle, int idrol, int idprivilegio) {
        this.iddetalle = iddetalle;
        this.idrol = idrol;
        this.idprivilegio = idprivilegio;
    }

    public Det_RolDTO(int idrol, int idprivilegio) {
        this.idrol = idrol;
        this.idprivilegio = idprivilegio;
    }

    public Det_RolDTO() {
    }
    
}
