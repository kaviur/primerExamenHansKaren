package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputPacienteDto;
import BackendC3.ClinicaOdontologica.entity.Paciente;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.PacienteNotFoundException;
import BackendC3.ClinicaOdontologica.mappers.PacienteMapper;
import BackendC3.ClinicaOdontologica.repository.IPacienteRepository;
import BackendC3.ClinicaOdontologica.service.IPacienteService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements IPacienteService {

    private final IPacienteRepository pacienteRepository;

    @Override
    public IDto buscar(Integer id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException("Paciente no encontrado"));

        return PacienteMapper.toDto(paciente);
    }

    @Override
    public IDto guardar(IDto dto) {
        if(!(dto instanceof InputPacienteDto)){
            throw new ServiceException("Entrada de datos incorrecta");
        }
        Paciente paciente = PacienteMapper.toEntity((InputPacienteDto) dto);
        return PacienteMapper.toDto(pacienteRepository.save(paciente));
    }

    @Override
    public IDto actualizar(IDto dto, Integer id) {
        if (!(dto instanceof InputPacienteDto pacienteDto)) {
            throw new IllegalArgumentException("Entrada de datos incorrecta");
        }

        Paciente paciente = pacienteRepository.findById(id)
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
    public List<IDto> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return PacienteMapper.toDtoList(pacientes);
    }
}
