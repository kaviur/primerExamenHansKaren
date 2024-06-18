package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.entity.Domicilio;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.NotFoundException;
import BackendC3.ClinicaOdontologica.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService implements ICrudService<Domicilio, Integer> {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Override
    public Domicilio buscar(Integer id) {
        return domicilioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el domicilio con id " + id));
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        Domicilio domicilioActual = buscar(domicilio.getId());
        if (domicilio.getCalle() != null) {
            domicilioActual.setCalle(domicilio.getCalle());
        }
        if (domicilio.getNumero() != null) {
            domicilioActual.setNumero(domicilio.getNumero());
        }
        if (domicilio.getLocalidad() != null) {
            domicilioActual.setLocalidad(domicilio.getLocalidad());
        }
        if (domicilio.getProvincia() != null) {
            domicilioActual.setProvincia(domicilio.getProvincia());
        }
        return domicilioRepository.save(domicilioActual);
    }

    @Override
    public void eliminar(Integer id) {
        Domicilio domicilio = buscar(id);
        domicilioRepository.delete(domicilio);
    }

    @Override
    public List<Domicilio> buscarTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        if (domicilios.isEmpty()) {
            throw new NotFoundException("No se encontraron domicilios");
        }
        return domicilios;
    }
}
