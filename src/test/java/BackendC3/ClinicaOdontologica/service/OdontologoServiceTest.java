package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputOdontologoDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.OdontologoDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarOdontologo() {
        InputOdontologoDto odontologo = new InputOdontologoDto();
        odontologo.setNombre("Juan");
        odontologo.setApellido("Perez");
        odontologo.setNumeroMatricula("12345678");
        odontologoService.guardar(odontologo);
        OdontologoDto odontologoPrueba = (OdontologoDto) odontologoService.buscar(3);
        assertEquals(odontologoPrueba.getNumeroMatricula(), "12345678");
    }

    @Test
    @Order(2)
    public void buscarOdontologos() {
        List<IDto> odontologoPrueba = odontologoService.buscarTodos();
        assertEquals(3, odontologoPrueba.size());
    }

    @Test
    @Order(3)
    public void eliminarOdontologo() {
        odontologoService.eliminar(3);
        List<IDto> odontologoPrueba = odontologoService.buscarTodos();
        assertEquals(2, odontologoPrueba.size());
    }

    @Test
    @Order(4)
    public void actualizarOdontologo() {
        InputOdontologoDto odontologo = new InputOdontologoDto();
        odontologo.setNombre("Juan");
        odontologo.setApellido("Perez");
        odontologo.setNumeroMatricula("12345678");
        odontologoService.actualizar(odontologo, 2);
        OdontologoDto odontologoPrueba = (OdontologoDto) odontologoService.buscar(2);
        assertEquals(odontologoPrueba.getNumeroMatricula(), "12345678");
    }
}
