package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputDomicilioDto;
import BackendC3.ClinicaOdontologica.entity.Domicilio;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.DomicilioNotFoundException;
import BackendC3.ClinicaOdontologica.mappers.DomicilioMapper;
import BackendC3.ClinicaOdontologica.repository.IDomicilioRepository;
import BackendC3.ClinicaOdontologica.service.IDomicilioService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Override
    public IDto buscar(Integer id) {
        Domicilio domicilio = domicilioRepository.findById(id)
                .orElseThrow(() -> new DomicilioNotFoundException("No se encontro el domicilio con id " + id));
        return DomicilioMapper.toDto(domicilio);
    }

    @Override
    public IDto guardar(IDto domicilio) {
        if(!(domicilio instanceof InputDomicilioDto)) {
            throw new ServiceException("Entrada de datos incorrecta");
        }
        Domicilio domicilioGuardado = domicilioRepository.save(DomicilioMapper.toEntity((InputDomicilioDto) domicilio));
        return DomicilioMapper.toDto(domicilioGuardado);
    }

    @Override
    public IDto actualizar(IDto domicilio, Integer id) {
        if(!(domicilio instanceof InputDomicilioDto domicilioDto)) {
            throw new IllegalArgumentException("Entrada de datos incorrecta");
        }
        Domicilio domicilioActual = domicilioRepository.findById(id)
                .orElseThrow(() -> new DomicilioNotFoundException("No se encontro el domicilio con id " + id));
        if (domicilioDto.getCalle() != null) {
            domicilioActual.setCalle(domicilioDto.getCalle());
        }
        if (domicilioDto.getNumero() != null) {
            domicilioActual.setNumero(domicilioDto.getNumero());
        }
        if (domicilioDto.getLocalidad() != null) {
            domicilioActual.setLocalidad(domicilioDto.getLocalidad());
        }
        if (domicilioDto.getProvincia() != null) {
            domicilioActual.setProvincia(domicilioDto.getProvincia());
        }
        return DomicilioMapper.toDto(domicilioRepository.save(domicilioActual));
    }

    @Override
    public void eliminar(Integer id) {
        Domicilio domicilio = domicilioRepository.findById(id)
                        .orElseThrow(() -> new DomicilioNotFoundException("No se encontro el domicilio con id " + id));
        domicilioRepository.delete(domicilio);
    }

    @Override
    public List<IDto> buscarTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        if (domicilios.isEmpty()) {
            throw new DomicilioNotFoundException("No se encontraron domicilios");
        }
        return DomicilioMapper.mapList(domicilios);
    }
}
