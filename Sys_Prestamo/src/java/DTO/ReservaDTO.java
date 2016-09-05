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
public class ReservaDTO {
    private int id_reserva;
    private int id_usuario;
    private int id_docente;
    private int id_detequipo;
    private String fecha_reserva;
    private String fecha_inicio;
    private String fecha_fin;
    private String dia;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_detequipo() {
        return id_detequipo;
    }

    public void setId_detequipo(int id_detequipo) {
        this.id_detequipo = id_detequipo;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public ReservaDTO(int id_reserva, int id_usuario, int id_docente, int id_detequipo, String fecha_reserva, String fecha_inicio, String fecha_fin, String dia) {
        this.id_reserva = id_reserva;
        this.id_usuario = id_usuario;
        this.id_docente = id_docente;
        this.id_detequipo = id_detequipo;
        this.fecha_reserva = fecha_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dia = dia;
    }

    public ReservaDTO(int id_usuario, int id_docente, int id_detequipo, String fecha_reserva, String fecha_inicio, String fecha_fin, String dia) {
        this.id_usuario = id_usuario;
        this.id_docente = id_docente;
        this.id_detequipo = id_detequipo;
        this.fecha_reserva = fecha_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dia = dia;
    }

    public ReservaDTO() {
    }
    
}
