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
public class PrestamoDTO {
    private int  idprestamo;
    private int iduser;
    private String beneficiado;
    private String fechaprestamo;
    private String fechadevolucion;

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(String beneficiado) {
        this.beneficiado = beneficiado;
    }

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public PrestamoDTO(int idprestamo, int iduser, String beneficiado, String fechaprestamo, String fechadevolucion) {
        this.idprestamo = idprestamo;
        this.iduser = iduser;
        this.beneficiado = beneficiado;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
    }

    public PrestamoDTO(int iduser, String beneficiado, String fechaprestamo, String fechadevolucion) {
        this.iduser = iduser;
        this.beneficiado = beneficiado;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
    }

    public PrestamoDTO() {
    }
    
}
