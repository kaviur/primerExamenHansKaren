window.addEventListener("load", function () {
    document.getElementById("emailForm").addEventListener("submit", function (event) {
      event.preventDefault(); // Prevenir el envío del formulario
  
      const email = document.getElementById("email").value;
  
      switch (email) {
        case "admin@gmail.com":
        case "user@gmail.com":
          window.location.href = "get_turnos.html";
          break;
        case "odontologo@gmail.com":
          window.location.href = "get_turnos_odontologo.html";
          break;
        case "paciente@gmail.com":
          window.location.href = "get_citas_paciente.html";
          break;
        default:
          alert("Correo no reconocido");
          break;
      }
    });
  });
  