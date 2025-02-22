document.getElementById("formularioReservas").addEventListener("submit", async (event) => {
    event.preventDefault();

    const reserva = {
        id: document.getElementById('id').value,
        estado: document.getElementById("estado").value,
        cliente: document.getElementById("Cliente").value,
        espacio: document.getElementById("espacio").value,
        fechaYHora: document.getElementById("Fechayhora").value
    };

    const response = await fetch('http://localhost:8081/api/reservas/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reserva)
    });

    if (response.ok) {
        alert('Reserva guardada con éxito');
        document.getElementById("formularioReservas").reset();
    } else {
        alert('Error al guardar la reserva');
    }
});

document.getElementById("buscarEspacio").addEventListener("click", async () => {
    const id = document.getElementById("buscarId").value;

    const response = await fetch(`http://localhost:8081/api/reservas/${id}`);

    if (response.ok) {
        const reserva = await response.json();
        
        document.getElementById('resultado').innerHTML = `
          <div class="card mt-3 mb-3">
            <div class="card-body" data-id="${reserva.id}" id="card">
              <h5 class="card-title">Reserva ID: ${reserva.id}</h5>
              <p><strong>Estado:</strong> ${reserva.estado}</p>
              <p><strong>Cliente:</strong> ${reserva.cliente}</p>
              <p><strong>Espacio:</strong> ${reserva.espacio}</p>
              <p><strong>Fecha y Hora:</strong> ${reserva.fechaYHora}</p>
              <a href="#Titulo"><button type="button" class="btn btn-secondary" onclick='editarReserva(${JSON.stringify(reserva)})'>Editar Reserva</button></a>
              <button type="button" class="btn btn-danger" onclick='eliminarReserva(${reserva.id})'>Eliminar</button>
            </div>
          </div>`;
    } else {
        document.getElementById("resultado").innerHTML = '<p class="text-danger">Reserva no encontrada</p>';
    }
});

async function eliminarReserva(id) {
    if (confirm('¿Está seguro de eliminar la reserva?')) {
        const response = await fetch(`http://localhost:8081/api/reservas/${id}`, {
            method: 'DELETE',
        });

        if (response.ok) {
            alert('Reserva eliminada con éxito');
            document.getElementById('resultado').innerHTML = '';
        } else {
            alert('Error al eliminar la reserva');
        }
    }
}

function editarReserva(reserva) {
    document.getElementById("estado").value = reserva.estado;
    document.getElementById("Cliente").value = reserva.cliente;
    document.getElementById("espacio").value = reserva.espacio;
    document.getElementById("Fechayhora").value = reserva.fechaYHora;

    document.getElementById('guardarCambios').onclick = async () => {
        const reservaActualizada = {
            id: reserva.id,
            estado: document.getElementById("estado").value,
            cliente: document.getElementById("Cliente").value,
            espacio: document.getElementById("espacio").value,
            fechaYHora: document.getElementById("Fechayhora").value
        };

        const response = await fetch(`http://localhost:8081/api/reservas/${reserva.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservaActualizada)
        });

        if (response.ok) {
            alert('Reserva actualizada con éxito');
            document.getElementById("formularioReservas").reset();
            document.getElementById("resultado").innerHTML = '';
        } else {
            alert('Error al actualizar la reserva');
        }
    };
}
