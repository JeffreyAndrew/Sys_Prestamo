
package DTO;

public class UsuarioDTO {
    
    private int idusuario;
    private int idpersona;
    private String user;
    private String password;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int idpersona, String user, String password) {
        this.idpersona = idpersona;
        this.user = user;
        this.password = password;
    }

    public UsuarioDTO(int idusuario, int idpersona, String user, String password) {
        this.idusuario = idusuario;
        this.idpersona = idpersona;
        this.user = user;
        this.password = password;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
}
