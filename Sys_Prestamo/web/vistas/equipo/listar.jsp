<%-- 
    Document   : listar
    Created on : 26/08/2016, 02:14:08 PM
    Author     : CESAR
--%>

<%@page import="java.util.List"%>
<%@page import="DTO.Det_EquipoDTO"%>
<%@page import="DTO.EquipoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario de Equipos</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
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
                Gestión de Equipos
                <small>SPE UPeU</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="index.jsp"><i class="fa fa-dashboard"></i> Inicio</a></li>
                <li><a href="#">Equipos</a></li>
                <li class="active">Inventario</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Inventario de Equipos</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="inventario" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>Marca</th>
                                        <th>Tipo</th>
                                        <th>Código</th>
                                        <th>Descripción</th>
                                        <th>Estado</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        List<Det_EquipoDTO> lista2 = (List<Det_EquipoDTO>) lista.get(0);
                                        List<EquipoDTO> lista3 = (List<EquipoDTO>) lista.get(1);
                                        for (int i = 0; i < lista2.size(); i++) {
                                            EquipoDTO eq = new EquipoDTO();
                                            Det_EquipoDTO deq = new Det_EquipoDTO();
                                            eq = lista3.get(i);
                                            deq = lista2.get(i);
                                    %>
                                    <tr>
                                        <td><%=eq.getMarca()%></td>
                                        <td><%=eq.getTipo()%></td>
                                        <td><%=deq.getCodigo()%></td>
                                        <td><%=deq.getDescripcion()%></td>
                                        <%
                                            if ("1".equals(deq.getEstado())) {
                                        %><td><span class="label label-success">Disponible</span></td><%
                                        } else if ("0".equals(deq.getEstado())) {
                                        %><td><span class="label label-danger">No Disponible</span></td><%
                                            }
                                        %>
                                        <td><a href="ec?ge=3&id=<%=deq.getIdDet_Equipo()%>&id2=<%=deq.getIdEquipo()%>"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                        <td><a data-toggle="modal" data-target="#delete<%=deq.getIdDet_Equipo()%>"><span class="glyphicon glyphicon-remove"></span></a></td>
                                <div class="modal modal-warning fade" id="delete<%=deq.getIdDet_Equipo()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="delete">Eliminar</h4>
                                            </div>
                                            <div class="modal-body">
                                                <p>¿Está seguro que desea eliminar este item del inventario?</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Cancelar</button>
                                                <a href="ec?ge=4&id=<%=deq.getIdDet_Equipo()%>" role="button" class="btn btn-outline">Eliminar</a>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                </tr>
                                <% }%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>Marca</th>
                                        <th>Tipo</th>
                                        <th>Código</th>
                                        <th>Descripción</th>
                                        <th>Estado</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- DataTables -->
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
        <!-- page script -->
        <script>
            $(function () {
                $('#inventario').DataTable({
                    "language": {
                        "sProcessing": "Procesando...",
                        "sLengthMenu": "Mostrar _MENU_ registros",
                        "sZeroRecords": "No se encontraron resultados",
                        "sEmptyTable": "Ningún dato disponible en esta tabla",
                        "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                        "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                        "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                        "sInfoPostFix": "",
                        "sSearch": "Buscar:",
                        "sUrl": "",
                        "sInfoThousands": ",",
                        "sLoadingRecords": "Cargando...",
                        "oPaginate": {
                            "sFirst": "Primero",
                            "sLast": "Último",
                            "sNext": "Siguiente",
                            "sPrevious": "Anterior"
                        },
                        "oAria": {
                            "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                        }
                    }
                });
            });
        </script>
    </body>
</html>
