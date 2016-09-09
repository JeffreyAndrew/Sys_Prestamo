$(document).ready(function () {
    listardoc();
});
$("#regp").click(function () {
    validar();
});
$("#idaddeq").click(function () {
    clearModalE();
});
function datDC(id) {
    $("#iddoc").attr("value", id);
    var url = "loan?mt=list";
    var data = "op=5&idpersona=" + id;
    $.post(url, data, function (objJson) {
        var lista = objJson.lista;
        if (lista.length > 0) {
            for (var i = 0; i < lista.length; i++) {
                $("#idocente").attr("value",lista[i].persona);
                $("#docenteModal").modal("hide");
            }
        }
    });
}
function clearModalE() {
    $("#ibox").empty();
    listaequiposdis();
}
function listaequiposdis() {
    var url = "loan?mt=list";
    var data = "op=2";
    $.post(url, data, function (objJson) {
        var lista = objJson.lista;
        if (lista.length > 0) {
            var m = "";
            $("#iadvice").attr("class", "hidden");
            $("#contab").attr("class", "box");
            for (var i = 0; i < lista.length; i++) {
                m += '<tr>';
                m += '<td>' + lista[i].marca + '</td>';
                m += '<td>' + lista[i].serie + '</td>';
                m += '<td>' + lista[i].tipo + '</td>';
                m += '<td>' + lista[i].codigo + '</td>';
                m += '<td>' + lista[i].descripcion + '</td>';
                m += '<td><button type="button" onclick="addequipo(' + lista[i].iddet + ')" class="btn btn-success"><i class="fa fa-check"></i></button></td>';
                m += '</tr>';
            }
            var d = createTableEq();
            $("#ibox").empty();
            $("#ibox").append(d);
            $("#dataeqdis").empty();
            $("#dataeqdis").append(m);
            $("#tabEquipo").DataTable({
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
        } else {
            $("#iadvice").attr("class", "callout callout-danger");
            $("#contab").attr("class", "hidden");
        }
    });
}
function addequipo(id) {
    var idpres = $("#iprestamo").val();
    var url = "loan?mt=add&op=2";
    var data = "idprestamo=" + idpres;
    data += "&iddet=" + id;
    $.post(url, data, function (objJson) {
        $('#equipoModal').modal('hide');
        if (objJson.resp) {
            var url = "loan?mt=update&op=1";
            var data = "estado=0";
            data += "&iddet=" + id;
            $.post(url, data);
            swal("Equipo añadido", "El equipo fue añadido correctamente", "success");
            listarequipos(idpres);
        } else {
            swal("Ups..", "Ocurrio un error al añadir el equipo", "error");
        }
    });
}
function validar() {
    var doc = $("#iddoc").val();
    var lug = $("#idlug").val();
    var hora = $("#ihour").val();
    var prest = $("#idprest").val();
    if (doc !== "" && lug !== "" && hora !== "") {
        confirmloan(prest, doc, lug, hora);
    } else {
        if (doc === "" || lug === "" || hora === "") {
            if (doc === "") {
                swal("¡Hey!", "Debe escoger el docente a quien se le prestará el/los equipo(s)", "warning");
            }
            if (lug === "") {
                swal("¡Hey!", "Debe ingresar el lugar en donde se usará el/los equipo(s)", "warning");
            }
            if (hora === "") {
                swal("¡Hey!", "Debe escoger la hora límite en la que se debe devolver el/los equipo(s)", "warning");
            }
        }
    }
}
function addloan(user, persona, lugar, hora) {
    var h=hora.split(":");
    var hu = parseInt(h[0]);
    var min = h[1];
    var dt=min.split(" ");
    var mn=dt[0];
    var c=dt[1];
    if (c==="PM") {
        hu=hu+12;
    }
    hu.toString();
    var ht=hu+":"+mn+":00";
    var url = "loan?mt=add&op=1";
    var data = "iduser=" + user;
    data += "&idpersona=" + persona;
    data += "&hora=" + ht;
    data += "&lugar=" + lugar;
    $.post(url, data, function (objJson) {
        var idprestamo = objJson.idprestamo;
        $("#iprestamo").attr("value", idprestamo);
    });
}

function listarequipos(id) {
    var url = "loan?mt=list&op=1";
    var data = "idp=" + id;
    $.post(url, data, function (objJson) {
        var lista = objJson.lista;
        if (lista.length > 0) {
            $("#isave").attr("class", "btn btn-info");
            var m = "";
            $("#iadvice").attr("class", "hidden");
            $("#contab").attr("class", "box");
            for (var i = 0; i < lista.length; i++) {
                m += '<tr>';
                m += '<td>' + lista[i].marca + '</td>';
                m += '<td>' + lista[i].serie + '</td>';
                m += '<td>' + lista[i].tipo + '</td>';
                m += '<td>' + lista[i].codigo + '</td>';
                m += '<td>' + lista[i].descripcion + '</td>';
                m += '<td><button type="button" onclick="removeeq(' + lista[i].iddet + ')" class="btn btn-danger"><i class="fa fa-close"></i></button></td>';
                m += '</tr>';
            }
            var d = createTable();
            $("#eqpres").empty();
            $("#eqpres").append(d);
            $("#datapres").empty();
            $("#datapres").append(m);
        } else {
            $("#isave").attr("class", "btn btn-info hidden");
        }
    });
}
function regcom() {
    var url = "loan?mt=update&op=2";
    var data = "com=" + $("#icom").val();
    data += "&idprestamo=" + $("#iprestamo").val();
    $.post(url, data, function (objJson) {
        if (objJson.resp) {
            location.href = "ci?op=2&id="+$("#iddoc").val();
        } else {

        }
    });
}

function removeeq(id) {
    var url = "loan?mt=remove&op=1";
    var data = "iddet=" + id;
    data += "&idprestamo=" + $("#iprestamo").val();
    $.post(url, data, function (objJson) {
        if (objJson.rp) {
            var url = "loan?mt=update&op=1";
            var data = "iddet=" + id;
            data += "&estado=1";
            $.post(url, data);
            $("#eqpres").empty();
            listarequipos($("#iprestamo").val());
        } else {
            swal("Ups...", "Ocurrió un error al desvincular este equipo", "error");
        }
    });
}
