package org.ide.plantilla.auth;

import lombok.Data;
import org.ide.plantilla.user.model.Role;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private Role role;
}
