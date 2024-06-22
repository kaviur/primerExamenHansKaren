package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.dto.TurnoDto;
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
    public TurnoDto buscar(Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new TurnoNotFoundException("Turno no encontrado"));

        //return TurnoMapper.toDto(turno);
        return null;
    }

    @Override
    public TurnoDto guardar(TurnoDto turnoDto) {
        Paciente paciente = pacienteRepository.findById(turnoDto.getPaciente().getId())
                .orElseThrow(() -> new TurnoNotFoundException("Paciente no encontrado"));

        Odontologo odontologo = odontologoRepository.findById(turnoDto.getOdontologo().getId())
                .orElseThrow(() -> new TurnoNotFoundException("Odontólogo no encontrado"));

        Turno turno = new Turno();
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFecha(turnoDto.getFecha());

        //return TurnoMapper.toDto(turnoRepository.save(turno));
        return null;
    }

    @Override
    public TurnoDto actualizar(TurnoDto turnoDto, Long id) {
        Turno turno = turnoRepository.findById(id)
                .orElseThrow(() -> new TurnoNotFoundException("Turno no encontrado"));

        //verificar si el paciente es el mismo
        if(turnoDto.getPaciente().getId() != turno.getPaciente().getId()){
            Paciente paciente = pacienteRepository.findById(turnoDto.getPaciente().getId())
                    .orElseThrow(() -> new TurnoNotFoundException("Paciente no encontrado"));
            turno.setPaciente(paciente);
        }

        //verificar si el odontologo es el mismo
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
    public List<TurnoDto> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        //return TurnoMapper.toDtoList(turnos);
        return null;
    }
}
