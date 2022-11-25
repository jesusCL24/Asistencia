$(document).ready(function() {

});

async function registrarUsuario() {

    let datos= {};
    datos.nombre= document.getElementById('txtNombre').value;
    datos.appaterno= document.getElementById('txtPaterno').value;
    datos.apmaterno= document.getElementById('txtMaterno').value;
    datos.CI= document.getElementById('txtCI').value;
    datos.contrasena= document.getElementById('txtPassword').value;

    let repetirPassword= document.getElementById('txtRepeatPassword').value;

    if (repetirPassword != datos.contrasena) {
        alert('La contraseña que escribiste es diferente.');
        return;

        }
    const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)     //llama a la funcion json.stringify convierte cualquier objeto de js a json
    });
    alert("La cuenta fue creada con existo..!!!");
    window.location.href='login.html';
}

