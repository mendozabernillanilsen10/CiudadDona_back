package comciudad.dona.dtos;


import org.springframework.security.core.userdetails.UserDetails;

import comciudad.dona.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse  {
    String token; 
    User usuario;
}
