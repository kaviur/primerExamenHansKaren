window.addEventListener("load", function () {
  function loadTurnos () {
    const url = "api/turno";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        if (data.success && data.data && Array.isArray(data.data)) {
          for (let turno of data.data) {
            console.log(turno)

            const table = document.getElementById("turnosTableBody");
            const turnoRow = table.insertRow();
            let tr_id = turno.id;
            turnoRow.id = tr_id;

            const deleteButton = createButton(
              `btn_delete_${turno.id}`,
              "btn btn-circle btn-error",
              `deleteBy(${turno.id})`,
              `<svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="4" d="M6 18L18 6M6 6l12 12"/>
              </svg>`
            );

            const updateButton = createButton(
              `btn_id_${turno.id}`,
              "btn btn-circle btn-success mr-4",
              `findBy(${turno.id})`,
              `<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                <path d="M20.71,7.04C21.1,6.65 21.1,6 20.71,5.63L18.37,3.29C18,2.9 17.35,2.9 16.96,3.29L15.12,5.12L18.87,8.87M3,17.25V21H6.75L17.81,9.93L14.06,6.18L3,17.25Z" />
              </svg>`
            );

            turnoRow.innerHTML = `
              <td> ${turno.id} </td> 
              <td class="paciente"> ${turno.paciente.nombre} ${ turno.paciente.apellido} </td> 
              <td class="odontologo"> ${turno.odontologo.nombre} ${turno.odontologo.apellido} </td> 
              <td class"fecha"> ${turno.fecha} </td> 
              <td> ${updateButton + deleteButton} </td> 
              `;
          }
        } else {
          console.error('Invalid data format or no data found');
        }        
      })
      .catch((error) =>
        console.error("Error al obtener los pacientes:", error)
      );
  }

  function createButton(id, className, onClick, innerHTML) {
    return `<button id="${id}" type="button" onclick="${onClick}" class="${className}">${innerHTML}</button>`;
  }

  const confirmDeleteModal = document.getElementById("confirmDeleteModal");
  const confirmDeleteButton = document.getElementById("confirmDeleteButton");
  const cancelDeleteButton = document.getElementById("cancelDeleteButton");
  let turnoIdToDelete = null;

  cancelDeleteButton.addEventListener("click", () => {
    confirmDeleteModal.close();
  });

  confirmDeleteButton.addEventListener("click", () => {
    if (turnoIdToDelete !== null) {
      deleteTurno(turnoIdToDelete);
      confirmDeleteModal.close();
    }
  });

  function showDeleteModal(id) {
    turnoIdToDelete = id;
    confirmDeleteModal.showModal();
  }

  function deleteTurno(id) {
    const url = `api/turno/${id}`;
    const settings = {
      method: "DELETE",
    };

    fetch(url, settings).then((response) => {
      if (response.ok) {
        console.log(`Turno con ID ${id} eliminado.`);
        document.getElementById(id).remove();
        showAlert("Turno eliminado exitosamente");
      } else {
        console.error(`Error al eliminar el Turno con ID ${id}.`);
        showAlert("Error al eliminar el el Turno", "error");
      }
    });
  }

  window.deleteBy = function (id) {
    showDeleteModal(id);
  };

  const updateModal = document.getElementById("updateModal");
  const updateCancelButton = document.getElementById("updateCancelButton");

  function showUpdateModal() {
    updateModal.showModal();
  }

  function closeUpdateModal() {
    updateModal.close();
  }

  //updateCancelButton.addEventListener("click", closeUpdateModal);

  const pacienteSelect = document.getElementById('paciente');
  const odontologoSelect = document.getElementById('odontologo');

  // Function to populate select options
  const populateSelect = async (selectElement, url, defaultText) => {
    try {
      const response = await fetch(url);
      if (!response.ok) throw new Error('Network response was not ok');
      const data = await response.json();

      // Check if data has 'data' property and it's an array
      if (data && Array.isArray(data.data)) {
        selectElement.innerHTML = `<option value="">${defaultText}</option>`;
        data.data.forEach(item => {
          const option = document.createElement('option');
          option.value = item.id;
          option.textContent = `${item.nombre} ${item.apellido}`;
          selectElement.appendChild(option);
        });
      } else {
        throw new Error('Invalid data format from API');
      }
    } catch (error) {
      selectElement.innerHTML = `<option value="">Error loading data</option>`;
      console.error('Error fetching data:', error);
    }
  };

  // Function to find and populate the form
  window.findBy = async function (id) {
    const url = `api/turno/${id}`;
    const settings = {
      method: "GET",
    };

    try {
      const response = await fetch(url, settings);
      const data = await response.json();

      // Wait for selects to be populated before setting values
      await Promise.all([
        populateSelect(pacienteSelect, '/api/paciente', 'Selecciona un Paciente'),
        populateSelect(odontologoSelect, '/api/odontologo', 'Selecciona un Odontólogo')
      ]);

      document.getElementById("turnoId").value = data.data.id;
      pacienteSelect.value = data.data.paciente.id;
      odontologoSelect.value = data.data.odontologo.id;
      document.getElementById("fecha").value = data.data.fecha;
      showUpdateModal();
    } catch (error) {
      console.error(`Error al obtener turno con ID ${id}:`, error);
    }
  };

  // Populate select elements initially
  populateSelect(pacienteSelect, '/api/paciente', 'Selecciona un Paciente');
  populateSelect(odontologoSelect, '/api/odontologo', 'Selecciona un Odontólogo');

  //update turno
  window.updateTurno = function () {
    const id = document.getElementById("turnoId").value;
    const url = `api/turno/${id}`;
    const settings = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        id: id,
        idPaciente: document.getElementById("paciente").value,
        idOdontologo: document.getElementById("odontologo").value,
        fecha: document.getElementById("fecha").value,
      }),
    };

    console.log("settings-----")
    console.log(settings);
    console.log(JSON.stringify(settings))


    fetch(url, settings)
      .then((response) => {
        if (response.ok) {
          console.log(`Turno con ID ${id} actualizado.`);
          showAlert("Turno Actualizado exitosamente");

          loadTurnos()

          closeUpdateModal();
        } else {
          console.error(`Error al actualizar turno con ID ${id}.`);
          showAlert("Error al actualizar el turno", "error");
        }
      })
      .catch((error) => {
        console.error(`Error al actualizar turno con ID ${id}:`, error);
        showAlert("Error al actualizar el turno", "error");
      });
  };

  // Añadir evento de submit al formulario para actualizar el turno
  document
    .getElementById("updateTurnoForm")
    .addEventListener("submit", function (event) {
      event.preventDefault();
      updateTurno();
    });

  // Función para mostrar el alert
  function showAlert(message, type = "success") {
    const alertContainer = document.createElement("div");
    alertContainer.className = `toast toast-top toast-end`;
    alertContainer.innerHTML = `
    <div class="alert alert-${type}">
        <svg xmlns="http://www.w3.org/2000/svg" class="stroke-current shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
        </svg>
        <span>${message}</span>
    <div/>`;

    document.body.appendChild(alertContainer);

    // Remover el alert después de 3 segundos
    setTimeout(() => {
      alertContainer.remove();
    }, 3000);
  }
  loadTurnos()
});