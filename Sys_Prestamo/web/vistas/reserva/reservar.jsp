<%-- 
    Document   : Reservar
    Created on : 05/09/2016, 03:46:25 AM
    Author     : CESAR
--%>

<%@page import="DTO.UsuarioDTO"%>
<%@page import="DTO.EquipoDTO"%>
<%@page import="DTO.Det_EquipoDTO"%>
<%@page import="DTO.Det_EquipoDTO"%>
<%@page import="java.util.List"%>
<%@page import="DTO.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listdoc" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="listdeq" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="listp" scope="session" class="java.util.ArrayList"/>
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
                        <form id="doreserve" role="form" method="post" action="rc">
                            <div class="box-body" style="margin:40px 20px 0px 30px; width: 50%;height: 50%; margin: 0 auto;">
                                <div class="form-group">
                                    <%
                                        List<UsuarioDTO> list = (List<UsuarioDTO>) listp;
                                    %>
                                    <input id="idprest" type="hidden" value="<%=list.get(0).getIdusuario()%>"><br>

                                    <div class="form-group">
                                        <label>Docente :</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-user"></i>
                                            </div>
                                            <input id="docente" type="text" name="docente" class="form-control" value="" disabled="disabled">
                                            <input id="idocente" type="hidden" name="idocente" class="form-control" value="0">
                                        </div>
                                        <button type="button" id="idescd" data-toggle="modal" data-target="#docenteModal" class="btn btn-success" style="float: right; margin-top: 10px"><i class="fa fa-search"></i>   Elegir Docente</button>
                                    </div> 

                                </div><br>

                                <div class="form-group">

                                    <label>Equipos</label>
                                    <div class="input-group">
                                        <table id="deqselected" class="table table-bordered table-striped table-responsive">
                                            <thead>
                                                <tr>
                                                    <th>Marca</th>
                                                    <th>Serie</th>
                                                    <th>Tipo</th>
                                                    <th>Código</th>
                                                    <th>Descripción</th>
                                                    <th>Eliminar</th>
                                                </tr>
                                            </thead>
                                            <tbody id="selected">
                                            </tbody>
                                        </table>
                                    </div>                                   
                                    <button id="idaddeq" type="button" data-toggle="modal" data-target="#equipoModal" class="btn btn-warning" style="float: right; margin-top: 10px"><i class="fa fa-search"></i>Escoger Equipo(s)</button><br>

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
                                <div class="row">
                                    <!-- time Picker -->
                                    <div class="bootstrap-timepicker col-md-6">
                                        <div class="form-group">
                                            <label>Desde: </label>

                                            <div class="input-group">
                                                <input id="hinicio" type="text" class="form-control timepicker">

                                                <div class="input-group-addon">
                                                    <i class="fa fa-clock-o"></i>
                                                </div>
                                            </div>
                                            <!-- /.input group -->
                                        </div>
                                        <!-- /.form group -->
                                    </div>

                                    <div class="bootstrap-timepicker col-md-6">
                                        <div class="form-group">
                                            <label>Hasta: </label>

                                            <div class="input-group">
                                                <input id="hfinal" type="text" class="form-control timepicker">

                                                <div class="input-group-addon">
                                                    <i class="fa fa-clock-o"></i>
                                                </div>
                                            </div>
                                            <!-- /.input group -->
                                        </div>
                                        <!-- /.form group -->
                                    </div>
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
                                                <input id="breserve" type="submit" class="btn btn-default btn-lg" value="Reservar">
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
                                                <h2 style="text-align: justify">¿Esta seguro de que desea cancelar la reserva?</h2>
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


        <div class="modal fade" id="docenteModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Buscar Docente</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box-body">
                            <%
                                int i = 0;
                                if (listdoc.isEmpty()) {
                            %>
                            <div id="iadviced" class="callout callout-danger">
                                <h4>Ups..</h4>
                                <p>No hay docentes habilitados para prestarse equipos</p>
                            </div>
                            <%} else {
                            %>
                            <div id="conTDoc" class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Lista de Docentes habilitados</h3>
                                </div>
                                <div id="iboxd" class="box-body">
                                    <table id="availableDoc" class="table table-bordered table-striped table-responsive">
                                        <thead>
                                            <tr>
                                                <th>Nombres y Apellidos</th>
                                                <th>DNI</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                i = 0;
                                                List<PersonaDTO> listd = (List<PersonaDTO>) listdoc;
                                                while (i < listd.size()) {
                                            %>
                                            <tr>
                                                <td><%=listd.get(i).getNombre() + " " + listd.get(i).getApellidos()%></td>
                                                <td><%=listd.get(i).getDni()%></td>
                                                <td><a data-dismiss="modal" onclick="selectdoc('<%=listd.get(i).getNombre() + " " + listd.get(i).getApellidos()%>', '<%=listd.get(i).getIdPersona()%>')"><span class="glyphicon glyphicon-check"></span></a></td>
                                            </tr>
                                            <%
                                                    i++;
                                                }
                                            %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Nombres y Apellidos</th>
                                                <th>DNI</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="equipoModal" tabindex="-1" >

            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Escoger Equipo(s)</h4>
                    </div>

                    <div class="modal-body">
                        <div class="box-body">
                            <%
                                i = 0;
                                List<Det_EquipoDTO> list1 = (List<Det_EquipoDTO>) listdeq.get(0);
                                List<EquipoDTO> list2 = (List<EquipoDTO>) listdeq.get(1);
                                if (list1.isEmpty()) {
                            %>
                            <div id="iadvice" class="callout callout-danger">
                                <h4>Equipos no disponibles</h4>
                                <p>Lamentablemente no hay equipos disponibles en este momento</p>
                            </div>
                            <%} else {
                            %>
                            <div id="contab" class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Lista de Equipos</h3>
                                </div>
                                <div id="ibox" class="box-body">
                                    <table id="inventario" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Marca</th>
                                                <th>Serie</th>
                                                <th>Tipo</th>
                                                <th>Código</th>
                                                <th>Descripción</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                while (i < list1.size()) {
                                                    EquipoDTO eq = new EquipoDTO();
                                                    Det_EquipoDTO deq = new Det_EquipoDTO();
                                                    eq = list2.get(i);
                                                    deq = list1.get(i);
                                            %>
                                            <tr>
                                                <td><%=eq.getMarca()%></td>
                                                <td><%=eq.getSerie()%></td>
                                                <td><%=eq.getTipo()%></td>
                                                <td><%=deq.getCodigo()%></td>
                                                <td><%=deq.getDescripcion()%></td>
                                                <td><a data-dismiss="modal" onclick="selecteq('<%=eq.getMarca()%>', '<%=eq.getSerie()%>', '<%=eq.getTipo()%>', '<%=deq.getCodigo()%>', '<%=deq.getDescripcion()%>',<%=deq.getIdDet_Equipo()%>)"><span class="glyphicon glyphicon-check"></span></a></td>
                                            </tr>
                                            <%
                                                    i++;
                                                }
                                            %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Marca</th>
                                                <th>Serie</th>
                                                <th>Tipo</th>
                                                <th>Código</th>
                                                <th>Descripción</th>
                                                <th>Seleccionar</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>

                </div>
            </div>

        </div>     
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
        <script src="plugins/daterangepicker/daterangepicker.js"></script>
        <!-- DataTables -->
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <!-- bootstrap datepicker -->
        <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
        <!-- bootstrap time picker -->
        <script src="plugins/timepicker/bootstrap-timepicker.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
        <script src="tools/js/selectdoc.js" type="text/javascript"></script>
        <!-- Page script -->
        <script>

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
                                                            startDate: moment(),
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

                                                        //Timepicker
                                                        $(".timepicker").timepicker({
                                                            showInputs: false,
                                                            showMeridian: false
                                                        });
                                                    });


        </script>
    </body>
</html>
