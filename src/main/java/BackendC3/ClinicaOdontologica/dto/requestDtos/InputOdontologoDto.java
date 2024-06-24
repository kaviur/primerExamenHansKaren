package BackendC3.ClinicaOdontologica.dto.requestDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class InputOdontologoDto implements Serializable, IDto {

    String numeroMatricula;
    String nombre;
    String apellido;

}
