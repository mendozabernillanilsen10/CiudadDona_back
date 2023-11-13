package comciudad.dona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.AddressConverters;
import comciudad.dona.converters.IngresosResponse;
import comciudad.dona.converters.PersonaConverters;
import comciudad.dona.converters.PhoneConverters;
import comciudad.dona.converters.RolCoverters;
import comciudad.dona.converters.UserConvertes;
import comciudad.dona.converters.UsuarioConverter;
import comciudad.dona.converters.companyConverters;
import comciudad.dona.dtos.AddressDTO;
import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.CompanyDTO;
import comciudad.dona.dtos.LoginRequest;
import comciudad.dona.dtos.PesonDTO;
import comciudad.dona.dtos.PhoneDTO;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.dtos.UsuarioDTO;
import comciudad.dona.entity.Address;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Person;
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.Role;
import comciudad.dona.entity.User;
import comciudad.dona.service.AddressService;
import comciudad.dona.service.AuthService;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.PersonService;
import comciudad.dona.service.PhoneService;
import comciudad.dona.service.RolService;
import comciudad.dona.service.companiaService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UsuarioController {

	private final AuthService authService;
	@Autowired
	RolService serviceRole;
	@Autowired
	AddressService serviceAdress;
	@Autowired
	PlatformTransactionManager transactionManager;
	@Autowired
	DistritoService distritoService;
	@Autowired
	PhoneService servicePhone;
	@Autowired
	PersonService ser;
	@Autowired
	companiaService companyservice;
	companyConverters Companyconverter = new companyConverters();
	UsuarioConverter converter = new UsuarioConverter();
	UserConvertes conUsers = new UserConvertes();
	PersonaConverters conPersona = new PersonaConverters();
	RolCoverters roleconverter = new RolCoverters();
	PersonaConverters convert = new PersonaConverters();
	PhoneConverters Phoneconverter = new PhoneConverters();
	AddressConverters Adressconverter = new AddressConverters();

	@PutMapping("/EmailValidacodigo")
	public ResponseEntity<String> verifyAccount(@RequestParam String email, @RequestParam String otp) {
		return new ResponseEntity<>(authService.verifyAccount(email, otp), HttpStatus.OK);
	}

	@PutMapping("/EmailGenerecodigo")
	public ResponseEntity<String> regenerateOtp(@RequestParam String email) {
		return new ResponseEntity<>(authService.regenerateOtp(email), HttpStatus.OK);
	}
	@PostMapping(value = "/login")
	public ResponseEntity<WrapperResponse<IngresosResponse>> login(
			@RequestBody LoginRequest request) {
		AuthResponse authResponse = authService.login(request);
		IngresosResponse respuestafinal = new IngresosResponse();
		UsuarioDTO userdto = converter.fromEntity(authResponse.getUsuario());
		Role role = serviceRole.findById(authResponse.getUsuario().getRole().getId());
		RolDTO articulosDTO = roleconverter.fromEntity(role);
		Person per = ser.findByidUser(authResponse.getUsuario());
		PesonDTO perdto = conPersona.fromEntity(per);
		respuestafinal.setPersona(perdto);
		User usuario = new User();
		usuario.setId(authResponse.getUsuario().getId());
		Phone phone = servicePhone.finByIdUser(usuario);
		PhoneDTO phoneDto = Phoneconverter.fromEntity(phone);
		Address address = serviceAdress.finByIdUser(usuario);
		AddressDTO adresDTO = Adressconverter.fromEntity(address);
		Company compan = companyservice.finByIdUser(usuario);
		CompanyDTO compDTO = Companyconverter.fromEntity(compan);
		respuestafinal.setRole(articulosDTO);
		respuestafinal.setUsuario(userdto);
		respuestafinal.setToken(authResponse.getToken());
		respuestafinal.setPhone(phoneDto);
		respuestafinal.setAddres(adresDTO);
		respuestafinal.setEmpresa(compDTO);
		return new WrapperResponse<>(true, "success", respuestafinal).createResponse(HttpStatus.OK);
	}

}
