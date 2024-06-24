window.addEventListener("load", function () {
    window.loadTurnos = function (id) {
      const url = `api/turno/odontologo/${id}`;
      const settings = {
        method: "GET",
      };
  
      fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
            console.log("turnos")
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
        .catch((error) => console.error("Error al obtener los turnos:", error));
    };
  });
  