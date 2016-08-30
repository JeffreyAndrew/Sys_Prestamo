<%-- 
    Document   : login
    Created on : 25/08/2016, 10:22:33 PM
    Author     : LEANDRO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SPE || UPeU</title>
        <%@include file="WEB-INF/jspf/import.jspf" %>
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="#"><b>SPE</b>UPeU</a>
            </div>
            <div class="login-box-body" style="box-shadow: 0 0 20px 0 black;">
                <p class="login-box-msg">Iniciar Sesión</p>

                <div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="Usuario">
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Contraseña">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <button type="button" class="btn btn-primary btn-block btn-flat">Ingresar</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
