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
        Usuario user = new Usuario("John", "JohnDoe", "johndoe@gmail.com", password, Role.ROLE_USER);
        userRepository.save(user);

        password = passwordEncoder.encode("admin");
        Usuario admin = new Usuario("Admin", "Admin", "admin@gmail.com", password, Role.ROLE_ADMIN);
        userRepository.save(admin);
    }
}
