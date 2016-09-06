function listdoc() {
    var url = "loan?mt=list";
    var data = "op=3";
    $.post(url, data, function (objJson) {
        var lista = objJson.list;
        if (lista.length > 0) {
            $("#iadviced").attr("class", "callout callout-success hidden");
            $("#conTDoc").attr("class", "box");
            var m = "";
            for (var i = 0; i < lista.length; i++) {
                m += "<tr>";
                m += "<td>" + lista[i].persona + "</td>";
                m += "<td>" + lista[i].dni + "</td>";
                m += "<td><button onclick='escdoc(" + lista[i].idprestamo + ")' class='btn btn-success'><i class='fa fa-check-square-o'><i/></button></td>";
                m += "</tr>";
            }
            var a = createTableDoc();
            $("#iboxdoc").empty();
            $("#iboxdoc").append(a);
            $("#datadoc").empty();
            $("#datadoc").append(m);

        } else {
            $("#iadviced").attr("class", "callout callout-success");
            $("#conTDoc").attr("class", "box hidden");
        }
    });
}
function escdoc(pre) {
    var url = "loan?mt=list";
    var data = "op=1&idprestamo="+pre;
    $("#itabp").attr("class","panel panel-success");
    $.post(url, data, function (objJson) {
        var lista = objJson.list;
        if (lista.length > 0) {
            for (var i = 0; i < lista.length; i++) {
            }
        }
    });
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