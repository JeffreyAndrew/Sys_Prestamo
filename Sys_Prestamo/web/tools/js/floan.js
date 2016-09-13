function listardoc() {
    var url = "loan?mt=list";
    var data = "op=4";
    $.post(url, data, function (objJson) {
        var lista = objJson.lista;
        if (lista.length > 0) {
            var m = "";
            $("#iadviced").attr("class", "hidden");
            $("#conTDoc").attr("class", "box");
            for (var i = 0; i < lista.length; i++) {
                m += '<tr>';
                m += '<td>' + lista[i].persona + '</td>';
                m += '<td>' + lista[i].dni + '</td>';
                m += '<td><button type="button" onclick="datDC(' + lista[i].idpersona + ')" class="btn btn-success"><i class="fa fa-check"></i></button></td>';
                m += '</tr>';
            }
            var d = createTableDoc();
            $("#iboxd").empty();
            $("#iboxd").append(d);
            $("#datadoc").empty();
            $("#datadoc").append(m);
            $("#tabDc").DataTable({
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
        }
    });
}

function confirmloan(prest, doc, lug, hora) {
    $("#regp").attr("class", "hidden");
    $("#idescd").attr("class", "hidden");
    $(".cancelar").attr("class", "btn btn-danger cancel");
    $(".cmb").attr("class", "callout callout-success cmb");
    $(".adv").attr("class", "hidden");
    $("#itabp").attr("class", "panel panel-primary col-md-12");
    $("#idlug").attr("disabled", "");
    $("#ihour").attr("disabled", "");
    addloan(prest, doc, lug, hora);
}

function createTable() {
    var t = '<table class="table table-condensed">';
    t += '<thead>';
    t += '<tr>';
    t += '<th><i class="fa fa-laptop"></i>Marca</th>';
    t += '<th>Serie</th>';
    t += '<th>Tipo</th>';
    t += '<th>Codigo</th>';
    t += '<th>Descripción</th>';
    t += '<th></th>';
    t += '</tr>';
    t += '</thead>';
    t += '<tbody id="datapres">';
    t += '</tbody>';
    t += '</table>';
    return t;
}
function createTableEq() {
    var m = '<table id="tabEquipo" class="table table-bordered table-striped">';
    m += '<thead>';
    m += '<tr>';
    m += '<th>Marca</th>';
    m += '<th>Serie</th>';
    m += '<th>Tipo</th>';
    m += '<th>Código</th>';
    m += '<th>Descripción</th>';
    m += '<th></th>';
    m += '</tr>';
    m += '</thead>';
    m += '<tbody id="dataeqdis">';
    m += '</tbody>';
    m += '</table>';
    return m;
}

function createTableDoc() {
    var m = '<table id="tabDc" class="table table-bordered table-striped">';
    m += '<thead>';
    m += '<tr>';
    m += '<th>Docente</th>';
    m += '<th>DNI</th>';
    m += '<th></th>';
    m += '</tr>';
    m += '</thead>';
    m += '<tbody id="datadoc">';
    m += '</tbody>';
    m += '</table>';
    return m;
}
function oc() {
    $(".am").attr("class", "hidden");
}

function canloan() {
    swal({title: "¿Está seguro?",
        text: "Se cancelará el prestamo y todos sus datos",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Eliminar",
        cancelButtonText: "Cancelar",
        closeOnConfirm: false,
        closeOnCancel: true},
    function (isConfirm) {
        if (isConfirm) {

        }
    });
}
function validar() {
    var doc = $("#iddoc").val();
    var lug = $("#idlug").val();
    var hora = $("#ihour").val();
    var prest = $("#idprest").val();
    if (doc !== "" && lug !== "" && hora !== "") {
        var d = new Date();
        var h = d.getHours();
        var mn = d.getMinutes();
        if (h < 10) {
            h.toString();
            h = "0" + h;
        }
        if (mn < 10) {
            mn.toString();
            mn = "0" + mn;
        }
        var hr = h + ":" + mn;
        var tm = hora.split(" ");
        var hn = tm[0];
        var tn = tm[1];
        var td = hn.split(":");
        var hd = parseInt(td[0]);
        var md = td[1];
        if (tn === "PM") {
            hd = hd + 12;
        }
        if (hd < 10) {
            hd.toString();
            hd = "0" + hd;
        }
        var hc = hd + ":" + md;
        if (hc < hr) {
            swal("¡Hey!", "Debe escoger una hora superior a la actual", "error");
        } else {
            swal({title: "Datos Registrados",
                text: "Ahora debe escoger los equipos",
                type: "success",
                closeOnConfirm: true},
            function (isConfirm) {
                if (isConfirm) {
                    confirmloan(prest, doc, lug, hora);
                }
            });
        }
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