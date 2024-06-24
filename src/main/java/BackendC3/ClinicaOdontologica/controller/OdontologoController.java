package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.dto.IDto;
import BackendC3.ClinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/odontologo")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public IDto guardar(@RequestBody IDto odontologo) {
        return odontologoService.guardar(odontologo);
    }

    @PutMapping("{id}")
    public IDto actualizar(@RequestBody IDto odontologo, @PathVariable Integer id) {
        return odontologoService.actualizar(odontologo, id);
    }

    @DeleteMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id) {
        odontologoService.eliminar(id);
        return "El odontologo ha sido eliminado correctamente";
    }

    @GetMapping
    public List<IDto> buscarTodos() {
        return odontologoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public IDto buscarPorId(@PathVariable Integer id) {
        return odontologoService.buscar(id);
    }
}
