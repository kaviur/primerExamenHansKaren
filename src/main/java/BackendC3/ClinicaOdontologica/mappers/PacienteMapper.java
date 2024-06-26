package BackendC3.ClinicaOdontologica.mappers;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.PacienteDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputPacienteDto;
import BackendC3.ClinicaOdontologica.entity.Domicilio;
import BackendC3.ClinicaOdontologica.entity.Paciente;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PacienteMapper {

    public static IDto toDto(Paciente paciente){
        return new PacienteDto(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getCedula(),
                paciente.getEmail(),
                paciente.getFechaIngreso().toString(),
                paciente.getDomicilio()
        );
    }

    public static Paciente toEntity(InputPacienteDto inputPacienteDto) {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(inputPacienteDto.getCalle());
        domicilio.setNumero(inputPacienteDto.getNumero());
        domicilio.setLocalidad(inputPacienteDto.getLocalidad());
        domicilio.setProvincia(inputPacienteDto.getProvincia());

        return Paciente.builder()
                .nombre(inputPacienteDto.getNombre())
                .apellido(inputPacienteDto.getApellido())
                .cedula(inputPacienteDto.getCedula())
                .email(inputPacienteDto.getEmail())
                .fechaIngreso(LocalDate.parse(inputPacienteDto.getFechaIngreso()))
                .domicilio(domicilio)
                .build();
    }

    public static List<IDto> toDtoList(List<Paciente> pacientes) {
        return pacientes.stream().map(PacienteMapper::toDto).toList();
    }
}
