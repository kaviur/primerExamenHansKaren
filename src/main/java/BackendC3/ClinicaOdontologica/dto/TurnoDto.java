package BackendC3.ClinicaOdontologica.dto;

import BackendC3.ClinicaOdontologica.dto.OdontologoDto;
import BackendC3.ClinicaOdontologica.dto.PacienteDto;
import BackendC3.ClinicaOdontologica.entity.Turno;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Turno}
 */
@Value
public class TurnoDto implements Serializable {
    OdontologoDto odontologo;
    PacienteDto paciente;
    LocalDateTime fecha;
}