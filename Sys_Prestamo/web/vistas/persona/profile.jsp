<%-- 
    Document   : profile
    Created on : 30/08/2016, 03:37:44 PM
    Author     : LEANDRO
--%>
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

                            <a href="#" class="btn btn-success"><b><i class="fa fa-pencil"></i>   Editar</b></a>
                                        <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
