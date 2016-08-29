<%-- 
    Document   : añadir
    Created on : 28/08/2016, 04:24:40 AM
    Author     : EXEBIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="bootstrap/js/jquery-1.12.3.min.js" type="text/javascript"></script>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> 
        <script src="plugins/input-mask/jquery.maskedinput.min.js" type="text/javascript"></script>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
        <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">    

        <script type="text/javascript">
            $(function () {

                $("#celular").mask("999999999");
                $("#dni").mask("99999999");
            });
        </script> 

        <script>function soloLetras(e) {
                key = e.keyCode || e.which;
                tecla = String.fromCharCode(key).toLowerCase();
                letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
                especiales = "8-37-39-46";

                tecla_especial = false
                for (var i in especiales) {
                    if (key == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }

                if (letras.indexOf(tecla) == -1 && !tecla_especial) {
                    return false;
                }
            }
            ;


            $(document).click(function () {
                $("#borrar").click(borrar);
                function borrar()
                {
                    $("#nombre").val('') && $("#apellidos").val('') &&
                            $("#celular").val('') && $("#dni").val('') && $("#correo").val('') && $("#idrol").val('');
                }

            });




        </script>  

        <title>SPE || UPeU</title>
    </head>
    <body style="padding: 3%;box-sizing: border-box;">
    <center>
        <div class="box" style="width: 80%;">
            <h3>Registro de Persona</h3><br/>
            <form class="form-horizontal" method="get" action="ci">
                <div box-body>
                    <div class="row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="letra col-sm-4 control-label"><i class="fa fa-user"></i>   Nombre </label>
                                <div class="col-sm-6">
                                    <input type="text" required="" name="nombre" id="nombre" class="a form-control" onkeypress="return soloLetras(event)">           
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="letra col-sm-4 control-label">Apellidos</label>
                                <div class="col-sm-6">    
                                    <input type="text" required="" name="apellido" id="apellidos" class="a form-control" onkeypress="return soloLetras(event)">             
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="letra col-sm-4 control-label">Celular</label>
                                <div class="col-sm-6">
                                    <input type="text" required="" name="celular" id="celular" class="a form-control"  >           
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="letra col-sm-4 control-label">Dni</label>
                                <div class="col-sm-6">
                                    <input type="number" required="" name="dni" id="dni" class="a form-control"  >             
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="letra col-sm-4 control-label">Rol</label>
                                <select class="form-control select2" name="idrol" data-placeholder="Select a State" style="width: 100%;">
                                    <option value="1">Prestamista</option>
                                    <option value="2">Docente</option>

                                </select>

                            </div>
                            <div class="bootstrap-timepicker">
                                <div class="form-group">


                                    <label class="letra col-sm-4 control-label">Correo</label>
                                    <div class="input-group">

                                        <input type="text" required="" name="correo" id="correo" class="a form-control  timepicker">  

                                    </div>
                                </div>
                            </div>

                        </div>


                    </div>
                    <div class="box-footer ">
                        <div class="botones form-group ">
                            <input type="hidden" name="op" id="op" value="3">
                            <div>
                                <button type="button" id="borrar"  class="btn btn-danger btn-lg pul  pull-left" >Cancelar</button>
                            </div>
                            <div>
                                <input type="submit" name="boton" id="boton" value="Registrar"  class="btn btn-primary btn-lg pul  pull-right ">
                            </div>
                        </div>

                    </div> 
                </div>
            </form>
        </div>
    </center>
    <!-- /.content -->

    <!-- ./wrapper -->
    <script src="bootstrap/js/formulario.js" type="text/javascript"></script>
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
