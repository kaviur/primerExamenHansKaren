package BackendC3.ClinicaOdontologica.dto.requestDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
public class InputTurnoDto implements Serializable, IDto {
    @NotEmpty(message = "El id del paciente no puede estar vacío")
    Integer idPaciente;

    @NotEmpty(message = "El id del odontólogo no puede estar vacío")
    Integer idOdontologo;

    @NotEmpty(message = "La fecha no puede estar vacía")
    LocalDateTime fecha;
}
