package BackendC3.ClinicaOdontologica.dto;

import BackendC3.ClinicaOdontologica.entity.Domicilio;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link BackendC3.ClinicaOdontologica.entity.Paciente}
 */
@Value
public class PacienteDto implements Serializable {
    Integer id;
    String nombre;
    String apellido;
    String cedula;
    Domicilio domicilio;
    String email;
}