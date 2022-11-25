// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function iniciarSesion() {

    let datos={};
    datos.nombre= document.getElementById('txtSombre').value;
    datos.contrasena= document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)     //llama a la funcion json.stringify convierte cualquier objeto de js a json
    });
    const res = await request.text();
    if (res != 'OK'){
        window.location.href='usuarios.html'
    }else{
        alert("Las credenciales son incorrectas");
    }
}
