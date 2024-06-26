package BackendC3.ClinicaOdontologica;

import BackendC3.ClinicaOdontologica.dto.requestDtos.InputOdontologoDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputPacienteDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputTurnoDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.OdontologoDto;
import BackendC3.ClinicaOdontologica.dto.responseDtos.PacienteDto;
import BackendC3.ClinicaOdontologica.entity.Domicilio;
import BackendC3.ClinicaOdontologica.entity.Odontologo;
import BackendC3.ClinicaOdontologica.entity.Paciente;
import BackendC3.ClinicaOdontologica.entity.Turno;
import BackendC3.ClinicaOdontologica.service.IOdontologoService;
import BackendC3.ClinicaOdontologica.service.IPacienteService;
import BackendC3.ClinicaOdontologica.service.ITurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TurnosIntegracionTest {
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IOdontologoService odontologoService;
    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private MockMvc mockMvc;

    private void cargarDatos() {
        InputPacienteDto pacienteDTO = new InputPacienteDto("Juan", "Pérez", "44445555", "juanperez10@gmail.com", "2024-06-23", "123", 10, "Bogotá", "Bogotá");
        PacienteDto paciente = (PacienteDto) pacienteService.guardar(pacienteDTO);

        InputOdontologoDto odontologoDTO = new InputOdontologoDto();
        odontologoDTO.setNombre("Máximo");
        odontologoDTO.setApellido("Aguilar");
        odontologoDTO.setNumeroMatricula("123456");
        OdontologoDto odontologo = (OdontologoDto) odontologoService.guardar(odontologoDTO);

        InputTurnoDto turno = new InputTurnoDto(3, 3, "2024-06-23T15:30:50");
        turnoService.guardar(turno);

    }

    @Test
    public void ListarTodosLosTurnosTest() throws Exception {
        cargarDatos();
        MvcResult respuesta = mockMvc.perform(MockMvcRequestBuilders.get("/api/turno").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());

    }
}