package BackendC3.ClinicaOdontologica.dto.requestDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class InputDomicilioDto implements Serializable, IDto {

    String calle;
    Integer numero;
    String localidad;
    String provincia;

}
