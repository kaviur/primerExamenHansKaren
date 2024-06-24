window.addEventListener("load", function () {
    // Definir las funciones globalmente
    window.loadTurnosOdontologo = function (id) {
      const url = `api/turno/odontologo/${id}`;
      const settings = {
        method: "GET",
      };
  
      fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            console.log("siii")
            console.log(data)
          if (data.success && data.data && Array.isArray(data.data)) {
            const table = document.getElementById("turnosOdontologo");
            table.innerHTML = ""; // Limpiar la tabla antes de agregar las filas
  
            for (let turno of data.data) {
              const turnoRow = table.insertRow();
              let tr_id = turno.id;
              turnoRow.id = tr_id;
  
              turnoRow.innerHTML = `
                <td class="paciente">${turno.paciente.nombre} ${turno.paciente.apellido}</td>
                <td class="fecha">${turno.fecha}</td>
              `;
            }
          } else {
            console.error('Invalid data format or no data found');
          }
        })
        .catch((error) => console.error("Error al obtener los turnos del odontólogo:", error));
    };
  
    window.loadTurnosPaciente = function (id) {
      const url = `api/turno/paciente/${id}`;
      const settings = {
        method: "GET",
      };
  
      fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            console.log("siii")
            console.log(data)
          if (data.success && data.data && Array.isArray(data.data)) {
            const table = document.getElementById("citasPaciente");
            table.innerHTML = ""; // Limpiar la tabla antes de agregar las filas
  
            for (let turno of data.data) {
              const turnoRow = table.insertRow();
              let tr_id = turno.id;
              turnoRow.id = tr_id;
  
              turnoRow.innerHTML = `
                <td class="odontologo">${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                <td class="fecha">${turno.fecha}</td>
              `;
            }
          } else {
            console.error('Invalid data format or no data found');
          }
        })
        .catch((error) => console.error("Error al obtener los turnos del paciente:", error));
    };
  
    // Ejemplo de cómo llamar a las funciones al cargar la página con un ID específico
    document.addEventListener("DOMContentLoaded", function() {
      loadTurnosPaciente(1); // Reemplaza 2 con el ID del paciente necesario
    });
  });
  