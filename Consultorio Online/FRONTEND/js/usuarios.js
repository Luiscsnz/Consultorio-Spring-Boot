//METODO PARA LISTAR
async function listarUsuarios() {



    let url = "http://localhost:8080/usuario/list"
    console.log(window.location.pathname)
    if (window.location.pathname == "/usuarios.html") {
        let response = await fetch(url)
        console.log(response)
        let data = await response.json()
        console.log(data)
        let tabla = document.getElementById('tablausuarios');
        tabla.innerHTML = "";

        data.forEach(element => {

            tabla.innerHTML += `
            <tr>
                <th scope="row">${element.id}</th>
                <td>${element.persona.nombre}</td>
                <td>${element.persona.correo}</td>
                <td><button type="button" class="btn btn-primary" onclick='window.location = "usuariosdetalle.html?id=${element.id}"'>Editar</button></td>
                <td><button type="button" class="btn btn-danger" onclick='borrarUsuario(${element.id})'>Borrar</button></td>}
            </tr>
            `


        })
    }


}
//METODO PARA BORRAR
function borrarUsuario(id) {
    let request = sendRequest('usuario/' + id, 'DELETE', '');
    request.onload = function() {
        listarUsuarios();
    }
}

//METODO PARA CARGAR
function cargarUsuario(id) {

    let request = sendRequest('usuario/list/' + id, 'GET', '');



    let nombre_usuario = document.getElementById('usuario');
    let password = document.getElementById('password')


    let tipo_usuario = document.getElementById('tipo_usuario')

    let nombre = document.getElementById('nombre')
    let apellido = document.getElementById('apellido')
    let direccion = document.getElementById('direccion')
    let correo = document.getElementById('correo')
    let fecha_nacimiento = document.getElementById('fecha_nacimiento')
    let ciudad = document.getElementById('ciudad')
    let celular = document.getElementById('celular')
    let sexo = document.getElementById('sexo')

    let idpersona = document.getElementById('idpersona')
    let idusuario = document.getElementById('idusuario')
    let idTipoUsuario = document.getElementById('idTipoUsuario')

    let administrador = document.getElementById('administrador')
    let auxiliar = document.getElementById('auxiliar')

    request.onload = function() {

        let datos = request.response;
        idusuario.value = datos.id;

        usuario.value = datos.nombre_usuario;
        password.value = datos.password;

        if (datos.tipoUsuario.nombre == "Administrador") {
            document.getElementById("tipo_usuario").value = "administrador"

        } else {

            document.getElementById("tipo_usuario").value = "auxiliar"
        }





        nombre.value = datos.persona.nombre;
        apellido.value = datos.persona.apellido;
        direccion.value = datos.persona.direccion;
        correo.value = datos.persona.correo;
        fecha_nacimiento.value = datos.persona.fecha_nacimiento;
        ciudad.value = datos.persona.ciudad;
        celular.value = datos.persona.telefono;
        sexo.value = datos.persona.sexo;

        idTipoUsuario.value = datos.tipoUsuario.id
        idpersona.value = datos.persona.id;
    }
    request.onerror = function() {
        alert("Error al cargar el registro");
    }
}
//METODO PARA AGREGAR O ACTUALIZAR
function grabarUsuario() {
    let nombre_usuario = document.getElementById('usuario').value;
    let password = document.getElementById('password').value

    let tipo_usuario = document.getElementById('tipo_usuario').value

    let nombre = document.getElementById('nombre').value
    let apellido = document.getElementById('apellido').value
    let direccion = document.getElementById('direccion').value
    let correo = document.getElementById('correo').value
    let fecha_nacimiento = document.getElementById('fecha_nacimiento').value;
    let ciudad = document.getElementById('ciudad').value
    let celular = document.getElementById('celular').value
    let sexo = document.getElementById('sexo').value

    let idpersona = document.getElementById('idpersona').value;
    let idusuario = document.getElementById('idusuario').value;

    let idTipoUsuario;
    if (tipo_usuario == "Administrador" || tipo_usuario == "administrador") {
        idTipoUsuario = 1

    } else {
        idTipoUsuario = 2
    }



    var datos = {
        'id': idusuario,
        'nombre_usuario': nombre_usuario,
        'password': password,
        'persona': {

            'nombre': nombre,
            'apellido': apellido,
            'direccion': direccion,
            'correo': correo,
            'telefono': celular,
            "fecha_nacimiento": fecha_nacimiento,
            "ciudad": ciudad,
            "sexo": sexo
        },
        "tipoUsuario": {
            "id": idTipoUsuario,
            "nombre": tipo_usuario
        }

    }
    console.log(datos)
    let request = sendRequest('usuario/' + idusuario, idusuario ? 'PUT' : 'POST', datos)
    request.onload = function() {
        window.location = "usuarios.html";
    }
    request.onerror = function() {
        alert("Error al guardar el registro");
    }





}

// async function guardarUsuario() {

//     let direccion = document.getElementById('direccion').value
//     let nombre = document.getElementById('nombre').value
//     let celular = document.getElementById('celular').value
//     let correo = document.getElementById('correo').value
//     let password = document.getElementById('password').value
//     let idpersona = document.getElementById('idpersona').value;

//     var datos = {

//         'nombre_usuario': usuario,
//         'password': password,
//         'persona': {

//             'nombre': nombre,
//             'direccion': direccion,
//             'correo': correo,
//             'telefono': celular,
//         },
//         "tipoUsuario": {

//             "nombre": "Administrador"
//         }

//     }


//     let url = "http://localhost:8080/usuario/"
//     let response = await fetch(url, { method: "POST", body: datos, mode: "no-cors" })
//     console.log(response)
//     let data = await response.json()
//     console.log(data)

// }