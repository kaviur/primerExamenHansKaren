package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputPacienteDto;
import BackendC3.ClinicaOdontologica.service.IPacienteService;
import BackendC3.ClinicaOdontologica.utils.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController//@Controller //<-- es controller pq vamos a usar una tecnologia de vista
@RequestMapping("/api/paciente")
public class PacienteController {
    private final IPacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Response> buscarTodos(){
        List<IDto> pacientes = pacienteService.buscarTodos();
        Response response = new Response(true, HttpStatus.OK, pacientes);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> buscarPorId(@PathVariable Integer id){
        IDto paciente = pacienteService.buscar(id);
        Response response = new Response(true, HttpStatus.OK, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@Valid @RequestBody InputPacienteDto pacienteDto){
        IDto paciente = pacienteService.guardar(pacienteDto);
        Response response = new Response(true, HttpStatus.OK, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizar(@Valid @RequestBody InputPacienteDto pacienteDto, @PathVariable Integer id){
        IDto paciente = pacienteService.actualizar(pacienteDto, id);
        Response response = new Response(true, HttpStatus.OK, paciente);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> eliminar(@PathVariable Integer id){
        pacienteService.eliminar(id);
        Response response = new Response(true, HttpStatus.OK, "Paciente eliminado con exito");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
