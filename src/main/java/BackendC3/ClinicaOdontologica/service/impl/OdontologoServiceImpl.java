package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.entity.Odontologo;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.DomicilioNotFoundException;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.OdontologoNotFoundException;
import BackendC3.ClinicaOdontologica.repository.IOdontologoRepository;
import BackendC3.ClinicaOdontologica.service.ICrudService;
import BackendC3.ClinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public Odontologo buscar(Integer id) {
        return odontologoRepository.findById(id)
                .orElseThrow(() -> new OdontologoNotFoundException("No se encontro el odontologo con id " + id));
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo, Integer id) {
        Odontologo odontologoActual = buscar(id);
        if (odontologo.getNombre() != null) {
            odontologoActual.setNombre(odontologo.getNombre());
        }
        if (odontologo.getApellido() != null) {
            odontologoActual.setApellido(odontologo.getApellido());
        }
        if (odontologo.getNumeroMatricula() != null) {
            odontologoActual.setNumeroMatricula(odontologo.getNumeroMatricula());
        }
        return odontologoRepository.save(odontologoActual);
    }

    @Override
    public void eliminar(Integer id) {
        Odontologo odontologo = buscar(id);
        odontologoRepository.delete(odontologo);
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        if (odontologos.isEmpty()) {
            throw new OdontologoNotFoundException("No se encontraron odontologos");
        }
        return odontologos;
    }
}
