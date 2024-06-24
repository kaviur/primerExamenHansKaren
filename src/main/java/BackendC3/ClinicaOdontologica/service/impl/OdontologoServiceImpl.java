package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputOdontologoDto;
import BackendC3.ClinicaOdontologica.entity.Odontologo;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.OdontologoNotFoundException;
import BackendC3.ClinicaOdontologica.mappers.OdontologoMapper;
import BackendC3.ClinicaOdontologica.repository.IOdontologoRepository;
import BackendC3.ClinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public IDto buscar(Integer id) {
        Odontologo odontologo = odontologoRepository.findById(id)
                .orElseThrow(() -> new OdontologoNotFoundException("No se encontro el odontologo con id " + id));
        return OdontologoMapper.toDto(odontologo);
    }

    @Override
    public IDto guardar(IDto odontologo) {
        if (!(odontologo instanceof InputOdontologoDto odontolgoDto)) {
            throw new IllegalArgumentException("Entrada de datos incorrecta");
        }
        Odontologo odontologoGuardado = odontologoRepository.save(OdontologoMapper.toEntity((InputOdontologoDto) odontologo));
        return OdontologoMapper.toDto(odontologoGuardado);
    }

    @Override
    public IDto actualizar(IDto odontologo, Integer id) {
        if(!(odontologo instanceof InputOdontologoDto odontologoDto)) {
            throw new IllegalArgumentException("Entrada de datos incorrecta");
        }
        Odontologo odontologoActual = odontologoRepository.findById(id)
                .orElseThrow(() -> new OdontologoNotFoundException("No se encontro el odontologo con id " + id));
        if (odontologoDto.getNombre() != null) {
            odontologoActual.setNombre(odontologoDto.getNombre());
        }
        if (odontologoDto.getApellido() != null) {
            odontologoActual.setApellido(odontologoDto.getApellido());
        }
        if (odontologoDto.getNumeroMatricula() != null) {
            odontologoActual.setNumeroMatricula(odontologoDto.getNumeroMatricula());
        }
        odontologoRepository.save(odontologoActual);
        return OdontologoMapper.toDto(odontologoActual);
    }

    @Override
    public void eliminar(Integer id) {
        Odontologo odontologo = odontologoRepository.findById(id)
                        .orElseThrow(() -> new OdontologoNotFoundException("No se encontro el odontologo con id " + id));
        odontologoRepository.delete(odontologo);
    }

    @Override
    public List<IDto> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        if (odontologos.isEmpty()) {
            throw new OdontologoNotFoundException("No se encontraron odontologos");
        }
        return OdontologoMapper.mapList(odontologos);
    }
}
