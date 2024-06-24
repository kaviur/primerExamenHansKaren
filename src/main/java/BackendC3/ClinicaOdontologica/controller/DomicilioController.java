package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/domicilio")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    @PostMapping
    public IDto guardar(@RequestBody IDto domicilio) {
        return domicilioService.guardar(domicilio);
    }

    @GetMapping("/{id}")
    public IDto buscar(@PathVariable Integer id) {
        return domicilioService.buscar(id);
    }

    @DeleteMapping("delete/{id}")
    public String eliminar(@PathVariable Integer id) {
        domicilioService.eliminar(id);
        return "El domicilio ha sido eliminado correctamente";
    }

    @PutMapping("{id}")
    public IDto actualizar(@RequestBody IDto domicilio, @PathVariable Integer id) {
        return domicilioService.actualizar(domicilio, id);
    }

    @GetMapping
    public List<IDto> buscarTodos() {
        return domicilioService.buscarTodos();
    }
}
