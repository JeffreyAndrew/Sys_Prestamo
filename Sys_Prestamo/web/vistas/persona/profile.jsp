<%-- 
    Document   : profile
    Created on : 30/08/2016, 03:37:44 PM
    Author     : LEANDRO
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DTO.PersonaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
        <jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
        <jsp:useBean id="persona" class="DAO.PersonaDAO"/>
        <jsp:useBean id="roles" class="DAO.RolDAO"/>
    </head>
    <body style="margin: auto;">
        <section class="content" style="width: 80%;">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <img class="profile-user-img img-responsive img-circle" src="dist/img/profile.jpg" alt="User profile picture">
                            <%
                                for (int i = 0; i < lista.size(); i++) {
                                    PersonaDTO u = new PersonaDTO();
                                    u = (PersonaDTO) lista.get(i);
                                    String rol = persona.getRol(u.getIdRol());
                            %>
                            <h3 class="profile-username text-center"><%= u.getNombre() + " " + u.getApellidos()%></h3>

                            <p class="text-muted text-center"><%=rol%></p>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b><i class="fa fa-credit-card"></i>   DNI</b> <a class="pull-right"><%= u.getDni()%></a>
                                </li>
                                <li class="list-group-item">
                                    <b><i class="fa fa-phone"></i>   Teléfono</b> <a class="pull-right"><%= u.getTelefono()%></a>
                                </li>
                                <li class="list-group-item">
                                    <b>Correo</b> <a class="pull-right"><%= u.getCorreo()%></a>
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
                                            <form method="post" action="ci">
                                                <div class="form-group">
                                                    <label>Nombre(s)</label>
                                                    <input class="form-control" name="name" type="text" value="<%= u.getNombre()%>">
                                                    <label>Apellidos</label>
                                                    <input class="form-control" name="last" type="text" value="<%= u.getApellidos()%>">
                                                    <label>Rol</label>
                                                    <p id="rolnow"><%=rol%></p><input type="hidden" value="<%= u.getIdRol()%>">
                                                    <button type="button" onclick="changerol()" class="btn btn-warning changerol" style="display: block;"><i class="fa fa-refresh"></i></button>
                                                    <select class="form-control comboRol hidden">
                                                        <option disabled>Escoger Rol</option>
                                                        <% ResultSet rs = roles.list();
                                                            while (rs.next()) {%>
                                                        <option value="<%= rs.getInt("idROL")%>"><%= rs.getString("NOMBRE")%></option>
                                                        <%}%>
                                                    </select>
                                                    <label>DNI</label>
                                                    <input class="form-control" name="dni" type="text" value="<%= u.getDni()%>">
                                                    <label>Telefono</label>
                                                    <input class="form-control" name="phone" type="text" value="<%= u.getTelefono()%>">
                                                    <label>Correo</label>
                                                    <input class="form-control" name="mail" type="email" value="<%= u.getCorreo()%>">
                                                </div>
                                                <button type="submit" class="btn btn-success" style="width: 100%;">Aceptar</button>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-close"></i>   Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button data-toggle="modal" data-target="#editModal" class="btn btn-success"><b><i class="fa fa-pencil"></i>   Editar</b></button>
                                        <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script>
            function changerol() {
                $(".comboRol").attr("class","form-control comboRol");
                $(".changerol").attr("class","hidden");
                $("#rolnow").attr("class","hidden");
            }
        </script>
    </body>
</html>
