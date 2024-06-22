package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.TurnoDto;
import BackendC3.ClinicaOdontologica.entity.Turno;
import BackendC3.ClinicaOdontologica.service.ITurnoService;
import BackendC3.ClinicaOdontologica.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turno")
@RequiredArgsConstructor
public class TurnoController {
    private final ITurnoService turnoService;

    @GetMapping
    public ResponseEntity<Response> buscarTodos(){
        List<TurnoDto> turnos = turnoService.buscarTodos();
        Response response = new Response(true, HttpStatus.OK, turnos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> buscarPorId(Long id){
        TurnoDto turno = turnoService.buscar(id);
        Response response = new Response(true, HttpStatus.OK, turno);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response> guardar(TurnoDto turnoDto){
        TurnoDto turno = turnoService.guardar(turnoDto);
        Response response = new Response(true, HttpStatus.OK, turno);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizar(@PathVariable Long id, TurnoDto turnoDto){
        TurnoDto turno = turnoService.actualizar(turnoDto, id);
        Response response = new Response(true, HttpStatus.OK, turno);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> eliminar(Long id){
        turnoService.eliminar(id);
        Response response = new Response(true, HttpStatus.OK, "Turno eliminado con exito");
        return ResponseEntity.ok(response);
    }
}
