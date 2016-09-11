<%-- 
    Document   : tprestamo
    Created on : 25/08/2016, 09:27:24 PM
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
        <jsp:useBean id="ipersona" scope="session" class="java.util.ArrayList"/>
    </head>
    <body>

        <div style="width: 80%; margin: auto;">            
            <center><h1>Reserva de Equipos</h1></center>             
            <input id="iprestamo" value="0" type="hidden">            
            <div class="panel panel-primary">
                <div class="panel-body">
                    <form>
                        <%for (int i = 0; i < ipersona.size(); i++) {
                                PersonaDTO u = new PersonaDTO();
                                u = (PersonaDTO) ipersona.get(i);
                        %>
                        <input id="idprest" type="hidden" class="form-control" disabled value="<%= u.getIdPersona()%>">
                        <%}%>
                        <div class="form-group">
                            <label>Docente :</label>
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="fa fa-user"></i>
                                </div>
                                <input id="idocente" type="text" class="form-control" value="" disabled>
                                <input id="iddoc" type="hidden" class="form-control" value="">
                            </div>
                            <button type="button" id="idescd" data-toggle="modal" data-target="#docenteModal" class="btn btn-success" style="float: right"><i class="fa fa-search"></i>   Escoger</button>
                        </div>                        
                        <label>Lugar :</label>
                        <input id="idlug" class="form-control" type="text" placeholder="Describa el Lugar en donde se usará el Equipo">
                        <div class="bootstrap-timepicker">
                            <div class="form-group">
                                <label>Hora límite para devolver:</label>
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-clock-o"></i>
                                    </div>
                                    <input type="text" id="ihour" class="form-control timepicker">                                    
                                </div>
                            </div>
                        </div>
                        <button id="regp" type="button" class="btn btn-warning" style="float: right;"><i class="fa fa-search"></i>   Escoger Equipo(s)</button>
                    </form>                    
                </div>
            </div>
            <script src="tools/js/floan.js"></script>
            <div id="itabp" class="panel panel-primary hidden">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-laptop"></i>   Lista de Equipos Seleccionados</h3>
                </div>
                <div class="panel-body">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Equipo(s) a Prestar</h3>
                        </div>
                        <button id="idaddeq" class="btn btn-warning" data-toggle="modal" data-target="#equipoModal" style="float: right;"><i class="fa fa-plus"></i>   Añadir</button>
                        <div id="eqpres" class="box-body no-padding">                            
                        </div>
                        <br/><br/>
                        <center>
                            <button id="isave" class="btn btn-info hidden" data-toggle="modal" data-target="#finalModal" type="button"><i class="fa fa-plus"></i>   Comentario</button>
                        </center>
                    </div>
                </div>
            </div>

        </div>
        <div class="modal fade" id="finalModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Detalle del Prestamo</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Comentario</label>
                            <textarea id="icom" class="form-control" rows="3" placeholder="Escriba un comentario sobre el prestamo..."></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                        <button type="button" onclick="regcom()" class="btn btn-success">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="docenteModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Buscar Docente</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box-body">
                            <div id="iadviced" class="callout callout-danger">
                                <h4>Ups..</h4>
                                <p>No hay docentes habilitados para prestarse equipos</p>
                            </div>
                            <div id="conTDoc" class="box hidden">
                                <div class="box-header">
                                    <h3 class="box-title">Lista de Docentes habilitados</h3>
                                </div>
                                <div id="iboxd" class="box-body">                                        
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="equipoModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Escoger Equipo(s)</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box-body">
                            <div id="iadvice" class="callout callout-danger">
                                <h4>Equipos no disponibles</h4>
                                <p>Lamentablemente no hay equipos disponibles en este momento</p>
                            </div>
                            <div id="contab" class="box hidden">
                                <div class="box-header">
                                    <h3 class="box-title">Lista de Equipos disponibles</h3>
                                </div>
                                <div id="ibox" class="box-body">                                        
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>     
        <script src="tools/js/functionloan.js" type="text/javascript"></script>        
    </body>

</html>