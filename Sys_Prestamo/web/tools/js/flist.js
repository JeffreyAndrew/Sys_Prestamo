function listar(rol) {
    var url = "loan?mt=list&op=6";
    var data = "idrol=" + rol;
    $.post(url, data, function (objJson) {
        var lista = objJson.lista;
        if (lista.length > 0) {
            $(".advice2").attr("class", "callout callout-warning advice2 hidden");
            $(".advice").attr("class", "hidden");
            $(".dTa").attr("class", "row dTa");
            var m = "";
            for (var i = 0; i < lista.length; i++) {
                m += '<tr>';
                m += '<td>' + lista[i].nombre + '</td>';
                m += '<td>' + lista[i].apellidos + '</td>';
                m += '<td>' + lista[i].dni + '</td>';
                m += '<td>' + lista[i].celular + '</td>';
                m += '<td>' + lista[i].correo + '</td>';
                m += '<td><a href="ci?op=2&id=' + lista[i].idpersona + '" class="btn btn-success"><i class="fa fa-user"></i>   Perfil</a></td>';
                m += '<td><a type="button" href="SVLH?histo=2&idpersona='+lista[i].idpersona+'" class="btn btn-info"><i class="fa fa-rotate-left"></i>   Historial</a></td>';
                m += '<td><button type="button" onclick="deleteperson(' + lista[i].idpersona + ')"  class="btn btn-danger"><i class="fa fa-close"></i>   Eliminar</button></td>';
                m += '</tr>';
            }
            var t = createTable();
            $(".conTable").empty();
            $(".conTable").append(t);
            $("#dataper").empty();
            $("#dataper").append(m);
            $("#datable").DataTable({
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
                }});

        } else {
            $(".dTa").attr("class", "row dTa hidden");
            $(".advice").attr("class", "hidden");
            $(".advice2").attr("class", "callout callout-warning advice2");
        }
    });
}
function createTable() {
    var t = '<table id="datable" class="table table-bordered table-striped">';
    t += '<thead>';
    t += '<tr>';
    t += '<th>Nombre</th>';
    t += '<th>Apellidos</th>';
    t += '<th>DNI</th>';
    t += '<th>Celular</th>';
    t += '<th>Correo</th>';
    t += '<th></th>';
    t += '<th></th>';
    t += '<th></th>';
    t += '</tr>';
    t += '</thead>';
    t += '<tbody id="dataper">';
    t += '</tbody>';
    t += '</table>';
    return t;
}

function deleteperson(id) {
    swal({
        title: "Confirmación",
        text: "¿Seguro que desea eliminar a esta persna del sistema?",
        type: "info",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Aceptar",
        cancelButtonText: "Cancelar",
        closeOnConfirm: false,
        closeOnCancel: false},
    function (isConfirm) {
        if (isConfirm) {
            var url = "loan?mt=remove&op=2";
            var data = "idpersona=" + id;
            $.post(url, data, function (objJson) {
                if (objJson.rp) {
                    swal({
                        title: "Eliminado",
                        text: "Se eliminó correctamente a la persona del sistema",
                        type: "success",
                        confirmButtonText: "Aceptar",
                        closeOnConfirm: true},
                    function (isConfirm) {
                        if (isConfirm) {
                            location.href = "ci?op=6&id="+$("#idper").val();
                        }
                    });
                } else {
                    swal("Ups...", "Ocurrió un error al eliminar la persona del sistema", "error");
                }
            });
        } else {
            swal("Cancelado", "No se eliminó a la persona", "error");
        }
    });
}