package BackendC3.ClinicaOdontologica.entity;

import BackendC3.ClinicaOdontologica.dto.OdontologoDto;
import BackendC3.ClinicaOdontologica.dto.PacienteDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Turno}
 */
@Value
public class TurnoDto implements Serializable {
    OdontologoDto odontologo;
    PacienteDto paciente;
}