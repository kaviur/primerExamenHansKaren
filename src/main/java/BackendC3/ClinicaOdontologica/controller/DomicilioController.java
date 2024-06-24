package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputDomicilioDto;
import BackendC3.ClinicaOdontologica.dto.requestDtos.InputPacienteDto;
import BackendC3.ClinicaOdontologica.service.IDomicilioService;
import BackendC3.ClinicaOdontologica.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/domicilio")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody InputDomicilioDto domicilio) {
        Response response = new Response(true, HttpStatus.OK, domicilioService.guardar(domicilio));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> buscar(@PathVariable Integer id) {
        Response response = new Response(true, HttpStatus.OK, domicilioService.buscar(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> eliminar(@PathVariable Integer id) {
        domicilioService.eliminar(id);
        Response response = new Response(true, HttpStatus.OK, "El domicilio ha sido eliminado correctamente");
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Response> actualizar(@RequestBody InputDomicilioDto domicilio, @PathVariable Integer id) {
        Response response = new Response(true, HttpStatus.OK, domicilioService.actualizar(domicilio, id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> buscarTodos() {
        Response response = new Response(true, HttpStatus.OK, domicilioService.buscarTodos());
        return ResponseEntity.ok(response);
    }
}
