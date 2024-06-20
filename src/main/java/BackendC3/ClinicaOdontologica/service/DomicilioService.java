package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.entity.Domicilio;
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
                .orElseThrow(() -> new RuntimeException("No se encontro el domicilio"));
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        domicilioRepository.findById(domicilio.getId())
                .orElseThrow(() -> new RuntimeException("No se encontro el domicilio"));
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminar(Integer id) {
        Domicilio domicilio = buscar(id);
        domicilioRepository.delete(domicilio);
    }

    @Override
    public List<Domicilio> buscarTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        if (!domicilios.isEmpty()) {
            return domicilios;
        }
        return List.of();
    }
}
