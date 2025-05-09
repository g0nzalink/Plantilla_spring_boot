package org.ide.plantilla.config;


import org.ide.plantilla.user.model.Role;
import org.ide.plantilla.user.model.User;
import org.ide.plantilla.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserInitializer {
    @Bean
    public CommandLineRunner init(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin"); //Nombre del usuario administrador
                admin.setPassword(encoder.encode("admin123")); //Contrasenia del usuario administrador
                admin.setRole(Role.ADMIN);
                userRepository.save(admin);
                System.out.println("✔ Usuario ADMIN creado por defecto.");
            }
        };
    }
}
