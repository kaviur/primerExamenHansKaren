package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.entity.Odontologo;
import BackendC3.ClinicaOdontologica.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/odontologo")
public class OdontologoController {

    @Autowired
    private ICrudService <Odontologo, Integer> odontologoService;

    @PostMapping
    public Odontologo guardar(@RequestBody Odontologo odontologo){
        return odontologoService.guardar(odontologo);
    }

    @PutMapping
    public Odontologo actualizar(@RequestBody Odontologo odontologo){
        return odontologoService.actualizar(odontologo);
    }

    @DeleteMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id){
        odontologoService.eliminar(id);
        return "El odontologo ha sido eliminado correctamente";
    }

    @GetMapping
    public List<Odontologo> buscarTodos(){
        return odontologoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Odontologo buscarPorId(@PathVariable Integer id){
        return odontologoService.buscar(id);
    }
}
