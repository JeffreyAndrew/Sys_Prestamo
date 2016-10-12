<%-- 
    Document   : profile
    Created on : 30/08/2016, 03:37:44 PM
    Author     : LEANDRO
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="DTO.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
        <jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
        <jsp:useBean id="persona" class="DAO.PersonaDAO"/>
        <jsp:useBean id="usuario" class="DAO.UsuarioDAO"/>
        <jsp:useBean id="roles" class="DAO.RolDAO"/>
    </head>
    <body style="margin: auto;">
        <section class="content" style="width: 80%;">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-danger">
                        <div class="box-body box-profile">
                            <%
                                String pass = "";
                                for (int i = 0; i < lista.size(); i++) {
                                    PersonaDTO u = new PersonaDTO();
                                    u = (PersonaDTO) lista.get(i);
                                    String rol = persona.getRol(u.getIdRol());
                                    ResultSet mp = usuario.list(u.getIdPersona());
                                    if (mp != null) {
                                        while (mp.next()) {
                                            String m = mp.getString("CLAVE");
                                            for (int p = 0; p < m.length(); p++) {
                                                pass = pass + "*";
                                            }
                                            
                            %>
                            <img class="profile-user-img img-responsive img-circle" src="dist/img/<%=rol + u.getSexo()%>.jpg" alt="User profile picture">
                            <h3 class="profile-username text-center"><%= u.getNombre() + " " + u.getApellidos()%></h3>
                            <input type="hidden" value="<%= u.getIdPersona()%>" id="idpersona">
                            <p class="text-muted text-center"><%=rol%></p>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b><i class="fa fa-credit-card"></i>   DNI</b> <a class="pull-right"><%= u.getDni()%></a>
                                </li>
                                <li class="list-group-item">
                                    <b><i class="fa fa-phone"></i>   Teléfono</b> <a class="pull-right"><%= u.getTelefono()%></a>
                                </li>
                                <li class="list-group-item">
                                    <b><i class="fa fa-envelope-o"></i>   Correo</b> <a class="pull-right"><%= u.getCorreo()%></a>
                                </li>
                                <li class="list-group-item">
                                    <b><i class="fa fa-user"></i>   Usuario</b> <a class="pull-right"><%= mp.getString("USUARIO")%></a>
                                </li>
                                <li class="list-group-item">
                                    <b><i class="fa fa-lock"></i>   Contraseña</b> <a class="pull-right"><%=pass%></a>
                                    <input id="idpass" type="hidden" value="<%=mp.getString("CLAVE")%>">
                                </li>
                            </ul>
                            <div class="modal fade" id="editModal" tabindex="-1" role="dialog">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title"><i class="fa fa-pencil"></i>   Editar datos</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form>
                                                <div class="form-group">
                                                    <label>Nombre(s)</label>
                                                    <input class="form-control" id="name" type="text" value="<%= u.getNombre()%>">
                                                    <label>Apellidos</label>
                                                    <input class="form-control" id="last" type="text" value="<%= u.getApellidos()%>">
                                                    <label>Rol</label>
                                                    <p id="rolnow"><%=rol%></p><input id="idrol" type="hidden" value="<%= u.getIdRol()%>">
                                                    <button type="button" onclick="changerol()" class="btn btn-warning changerol" style="display: block;"><i class="fa fa-refresh"></i></button>
                                                    <select onclick="changev(this.value)" id="newrol" class="form-control comboRol hidden">
                                                        <option disabled selected>Escoger Rol</option>
                                                        <% ResultSet rs = roles.list();
                                                            while (rs.next()) {%>
                                                        <option value="<%= rs.getInt("idROL")%>"><%= rs.getString("NOMBRE")%></option>
                                                        <%}%>
                                                    </select>
                                                    <label>DNI</label>
                                                    <input class="form-control" id="dni" type="text" value="<%= u.getDni()%>">
                                                    <label>Telefono</label>
                                                    <input class="form-control" id="phone" type="text" value="<%= u.getTelefono()%>">
                                                    <label>Correo</label>
                                                    <input class="form-control" id="mail" type="email" value="<%= u.getCorreo()%>">
                                                    <input type="hidden" value="1" id="tipo">
                                                </div>
                                                <button type="button" onclick="validarS()" class="btn btn-success" style="width: 100%;">Aceptar</button>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger sub" data-dismiss="modal"><i class="fa fa-close"></i>   Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="editUserModal" tabindex="-1" role="dialog">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title"><i class="fa fa-lock"></i>   Editar Usuario</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div>
                                                <label>Usuario</label>
                                                <input class="form-control" id="nwuser" type="text" value="<%= mp.getString("USUARIO")%>"  placeholder="Ingrese su usuario">                                                
                                                <label>Contraseña</label>
                                                <input class="form-control" id="nwpass" type="password" value="<%= mp.getString("CLAVE")%>" placeholder="Ingrese su contraseña actual">
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger sub" data-dismiss="modal"><i class="fa fa-close"></i>   Cerrar</button>
                                            <button onclick="upuser()" type="button" class="btn btn-success"><i class="fa fa-check"></i>   Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button data-toggle="modal" data-target="#editModal" class="btn btn-success" style="display: inline-block;float: left;"><b><i class="fa fa-pencil"></i>   Editar Datos</b></button>
                            <button data-toggle="modal" data-target="#editUserModal" class="btn btn-warning" style="display: inline-block;float: right;"><b><i class="fa fa-lock"></i>   Editar Usuario</b></button>
                                        <%}
                                        } else {%>
                                        <%@include file="/vistas/persona/profiled.jsp" %>
                                        <% }%>            
                                        <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="tools/js/lbprofile.js" type="text/javascript"></script>
    </body>
</html>
