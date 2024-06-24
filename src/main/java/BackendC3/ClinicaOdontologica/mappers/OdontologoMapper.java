package BackendC3.ClinicaOdontologica.mappers;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputOdontologoDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.OdontologoDto;
import BackendC3.ClinicaOdontologica.entity.Odontologo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OdontologoMapper {

    public static IDto toDto(Odontologo odontologo) {
        return new OdontologoDto(
                odontologo.getId(),
                odontologo.getNumeroMatricula(),
                odontologo.getNombre(),
                odontologo.getApellido()
        );
    }

    public static Odontologo toEntity(InputOdontologoDto odontologoDto) {
        return Odontologo.builder()
                .numeroMatricula(odontologoDto.getNumeroMatricula())
                .nombre(odontologoDto.getNombre())
                .apellido(odontologoDto.getApellido())
                .build();
    }

    public static List<IDto> mapList(List<Odontologo> odontologos) {
        return odontologos.stream().map(OdontologoMapper::toDto).toList();
    }
}
