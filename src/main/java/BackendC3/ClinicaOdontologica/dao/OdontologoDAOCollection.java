package BackendC3.ClinicaOdontologica.dao;

import BackendC3.ClinicaOdontologica.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class OdontologoDAOCollection implements iDao<Odontologo>{
    private static final List<Odontologo> odontologos = new ArrayList<Odontologo>();
    private static final AtomicLong idCounter = new AtomicLong();
    private static final Logger logger = Logger.getLogger(OdontologoDAOCollection.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId((int) idCounter.incrementAndGet());
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado localmente en la colección: " + odontologo);

        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Optional<Odontologo> odontologo = odontologos.stream()
                .filter(o -> o.getId()
                        .equals(id))
                .findFirst();

        if (odontologo.isPresent()) {
            logger.info("Odontólogo encontrado en la colección: " + odontologo.get());
            return odontologo.get();
        } else {
            logger.warn("Odontólogo no encontrado en la colección con ID: " + id);
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {
        odontologos.removeIf(o -> o.getId().equals(id));
        logger.info("Odontólogo eliminado de colección con ID: " + id);
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        for (int i = 0; i < odontologos.size(); i++) {
            if (odontologos.get(i).getId().equals(odontologo.getId())) {
                odontologos.set(i, odontologo);
                logger.info("Odontólogo actualizado en la colección: " + odontologo);
                return;
            }
        }
        logger.warn("No se encuentra registrado ese odontólogo en la base de datos local: " + odontologo.getId());
    }


    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Lista de todos los odontólogos en colección: " + odontologos);
        return new ArrayList<>(odontologos);
    }

    @Override
    public Odontologo buscarPorString(String string) {
        return null;
    }
}
