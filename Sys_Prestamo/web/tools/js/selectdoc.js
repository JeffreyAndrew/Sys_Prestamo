/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function selectdoc(nombre, id) {
    $("#docente").val(nombre);
    $("#idocente").val(id);
}

function selecteq(marca, serie, tipo, codigo, descripcion, id) {
    var i = 0;
    var m = "";
    $("#selected").empty();
    m += '<tr id="eq' + id + '">';
    m += '<td>' + marca + '</td>';
    m += '<td>' + serie + '</td>';
    m += '<td>' + tipo + '</td>';
    m += '<td>' + codigo + '</td>';
    m += '<td>' + descripcion + '</td>';
    m += '<td><button type="button" onclick="deleteeq()"  class="btn btn-danger"><i class="fa fa-close"></i></button></td>';
    m += '</tr>';
    $("#selected").append(m);
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