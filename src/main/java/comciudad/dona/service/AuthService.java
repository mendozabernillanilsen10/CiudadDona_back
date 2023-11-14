package comciudad.dona.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.RegisterRequest;
import comciudad.dona.dtos.ResponseEmailDto;
import comciudad.dona.dtos.responseMailToken;
import comciudad.dona.entity.User;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.UserRepository;
import comciudad.dona.security.JwtService;
import comciudad.dona.validadors.UsuarioValidator;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import comciudad.dona.utils.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	@Autowired
	OtpUtil otpUtil;
	@Autowired
	EmailUtil emailUtil;
	ResponseEmailDto dto;
	public responseMailToken verifyAccount(String username, String otp) {
		responseMailToken ms = new responseMailToken();
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("usuario No se encontrado con :" + username));
		try {
			ResponseEmailDto men;
			if (user.getOtp().equals(otp)
					&& Duration.between(user.getOtpGeneratedTime(), LocalDateTime.now()).getSeconds() < (6 * 60)) {
				userRepository.save(user);
				ms.setMensaje("verificado");
				ms.setToken(jwtService.getToken(user));
				ms.setMail(user.getUsername());
				return ms;
			}
		} catch (ValidateServiceException | NoDataFoundException e) {
			throw new ValidateServiceException("error del servidor");
		} catch (Exception e) {
		}
		throw new ValidateServiceException("Por favor regenera otro codigo  y vuelve a intentarlo.");
	}
	
	
	public ResponseEmailDto regenerateOtp(String email) {

		User user = userRepository.findByUsername(email)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con este correo electrónico:" + email));
		String otp = otpUtil.generateOtp();
		try {
			emailUtil.sendOtpEmail(email, otp);
		} catch (MessagingException e) {
			throw new RuntimeException("No se puede enviar el codigo de verifcacion , inténtalo de nuevo.");
		}
		ResponseEmailDto ms = new ResponseEmailDto();
		user.setOtp(otp);
		user.setOtpGeneratedTime(LocalDateTime.now());
		userRepository.save(user);
		ms.setMensaje("Codigo de vefificacion enviado ... verifique la cuenta en 3 minuto");
		return ms;
	}
	public AuthResponse login(LoginRequest request) {
		try {
			User usuario = userRepository.findByUsername(request.getUsername())
					.orElseThrow(() -> new ValidateServiceException("Usuario o contraseña incorrectos."));
			if (!usuario.getActivo()) {
				throw new ValidateServiceException("El usuario está desactivado, comuníquese con el administrador.");
			}
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			return AuthResponse.builder().token(jwtService.getToken(usuario)).usuario(usuario).build();
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException("Error al iniciar sesión", e);
		}
	}
	public ResponseEmailDto ResetPassword(LoginRequest request) {
		User existUsuario = userRepository.findByUsername(request.getUsername()).orElse(null);
		if (existUsuario != null) {
			existUsuario.setPassword(passwordEncoder.encode(request.getPassword()));
			userRepository.save(existUsuario);
		}
		ResponseEmailDto ms = new ResponseEmailDto();
		ms.setMensaje("ya puede iniciar seccion");
		return ms;
	}
	public AuthResponse register(RegisterRequest request) {
		try {
			User usuario = new User();
			usuario.setUsername(request.getUsername());
			usuario.setPassword(request.getPassword());
			UsuarioValidator.save(usuario);
			User existUsuario = userRepository.findByUsername(request.getUsername()).orElse(null);
			if (existUsuario != null) {
				throw new ValidateServiceException("El usuario ya existe.");
			}
			User user = User.builder().username(request.getUsername())
					.password(passwordEncoder.encode(request.getPassword())).role(request.getRole())
					.roles(RolesAcces.USER).activo(true).build();
			User users = userRepository.save(user);
			return AuthResponse.builder().token(jwtService.getToken(users)).usuario(users).build();
		} catch (ValidateServiceException e) {
			throw e;
		} catch (NoDataFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralServiceException(e.getMessage(), e);
		}

	}

}
