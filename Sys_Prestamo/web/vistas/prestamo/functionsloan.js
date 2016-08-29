$(document).ready(function () {
});
$("#regp").click(function () {
    validar();
});
$("#idaddeq").click(function () {
    clearModalE();
});
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
            $("#tabEquipo").DataTable();
            $("#dataeqdis").empty();
            $("#dataeqdis").append(m);
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
            var data = "iddet=" + id;
            $.post(url, data);
            new PNotify({
                title: "Equipo Añadido",
                type: "success",
                text: "Agregado Correctamente",
                nonblock: {
                    nonblock: true
                }
            });
            listarequipos(idpres);
        } else {
            new PNotify({
                title: "Error al agregar",
                type: "error",
                text: "Ha ocurrido un error al agregar equipo",
                nonblock: {
                    nonblock: true
                }
            });
        }
    });
}
function confirmloan(prest, doc, lug, fec) {
    $("#regp").attr("class", "hidden");
    $("#idescd").attr("class", "hidden");
    $("#itabp").attr("class", "panel panel-primary");
    $("#idlug").attr("disabled", "");
    $("#datepicker").attr("disabled", "");
    addloan(prest, doc, lug, fec);
}

function validar() {
    var doc = $("#iddoc").val();
    var lug = $("#idlug").val();
    var fec = $("#datepicker").val();
    var prest = $("#idprest").val();
    if (doc !== "" && lug !== "" && fec !== "") {
        confirmloan(prest, doc, lug, fec);
    } else {
        if (doc === "" || lug === "" || fec === "") {
            if (doc === "") {
                new PNotify({
                    title: "Docente no escogido",
                    type: "error",
                    text: "Debe escoger el docente al que se hará el prestamo",
                    nonblock: {
                        nonblock: true
                    }
                });
            }
            if (lug === "") {
                new PNotify({
                    title: "Lugar no especificado",
                    type: "error",
                    text: "No especificó el lugar",
                    nonblock: {
                        nonblock: true
                    }
                });
            }
            if (fec === "") {
                new PNotify({
                    title: "Fecha no especificada",
                    type: "error",
                    text: "No especificó la fecha de devolución",
                    nonblock: {
                        nonblock: true
                    }
                });
            }
        }
    }
}
function addloan(user, persona, lugar, fecha) {
    var orf = fecha.split("/");
    var dia = orf[1];
    var mes = orf[0];
    var an = orf[2];
    var fecenv = an + "-" + mes + "-" + dia;
    var url = "loan?mt=add&op=1";
    var data = "iduser=" + user;
    data += "&idpersona=" + persona;
    data += "&fecha=" + fecenv;
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
            $("#isave").attr("class", "btn btn-danger");
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
                m += '<td><button type="button" onclick="addequipo(this.value)" class="btn btn-danger"><i class="fa fa-close" value="' + lista[i].iddet + '"></i></button></td>';
                m += '</tr>';
            }
            var d = createTable();
            $("#eqpres").empty();
            $("#eqpres").append(d);
            $("#datapres").empty();
            $("#datapres").append(m);
        }
    });
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

function regcom() {
    var url = "loan?mt=update&op=2";
    var data = "com=" + $("#icom").val();
    data += "&idprestamo=" + $("#iprestamo").val();
    $.post(url, data, function (objJson) {
        if (objJson.resp) {
            location.href="loan?mt=rd&op=1";
        }else{
            
        }
    });
}



