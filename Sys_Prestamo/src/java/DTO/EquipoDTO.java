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
public class EquipoDTO {
    
   private int idEquipo;
   private String nombre;
   private String serie;
   private String tipo;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EquipoDTO(int idEquipo, String nombre, String serie, String tipo) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.serie = serie;
        this.tipo = tipo;
    }
    
    public EquipoDTO(String nombre, String serie, String tipo) {
        this.nombre = nombre;
        this.serie = serie;
        this.tipo = tipo;
    }

    public EquipoDTO() {
    }
    
    
}
