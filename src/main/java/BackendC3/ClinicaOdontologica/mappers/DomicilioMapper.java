package BackendC3.ClinicaOdontologica.mappers;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputDomicilioDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.DomicilioDto;
import BackendC3.ClinicaOdontologica.entity.Domicilio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomicilioMapper {
    public static IDto toDto(Domicilio domicilio){
        return new DomicilioDto(
                domicilio.getId(),
                domicilio.getCalle(),
                domicilio.getNumero(),
                domicilio.getLocalidad(),
                domicilio.getProvincia()
        );
    }

    public static Domicilio toEntity(InputDomicilioDto domicilioDto){
        return Domicilio.builder()
                .calle(domicilioDto.getCalle())
                .numero(domicilioDto.getNumero())
                .localidad(domicilioDto.getLocalidad())
                .provincia(domicilioDto.getProvincia())
                .build();
    }

    public static List<IDto> mapList(List<Domicilio> domicilios) {
        return domicilios.stream().map(DomicilioMapper::toDto).toList();
    }

}
