<%-- 
    Document   : tdevoluciosn
    Created on : 29/08/2016, 09:59:32 AM
    Author     : LEANDRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
    </head>
    <body>
        <div style="width: 80%;margin: auto;">
            <center><h1>Devolución de Equipos</h1></center>
            <input id="iprestamo" value="0" type="hidden">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa fa-rotate-left"></i>   Devolución de Equipos</h3>
                </div>
                <div class="panel-body">
                    <div class="box">
                        <div class="box-body">
                            <div class="form-group">
                                <label>Docente :</label>
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-user"></i>
                                    </div>
                                    <input id="idocente" type="text" class="form-control" value="" disabled>
                                    <input id="iddoc" type="hidden" class="form-control" value="0">
                                </div>
                                <button onclick="listdoc()" type="button" id="idescd" data-toggle="modal" data-target="#docenteModal" class="btn btn-success" style="float: right"><i class="fa fa-search"></i>   Escoger</button>
                            </div>
                            <div class="conTable hidden"></div>
                            <div class="form-group hidden">
                                <label>Comentario</label>
                                <textarea id="icom" class="form-control" rows="3" placeholder="Escriba un comentario sobre los equipos devueltos..."></textarea>
                            </div>
                            <center>
                                <button class="btn btn-danger hidden">Guardar Cambios</button>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="docenteModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Escoger Docente</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box-body">
                            <div id="iadviced" class="callout callout-success">
                                <h4>¡Genial!</h4>
                                <p>Todos los docentes han devuelto los equipos prestados</p>
                            </div>
                            <div id="conTDoc" class="box hidden">
                                <div class="box-header">
                                    <h3 class="box-title">Lista de Docentes con Prestamo Activo</h3>
                                </div>
                                <div id="iboxdoc" class="box-body">                                        
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary hidden">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="tools/js/functionsreturn.js" type="text/javascript"></script>        
    </body>
</html>
