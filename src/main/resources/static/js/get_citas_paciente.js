window.addEventListener("load", function () {
    function loadCitas(id) {
      const url = `api/turno/paciente/${id}`;
      const settings = {
        method: "GET",
      };
  
      fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
          const tableBody = document.getElementById("citasPaciente");
          const table = document.getElementById("turnoTable");
          const noCitasMsg = document.getElementById("no-citas");
  
          if (data.success && data.data && Array.isArray(data.data) && data.data.length > 0) {
            tableBody.innerHTML = ""; // Limpiar la tabla antes de agregar las filas
  
            for (let turno of data.data) {
              const turnoRow = tableBody.insertRow();
              let tr_id = turno.id;
              turnoRow.id = tr_id;

              // Extraer fecha y hora del formato ISO 8601
              const [date, time] = turno.fecha.split("T");
              const formattedTime = time.substring(0, 5); 
  
              turnoRow.innerHTML = `
                <td class="odontologo">Dr ${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                <td class="fecha">${date}</td>
                <td class="hora">${formattedTime}</td>
              `;
            }
  
            // Mostrar la tabla y ocultar el mensaje
            table.classList.remove("hidden");
            noCitasMsg.classList.add("hidden");
          } else {
            // Ocultar la tabla y mostrar el mensaje
            table.classList.add("hidden");
            noCitasMsg.classList.remove("hidden");
          }
        })
        .catch((error) => {
          console.error("Error al obtener los turnos del paciente:", error);
  
          // Ocultar la tabla y mostrar el mensaje en caso de error
          document.getElementById("citasPaciente").classList.add("hidden");
          document.getElementById("no-citas").classList.remove("hidden");
        });
    }
  
    // Llamar a la función al cargar la página con un ID específico
    loadCitas(2); // Reemplaza 2 con el ID del paciente necesario
  });
  