document.getElementById("formularioEspacios").addEventListener("submit", async (event) => {
    event.preventDefault();

    const espacio = {
        nombre:document.getElementById("nombre").value,
        tipo:document.getElementById("tipo").value,
        capacidad:document.getElementById("capacidad").value,
        disponibilidad:document.getElementById("disponibilidad").value
    }

    const response = await fetch('http://localhost:8080/api/espacios/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(espacio)
    });

    if (response.ok) {
        alert('Espacio guardado con exito');
        document.getElementById("formularioEspacios").reset();
    } else {
        alert('Error al guardar el espacio');
    }
});

document.getElementById("buscarEspacio").addEventListener("click", async () => {
    const nombre = document.getElementById("buscarNombre").value;

    const response= await fetch(`http://localhost:8080/api/espacios/${nombre}`);

    if (response.ok) {
        const espacio = await response.json();

        const resultadoDiv = document.getElementById('resultado');
        resultadoDiv.innerHTML = `
          <div class="card mt-3 mb-3">
            <div class="card-body" data-id="${espacio.nombre}" id="card">
              <h5 class="card-title">${espacio.nombre}</h5>
              <p><strong>Tipo:</strong> ${espacio.tipo}</p>
              <p><strong>Capacidad Maxima:</strong> ${espacio.capacidad}</p>
              <p><strong>Disponibilidad:</strong> ${espacio.disponibilidad}</p>
              <a href="#Titulo"><button type="button" class="btn btn-secondary" onclick='editarEspacio(${JSON.stringify(espacio)})'>Editar Espacio</button></a>
              <button type="button" class="btn btn-danger" onclick='eliminarEspacio(${cliente.nombre})'>Eliminar</button>
            </div>
          </div>`;
    } else {
        document.getElementById("resultado").innerHTML = '<p class="text-danger">Espacio no encontrado</p>'
    }
});

async function eliminarEspacio(nombre){
    if (confirm('Esta seguro de eliminar el espacio?')) {
        const response = await fetch(`http://localhost:8080/api/espacios/${nombre}`, {
            method: 'DELETE',
        });

        if (response.ok) {
            alert('Espacio eliminado con exito');
            document.getElementById('resultado').innerHTML='';
        } else {
            alert('Error al eliminar el espacio');
        }
    }
}

function editarEspacio(espacio) {
    document.getElementById("nombre").value = espacio.nombre;
    document.getElementById("tipo").value = espacio.tipo;
    document.getElementById("capacidad").value = espacio.capacidad;
    document.getElementById("disponibilidad").value = espacio.disponibilidad;

    document.getElementById('guardarCambios').onclick = async () => {
        const espacioActualizado = {
            nombre: document.getElementById('nombre').value,
            tipo: document.getElementById('tipo').value,
            capacidad: document.getElementById('capacidad').value,
            disponibilidad: document.getElementById('disponibilidad').value
        };

        const response = await fetch(`http://localhost:8080/api/espacios/${espacio.nombre}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(espacioActualizado),
        });

        if (response.ok) {
            alert('Espacio actualizado con éxito');
            document.getElementById('formularioEspacios').reset();
            document.getElementById('resultado').innerHTML = '';
        } else {
            alert('Error al actualizar el espacio');
        }
    };
}