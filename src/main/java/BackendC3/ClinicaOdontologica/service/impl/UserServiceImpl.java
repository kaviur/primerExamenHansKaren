package BackendC3.ClinicaOdontologica.service.impl;

import BackendC3.ClinicaOdontologica.entity.Usuario;
import BackendC3.ClinicaOdontologica.repository.IUserRepository;
import BackendC3.ClinicaOdontologica.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Usuario no encontrado con el email: " + username);
    }
}
