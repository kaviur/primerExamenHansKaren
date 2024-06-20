package BackendC3.ClinicaOdontologica.mappers;

import BackendC3.ClinicaOdontologica.dto.PacienteDto;
import BackendC3.ClinicaOdontologica.entity.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public static PacienteDto toDto(Paciente paciente){
        return new PacienteDto(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getCedula(),
                paciente.getDomicilio(),
                paciente.getEmail()
        );
    }

    public static Paciente toEntity(PacienteDto pacienteDto){
        return Paciente.builder()
                .nombre(pacienteDto.getNombre())
                .apellido((pacienteDto.getApellido()))
                .cedula(pacienteDto.getCedula())
                .email(pacienteDto.getEmail())
                .build();
    }
}
