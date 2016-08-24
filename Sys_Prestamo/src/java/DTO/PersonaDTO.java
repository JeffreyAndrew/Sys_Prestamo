
package DTO;

public class PersonaDTO {
    
    private int idpersona;
    private String nombre;
    private String apellido;
    private int DNI;
    private int idrol;
    private String facultad;
    private String escuela;
    private int telefono;
    private String correo;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, int DNI, int idrol, String facultad, String escuela, int telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.idrol = idrol;
        this.facultad = facultad;
        this.escuela = escuela;
        this.telefono = telefono;
        this.correo = correo;
    }

    public PersonaDTO(int idpersona, String nombre, String apellido, int DNI, int idrol, String facultad, String escuela, int telefono, String correo) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.idrol = idrol;
        this.facultad = facultad;
        this.escuela = escuela;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    

}
