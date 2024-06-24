package BackendC3.ClinicaOdontologica.dto.requestDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
@Data
public class InputTurnoDto implements Serializable, IDto {
    @NotNull(message = "El id del paciente no puede estar vacío")
    Integer idPaciente;

    @NotNull(message = "El id del odontólogo no puede estar vacío")
    Integer idOdontologo;

    @NotEmpty(message = "La fecha no puede estar vacía")
    String fecha;
}
