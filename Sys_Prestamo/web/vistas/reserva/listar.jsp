<%-- 
    Document   : Listar
    Created on : 05/09/2016, 03:45:24 AM
    Author     : CESAR
--%>

<%@page import="DAO.ReservaDAO"%>
<%@page import="java.util.List"%>
<%@page import="DTO.Det_EquipoDTO"%>
<%@page import="DTO.EquipoDTO"%>
<%@page import="DTO.PersonaDTO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page import="DTO.ReservaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Reservas</title>
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
                Gestión de Reserva de Equipos
                <small>SPE UPeU</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Lista de Reservas</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="inventario" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>Usuario</th>
                                        <th>Docente</th>
                                        <th>Fecha de Reserva</th>
                                        <th>Fecha de Inicio</th>
                                        <th>Fecha Final</th>
                                        <th>Día</th>
                                        <th>Hora Inicio</th>
                                        <th>Hora Fin</th>
                                        <th>N° Equipos</th>
                                        <th>Editar</th>
                                        <th>Cancelar</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        List<ReservaDTO> list1=(List<ReservaDTO>) lista.get(0);
                                        List<UsuarioDTO> list2=(List<UsuarioDTO>) lista.get(1);
                                        List<PersonaDTO> list3=(List<PersonaDTO>) lista.get(2);
                                        ReservaDAO rdao=new ReservaDAO();
                                        /*List<EquipoDTO> list4=(List<EquipoDTO>) lista.get(3);
                                        List<Det_EquipoDTO> list5=(List<Det_EquipoDTO>) lista.get(4);*/
                                        for (int i = 0; i < list1.size(); i++) {
                                            ReservaDTO rdto = list1.get(i);
                                            UsuarioDTO udto = list2.get(i);
                                            PersonaDTO pdto = list3.get(i);
                                    %>
                                    <tr>
                                        <td><%=udto.getUser()%></td>
                                        <td><%=pdto.getNombre()%></td>
                                        <td><%=rdto.getFecha_reserva()%></td>
                                        <td><%=rdto.getFecha_inicio()%></td>
                                        <td><%=rdto.getFecha_fin()%></td>
                                        <% switch(rdto.getDia()){
                                            case "SUNDAY":
                                                %><td>Domingo</td> <%
                                                break;
                                            case "MONDAY":
                                                %><td>Lunes</td> <%
                                                break;
                                            case "TUESDAY":
                                                %><td>Martes</td> <%
                                                break;
                                            case "WEDNESDAY":
                                                %><td>Lunes</td> <%
                                                break;
                                            case "THURSDAY":
                                                %><td>Lunes</td> <%
                                                break;
                                            case "FRIDAY":
                                                %><td>Lunes</td> <%
                                                break;
                                            case "SATURDAY":
                                                %><td>Lunes</td> <%
                                                break;
                                        }%>
                                        <td><%=rdto.getHora_ini()%></td>
                                        <td><%=rdto.getHora_fin()%></td>
                                        <td><%=rdao.counteq(rdto.getId_reserva()).get(0) %></td>
                                        <td><a href="rc?ge=3&id=<%=rdto.getId_reserva() %>"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                        <td><a data-toggle="modal" data-target="#delete<%=rdto.getId_reserva() %>"><span class="glyphicon glyphicon-remove"></span></a></td>
                                <div class="modal modal-warning fade" id="delete<%=rdto.getId_reserva() %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                                                <a href="rc?gr=4&id=<%=rdto.getId_reserva() %>" role="button" class="btn btn-outline">Eliminar</a>
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
                                        <th>Usuario</th>
                                        <th>Docente</th>
                                        <th>Fecha de Reserva</th>
                                        <th>Fecha de Inicio</th>
                                        <th>Fecha Final</th>
                                        <th>Día</th>
                                        <th>Hora Inicio</th>
                                        <th>Hora Fin</th>
                                        <th>N° Equipos</th>
                                        <th>Editar</th>
                                        <th>Cancelar</th>
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
