package BackendC3.ClinicaOdontologica.security;

import BackendC3.ClinicaOdontologica.entity.Usuario;
import BackendC3.ClinicaOdontologica.entity.enums.Role;
import BackendC3.ClinicaOdontologica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements ApplicationRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String password = passwordEncoder.encode("user");
        Usuario user = new Usuario("User", "User", "user@gmail.com", password, Role.ROLE_USER);
        userRepository.save(user);

        String passwordAdmin = passwordEncoder.encode("admin");
        Usuario admin = new Usuario("Admin", "Admin", "admin@gmail.com", passwordAdmin, Role.ROLE_ADMIN);
        userRepository.save(admin);

        String  passwordOdontologo = passwordEncoder.encode("odontologo");
        Usuario odontologo = new Usuario("Odontologo", "Odontologo", "odontologo@gmail.com", passwordOdontologo, Role.ROLE_ODONTOLOGO);
        userRepository.save(odontologo);

        String passwordPaciente = passwordEncoder.encode("paciente");
        Usuario paciente = new Usuario("Paciente", "Paciente", "paciente@gmail.com", passwordPaciente, Role.ROLE_PACIENTE);
        userRepository.save(paciente);

    }
}
