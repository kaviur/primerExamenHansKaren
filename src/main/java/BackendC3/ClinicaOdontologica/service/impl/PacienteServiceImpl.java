package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.dto.PacienteDto;
import BackendC3.ClinicaOdontologica.entity.Paciente;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.PacienteNotFoundException;
import BackendC3.ClinicaOdontologica.mappers.PacienteMapper;
import BackendC3.ClinicaOdontologica.repository.IPacienteRepository;
import BackendC3.ClinicaOdontologica.service.IPacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements IPacienteService {

    private final IPacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    @Override
    public PacienteDto buscar(Integer id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente no encontrado"));

        return PacienteMapper.toDto(paciente);
    }

    @Override
    public PacienteDto guardar(PacienteDto pacienteDto) {
        Paciente paciente = pacienteMapper.toEntity(pacienteDto);
        return PacienteMapper.toDto(pacienteRepository.save(paciente));
    }

    @Override
    public PacienteDto actualizar(PacienteDto pacienteDto) {
        Paciente paciente = pacienteRepository.findById(pacienteDto.getId())
                .orElseThrow(() -> new PacienteNotFoundException("Paciente no encontrado"));

        paciente.setNombre(pacienteDto.getNombre());
        paciente.setApellido(pacienteDto.getApellido());
        paciente.setDni(pacienteDto.getDni());

        return PacienteMapper.toDto(pacienteRepository.save(paciente));
    }

    @Override
    public void eliminar(Integer id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente no encontrado"));

        pacienteRepository.delete(paciente);
    }

    @Override
    public List<PacienteDto> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return PacienteMapper.toDtoList(pacientes);
    }
}
