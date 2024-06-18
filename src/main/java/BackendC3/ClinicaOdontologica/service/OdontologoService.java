package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.entity.Odontologo;
import BackendC3.ClinicaOdontologica.exceptions.customExceptions.NotFoundException;
import BackendC3.ClinicaOdontologica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements ICrudService<Odontologo, Integer>  {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public Odontologo buscar(Integer id) {
        return odontologoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el odontologo con id " + id));
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Odontologo  odontologoActual = buscar(odontologo.getId());
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
        try {
            List<Odontologo> odontologos = odontologoRepository.findAll();
            if (odontologos.isEmpty()) {
                throw new NotFoundException("No se encontraron odontologos");
            }
            return odontologos;
        } catch (Exception e) {
            throw new NotFoundException("No se encontraron odontologos");
        }
    }
}
