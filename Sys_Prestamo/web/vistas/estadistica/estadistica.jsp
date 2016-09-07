
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.Det_PrestamoDTO"%>
<%@page import="DTO.PrestamoDTO" %>
<jsp:useBean id="List_rol" scope="session" class="java.util.ArrayList" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dist/css/admin.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Admin</title>
    </head>
    <body>


        <div class="container">
            <div class="row">

                <section class="content">
                    <h1>Lista de Los Roles del Sistema</h1>
                    <div class="col-md-8 col-md-offset-2">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-success btn-filter" id="crearrol" data-target="pagado">+ Añadir</button>
                                    </div>
                                </div>
                                <div class="table-container">
                                    <table class="table table-bordered color2" >
                                        <tr>
                                            <th>ID</th>
                                            <th></th>
                                            <th style="width: 30%"> </th>

                                        </tr>
                                        <% for (int i = 0; i < List_rol.size(); i++) {
                                                DTO.PrestamoDTO dat = new DTO.PrestamoDTO();
                                                dat = (DTO.PrestamoDTO) List_rol.get(i);

                                        %>
                                        <tr>
                                            <td><%= dat.getIdPrestamo()%></td>
                                            <td><%= dat.getIdUsuario()%></td>
                                            <td></td>

                                        </tr>
                                        <%}%>
                                        <tbody id="table_rol">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>
                </section>

            </div>
        </div>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Registrar Roles</h4>
                    </div>
                    <div class="modal-body">
                        <div id="formulario" class="main-center">
                            <img src="dist/img/user2-160x160.jpg" class="avatar">
                            <form class="form-horizontal" id="formrol" method="post">
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">Nombre del Rol</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="rol_name" id="name"  placeholder="Nombre del rol"/>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div id="true" class="main-center" style="display: none">
                            <img src="dist/img/true.png" width="250" height="250" />
                        </div>
                        <div id="false" class="main-center" style="display: none">
                            <img src="dist/img/false.png" width="250" height="250" />
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn  alazarin" data-dismiss="modal">Cancelar</button>
                        <button type="button" id="setrol" class="btn  turquish">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Editar Rol</h4>
                    </div>
                    <div class="modal-body">
                        <div id="formulario" class="main-center">
                            <form class="form-horizontal" id="formrol2" method="post">
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">Nombre del Rol</label>
                                    <div class="cols-sm-10">
                                        <div id="datos_id" class="input-group">

                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div id="true" class="main-center" style="display: none">
                            <img src="dist/img/true.png" width="250" height="250" />
                        </div>
                        <div id="false" class="main-center" style="display: none">
                            <img src="dist/img/false.png" width="250" height="250" />
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn  alazarin" data-dismiss="modal">Cancelar</button>
                        <button type="button" id="setrol2" class="btn  turquish">Guardar Cambios</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
         <script>
            var id_rol;
            $(document).ready(function () {
                listarrol();// funcion para listar los roles con ajax

                $('#setrol').on('click', function () {
                    var datos = $('#formrol').serializeArray();// sacamos los datos del formulario y lo ponemos en un Objet


                    $.ajax({
                        url: "admin?op=2",
                        data: datos,
                        success: function (data) {
                            if (data == "true") {
                                $('#formulario').hide();
                                $('#true').show(200);// mostrar el div con la inagen success
                                setTimeout(function () { // pausar el codigo
                                    $('#myModal').modal('toggle');// cerrar el modal despues del tiempo
                                    listarrol();
                                }, 2000);// tiempo de la pausa del codigo

                            } else {
                                $('#formulario').hide();
                                $('#false').show(200);
                                setTimeout(function () {
                                    $('#myModal').modal('toggle');
                                }, 2000);
                            }
                        },
                        error: function () {
                            $('#formulario').hide();
                            $('#false').show(200);
                            setTimeout(function () {
                                $('#myModal').modal('toggle');
                            }, 2000);
                        }
                    });
                });
//----------------------- guardar cambios de la edicion ----------------------
                $('#setrol2').on('click', function () {
                    var datos = $('#formrol2').serializeArray();
                    $.ajax({
                        url: "admin?op=edit&id=" + id_rol,
                        data: datos,
                        success: function (data) {
                            $('#myModal2').modal('toggle');
                            listarrol();
                        },
                        error: function (d) {
                        }
                    });
                });

                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^   
                $('#crearrol').click(function () {
                    $('#myModal').modal();                     // initialized with defaults
                    $('#myModal').modal({keyboard: false});   // initialized with no keyboard
                    $('#myModal').modal('show');
                });

            });

            function listarrol() {
                $.ajax({
                    url: "admin?op=3",
                    data: "",
                    success: function (data) {
                        $('#table_rol').html(data);
                    },
                    error: function (d) {

                        console.log(d);
                    }

                });
            }
            function eliminar(id) {
                var statusConfirm = confirm("¿Realmente desea eliminar esto?");
                if (statusConfirm == true)
                {
                    $.post('admin?op=delete&id=' + id, function (d) {
                        console.log(d);
                        if (d) {
                            listarrol();

                        }
                    });
                }

            }
            function editar(id) {
                $('#myModal2').modal('show');
                $.post('admin?op=list_id&id=' + id, function (d) {
                    $('#datos_id').html(d);
                    id_rol = id;
                });
            }
        </script>
    </body>
</html>
