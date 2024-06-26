package BackendC3.ClinicaOdontologica.dto.responseDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.entity.Domicilio;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link BackendC3.ClinicaOdontologica.entity.Paciente}
 */
@Value
@Data
public class PacienteDto implements Serializable, IDto {
    Integer id;
    String nombre;
    String apellido;
    String cedula;
    String email;
    String fechaIngreso;
    Domicilio domicilio;
}