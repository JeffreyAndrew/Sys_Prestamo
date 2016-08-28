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
        <title>Registrar Equipos</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
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
                <li class="active">Registrar</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <!-- left column -->
                <div style="margin: 40px 20px 0px 20px">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <center> <h1 class="box-title" style="font-size: 50px">Registrar Equipos</h1> </center>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="ec">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="marca">Marca</label>
                                    <input type="text" required="" maxlength="30" onkeypress="return soloLetras(event)" class="form-control input-lg" id="marca" name="marca" placeholder="Marca">
                                </div>

                                <div class="form-group">
                                    <label for="serie">Serie</label>
                                    <input type="text" required="" maxlength="30" class="form-control input-lg" id="serie" name="serie" placeholder="Serie">
                                </div>

                                <div class="form-group">
                                    <label for="tipo">Tipo</label>
                                    <input type="text" required="" maxlength="120" class="form-control input-lg" id="tipo" name="tipo" placeholder="Tipo">
                                </div>

                                <div class="form-group">
                                    <label for="codigo">Codigo</label>
                                    <input type="text" required="" maxlength="30"  class="form-control input-lg" id="codigo" name="codigo" placeholder="Código">
                                </div>

                                <div class="form-group">
                                    <label for="descripcion">Descripcion</label>
                                    <textarea type="text"  required="" maxlength="120" class="form-control input-lg" rows="5" id="descripcion" name="descripcion" placeholder="Descripcion"></textarea>
                                </div>

                                <div class="form-group">
                                    <input type="hidden" name="ge" value="5">
                                </div>

                                <div class="box-footer">
                                    <a role="button" class="btn btn-danger" href="ce?ge=1" data-toggle="modal">Cancelar</a>
                                    <button type="button" class="btn btn-info pull-right" href="#registrar" data-toggle="modal">Registrar</button>
                                </div> 

                                <div class="modal fade" id="registrar">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <center><h1 class="modal-title">Atención</h1></center>
                                            </div>
                                            <div class="modal-body">
                                                <h2 style="text-align: justify">¿Esta seguro de que desea registrar este nuevo equipo? Si es necesario verifique los campos nuevamente.</h2>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="submit" class="btn btn-default btn-lg" value="Registrar">
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
                                                <a class="btn btn-danger btn-lg" href="../../index.jsp">Si</a>                                                        
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
        <!-- /.content -->

        <!-- ./wrapper -->
        <script src="../../bootstrap/js/formulario.js" type="text/javascript"></script>
        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
    </body>
</html>
