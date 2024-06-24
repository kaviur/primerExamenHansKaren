package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.dto.IDto;

import java.util.List;

public interface ITurnoService extends ICrudService<IDto, Long>{

    List<IDto> buscarTurnosPorPaciente(Long idPaciente);
    List<IDto> buscarTurnosPorOdontologo(Long idOdontologo);
}
