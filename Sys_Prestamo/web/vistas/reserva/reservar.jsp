<%-- 
    Document   : Reservar
    Created on : 05/09/2016, 03:46:25 AM
    Author     : CESAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Realizar Reserva</title>
        <%@include file="/WEB-INF/jspf/impbts.jspf" %>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- daterange picker -->
        <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
        <!-- bootstrap datepicker -->
        <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
        <!-- Select2 -->
        <link rel="stylesheet" href="plugins/select2/select2.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Gestión de Reservas
                <small>SPE UPeU</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <!-- left column -->
                <div style="margin: 40px 20px 0px 20px">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <center> <h1 class="box-title" style="font-size: 50px">Realizar una Reserva</h1> </center>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="rc">
                            <div class="box-body" style="margin:40px 20px 0px 30px; width: 50%;height: 50%; margin: 0 auto;">
                                <div class="form-group">

                                    <input id="idprest" type="hidden" class="form-control" disabled value=""><br>

                                    <div class="form-group">
                                        <label>Docente :</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-user"></i>
                                            </div>
                                            <input id="idocente" type="text" name="docente" class="form-control" value="" disabled>                                         
                                        </div>
                                        <button type="button" id="idescd" data-toggle="modal" data-target="#docenteModal" class="btn btn-success" style="float: right; margin-top: 10px"><i class="fa fa-search"></i>   Elegir Docente</button>
                                    </div> 
                                </div><br>

                                <div class="form-group">
                                    <label for="codigo">Equipo</label>
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-hdd-o"></i>
                                        </div>
                                        <input type="text" required="" disabled="" maxlength="120" class="form-control input-lg" id="tipo" name="codigo" placeholder="Equipo">
                                    </div>                                   
                                    <button id="regp" type="button" class="btn btn-warning" style="float: right; margin-top: 10px"><i class="fa fa-search"></i>   Seleccionar Equipo(s)</button><br>

                                </div>

                                <div class="form-group">
                                    <!-- Date range -->
                                    <div class="form-group">
                                        <label>Tiempo de Reserva</label>

                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" name="fechas" class="form-control pull-right" id="reservation">
                                        </div>
                                        <!-- /.input group -->
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="dia">Día</label>
                                    <select id="dia" name="dia" class="form-control select2" style="width: 100%;">
                                        <option selected="selected" value="SUNDAY">Domingo</option>
                                        <option value="MONDAY">Lunes</option>
                                        <option value="TUESDAY">Martes</option>
                                        <option value="WEDNESDAY">Miércoles</option>
                                        <option value="THURSDAY">Jueves</option>
                                        <option value="FRIDAY">Viernes</option>
                                        <option value="SATURDAY">Sábado</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <input type="hidden" name="gr" value="3">
                                </div>

                                <div class="box-footer">
                                    <a role="button" class="btn btn-danger" href="rc?gr=1" data-toggle="modal">Cancelar</a>
                                    <button type="button" class="btn btn-info pull-right" href="#reservar" data-toggle="modal">Reservar</button>
                                </div> 

                                <div class="modal fade" id="reservar">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <center><h1 class="modal-title">Atención</h1></center>
                                            </div>
                                            <div class="modal-body">
                                                <h2 style="text-align: justify">¿Esta seguro de que desea realizar esta reserva? Si es necesario verifique los campos nuevamente.</h2>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="submit" onsubmit="enviar()" class="btn btn-default btn-lg" value="Reservar">
                                                <button type="button" class="btn btn-danger btn- btn-lg" data-dismiss="modal">Cerrar</button>                                                        
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="modal fade" id="cancelar">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <center><h1 class="modal-title">Atención</h1></center>
                                            </div>
                                            <div class="modal-body">
                                                <h2 style="text-align: justify">Esta seguro de que desea cancelar el registro.</h2>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default btn-lg" data-dismiss="modal" >No</button>
                                                <a class="btn btn-danger btn-lg" href="index.jsp">Si</a>                                                        
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </form>

                    </div>
                    <!-- /.box -->                       


                </div>
                <!--/.col (left) -->
                <!-- right column HASTA AQUI -->                        
            </div>
            <!-- /.row -->
        </section>
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
    <script src="tools/js/functionsloan.js" type="text/javascript"></script>  
    <!-- jQuery 2.2.3 -->
    <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- Select2 -->
    <script src="plugins/select2/select2.full.min.js"></script>
    <!-- InputMask -->
    <script src="plugins/input-mask/jquery.inputmask.js"></script>
    <script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <!-- date-range-picker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
    <script src="plugins/daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap datepicker -->
    <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
    <!-- FastClick -->
    <script src="plugins/fastclick/fastclick.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="dist/js/demo.js"></script>
    <!-- Page script -->
    <script>


                                                    var startDate;
                                                    var endDate;
                                                    $(document).ready(function () {
                                                        //Initialize Select2 Elements
                                                        $(".select2").select2();

                                                        //Datemask dd/mm/yyyy
                                                        $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
                                                        //Datemask2 mm/dd/yyyy
                                                        $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
                                                        //Money Euro
                                                        $("[data-mask]").inputmask();

                                                        //Date range picker
                                                        $('#reservation').daterangepicker({
                                                            separator: ' hasta ',
                                                            locale: {
                                                                applyLabel: 'Enviar',
                                                                fromLabel: 'Desde',
                                                                toLabel: 'Hasta',
                                                                customRangeLabel: 'Rango Personalizado',
                                                                daysOfWeek: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
                                                                monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                                                                firstDay: 1,
                                                                format: 'YYYY/MM/DD'
                                                            }
                                                        });
                                                        //Date range picker with time picker
                                                        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});


                                                        //Date picker
                                                        $('#datepicker').datepicker({
                                                            autoclose: true
                                                        });
                                                    });


    </script>
</body>
</html>
