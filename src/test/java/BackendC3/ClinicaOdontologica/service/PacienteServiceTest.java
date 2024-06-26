package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputPacienteDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.PacienteDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {
    @Autowired
    private IPacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPaciente() {
        InputPacienteDto inputPacienteDto = new InputPacienteDto("Juan", "Pérez", "44445555", "juanperez10@gmail.com", "2024-06-23", "123", 10, "Bogotá", "Bogotá");
        PacienteDto pacienteGuardado = (PacienteDto) pacienteService.guardar(inputPacienteDto);
        assertEquals(3, pacienteGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarPacientePorId() {
        Integer id = 3;
        IDto pacienteBuscado = pacienteService.buscar(id);
        assertNotNull(pacienteBuscado);
    }

    @Test
    @Order(3)
    public void actualizarPaciente() {
        Integer id = 3;
        InputPacienteDto inputPacienteDto = new InputPacienteDto("Maria", "Torres", "20202020", "mariatorres@gmail.com", "2024-06-37T18:20:00", "456", 20, "Bogotá", "Bogotá");
        pacienteService.actualizar(inputPacienteDto, id);
        PacienteDto pacienteActualizado = (PacienteDto) pacienteService.buscar(id);
        assertEquals("Maria", pacienteActualizado.getNombre());
    }

    @Test
    @Order(4)
    public void ListarTodos() {
        List<IDto> listaPacientes = pacienteService.buscarTodos();
        assertEquals(3, listaPacientes.size());
    }

    @Test
    @Order(5)
    public void eliminarPaciente() {
        pacienteService.eliminar(3);
        List<IDto> pacienteEliminado = pacienteService.buscarTodos();
        assertEquals(2, pacienteEliminado.size());
    }
}
