package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputTurnoDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.TurnoDto;
import BackendC3.ClinicaOdontologica.entity.Odontologo;
import BackendC3.ClinicaOdontologica.entity.Paciente;
import BackendC3.ClinicaOdontologica.entity.Turno;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.TurnoNotFoundException;
import BackendC3.ClinicaOdontologica.repository.IOdontologoRepository;
import BackendC3.ClinicaOdontologica.repository.IPacienteRepository;
import BackendC3.ClinicaOdontologica.repository.ITurnoRepository;
import BackendC3.ClinicaOdontologica.service.ITurnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnoServiceImpl implements ITurnoService {

    private final ITurnoRepository turnoRepository;
    private final IPacienteRepository pacienteRepository;
    private final IOdontologoRepository odontologoRepository;

    @Override
    public IDto buscar(Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new TurnoNotFoundException("Turno no encontrado"));

        //return TurnoMapper.toDto(turno);
        return null;
    }

    @Override
    public IDto guardar(IDto dto) {
        if(!(dto instanceof InputTurnoDto turnoDto)){
            throw new IllegalArgumentException("Entrada de datos incorrecta");
        }

        Paciente paciente = pacienteRepository.findById(turnoDto.getIdPaciente())
                .orElseThrow(() -> new TurnoNotFoundException("Paciente no encontrado"));

        Odontologo odontologo = odontologoRepository.findById(turnoDto.getIdOdontologo())
                .orElseThrow(() -> new TurnoNotFoundException("Odontólogo no encontrado"));

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFecha(turnoDto.getFecha());

        //return TurnoMapper.toDto(turnoRepository.save(turno));
        return null;
    }

    @Override
    public IDto actualizar(IDto dto, Long id) {
        if(!(dto instanceof TurnoDto turnoDto)){
            throw new IllegalArgumentException("Entrada de datos incorrecta");
        }

        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new TurnoNotFoundException("Turno no encontrado"));

        if(turnoDto.getPaciente().getId() != turno.getPaciente().getId()){
            Paciente paciente = pacienteRepository.findById(turnoDto.getPaciente().getId())
                    .orElseThrow(() -> new TurnoNotFoundException("Paciente no encontrado"));
            turno.setPaciente(paciente);
        }

        if(turnoDto.getOdontologo().getId() != turno.getOdontologo().getId()){
            Odontologo odontologo = odontologoRepository.findById(turnoDto.getOdontologo().getId())
                    .orElseThrow(() -> new TurnoNotFoundException("Odontólogo no encontrado"));
            turno.setOdontologo(odontologo);
        }

        turno.setFecha(turnoDto.getFecha());

        //return TurnoMapper.toDto(turnoRepository.save(turno));
        return null;
    }

    @Override
    public void eliminar(Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new TurnoNotFoundException("Turno no encontrado"));

        turnoRepository.delete(turno);
    }

    @Override
    public List<IDto> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        //return TurnoMapper.toDtoList(turnos);
        return null;
    }
}
