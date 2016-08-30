<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="DTO.UsuarioDTO"%>
<jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
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
                        Data Tables
                        <small>advanced tables</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Tables</a></li>
                        <li class="active">Data tables</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <center><div class="box-header">
                                    <h5 class="box-title">Lista de Usuarios</h5>
                                    </div></center>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="listau" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Usuario</th>
                                                <th>Contraseña</th>
                                                <th>Gestionar</th>
                                            </tr>
                                            
                                        </thead>
                                        <tbody>

                                            <%
                                                for (int i = 0; i < lista.size(); i++) {
                                                    UsuarioDTO us = new UsuarioDTO();
                                                    us = (UsuarioDTO) lista.get(i);
                                            %>
                                            <tr>
                                                <td><%=us.getIdusuario()%></td>
                                                <td><%=us.getUser()%></td>
                                                <td><%=us.getPassword()%></td>
                                                <td><a data-toggle="modal" data-target="#delete<%=us.getIdusuario()%>"><span class="glyphicon glyphicon-remove"></span></a></td>
                                        <div class="modal modal-warning fade" id="delete<%=us.getIdusuario()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title" id="delete">Eliminar</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>¿Está seguro que desea eliminar este usuario?</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">Cancelar</button>
                                                        <a href="ci?op=7&id=<%=us.getIdusuario()%>" role="button" class="btn btn-outline">Eliminar</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </tr>
                                        <% }%>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>ID</th>
                                                <th>Usuario</th>
                                                <th>Contraseña</th>
                                                <th>Gestionar</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            
        <!-- ./wrapper -->

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
                $('#listau').DataTable({
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
