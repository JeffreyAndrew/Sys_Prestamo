/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import config.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garcia
 */
public class PersonaDTO {

    public int getIdPersona() {
        return idPersona;
    }
    private int idPersona;
    private int idRol;
    private String nombre;
    private String apellidos;
    private int dni;
    private int celular;
    private String correo;

    public PersonaDTO() {
    }

    public PersonaDTO(int idRol, String nombre, String apellidos, int dni, int celular, String correo) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public PersonaDTO(int idPersona, int idRol, String nombre, String apellidos, int dni, int celular, String correo) {
        this.idPersona = idPersona;
        this.idRol = idRol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

}
