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
    private String fecha_reserva;
    private String fecha_inicio;
    private String fecha_fin;
    private String dia;
    private String hora_ini;
    private String hora_fin;

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

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public ReservaDTO(int id_reserva, int id_usuario, int id_docente, int id_detequipo, String fecha_reserva, String fecha_inicio, String fecha_fin, String dia,String hora_ini,String hora_fin) {
        this.id_reserva = id_reserva;
        this.id_usuario = id_usuario;
        this.id_docente = id_docente;
        this.fecha_reserva = fecha_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dia = dia;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
    }

    public ReservaDTO(int id_usuario, int id_docente, int id_detequipo, String fecha_reserva, String fecha_inicio, String fecha_fin, String dia,String hora_ini,String hora_fin) {
        this.id_usuario = id_usuario;
        this.id_docente = id_docente;
        this.fecha_reserva = fecha_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dia = dia;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
    }

    public ReservaDTO() {
    }
    
}
