let contentClients = null;
let listaPersonas = null;
let cedulaEliminar = null;
let formInsertarUsuario = null
let formEditarUsuario = null;
let formEliminarUsuario = null;
let modalCrearUsuario = null;
let modalEditarUsuario = null;
let modalEliminarUsuario = null;
let waitContentEdit = null
let waitContent = null;
let waitContentCreate = null;
let texto_eliminar = null;


window.onload = function () {
    contentClients = document.getElementById("contentClients");
    formInsertarUsuario = document.getElementById("formInsertarUsuario");
    formEditarUsuario = document.getElementById("formEditarUsuario");
    formEliminarUsuario = document.getElementById("formEliminarUsuario");
    texto_eliminar = document.getElementById("texto_eliminar");

    waitContentEdit = document.getElementById("waitContentEdit");
    waitContent = document.getElementById("waitContent");
    waitContentCreate = document.getElementById("waitContentCreate");

    formInsertarUsuario.addEventListener("submit", function (event) {
        event.preventDefault();
        crearPersona();
    });

    formEditarUsuario.addEventListener("submit", function (event) {
        event.preventDefault();
        editarPersona();
    });

    formEliminarUsuario.addEventListener("submit", function (event) {
        event.preventDefault();
        eliminarPersona();
    });

    modalCrearUsuario = new bootstrap.Modal(document.getElementById('modalCrearUsuario'), {
        keyboard: false,
    })

    modalEditarUsuario = new bootstrap.Modal(document.getElementById('modalEditarUsuario'), {
        keyboard: false,
    })

    modalEliminarUsuario = new bootstrap.Modal(document.getElementById('modalEliminarUsuario'), {
        keyboard: false,
    })

    getClients("http://localhost/APIenPHP/personas/Obtener.php");
}

function getClients(endpoint) {

    waitContent.style.display = "block";
    fetch(endpoint)
    .then(res => res.json())
    .then(data => {
        // console.log("Se recibe");
        // console.log( data );
        listaPersonas = data.registros;
        contentClients.innerHTML = "";
        for (let i = 0; i < data.registros.length; i++) {
            temp = `
                <tr>
                    <td>${data.registros[i].cedula}</td>
                    <td>${data.registros[i].nombres}</td>
                    <td>${data.registros[i].apellidos}</td>
                    <td>${data.registros[i].telefono}</td>
                    <td>${data.registros[i].direccion}</td>
                    <td>${data.registros[i].email}</td>
                    <td>${data.registros[i].rol}</td>
                    <td>
                        <button class="btn btn-primary" onclick="abrirModalEditar( ${i} )">Editar</button>
                    </td>
                    <td>
                        <button class="btn btn-danger" onclick="mostrarModalEliminar( ${i} )">Eliminar</button>
                    </td>
                </tr>
                `;
            contentClients.innerHTML += temp;

        }
        waitContent.style.display = "none";
    });
}

function abrirModalEditar(indice) {
    console.log("Editando: ");
    console.log(listaPersonas[indice]);
    document.getElementById("campo_editar_cedula").value = listaPersonas[indice].cedula;
    document.getElementById("campo_editar_nombres").value = listaPersonas[indice].nombres;
    document.getElementById("campo_editar_apellidos").value = listaPersonas[indice].apellidos;
    document.getElementById("campo_editar_telefono").value = listaPersonas[indice].telefono;
    document.getElementById("campo_editar_direccion").value = listaPersonas[indice].direccion;
    document.getElementById("campo_editar_email").value = listaPersonas[indice].email;
    document.getElementById("campo_editar_rol").value = listaPersonas[indice].rol;
    modalEditarUsuario.show();
}

function editarPersona(){
    let datos = new FormData(formEditarUsuario);
    let configuracion = {
        method: "POST",
        headers: {
            "Accept": "application/json",
        },
        body: datos,
    };
    waitContentCreate.style.display = "block";
    fetch("http://localhost/APIenPHP/personas/Editar.php", configuracion)
    .then(res => res.json())
    .then(data => {
        console.log("Se recibe del endpoint Insert");
        console.log(data)

        if (data.status) {

            modalEditarUsuario.hide();
            getClients("http://localhost/APIenPHP/personas/Obtener.php");
            Swal.fire({
                title: '<strong><u>EXITO</u></strong>',
                icon: 'success',
                html: 'Se actualizaron los datos exitosamente',
                confirmButtonText: 'Entendido',
            })
        } else {
            Swal.fire({
                title: '<strong><u>ERROR</u></strong>',
                icon: 'error',
                html: 'Se ha presentado un error, vuelva a intentarlo',
                confirmButtonText: 'Entendido',
            })
        }
        waitContentCreate.style.display = "none";
    });
}

function mostrarModalEliminar(indice) {
    console.log("Eliminando: ");
    console.log(listaPersonas[indice]);
    cedulaEliminar = listaPersonas[indice].cedula;
    texto_eliminar.textContent = "¿Desea eliminar al usuario con cedula "+cedulaEliminar+"?";
    modalEliminarUsuario.show();
}

function eliminarPersona(){
    let datos = new FormData();
    datos.append("cedula", cedulaEliminar);
    let configuracion = {
        method: "POST",
        headers: {
            "Accept": "application/json",
        },
        body: datos,
    };
    waitContentCreate.style.display = "block";
    fetch("http://localhost/APIenPHP/personas/Eliminar.php", configuracion)
        .then(res => res.json())
        .then(data => {
            console.log("Se recibe del endpoint Eliminar");
            console.log(data)

            if (data.status) {

                modalEliminarUsuario.hide();
                getClients("http://localhost/APIenPHP/personas/Obtener.php");
                Swal.fire({
                    title: '<strong><u>EXITO</u></strong>',
                    icon: 'success',
                    html: 'Usuario eliminado con exito',
                    confirmButtonText: 'Entendido',
                })
            } else {
                Swal.fire({
                    title: '<strong><u>ERROR</u></strong>',
                    icon: 'error',
                    html: 'Se ha presentado un error, vuelva a intentarlo',
                    confirmButtonText: 'Entendido',
                })
            }
            waitContentCreate.style.display = "none";
        });

}

function crearPersona() {
    let datos = new FormData(formInsertarUsuario);
    let configuracion = {
        method: "POST",
        headers: {
            "Accept": "application/json",
        },
        body: datos,
    };
    waitContentCreate.style.display = "block";
    fetch("http://localhost/APIenPHP/personas/Insert.php", configuracion)
        .then(res => res.json())
        .then(data => {
            console.log("Se recibe del endpoint Insert");
            console.log(data)

            if (data.status) {

                formInsertarUsuario.reset();  //Limpiando el formulario.
                modalCrearUsuario.hide();
                getClients("http://localhost/APIenPHP/personas/Obtener.php");
                Swal.fire({
                    title: '<strong><u>EXITO</u></strong>',
                    icon: 'success',
                    html: 'Registro creado con exito',
                    confirmButtonText: 'Entendido',
                })
            } else {
                Swal.fire({
                    title: '<strong><u>ERROR</u></strong>',
                    icon: 'error',
                    html: 'Se ha presentado un error, es posible que la cedula esté repetida',
                    confirmButtonText: 'Entendido',
                })
            }
            waitContentCreate.style.display = "none";
        });
}