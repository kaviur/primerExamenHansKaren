package BackendC3.ClinicaOdontologica.dto.responseDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.entity.Turno;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Turno}
 */
@Value
public class TurnoDto implements Serializable, IDto {
    Integer id;
    OdontologoDto odontologo;
    PacienteDto paciente;
    LocalDateTime fecha;
}