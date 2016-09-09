<%-- 
    Document   : HistoDocent
    Created on : 07/09/2016, 11:34:42 PM
    Author     : Igor
--%>
<%@page import="DAO.HistorialDAO"%>
<%@page import="java.util.List"%>
<%@page import="Controller.SVL_Historial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Historial De Docente</title>
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
        <jsp:useBean id="historial" scope="session" class="java.util.ArrayList"/>
    </head>
   <body class="hold-transition skin-blue sidebar-mini">
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
                                       <td><strong>ID DEL PRESTAMO</strong></td>
                                       <td><strong>NOMBRE DEL DOCENTE</strong></td>
                                       <td><strong>MARCA</strong></td>
                                       <td><strong>SERIE</strong></td>
                                       <td><strong>TIPO</strong></td>
                                       <td><strong>ESTADO</strong></td>
                                       <td><strong>CODIGO</strong></td>
                                       <td><strong>DESCRIPCIÓN</strong></td>
                                   </tr>
                                <tbody>
                              
                                 <%String lista[][];%>
                                <%for(int i=0; i<lista.length;i++){%>
                                 <tr>
                                     <td><%=lista[i][0] %></td>
                                     <td><%=lista[i][1]+" "+lista[i][2]%></td>
                                     <td><%=lista[i][3]%></td>
                                     <td><%=lista[i][4]%></td>
                                     <td><%=lista[i][5]%></td>
                                     <td><%=lista[i][6]%></td>
                                     <td><%=lista[i][7]%></td>
                                     <td><%=lista[i][8]%></td>
                                 </tr>
                                 
                                  <% }%> 
                                 
                                 
                                       
                                 
                             
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
