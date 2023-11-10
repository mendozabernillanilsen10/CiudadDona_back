package comciudad.dona.service;

import org.springframework.security.authentication.AuthenticationManager;  
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.RegisterRequest;
import comciudad.dona.entity.User;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.UserRepository;
import comciudad.dona.security.JwtService;
import comciudad.dona.utils.RolesAcces;
import comciudad.dona.validadors.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponse login(LoginRequest request) {
      try {
            User usuario = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new ValidateServiceException("Usuario o contraseña incorrectos."));

            if (!usuario.getActivo()) {
                throw new ValidateServiceException("El usuario está desactivado, comuníquese con el administrador.");
            }

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            return AuthResponse.builder()
                    .token(jwtService.getToken(usuario))
                    .usuario(usuario)
                    .build();
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException("Error al iniciar sesión", e);
        }
    }


    public AuthResponse register(RegisterRequest request) {
    	try {
    		User usuario = new User();
    		usuario.setUsername(request.getUsername());
    		usuario.setPassword(request.getUsername());
	        UsuarioValidator.save(usuario);
	        User existUsuario = userRepository.findByUsername(request.getUsername()).orElse(null);
	        if (existUsuario != null) {
	            throw new ValidateServiceException("El usuario ya existe.");
	        }
	        User user = User.builder()
	                .username(request.getUsername())
	                .password(passwordEncoder.encode( request.getPassword()))
	                .role(request.getRole())
	                .roles(RolesAcces.USER)
	                .activo(true)
	                .build();
	            User  users= userRepository.save(user);
	            return AuthResponse.builder()
	                .token(jwtService.getToken(users))
	                .usuario(users)
	                .build();
	            
	            
        } catch (ValidateServiceException e) {
	        throw e; 
	    } catch (NoDataFoundException e) {
	        throw e;
	    } catch (Exception e) {
	        throw new GeneralServiceException(e.getMessage(), e);
	    }
 
    }
    
    
    

}
