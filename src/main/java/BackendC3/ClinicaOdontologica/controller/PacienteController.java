package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.service.IPacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller //<-- es controller pq vamos a usar una tecnologia de vista
@RequestMapping("/paciente")
public class PacienteController {
    private IPacienteService pacienteService;

//    public PacienteController() {
//        pacienteService = new PacienteService();
//    }
//
//    //ahora vienen todos los metodos que nos permitan actuar como intermediarios.
    @GetMapping
    public String buscarPacientePorCorreo() {
        return "Hello world";
    }
}
