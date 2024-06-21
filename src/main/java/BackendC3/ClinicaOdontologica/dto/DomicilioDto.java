package BackendC3.ClinicaOdontologica.dto;

import lombok.Data;
import lombok.Value;

@Value
@Data
public class DomicilioDto {
    Integer id;
    String calle;
    int numero;
    String localidad;
    String provincia;
}
