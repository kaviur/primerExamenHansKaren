package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputTurnoDto;
import BackendC3.ClinicaOdontologica.service.ITurnoService;
import BackendC3.ClinicaOdontologica.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turno")
@RequiredArgsConstructor
@Tag(name = "Turno", description = "Operaciones relacionadas con los turnos")
public class TurnoController {
    private final ITurnoService turnoService;

    @GetMapping
    public ResponseEntity<Response> buscarTodos(){
        List<IDto> turnos = turnoService.buscarTodos();
        Response response = new Response(true, HttpStatus.OK, turnos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> buscarPorId(@PathVariable Long id){
        IDto turno = turnoService.buscar(id);
        Response response = new Response(true, HttpStatus.OK, turno);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody InputTurnoDto turnoDto){
        IDto turno = turnoService.guardar(turnoDto);
        Response response = new Response(true, HttpStatus.OK, turno);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizar(@PathVariable Long id, @RequestBody InputTurnoDto turnoDto){
        IDto turno = turnoService.actualizar(turnoDto, id);
        Response response = new Response(true, HttpStatus.OK, turno);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> eliminar(@PathVariable Long id){
        turnoService.eliminar(id);
        Response response = new Response(true, HttpStatus.OK, "Turno eliminado con exito");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Response> buscarTurnosPorPaciente(@PathVariable Long id){
        List<IDto> turnos = turnoService.buscarTurnosPorPaciente(id);
        Response response = new Response(true, HttpStatus.OK, turnos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/odontologo/{id}")
    public ResponseEntity<Response> buscarTurnosPorOdontologo(@PathVariable Long id){
        List<IDto> turnos = turnoService.buscarTurnosPorOdontologo(id);
        Response response = new Response(true, HttpStatus.OK, turnos);
        return ResponseEntity.ok(response);
    }
}
