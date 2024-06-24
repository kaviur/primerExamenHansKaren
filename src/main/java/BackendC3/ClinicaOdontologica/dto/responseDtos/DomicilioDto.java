package BackendC3.ClinicaOdontologica.dto.responseDtos;

import BackendC3.ClinicaOdontologica.dto.IDto;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Value
@Data
public class DomicilioDto implements Serializable, IDto {
    Integer id;
    String calle;
    Integer numero;
    String localidad;
    String provincia;
}
