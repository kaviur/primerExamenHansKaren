package BackendC3.ClinicaOdontologica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //<-- es controller pq vamos a usar una tecnologia de vista
@RequestMapping("/paciente")
public class PacienteController {
//    private PacienteService pacienteService;
//
//    public PacienteController() {
//        pacienteService = new PacienteService();
//    }
//
//    //ahora vienen todos los metodos que nos permitan actuar como intermediarios.
//    @GetMapping
//    public String buscarPacientePorCorreo(Model model, @RequestParam("email") String email) {
//
//        Paciente paciente = pacienteService.buscarPorEmail(email);
//        model.addAttribute("nombre", paciente.getNombre());
//        model.addAttribute("apellido", paciente.getApellido());
//        return "index";
//
//        //return pacienteService.buscarPorEmail(email);
//    }
}
