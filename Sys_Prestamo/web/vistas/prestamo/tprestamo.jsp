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
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
    </head>
    <body>

        <div style="width: 80%; margin: auto;">
            <center><h1>Prestamo de Equipos</h1></center>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Formulario de Prestamo</h3>
                </div>
                <div class="panel-body">
                    <form>
                        <label>Prestamista :</label>
                        <input type="text" class="form-control" disabled value="Nombre del Prestamista">
                        <div class="form-group">
                            <label>Docente :</label>
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="fa fa-user"></i>
                                </div>
                                <input type="text" class="form-control" disabled>
                            </div>
                            <button type="button" data-toggle="modal" data-target="#exampleModal" class="btn btn-success" style="float: right"><i class="fa fa-search"></i>   Escoger</button>
                        </div> 
                        <label>Lugar :</label>
                        <input class="form-control" type="text" placeholder="Describa el Lugar en donde se usará el Equipo">
                        <div class="form-group">
                            <label>Fecha Límite para Devolver :</label>
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right" id="datepicker" placeholder="Fecha de Devolución">
                            </div>
                        </div>                       
                    </form>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Equipo(s) a Prestar</h3>
                        </div>
                        <button class="btn btn-warning"><i class="fa fa-plus"></i>   Añadir</button>
                        <div class="box-body no-padding">
                            <table class="table table-condensed">
                                <thead>
                                    <tr>
                                        <th>Nombre :</th>
                                        <th>Serie :</th>
                                        <th>Código :</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <button class="btn btn-danger" type="button"><i class="fa fa-send"></i>   Guardar</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="exampleModalLabel">Buscar Docente</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>