package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.PacienteDto;
import BackendC3.ClinicaOdontologica.service.IPacienteService;
import BackendC3.ClinicaOdontologica.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController//@Controller //<-- es controller pq vamos a usar una tecnologia de vista
@RequestMapping("/api/paciente")
public class PacienteController {
    private final IPacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Response> buscarTodos(){
        List<PacienteDto> pacientes = pacienteService.buscarTodos();
        Response response = new Response(true, HttpStatus.OK, pacientes);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> buscarPorId(@PathVariable Integer id){
        PacienteDto paciente = pacienteService.buscar(id);
        Response response = new Response(true, HttpStatus.OK, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
