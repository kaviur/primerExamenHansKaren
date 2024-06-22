package BackendC3.ClinicaOdontologica.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Value
@Data
public class DomicilioDto implements Serializable, IDto {
    Integer id;
    String calle;
    int numero;
    String localidad;
    String provincia;
}
