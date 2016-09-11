<%-- 
    Document   : index
    Created on : 25/08/2016, 10:09:05 PM
    Author     : LEANDRO
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DTO.PersonaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%try {%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SPE || UPeU</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <%@include file="WEB-INF/jspf/import.jspf" %>
        <jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
        <jsp:useBean id="persona" class="DAO.PersonaDAO"/>
        <jsp:useBean id="roles" class="DAO.RolDAO"/>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <%
            for (int i = 0; i < lista.size(); i++) {
                PersonaDTO u = new PersonaDTO();
                u = (PersonaDTO) lista.get(i);
                String rol = persona.getRol(u.getIdRol());
                int irol = u.getIdRol();
        %>
        <div class="wrapper">

            <header class="main-header">
                <a href="#" class="logo">
                    <span class="logo-mini">SPE</span>
                    <span class="logo-lg"><b>SPE</b>UPeU</span>
                </a>
                <nav class="navbar navbar-static-top">
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">          
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="dist/img/<%=rol + u.getSexo()%>.jpg" class="user-image" alt="User Image">
                                    <span class="hidden-xs"><%= u.getNombre() + " " + u.getApellidos()%></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="user-header">
                                        <img src="dist/img/<%=rol + u.getSexo()%>.jpg" class="img-circle" alt="User Image">

                                        <p>
                                            <%= u.getNombre() + " " + u.getApellidos()%>
                                            <small><%= rol%></small>
                                        </p>
                                    </li>
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="ci?op=2&id=<%=u.getIdPersona()%>" target="box" class="btn btn-default btn-flat">Perfil</a>
                                        </div>
                                        <div class="pull-right">
                                            <a href="login?act=out" class="btn btn-default btn-flat">Salir</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <aside class="main-sidebar">
                <section class="sidebar">
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="dist/img/<%=rol + u.getSexo()%>.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p><%= u.getNombre()%></p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Activo</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu">
                        <li class="header">MENÚ</li>
                        <li>
                            <a href="ci?op=2&id=<%=u.getIdPersona()%>" target="box">
                                <i class="fa fa-user"></i> <span>Perfil</span>
                            </a>
                        </li>
                        <%if (irol == 1 || irol == 2) {%>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i> <span>Gestión Prestamo</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a target="box" href="main?op=1&id=<%= u.getIdPersona()%>"><i class="fa fa-gear"></i> Prestamo de Equipo</a></li>
                                <li><a target="box" href="loan?mt=rd&op=2"><i class="fa fa-gear"></i> Devolución de Equipo</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-calendar"></i> <span>Reservas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a target="box" href="rc?gr=2"><i class="fa fa-circle-o"></i> Hacer una Reserva</a></li>
                                <li><a target="box" href="rc?gr=1"><i class="fa fa-circle-o"></i> Lista de Reservas</a></li>
                            </ul>
                        </li>
                        <% }
                            if (irol == 1) {%>
                        <li class="treeview" id="Equipos">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Equipos</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="ec?ge=2" target="box"><i class="fa fa-circle-o"></i> Registrar</a></li>
                                <li><a href="ec?ge=1" target="box"><i class="fa fa-circle-o"></i> Inventario de Equipos</a></li>
                            </ul>
                        </li>
                        <% }
                            if (irol == 1) {
                        %>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-user"></i> <span>Gestión de Roles</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="admin?op=1" target="box"><i class="fa fa-gear"></i> Gestión de Roles</a></li>
                            </ul>
                        </li>
                        <% }
                            if (irol == 1) {
                        %>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-user"></i> <span>Usuario</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="ci?op=4" target="box"><i class="fa fa-gear"></i>Lista usuarios</a></li>
                            </ul>
                        </li>
                        <% }
                            if (irol == 1 || irol == 2) {
                        %>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-users"></i> <span>Gestión de Personas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="ci?op=1&id=<%=u.getIdPersona()%>" target="box"><i class="fa fa-user"></i>  Añadir Persona</a></li>
                                <li><a href="ci?op=6&id=<%=u.getIdPersona()%>" target="box"><i class="fa fa-users"></i>  Listar Personas</a></li>
                            </ul>
                        </li>
                        <% }%>


                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-pie-chart"></i>
                                <span>Estadistica</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a><ul class="treeview-menu menu-open" style="display: none;">
                                <li class=""><a href="Esta?op=2"><i class="fa fa-circle-o"></i> Porcentaje </a></li>
                                <li><a href="Esta?op=1" ><i class="fa fa-circle-o"></i>En intervalo de fechas</a></li>
                                <li><a href="Esta?op=3"><i class="fa fa-circle-o"></i> sin devolver</a></li>
                            </ul> 
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-history" aria-hidden="true"></i> <span>Historial de Préstamos</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="SVLH?histo=1" target="box"><i class="fa fa-laptop" aria-hidden="true"></i> Préstamo del equipo</a></li>
                                <li><a href="SVLH?histo=3" target="box"><i class="fa fa-globe" aria-hidden="true"></i> Todos los Préstamos</a></li>
                            </ul>
                        </li>


                    </ul>
                </section>
            </aside>

            <div class="content-wrapper">
                <iframe name="box" src="ci?op=2&id=<%=u.getIdPersona()%>" id="idboxload" onload="loadFrame(this.contentWindow.location);"
                        style="height: 1000px;width: 100%; border: none; overflow-y: hidden">
                </iframe>
            </div>
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 1.0.0
                </div>
                <strong>Copyright &copy;Ingeniería de Sistemas IV CICLO || 2016-II</strong> All rights
                reserved.
            </footer>


        </div>  
        <%}%>
    </body>
</html>
<%} catch (Exception e) {%>
<%@include file="/tools/files/error.jsp"  %>
<%}

%>