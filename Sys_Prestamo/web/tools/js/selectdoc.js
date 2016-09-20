/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var eqsel = [];

var i = 0;
function selectdoc(nombre, id) {
    $("#docente").val(nombre);
    $("#idocente").val(id);
}
$("#breserve").click(function(){
    $.post("rc",{
            'eqsel[]':eqsel,
            gr:3,
            fechas:$("#reservation").val(),
            idocente:$("#idocente").val(),
            dia:$("#dia").val(),
            hinicio:$("#hinicio").val(),
            hfinal:$("#hfinal").val(),
            idprest:$("#idprest").val()
    },function(responseText){
        $(location).attr('href',responseText);
    });
    return false;
});
function selecteq(marca, serie, tipo, codigo, descripcion, id) {
    deleteeq(id);
    var m = '<tr id="eq' + id + '">';
    $("#deqselected .odd").remove();
    m += '<td>' + marca + '</td>';
    m += '<td>' + serie + '</td>';
    m += '<td>' + tipo + '</td>';
    m += '<td>' + codigo + '</td>';
    m += '<td>' + descripcion + '</td>';
    m += '<td><button type="button" onclick="deleteeq(' + id + ')"  class="btn btn-danger"><i class="fa fa-close"></i></button></td>';
    m += '</tr>';
    var a = 0;
    if (eqsel.length == 0) {
        eqsel.push(id);
    } else {
        for (i = 0; i < eqsel.length; i++) {
            if (eqsel[i] == id) {
                a = 1;
            }
        }
        if (a == 0) {
            eqsel.push(id);
        }
    }
    $("#selected").append(m);
}

function deleteeq(ideq) {
    $("#deqselected #eq" + ideq).remove();
    for (i = 0; i < eqsel.length; i++) {
        if (eqsel[i] == ideq) {
            eqsel.splice(i, 1);
        }
    }
}

$(function () {
    $('#inventario, #availableDoc').DataTable({
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
    $('#deqselected').DataTable({
        info: false,
        ordering: false,
        paging: false,
        searching: false,
        "language": {
            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sEmptyTable": "Ningún Equipo agregado",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando..."
        }
    });
});