package BackendC3.ClinicaOdontologica.security;

import BackendC3.ClinicaOdontologica.entity.*;
import BackendC3.ClinicaOdontologica.entity.enums.Role;
import BackendC3.ClinicaOdontologica.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class InitialData implements ApplicationRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String password = passwordEncoder.encode("user");
        Usuario user = new Usuario("User", "User", "user@gmail.com", password, Role.USER);
        userRepository.save(user);

        String passwordAdmin = passwordEncoder.encode("admin");
        Usuario admin = new Usuario("Admin", "Admin", "admin@gmail.com", passwordAdmin, Role.ADMIN);
        userRepository.save(admin);

        String  passwordOdontologo = passwordEncoder.encode("odontologo");
        Usuario odontologo = new Usuario("Odontologo", "Odontologo", "odontologo@gmail.com", passwordOdontologo, Role.ODONTOLOGO);
        userRepository.save(odontologo);

        String passwordPaciente = passwordEncoder.encode("paciente");
        Usuario paciente = new Usuario("Paciente", "Paciente", "paciente@gmail.com", passwordPaciente, Role.PACIENTE);
        userRepository.save(paciente);

        Domicilio domicilio1 = Domicilio.builder()
                .calle("Av. Principal")
                .numero(123)
                .localidad("Usaquén")
                .provincia("Bogotá")
                .build();

        Paciente paciente1 = Paciente.builder()
                .nombre("Pablo")
                .apellido("López")
                .cedula("71202458")
                .email("pablolopez@gmail.com")
                .domicilio(domicilio1)
                .fechaIngreso(LocalDate.now())
                .build();
        pacienteRepository.save(paciente1);

        Domicilio domicilio2 = Domicilio.builder()
                .calle("Av. Central")
                .numero(456)
                .localidad("Palermo")
                .provincia("Buenos Aires")
                .build();

        Paciente paciente2 = Paciente.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .cedula("578654025")
                .email("juanperez@gmail.com")
                .domicilio(domicilio2)
                .fechaIngreso(LocalDate.now())
                .build();
        pacienteRepository.save(paciente2);

        Odontologo odontologo1 = Odontologo.builder()
                .nombre("Miguel")
                .apellido("García")
                .numeroMatricula("ABC123")
                .build();
        odontologoRepository.save(odontologo1);

        Odontologo odontologo2 = Odontologo.builder()
                .nombre("María")
                .apellido("López")
                .numeroMatricula("DEF456")
                .build();
        odontologoRepository.save(odontologo2);

        Turno turno1 = Turno.builder()
                .paciente(paciente1)
                .odontologo(odontologo1)
                .fecha(LocalDateTime.parse("2023-06-26T10:30:00"))
                .build();
        turnoRepository.save(turno1);

        Turno turno2 = Turno.builder()
                .paciente(paciente2)
                .odontologo(odontologo2)
                .fecha(LocalDateTime.parse("2023-06-27T14:45:00"))
                .build();
        turnoRepository.save(turno2);

        Turno turno3 = Turno.builder()
                .paciente(paciente1)
                .odontologo(odontologo2)
                .fecha(LocalDateTime.parse("2023-06-28T09:00:00"))
                .build();
        turnoRepository.save(turno3);

        Turno turno4 = Turno.builder()
                .paciente(paciente2)
                .odontologo(odontologo1)
                .fecha(LocalDateTime.parse("2023-06-29T11:15:00"))
                .build();
        turnoRepository.save(turno4);

    }
}
