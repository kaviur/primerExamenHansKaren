package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputOdontologoDto;
import BackendC3.ClinicaOdontologica.service.IOdontologoService;
import BackendC3.ClinicaOdontologica.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/odontologo")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody InputOdontologoDto odontologo) {
        Response response = new Response(true, HttpStatus.OK, odontologoService.guardar(odontologo));
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Response> actualizar(@RequestBody InputOdontologoDto odontologo, @PathVariable Integer id) {
        Response response = new Response(true, HttpStatus.OK, odontologoService.actualizar(odontologo, id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> eliminar(@PathVariable Integer id) {
        odontologoService.eliminar(id);
        Response response = new Response(true, HttpStatus.OK, "Odontologo eliminado con éxito");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> buscarTodos() {
        Response response = new Response(true, HttpStatus.OK, odontologoService.buscarTodos());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> buscarPorId(@PathVariable Integer id) {
        Response response = new Response(true, HttpStatus.OK, odontologoService.buscar(id));
        return ResponseEntity.ok(response);
    }
}
