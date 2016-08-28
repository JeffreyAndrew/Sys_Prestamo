/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author CESAR
 */
public class Det_PrestamoDTO {
    
    private int idPrestamo;
    private int idDet_Equipo;

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdDet_Equipo() {
        return idDet_Equipo;
    }

    public void setIdDet_Equipo(int idDet_Equipo) {
        this.idDet_Equipo = idDet_Equipo;
    }

    public Det_PrestamoDTO(int idPrestamo, int idDet_Equipo) {
        this.idPrestamo = idPrestamo;
        this.idDet_Equipo = idDet_Equipo;
    }

    public Det_PrestamoDTO() {
    }
    
    
}
