<%-- 
    Document   : registro
    Created on : 26/08/2016, 02:12:22 PM
    Author     : CESAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
    </head>   

    <body class="hold-transition skin-blue sidebar-mini">
        <div class="row">
            <div style="padding: 5%;box-sizing: border-box;">
                <div class="box box-success">
                    <div class="box-header with-border">
                        <center> <h1 >Registro de Equipos</h1> </center>
                    </div>
                    <form role="form" method="post" action="ec">
                        <div class="box-body col-md-12">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="marca">Marca</label>
                                    <input type="text" required="" maxlength="30" onkeypress="return soloLetras(event)" class="form-control" id="marca" name="marca" placeholder="Marca">
                                </div>

                                <div class="form-group">
                                    <label for="serie">Serie</label>
                                    <input type="text" required="" maxlength="30" class="form-control" id="serie" name="serie" placeholder="Serie">
                                </div>
                            </div>
                            <div class="col-md-6">
                            <div class="form-group">
                                <label>Tipo</label>
                                <select id="sroles" required class="form-control select2" name="tipo">
                                    <option value="" selected disabled>Escoger Tipo</option>
                                    <option value="laptop">Laptop</option>
                                    <option value="proyector">Proyector</option>
                                    <option value="cable">Cable</option>
                                    <option value="cargador">Cargador</option>
                                </select>  
                            </div>

                            <div class="form-group">
                                <label for="codigo">Código</label>
                                <input type="text" required="" maxlength="30"  class="form-control" id="codigo" name="codigo" placeholder="Código">
                            </div>
                            </div>
                            <div class="form-group col-md-12">
                                <label for="descripcion">Descripción</label>
                                <textarea  required="" maxlength="120" class="form-control" rows="3" id="descripcion" name="descripcion" placeholder="Descripcion"></textarea>
                            </div>

                            <div class="form-group">
                                <input type="hidden" name="ge" value="5">
                            </div>

                            <div class="col-md-12">
                                <center><button type="button" class="btn btn-success" data-toggle="modal" data-target="#registrar">Registrar</button></center>
                            </div> 

                            <div class="modal fade" id="registrar">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <center><h2 class="modal-title">Atención</h2></center>
                                        </div>
                                        <div class="modal-body">
                                            <h3 style="text-align: justify">¿Esta seguro de que desea registrar este nuevo equipo? Si es necesario verifique los campos nuevamente.</h3>
                                        </div>
                                        <div class="modal-footer">
                                            <input type="submit" class="btn btn-default btn-lg" value="Registrar">
                                            <button type="button" class="btn btn-danger btn- btn-lg" data-dismiss="modal">Cerrar</button>                                                        
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>      
            </div>
        </div>
    </body>
</html>
