package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.entity.Paciente;
import BackendC3.ClinicaOdontologica.service.PacienteService;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller //<-- es controller pq vamos a usar una tecnologia de vista
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController() {
        pacienteService = new PacienteService();
    }
//
//    //ahora vienen todos los metodos que nos permitan actuar como intermediarios.
    @GetMapping
    public String buscarPacientePorCorreo() {
        return "Hello world";
    }
}
