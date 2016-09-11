function listdoc() {var url = "loan?mt=list";var data = "op=3";$.post(url, data, function (objJson) {var lista = objJson.list;if (lista.length > 0) {$("#iadviced").attr("class", "callout callout-success hidden");$("#conTDoc").attr("class", "box");var m = "";for (var i = 0; i < lista.length; i++) {m += "<tr>";m += "<td>" + lista[i].persona + "</td>";m += "<td>" + lista[i].dni + "</td>";m += "<td><button onclick='escdoc(" + lista[i].idprestamo + ")' class='btn btn-success'><i class='fa fa-check-square-o'><i/></button></td>";m += "</tr>";}var a = createTableDoc();$("#iboxdoc").empty();$("#iboxdoc").append(a);$("#datadoc").empty();$("#datadoc").append(m);} else {$("#iadviced").attr("class", "callout callout-success");$("#conTDoc").attr("class", "box hidden");}});}
function escdoc(pre) {$("#docenteModal").modal("hide");var url = "loan?mt=list&op=1";var data = "idp=" + pre;$("#itabp").attr("class", "panel panel-success pd");$.post(url, data, function (objJson) {var lista = objJson.lista;if (lista.length > 0) {dataloan(pre);var m = "";$("#saveB").attr("class", "btn btn-danger");for (var i = 0; i < lista.length; i++) {m += '<tr>';m += '<td><center>' + lista[i].marca + '</center></td>';m += '<td><center>' + lista[i].serie + '</center></td>';m += '<td><center>' + lista[i].tipo + '</center></td>';m += '<td><center>' + lista[i].codigo + '</center></td>';m += '<td><center><a style="cursor: pointer;" ><i class="fa fa-refresh"></i></a></center></td>';m += '<td><center><input id="' + lista[i].iddet + '"  class="icheckbox_minimal-red" type="checkbox" onclick="devolution(this.id)" value="1" checked></center></td>';m += '</tr>';}$(".conTable").attr("class", "conTable");var f = createTable();$(".conTable").empty();$(".conTable").append(f);$("#datapres").empty();$("#datapres").append(m);}});}
function devolution(id) {
    if ($("#" + id + "").val() === "1") {
        $("#" + id + "").attr("value", "0");
    } else {
        $("#" + id + "").attr("value", "1");
    }

}
function dev() {
    var filas = document.getElementById('datapres').rows.length ;
    for (var i = 0; i < filas; i++) {
        var a=document.getElementById('datapres').rows[i].cells[5].innerHTML.split('id="');
        var b=a[1].split('" class');
        var c=b[0];
        var url="";
        var data="";
        $.post(url, data);
    }
    
}

function createTableDoc() {
    var m = '<table id="tabDc" class="table table-bordered table-striped">';
    m += '<thead>';
    m += '<tr>';
    m += '<th><i class="fa fa-user"></i>   Nombres y Apellidos</th>';
    m += '<th><i class="fa fa-credit-card"></i>   DNI</th>';
    m += '<th></th>';
    m += '</tr>';
    m += '</thead>';
    m += '<tbody id="datadoc">';
    m += '</tbody>';
    m += '</table>';
    return m;
}

function dataloan(id) {var url = "loan?mt=list&op=7";var data = "idp=" + id;$.post(url, data, function (objJson) {var lista = objJson.lista;if (lista.length > 0) {$(".dT").attr("class", "hidden");$(".dataLoan").attr("class", "dataLoan");for (var i = 0; i < lista.length; i++) {$("#idc").attr("value", lista[i].persona);$("#ifp").attr("value", lista[i].fprestamo);$("#ihp").attr("value", lista[i].hprestamo);$("#ihl").attr("value", lista[i].hlimite);var date = new Date();var time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();var day = parseInt(date.getDate());var month = parseInt(date.getMonth() + 1);if (day < 10) {day.toString();day = "0" + day;}if (month < 10) {month = "0" + month;}var dta = (date.getFullYear() + "-" + month + "-" + day);if (lista[i] !== dta) {$(".pd").attr("class", "panel panel-danger pd");$(".adviceT").attr("class", "callout callout-danger adviceT");} else {if (lista[i].hlimite < time) {$(".pd").attr("class", "panel panel-danger pd");$(".adviceT").attr("class", "callout callout-danger adviceT");}}}} else {}});}

function createTable() {
    var t = '<table id="TablaDatos" class="table table-condensed daT">';
    t += '<thead>';
    t += '<tr>';
    t += '<th><center><i class="fa fa-laptop"></i>   Marca</center></th>';
    t += '<th><center>Serie</center></th>';
    t += '<th><center>Tipo</center></th>';
    t += '<th><center>Código</center></th>';
    t += '<th><center>Descripción</center></th>';
    t += '<th><center>A devolver</center></th>';
    t += '</tr>';
    t += '</thead>';
    t += '<tbody id="datapres">';
    t += '</tbody>';
    t += '</table>';
    return t;
}