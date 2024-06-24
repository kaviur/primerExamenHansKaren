document.addEventListener("DOMContentLoaded", function () {
  // Agregar Turno
  document
    .getElementById("turno-form")
    .addEventListener("submit", function (event) {
      event.preventDefault();
      const turno = {
        idPaciente: document.getElementById("paciente").value,
        idOdontologo: document.getElementById("odontologo").value,
        fecha: document.getElementById("fecha").value // "2024-06-23T15:30"
      };

      fetch("api/turno", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(turno),
      })
      .then((response) => {
        if (!response.ok) {
          return response.json().then((data) => {
            if (data.errors && data.errors.length > 0) {
              const errorMessage = data.errors.join("<br>");
              showAlert(errorMessage, "error");
            } else {
              showAlert("Error al agregar el turno", "error");
            }
            throw new Error("Error al agregar el turno");
          });
        }
        return response.json();
      })
      .then((data) => {
        console.log("Turno agregado:", data);
        showAlert("Turno agregado exitosamente");

        setTimeout(() => {
          window.location.href = "get_turnos.html";
        }, 1000); 
      })
      .catch((error) => {
        console.error("Error:", error);
        showAlert("Error al agregar el turno", "error");
      });
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

    setTimeout(() => {
      alertContainer.remove();
    }, 3000);
  }
});