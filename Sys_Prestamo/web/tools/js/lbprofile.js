function changerol() {
    $(".comboRol").attr("class", "form-control comboRol");
    $(".changerol").attr("class", "hidden");
    $("#rolnow").attr("class", "hidden");
    $("#tipo").attr("value", "2");
}
function changev(id) {
    $("#idrol").attr("value", id);
}
function validarS() {
    if ($("#name").val() !== "" && $("#last").val() !== "" && $("#dni").val() !== "" && $("#phone").val() !== "" && $("#mail").val() !== "") {
        if ((/^([0-9])*$/.test($("#dni").val())) === true && (/^([0-9])*$/.test($("#phone").val())) === true) {
            updateperson();
        } else {
            swal("Campos errados", "No puede ingresar letras en un campo de números", "error");
        }
    } else {
        swal("Campos Vacíos", "No debe dejar campos vacíos", "warning");
    }
}
function updateperson() {
    var url = "ci?op=1";
    var data = "id=" + $("#idpersona").val();
    data += "&idrol=" + $("#idrol").val();
    data += "&name=" + $("#name").val();
    data += "&last=" + $("#last").val();
    data += "&dni=" + $("#dni").val();
    data += "&phone=" + $("#phone").val();
    data += "&mail=" + $("#mail").val();
    swal({
        title: "Confirmación",
        text: "¿Seguro que desea guardar los cambios?",
        type: "info",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Aceptar",
        cancelButtonText: "Cancelar",
        closeOnConfirm: false,
        closeOnCancel: false},
    function (isConfirm) {
        if (isConfirm) {
            $.post(url, data);
            swal({
                title: "Cambios Realizados",
                text: "Se efectuaron los cambios correctamente",
                type: "success",
                confirmButtonText: "Aceptar",
                closeOnConfirm: true},
            function (isConfirm) {
                if (isConfirm) {
                    location.href = "ci?op=2&id=" + $("#idpersona").val();
                }
            });
        } else {
            swal("Cancelado", "No se realizaron cambios", "error");
        }
    });
}
function upuser() {
    var user = $("#nwuser").val();
    var pass = $("#nwpass").val();
    var id = $("#idpersona").val();
    $('#editUserModal').modal('hide');
    swal({
        title: "Confirmación",
        text: "Escribe tu contraseña actual",
        type: "input",
        inputType: "password",
        showCancelButton: true,
        closeOnConfirm: false,
        animation: "slide-from-top",
        inputPlaceholder: "Contraseña"},
    function (inputValue) {
        if (inputValue === false) {
            return false;
        }
        if (inputValue === "") {
            swal.showInputError("Debes escribir algo");
            return false;
        }
        if ($("#idpass").val() === inputValue) {
            var url = "ci?op=2";
            var data = "user=" + user;
            data += "&pass=" + pass;
            data += "&id=" + id;
            $.post(url, data);
            swal({
                title: "¡Genial!",
                text: "Se efectuaron los cambios en el usuario correctamente",
                type: "success",
                confirmButtonText: "Aceptar",
                closeOnConfirm: true},
            function (isConfirm) {
                if (isConfirm) {
                    location.href = "ci?op=2&id=" + $("#idpersona").val();
                }
            });
        } else {
            swal.showInputError("Las contraseñas no coinciden");
        }

    });
}
