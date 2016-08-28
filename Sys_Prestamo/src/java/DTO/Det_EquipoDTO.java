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
public class Det_EquipoDTO {
    
    private int idDet_Equipo;
    private int idEquipo;
    private int codigo;
    private String descripcion;
    private String estado;

    public int getIdDet_Equipo() {
        return idDet_Equipo;
    }

    public void setIdDet_Equipo(int idDet_Equipo) {
        this.idDet_Equipo = idDet_Equipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Det_EquipoDTO(int idDet_Equipo, int idEquipo, int codigo, String descripcion, String estado) {
        this.idDet_Equipo = idDet_Equipo;
        this.idEquipo = idEquipo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Det_EquipoDTO(int idEquipo, int codigo, String descripcion, String estado) {
        this.idEquipo = idEquipo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Det_EquipoDTO() {
    }
    
    
}
