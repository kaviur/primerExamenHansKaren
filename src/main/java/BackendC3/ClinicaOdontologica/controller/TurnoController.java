package BackendC3.ClinicaOdontologica.controller;

import BackendC3.ClinicaOdontologica.service.ITurnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turno")
@RequiredArgsConstructor
public class TurnoController {
    private final ITurnoService turnoService;
}
