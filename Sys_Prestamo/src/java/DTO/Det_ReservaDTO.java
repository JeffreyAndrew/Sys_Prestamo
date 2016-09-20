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
public class Det_ReservaDTO {
    
    private int idDet_Equipo;
    private int idReserva;

    public Det_ReservaDTO(int idDet_Equipo, int idReserva) {
        this.idDet_Equipo = idDet_Equipo;
        this.idReserva = idReserva;
    }

    public Det_ReservaDTO() {
    }

    public int getIdDet_Equipo() {
        return idDet_Equipo;
    }

    public void setIdDet_Equipo(int idDet_Equipo) {
        this.idDet_Equipo = idDet_Equipo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    
}
