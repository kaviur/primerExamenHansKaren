import dao.BD;
import dao.OdontologoDAOCollection;
import dao.OdontologoDAOH2;
import dao.iDao;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;
import service.PacienteService;

import java.util.List;

public class OdontologoServiceTest {



    @Test
    public void testAgregarYBuscarOdontologo() {
        BD.crearTablas();
        Odontologo odontologo = new Odontologo("12345", "Juan", "Perez");
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
        OdontologoService odontologoService = new OdontologoService(odontologoDAOH2);
        Odontologo odontologoGuardado = odontologoService.guardarOdontologo(odontologo);
        //Odontologo odontologoBuscado = odontologoService.buscarOdontologo(odontologo.getId());
        //Assertions.assertNotNull(odontologoBuscado);
        Assertions.assertEquals("Juan", odontologoGuardado.getNombre());
    }

    @Test
    // recuperar odontologo
    public void testRecuperarOdontologo() {
        BD.crearTablas();
        Odontologo odontologo1 = new Odontologo("12345", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo("123456", "Miguel", "Flores");
        Odontologo odontologo3 = new Odontologo("1234567", "John", "Doe");

        // descomentar el DAO a usar
        //iDao<Odontologo> odontologoDAO = new OdontologoDAOCollection();
        iDao<Odontologo> odontologoDAO = new OdontologoDAOH2();

        OdontologoService odontologoService = new OdontologoService(odontologoDAO);
        Odontologo odontologoGuardado1 = odontologoService.guardarOdontologo(odontologo1);
        Odontologo odontologoGuardado2 = odontologoService.guardarOdontologo(odontologo2);
        Odontologo odontologoGuardado3 = odontologoService.guardarOdontologo(odontologo3);
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assertions.assertEquals(3, odontologos.size());
    }

}
