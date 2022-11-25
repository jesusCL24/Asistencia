// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
  actualizarNombreUsuario();
});

function actualizarNombreUsuario(){
  document.getElementById('txt-Nombre').outerHTML=localStorage.nombre;
}


async function cargarUsuarios() {

  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();
  let botonEditar='<a href="#" className="btn btn-info btn-circle btn-lg"><i className="fas fa-info-circle"></i></a>';

  let listadoHtml='';

  for(let usuario of usuarios){
      let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm" ><i class="fas fa-trash"></i></a>';

      let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.nombre + '</td> <td>' + usuario.appaterno + '</td><td>'
          + usuario.appaterno+'</td><td>'+usuario.CI+'</td><td>'+usuario.contrasena+'</td><td>' + botonEliminar + '</td></tr>';

    listadoHtml+=usuarioHtml;
  }
  document.querySelector('#usuarios tbody') .outerHTML=listadoHtml;
}

async function eliminarUsuario(id) {

  if (!confirm("¿Desea eliminar este elemento?")){
    return;
  }

  const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  location.reload();
}