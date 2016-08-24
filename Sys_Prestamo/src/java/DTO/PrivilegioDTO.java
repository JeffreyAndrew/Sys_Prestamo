
package DTO;

public class PrivilegioDTO {
    
    private int idprivilegio;
    private String nombre;
    private String estado;

    public PrivilegioDTO() {
    }

    public PrivilegioDTO(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    
    public PrivilegioDTO(int idprivilegio, String nombre, String estado) {
        this.idprivilegio = idprivilegio;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdprivilegio() {
        return idprivilegio;
    }

    public void setIdprivilegio(int idprivilegio) {
        this.idprivilegio = idprivilegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
