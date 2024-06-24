package BackendC3.ClinicaOdontologica.dto.requestDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

@Value
public class InputPacienteDto implements Serializable, IDto {
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    String nombre;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    String apellido;

    @NotEmpty(message = "El DNI no puede estar vacío")
    @Size(min = 7, max = 12, message = "El DNI debe tener entre 7 y 12 caracteres")
    String cedula;

    @NotEmpty(message = "El email no puede estar vacío")
    @Size(min = 3, max = 50, message = "El email debe tener entre 3 y 50 caracteres")
    String email;

    String fechaIngreso;

    @NotEmpty(message = "La calle no puede estar vacía")
    String calle;

    @NotNull(message = "El número no puede estar vacío")
    Integer numero;

    @NotEmpty(message = "La localidad no puede estar vacía")
    String localidad;

    @NotEmpty(message = "La provincia no puede estar vacía")
    String provincia;
}
