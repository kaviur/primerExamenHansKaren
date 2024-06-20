package BackendC3.ClinicaOdontologica.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link BackendC3.ClinicaOdontologica.entity.Odontologo}
 */
@Value
public class OdontologoDto implements Serializable {
    Integer id;
    String numeroMatricula;
    String nombre;
    String apellido;
}