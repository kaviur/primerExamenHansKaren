import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;
import service.PacienteService;

import java.util.List;

public class OdontologoServiceTest {



    @Test
    public void testAgregarYBuscarOdontologo() {
        Odontologo odontologo = new Odontologo("12345", "Juan", "Perez");
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
        OdontologoService odontologoService = new OdontologoService(odontologoDAOH2);
        odontologoService.guardarOdontologo(odontologo);
        Odontologo odontologoBuscado = odontologoService.buscarOdontologo(odontologo.getId());
        Assertions.assertNotNull(odontologoBuscado);
        Assertions.assertEquals("Juan", odontologoBuscado.getNombre());
    }


}
