<%-- 
    Document   : tprestamo
    Created on : 25/08/2016, 09:27:24 PM
    Author     : LEANDRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <%@include file="/WEB-INF/jspf/impbootstrap.jspf" %>
    </head>
    <body>
    <center>
        <div style="width: 80%;">
        <h1>Prestamo de Equipos</h1>

        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Formulario de Prestamo</h3>
            </div>
            <div class="panel-body">
                <form>
                    <label>Lugar :</label>
                    <input class="form-control" type="text" placeholder="Describa el Lugar en donde se usará el Equipo">
                </form>
            </div>
        </div>
        </div>
    </center>
</body>

</html>