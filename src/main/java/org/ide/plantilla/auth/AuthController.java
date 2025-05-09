package org.ide.plantilla.auth;

import org.ide.plantilla.user.model.User;
import org.ide.plantilla.user.repository.UserRepository;
import org.ide.plantilla.auth.JwtService;
import org.ide.plantilla.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Aqui estan las funciones de registrarse y login por defecto

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        userService.register(request.getUsername(), request.getPassword(), request.getRole());
        return ResponseEntity.ok("Usuario registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        String token = userService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", ""); // eliminamos el prefijo
        String username = jwtService.extractUsername(token); // extraes el subject (username)

        User user = userRepository.findByUsername(username).orElseThrow();

        return ResponseEntity.ok(Map.of(
                "id", user.getId(),
                "username", user.getUsername(),
                "role", user.getRole().name()
        ));
    }
}
