package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.entity.Odontologo;
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
                .orElseThrow(() -> new RuntimeException("No se encontro el odontologo"));
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Odontologo  odontologoActual = buscar(odontologo.getId());
        odontologoActual.setNumeroMatricula(odontologo.getNumeroMatricula());
        odontologoActual.setNombre(odontologo.getNombre());
        odontologoActual.setApellido(odontologo.getApellido());
        return guardar(odontologo);
    }

    @Override
    public void eliminar(Integer id) {
        Odontologo odontologo = buscar(id);
        odontologoRepository.delete(odontologo);
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }
}
