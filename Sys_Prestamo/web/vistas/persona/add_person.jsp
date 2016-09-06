<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
        <jsp:useBean id="rol" class="DAO.RolDAO"></jsp:useBean>
            <title></title>
        </head>
        <body style="padding:2% 9%;box-sizing: border-box;">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-male"></i>   Registro de Personas</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" method="get" action="ci">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label class="letra col-sm-4 control-label"><i class="fa fa-user"></i>   Nombre </label>
                                        <div class="col-sm-6">
                                            <input type="text" required name="nombre" id="nombre" placeholder="Esciba su(s) Nombre(s)" class="a form-control">           
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="letra col-sm-4 control-label">Apellidos</label>
                                        <div class="col-sm-6">    
                                            <input type="text" required name="apellido" id="apellidos" class="a form-control" placeholder="Escriba sus apellidos">             
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="letra col-sm-4 control-label"><i class="fa fa-phone"></i>   Celular</label>
                                        <div class="col-sm-6">
                                            <input type="number" placeholder="Escriba su número de celular" max="999999999" min="900000000" required name="celular" id="celular" class="a form-control"  >           
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="letra col-sm-4 control-label"><i class="fa fa-credit-card"></i>   DNI</label>
                                        <div class="col-sm-6">
                                            <input type="number" placeholder="Escriba su DNI" required name="dni" id="dni" class="a form-control"  >             
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="letra col-sm-4 control-label"><i class="fa fa-envelope"></i>   Correo</label>
                                        <div class="col-sm-6">
                                            <input type="email" placeholder="Escriba su dirección de correo electrónico" required name="correo" id="correo" class="a form-control">  
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="letra col-sm-4 control-label">Rol</label>
                                        <div class="col-sm-6">
                                            <select id="sroles" required class="form-control select2" name="idrol">
                                                <option selected disabled >Escoger Rol</option>
                                            <% ResultSet rs = rol.list();
                                                while (rs.next()) {%>
                                            <option value="<%= rs.getInt("idROL")%>" ><%= rs.getString("NOMBRE")%></option>
                                            <%}%>
                                        </select>  
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="letra col-sm-4 control-label">Sexo</label>
                                    <div class="col-sm-6">
                                        <select class="form-control select2" required name="sex">
                                            <option selected disabled>Elegir Sexo</option>
                                            <option value="M">Masculino</option>
                                            <option value="F">Femenino</option>
                                        </select>  
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <center>
                        <button type="submit" class="btn btn-danger">Registrar</button>
                    </center>
                </form>
            </div>
        </div>
    </body>
</html>
