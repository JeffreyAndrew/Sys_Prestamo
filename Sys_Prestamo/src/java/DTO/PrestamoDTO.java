/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LEANDRO
 */
public class PrestamoDTO {
    private int idPrestamo;
    private int idUsuario;
    private int PersonaRes;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String lugar;
    private String comentariop;
    private String comentariod;
    private String estado;

    public PrestamoDTO() {
    }

    public PrestamoDTO(int idUsuario, int PersonaRes, String fechaPrestamo, String fechaDevolucion, String lugar, String comentariop, String comentariod, String estado) {
        this.idUsuario = idUsuario;
        this.PersonaRes = PersonaRes;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.lugar = lugar;
        this.comentariop = comentariop;
        this.comentariod = comentariod;
        this.estado = estado;
    }

    public PrestamoDTO(int idPrestamo, int idUsuario, int PersonaRes, String fechaPrestamo, String fechaDevolucion, String lugar, String comentariop, String comentariod, String estado) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.PersonaRes = PersonaRes;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.lugar = lugar;
        this.comentariop = comentariop;
        this.comentariod = comentariod;
        this.estado = estado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPersonaRes() {
        return PersonaRes;
    }

    public void setPersonaRes(int PersonaRes) {
        this.PersonaRes = PersonaRes;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getComentariop() {
        return comentariop;
    }

    public void setComentariop(String comentariop) {
        this.comentariop = comentariop;
    }

    public String getComentariod() {
        return comentariod;
    }

    public void setComentariod(String comentariod) {
        this.comentariod = comentariod;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
