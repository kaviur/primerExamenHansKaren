package BackendC3.ClinicaOdontologica.dto.responseDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link BackendC3.ClinicaOdontologica.entity.Odontologo}
 */
@Value
public class OdontologoDto implements Serializable, IDto {
    Integer id;
    String numeroMatricula;
    String nombre;
    String apellido;
}