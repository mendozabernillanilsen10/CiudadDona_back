package comciudad.dona.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.RegisterRequest;
import comciudad.dona.dtos.ResponseEmailDto;
import comciudad.dona.dtos.responseMailToken;
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.User;
import comciudad.dona.exceptions.GeneralServiceException;
import comciudad.dona.exceptions.NoDataFoundException;
import comciudad.dona.exceptions.ValidateServiceException;
import comciudad.dona.repository.PhoneRepository;
import comciudad.dona.repository.UserRepository;
import comciudad.dona.security.JwtService;
import comciudad.dona.service.impl.TwilioSmsService;
import comciudad.dona.utils.EmailUtil;
import comciudad.dona.utils.OtpUtil;
import comciudad.dona.utils.RolesAcces;
import comciudad.dona.validadors.UsuarioValidator;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
	@Autowired
	UserRepository userRepository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	@Autowired
	private PhoneRepository repositoryPhone;

	@Autowired
	OtpUtil otpUtil;
	@Autowired
	EmailUtil emailUtil;
	ResponseEmailDto dto;
	@Autowired
	private TwilioSmsService smsService;
	private Map<String, String> otps = new HashMap<>();

	
	
	// GENERAR CODIGO OTP PHONE
	
	public ResponseEmailDto generarOtpPhone(String phone) {
		ResponseEmailDto ms = new ResponseEmailDto();

		Phone existe = repositoryPhone.findBycelular(phone);
		if (existe != null) {
			User user = new User();
			user.setId(existe.getIdUser().getId());
			UUID id = existe.getIdUser().getId();
			Optional<User> exisuser = userRepository.findById(id);
			if (exisuser.isPresent()) {
				User users = exisuser.get();
				String otp = otpUtil.generateOtp();
				otps.put(phone, otp);
				String msg = " Su Codigo de veficacion para restablecer su cuenta es : ";
				smsService.sendSms(phone, msg + otp);
				users.setOtp(otp);
				users.setOtpGeneratedTime(LocalDateTime.now());
				userRepository.save(users);
				ms.setMensaje("Codigo de vefificacion enviado ... verifique la cuenta en 3 minuto");
			}
		} else {
			throw new ValidateServiceException("Telefono no se encuentra Registrado");

		}
		return ms;
	}
	// GENERAR CODIGO OTP EMAIL
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
	 public responseMailToken verifyAccountPhone(String phoneNumber, String otp) {
		 responseMailToken phoneToken = new responseMailToken();
	        // Buscar el teléfono en la base de datos
	        Phone existingPhone = repositoryPhone.findBycelular(phoneNumber);

	        if (existingPhone != null) {
	            // Obtener el usuario asociado al teléfono
	            User user = existingPhone.getIdUser();
	            // Verificar el OTP y el tiempo de generación
	            if (isValidOTP(user, otp)) {
	                phoneToken.setMensaje("verificado");
	                phoneToken.setToken(jwtService.getToken(user));
	                phoneToken.setEmail(user.getUsername());
	                return phoneToken;
	            } else {
	                throw new ValidateServiceException("Por favor regenera otro código y vuelve a intentarlo.");
	            }
	        } else {
	            throw new ValidateServiceException("Teléfono no existe");
	        }
	    }
	  
	    private boolean isValidOTP(User user, String otp) {
	        try {
	            if (user.getOtp().equals(otp) &&
	                    Duration.between(user.getOtpGeneratedTime(), 
	                    		LocalDateTime.now()).getSeconds() < (3 * 60)) {
	                return true;
	            }
	        } catch (ValidateServiceException | NoDataFoundException e) {
	            logError("Error del servidor", e);
	            throw new ValidateServiceException("Error del servidor");
	        } catch (Exception e) {
	            logError("Error durante la validación del OTP", e);
	        }
	        return false;
	    }

	    private void logError(String message, Exception e) {
	        e.printStackTrace(); // o loguear el error con tu mecanismo de registro preferido
	    }
	    
	    
	    
	    
	public responseMailToken verifyAccount(String username, String otp) {
		responseMailToken ms = new responseMailToken();
	
		try {
				User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("usuario No se encontrado con :" + username));
		
			if (user.getOtp().equals(otp)
					&& Duration.between(user.getOtpGeneratedTime(), LocalDateTime.now()).getSeconds() < (3 * 60)) {
				ms.setMensaje("verificado");
				ms.setToken(jwtService.getToken(user));
				ms.setEmail(user.getUsername());
				return ms;
			}
		} catch (ValidateServiceException | NoDataFoundException e) {
			throw new ValidateServiceException("error del servidor");
		} catch (Exception e) {
		}
		throw new ValidateServiceException("Por favor regenera otro codigo  y vuelve a intentarlo.");
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
