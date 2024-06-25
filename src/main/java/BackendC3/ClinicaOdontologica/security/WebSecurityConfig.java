package BackendC3.ClinicaOdontologica.security;

import BackendC3.ClinicaOdontologica.entity.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auths) -> auths
                        .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
//                        .requestMatchers("/api/domicilio/**").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/api/odontologo/**").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/api/paciente/**").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/api/turno/**").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers(HttpMethod.GET, "/api/paciente/**").hasAnyRole("PACIENTE", "ODONTOLOGO")
//                        .requestMatchers(HttpMethod.GET, "/api/odontologo/**").hasAnyRole("PACIENTE", "ODONTOLOGO")
//                        .requestMatchers(HttpMethod.GET, "/api/turno/**").hasAnyRole("PACIENTE", "ODONTOLOGO")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
//                .formLogin(form -> form
//                        .loginPage("/index.html")
//                        .permitAll()
//                        .defaultSuccessUrl("/default", true))
                .logout(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin@gmail.com").password(bCryptPasswordEncoder.encode("admin")).roles("ADMIN").build());
        manager.createUser(User.withUsername("user@gmail.com").password(bCryptPasswordEncoder.encode("user")).roles("USER").build());
        manager.createUser(User.withUsername("odontologo@gmail.com").password(bCryptPasswordEncoder.encode("odontologo")).roles("ODONTOLOGO").build());
        manager.createUser(User.withUsername("paciente@gmail.com").password(bCryptPasswordEncoder.encode("paciente")).roles("PACIENTE").build());
        return manager;
    }
}
