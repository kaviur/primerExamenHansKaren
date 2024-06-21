package BackendC3.ClinicaOdontologica.mappers;

import BackendC3.ClinicaOdontologica.dto.DomicilioDto;
import BackendC3.ClinicaOdontologica.entity.Domicilio;
import org.springframework.stereotype.Controller;

@Controller
public class DomicilioMapper {
    public static DomicilioDto toDto(Domicilio domicilio){
        return new DomicilioDto(
                domicilio.getId(),
                domicilio.getCalle(),
                domicilio.getNumero(),
                domicilio.getLocalidad(),
                domicilio.getProvincia()
        );
    }

    public static Domicilio toEntity(DomicilioDto domicilioDto){
        return Domicilio.builder()
                .calle(domicilioDto.getCalle())
                .numero(domicilioDto.getNumero())
                .localidad(domicilioDto.getLocalidad())
                .provincia(domicilioDto.getProvincia())
                .build();
    }
}
