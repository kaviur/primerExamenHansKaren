window.addEventListener("DOMContentLoaded", function () {
  // Agregar Odontólogo
  document
    .getElementById("addOdontologoForm")
    .addEventListener("submit", function (event) {
      event.preventDefault();
      const odontologo = {
        numeroMatricula: document.getElementById("odontologoMatricula").value,
        nombre: document.getElementById("odontologoNombre").value,
        apellido: document.getElementById("odontologoApellido").value,
      };

      fetch("api/odontologo", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(odontologo),
      })
        .then((response) => {
          if (!response.ok) {
            return response.json().then((data) => {
              if (data.errors && data.errors.length > 0) {
                const errorMessage = data.errors.join("<br>");
                showAlert(errorMessage, "error");
              } else {
                showAlert("Error al agregar el Paciente", "error");
              }
              throw new Error("Error al agregar el paciente");
            });
          }
          return response.json();
        })
        .then((data) => {
          console.log("Odontólogo agregado:", data);
          showAlert("Odontólogo agregado exitosamente");
          setTimeout(() => {
            window.location.href = "get_odontologos.html";
          }, 1000); 
        })
        .catch((error) => {
          console.error("Error:", error);
          showAlert("Error al agregar el odontólogo", "error");
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

    // Remover el alert después de 3 segundos
    setTimeout(() => {
      alertContainer.remove();
    }, 3000);
  }
});