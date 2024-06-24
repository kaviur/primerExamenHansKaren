package BackendC3.ClinicaOdontologica.mappers;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputTurnoDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.OdontologoDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.PacienteDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.TurnoDto;
import BackendC3.ClinicaOdontologica.entity.Turno;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurnoMapper {

    public static IDto toDto(Turno turno){
        return new TurnoDto(
                turno.getId().intValue(),
                (OdontologoDto) OdontologoMapper.toDto(turno.getOdontologo()),
                (PacienteDto) PacienteMapper.toDto(turno.getPaciente()),
                turno.getFecha().toString()
        );
    }

//    public static Turno toEntity(TurnoDto turnoDto){
//        return Turno.builder()
//                .odontologo(OdontologoMapper.toEntity(turnoDto.getOdontologo()))
//                .paciente(PacienteMapper.toEntity(turnoDto.getPaciente()))
//                .build();
//    }

    public static List<IDto> toDtoList(List<Turno> turnos) {
        return turnos.stream().map(TurnoMapper::toDto).toList();
    }

}
