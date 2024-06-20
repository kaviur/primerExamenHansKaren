package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.entity.Domicilio;
import BackendC3.ClinicaOdontologica.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    @Autowired
    ICrudService <Domicilio, Integer> domicilioService;

    @PostMapping
    public Domicilio guardar(@RequestBody Domicilio domicilio){
        return domicilioService.guardar(domicilio);
    }

    @GetMapping("/{id}")
    public Domicilio buscar(@PathVariable Integer id){
        return domicilioService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        domicilioService.eliminar(id);
    }

    @PutMapping
    public Domicilio actualizar(@RequestBody Domicilio domicilio){
        return domicilioService.actualizar(domicilio);
    }
}
