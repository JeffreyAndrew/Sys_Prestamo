<%-- 
    Document   : list
    Created on : 05/09/2016, 09:23:52 PM
    Author     : LEANDRO
--%>

<%@page  import="DTO.PersonaDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="persona" class="DAO.PersonaDAO"/>
<jsp:useBean id="rol2" class="DAO.RolDAO"/>
<jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
        <jsp:useBean id="rol" class="DAO.RolDAO"></jsp:useBean>
        </head>
        <body style="padding: 2% 6%;box-sizing: border-box;">
        <%

            for (int i = 0; i < lista.size(); i++) {

                PersonaDTO u = new PersonaDTO();
                u = (PersonaDTO) lista.get(i);
                String rol = persona.getRol(u.getIdRol());

                int irol = u.getIdRol();


        %>





    <center><h1>Personas</h1></center>
    <div class="col-md-4">
        <select onchange="listar(this.value)" id="selRol" class="form-control select2">
            <option disabled selected>Elegir Rol</option>
            <% if (irol == 1) {%>   

            <% ResultSet rs = rol2.list();
                while (rs.next()) {%>
            <option value="<%= rs.getInt("idROL")%>" ><%= rs.getString("NOMBRE")%></option>
            <%}%>

            <%}%>
            <% if (irol == 2) {%>   

            <% ResultSet rs = rol2.list1();
                while (rs.next()) {%>
            <option value="<%= rs.getInt("idROL")%>" ><%= rs.getString("NOMBRE")%></option>
            <%}%>

            <%}%>
            


        </select>
    </div>
    <br/><br/>
    <div class="row hidden dTa">
        <div class="col-xs-12">
            <div class="box box-info">
                <div class="box-header">
                    <h3 class="box-title">Lista de Personas según su Rol</h3>
                </div>                    
                <div class="box-body conTable">
                </div>
            </div>
        </div>
    </div>
    <div class="callout callout-info advice">
        <h4>Hey!</h4>
        <p>Debes escoger un rol para poder ver una lista específica</p>
    </div>
    <div class="callout callout-warning advice2 hidden">
        <h4>Ups...</h4>
        <p>No hay personas registradas con este rol</p>
    </div>
    <script src="tools/js/flist.js" type="text/javascript"></script>
    <% }%>
</body>
</html>
