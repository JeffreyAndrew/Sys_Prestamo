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
            <input id="iprestamo" value="0" type="hidden">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-pencil"></i>   Formulario de Prestamo</h3>
                </div>
                <div class="panel-body">
                    <form>
                        <label>Prestamista :</label>
                        <input id="idprest" type="text" class="form-control" disabled value="1">
                        <div class="form-group">
                            <label>Docente :</label>
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="fa fa-user"></i>
                                </div>
                                <input id="iddoc" type="text" class="form-control" value="1" disabled>
                            </div>
                            <button type="button" id="idescd" data-toggle="modal" data-target="#docenteModal" class="btn btn-success" style="float: right"><i class="fa fa-search"></i>   Escoger</button>
                        </div> 
                        <label>Lugar :</label>
                        <input id="idlug" class="form-control" type="text" placeholder="Describa el Lugar en donde se usará el Equipo">
                        <div class="form-group">
                            <label>Fecha Límite para Devolver :</label>
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right" id="datepicker" placeholder="Fecha de Devolución">
                            </div>
                        </div>
                        <button id="regp" type="button" class="btn btn-info" style="float: right;"><i class="fa fa-search"></i>   Escoger Equipo(s)</button>
                    </form>                    
                </div>
            </div>
            <div id="itabp" class="panel panel-primary hidden">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-laptop"></i>   Lista de Equipos Seleccionados</h3>
                </div>
                <div class="panel-body">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Equipo(s) a Prestar</h3>
                        </div>
                        <button class="btn btn-warning" data-toggle="modal" data-target="#equipoModal" style="float: right;"><i class="fa fa-plus"></i>   Añadir</button>
                        <div class="box-body no-padding">                            
                        </div>
                        <br/><br/>
                        <center>
                            <button class="btn btn-danger hidden" type="button">Guardar</button>
                        </center>
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
        <div class="modal fade" id="equipoModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Escoger Equipo(s)</h4>
                    </div>
                    <div class="modal-body">
                            <div class="box-body">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">Lista de Equipos disponibles</h3>
                                    </div>
                                    <div class="box-body">
                                        <table id="tabEquipo" class="table table-bordered table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Nombre</th>
                                                    <th>Serie</th>
                                                    <th>Tipo</th>
                                                    <th>Código</th>
                                                    <th>Descripción</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Laptop</td>
                                                    <td>Internet Explorer 7</td>
                                                    <td>Win XP SP2+</td>
                                                    <td>7</td>
                                                    <td>blanfjanfj af aklsfjak fsajkfh asjkfha</td>
                                                    <td><a class="btn btn-success"><i class="fa fa-check"></i>   Escoger</a></td>
                                                </tr>
                                            </tbody>
                                        </table>
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
        <script>
            $(document).ready(function () {
                $("#tabEquipo").DataTable();
            });
            $("#regp").click(function () {
                validar();
            });
            function listaequipos(){
                
            }
            function confirmloan(prest, doc, lug, fec) {
                $("#regp").attr("class", "hidden");
                $("#idescd").attr("class", "hidden");
                $("#itabp").attr("class", "panel panel-primary");
                $("#idlug").attr("disabled", "");
                $("#datepicker").attr("disabled", "");
                addloan(prest, doc, lug, fec);
            }

            function validar() {
                var doc = $("#iddoc").val();
                var lug = $("#idlug").val();
                var fec = $("#datepicker").val();
                var prest = $("#idprest").val();
                if (doc !== "" && lug !== "" && fec !== "") {
                    confirmloan(prest, doc, lug, fec);
                } else {
                    if (doc === "" || lug === "" || fec === "") {
                        if (doc === "") {
                            new PNotify({
                                title: "Docente no escogido",
                                type: "error",
                                text: "Debe escoger el docente al que se hará el prestamo",
                                nonblock: {
                                    nonblock: true
                                }
                            });
                        }
                        if (lug === "") {
                            new PNotify({
                                title: "Lugar no especificado",
                                type: "error",
                                text: "No especificó el lugar",
                                nonblock: {
                                    nonblock: true
                                }
                            });
                        }
                        if (fec === "") {
                            new PNotify({
                                title: "Fecha no especificada",
                                type: "error",
                                text: "No especificó la fecha de devolución",
                                nonblock: {
                                    nonblock: true
                                }
                            });
                        }
                    }
                }
            }
            function addloan(user, persona, lugar, fecha) {
                var orf = fecha.split("/");
                var dia = orf[1];
                var mes = orf[0];
                var an = orf[2];
                var fecenv = an + "-" + mes + "-" + dia;
                var url = "loan?mt=add&op=1";
                var data = "iduser=" + user;
                data += "&idpersona=" + persona;
                data += "&fecha=" + fecenv;
                data += "&lugar=" + lugar;
                $.post(url, data, function (objJson) {
                    var idprestamo = objJson.idprestamo;
                    $("#iprestamo").attr("value", idprestamo);
                });
            }

            function listarequipos(id) {
                var url = "loan?meth=add&op=3";
                var data = "idp=";
                $.post(url, data, function (objJson) {
                    if (objJson.result === true) {
                    } else {
                    }
                });
            }
            function createTable() {
                var t = '<table class="table table-condensed">';
                t += '<thead>';
                t += '<tr>';
                t += '<th><i class="fa fa-laptop"></i>Nombre :</th>';
                t += '<th>Serie :</th>';
                t += '<th>Descripción :</th>';
                t += '<th>Codigo :</th>';
                t += '</tr>';
                t += '</thead>';
                t += '<tbody id="idequipos">';
                t += '</tbody>';
                t += '</table>';
                return t;
            }
        </script>
    </body>

</html>