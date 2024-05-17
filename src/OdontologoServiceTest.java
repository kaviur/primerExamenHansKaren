import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoServiceTest {
    private OdontologoService odontologoService;

    @Test
    public void testAgregarYBuscarOdontologo() {
        Odontologo odontologo = new Odontologo("12345", "Juan", "Perez");
        odontologoService.guardarOdontologo(odontologo);
        Odontologo odontologoBuscado = odontologoService.buscarOdontologo(odontologo.getId());
        Assertions.assertNotNull(odontologoBuscado);
        Assertions.assertEquals("Juan", odontologoBuscado.getNombre());
    }

    @Test
    public void testBuscarTodosLosOdontologos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assertions.assertNotNull(odontologos);
    }
}
