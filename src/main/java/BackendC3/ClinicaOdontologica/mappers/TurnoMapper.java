package BackendC3.ClinicaOdontologica.mappers;

import BackendC3.ClinicaOdontologica.dto.TurnoDto;
import BackendC3.ClinicaOdontologica.entity.Turno;
import org.springframework.stereotype.Component;

@Component
public class TurnoMapper {

//    public static TurnoDto toDto(Turno turno){
//        return new TurnoDto(
//                OdontologoMapper.toDto(turno.getOdontologo()),
//                PacienteMapper.toDto(turno.getPaciente())
//        );
//    }

//    public static Turno toEntity(TurnoDto turnoDto){
//        return Turno.builder()
//                .odontologo(OdontologoMapper.toEntity(turnoDto.getOdontologo()))
//                .paciente(PacienteMapper.toEntity(turnoDto.getPaciente()))
//                .build();
//    }

}
