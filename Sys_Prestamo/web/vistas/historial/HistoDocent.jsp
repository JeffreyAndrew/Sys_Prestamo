<%-- 
    Document   : HistoDocent
    Created on : 07/09/2016, 11:34:42 PM
    Author     : Igor
--%>
<%@page import="DAO.HistorialDAO"%>
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
    </head>
   <body class="hold-transition skin-blue sidebar-mini">
       <section class="content-header"style="text-align: center;">
            <h2>
                "Historial De Prestamo por Docente"
                <small>SPE UPeU</small>
            </h2>
        </section>
        
        
         <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Historial prestamo por docente....</h3>
                        </div>
                       


              
                                     
                                <table class="table table-bordered table-striped" style="text-align:center">
                                   <tr><td><strong>ID DEL PRESTAMO</strong></td><td><strong>NOMBRE DEL DOCENTE</strong></td><td><strong>MARCA</strong></td><td><strong>SERIE</strong></td><td><strong>TIPO</strong></td><td><strong>ESTADO</strong></td><td><strong>CODIGO</strong></td><td><strong>DESCRIPCIÓN</strong></td></tr>
                                   <% String lista[][]= HistorialDAO.listarHistoDocent(1);%>
                                <%for(int i=0; i<lista.length;i++){%>
                                 <tr><td><%=lista[i][0] %></td><td><%=lista[i][1]+" "+lista[i][2]%></td><td><%=lista[i][3]%></td><td><%=lista[i][4]%></td><td><%=lista[i][5]%></td><td><%=lista[i][6]%></td><td><%=lista[i][7]%></td><td><%=lista[i][8]%></td></tr>
                              
                                  <% }%>  
                             
                               
                              
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
        
        
        
        
        
        
        
    </body>
</html>
