<%-- 
    Document   : HistoDocent
    Created on : 07/09/2016, 11:34:42 PM
    Author     : Igor
--%>
<%@page import="DAO.HistorialDAO"%>
<%@page import="java.util.List"%>
<%@page import="Controller.SVL_Historial"%>
<%@page import="DTO.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial De Docente</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
        <jsp:useBean id="persona" scope="session" class="java.util.ArrayList"/>
        <jsp:useBean id="pD" class="DAO.PersonaDAO"/>
        <jsp:useBean id="hD" class="DAO.HistorialDAO"/>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <%
            int id = 0;
            for (int i = 0; i < persona.size(); i++) {
                PersonaDTO u = new PersonaDTO();
                u = (PersonaDTO) persona.get(i);
                id = u.getIdPersona();
            }
        %>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Historial prestamo por docente....</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="inventario" class="table table-bordered table-striped">

                                <tr>
                                    <th><strong>ID DEL PRESTAMO</strong></th>
                                    <th><strong>MARCA</strong></th>
                                    <th><strong>SERIE</strong></th>
                                    <th><strong>TIPO</strong></th>
                                    <th><strong>CODIGO</strong></th>
                                    <th><strong>DESCRIPCIÓN</strong></th>
                                </tr>
                                <tbody>                                    
                                    <% String[][] data = hD.listarHistoDocent(id);
                                            for (int i = 0; i < data.length; i++) {%>
                                    <tr>
                                        <td> <%= data[i][0]%></td>
                                        <td><%=data[i][1]%></td>
                                        <td><%=data[i][2]%></td>
                                        <td><%=data[i][3]%></td>
                                        <td><%=data[i][4]%></td>
                                        <td><%=data[i][5]%></td>
                                    </tr>
                                    <%}%>

                                </tbody>


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
                $('#historial').DataTable({
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
                        "oP+¿p'o0i9uy7taginate": {
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
