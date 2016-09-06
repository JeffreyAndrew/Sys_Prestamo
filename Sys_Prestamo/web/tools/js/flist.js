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
                m += '<td><a href="ci?op=2&id='+lista[i].idpersona+'" class="btn btn-success"><i class="fa fa-user"></i>   Ver Perfil</a></td>';
                m += '<td><button type="button"  class="btn btn-info"><i class="fa fa-user"></i>   Ver Historial</button></td>';
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
    t += '</tr>';
    t += '</thead>';
    t += '<tbody id="dataper">';
    t += '</tbody>';
    t += '</table>';
    return t;
}