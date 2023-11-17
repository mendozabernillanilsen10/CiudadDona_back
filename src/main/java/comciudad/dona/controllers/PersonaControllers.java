package comciudad.dona.controllers;

import java.util.Date;    
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import comciudad.dona.dtos.AddressDTO;
import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.PesonDTO;
import comciudad.dona.dtos.PhoneDTO;
import comciudad.dona.dtos.RegisterRequest;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.dtos.UsuarioDTO;
import comciudad.dona.entity.Address;
import comciudad.dona.entity.Person;
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.Role;
import comciudad.dona.entity.User;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.service.AddressService;
import comciudad.dona.service.AuthService;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.PersonService;
import comciudad.dona.service.PhoneService;
import comciudad.dona.service.RolService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;
@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/Person")
public class PersonaControllers {
	@Autowired
	RolService serviceRole;
	@Autowired
	AddressService serviceAdress ;
	@Autowired
	PlatformTransactionManager transactionManager;
    @Autowired
	DistritoService distritoService ;
	@Autowired
	PhoneService servicePhone;
	@Autowired
	PersonService ser;
	UsuarioConverter converter=new UsuarioConverter();
	UserConvertes conUsers = new UserConvertes();
	PersonaConverters conPersona =new PersonaConverters();
	RolCoverters roleconverter = new RolCoverters ();
	PersonaConverters convert= new PersonaConverters ();
	private final AuthService authService;
	PhoneConverters Phoneconvert = new PhoneConverters ();
	AddressConverters Adressconverter = new AddressConverters();
	
	@PostMapping(value = "/registers")
	public ResponseEntity<WrapperResponse<IngresosResponse>>  register(
    		 @RequestParam("email") String email,
    		    @RequestParam("password") String password,
    		    @RequestParam("role_role") UUID role_role,
    		    @RequestParam("Dni") String Dni,
    		    @RequestParam("nombre") String nombre,
    		    @RequestParam("apellido") String apellido,
    		    @RequestParam("fecha_na") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_na,
    		    @RequestParam("Numero_celular") String Numero_celular,
    		    @RequestParam("Numero_whatsapp") String Numero_whatsapp,
    		    @RequestParam("Reference") String Reference,
    		    @RequestParam("street") String street,
    		    @RequestParam("IdDistrito") Long IdDistrito)
    {
		try {
		        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		        TransactionStatus status = transactionManager.getTransaction(def);
		        try {
			        IngresosResponse respuestafinal = new IngresosResponse();
			        RegisterRequest request = new RegisterRequest();
			        request.setUsername(email);
			        request.setPassword(password);
			        Role role = serviceRole.findById(role_role);
			        request.setRole(role);
				    RolDTO articulosDTO =roleconverter.fromEntity(role);
				    AuthResponse authResponse = authService.register(request);
			        UsuarioDTO userdto  = converter.fromEntity(authResponse.getUsuario());
			        User usuario  = new User();
			        usuario.setId(authResponse.getUsuario().getId());
			        Person per = new Person();
		            per.setIdUser(usuario);
		            per.setSurName(apellido);
		            per.setDNI(Dni);
		            per.setName(nombre);
		            per.setDate_of_Birth(fecha_na);
		            ser.save(per);
		            Phone phone = new Phone();
		            phone.setCelular(Numero_celular);
		            phone.setWhatsapp(Numero_whatsapp);
		            phone.setIdUser(usuario);
		            Phone newPhone = servicePhone.save(phone);   
		    	    PhoneDTO phoneDTO = Phoneconvert.fromEntity(newPhone);
		            ubdistrito dis = distritoService.findById(IdDistrito);
		            Address address = new Address();
		            address.setStreet(street);
		            address.setReference(Reference);
		            address.setUbdistrito_Id(dis);
		            address.setIdUser(usuario);
		            Address newAddress = serviceAdress.save(address);
		    	    AddressDTO adresDTO = Adressconverter.fromEntity(newAddress);
		    	       
		    	    PesonDTO perdto = conPersona.fromEntity(per);
				    respuestafinal.setRole(articulosDTO);
		    	    respuestafinal.setUsuario(userdto);
			        respuestafinal.setToken(authResponse.getToken());
		    	    respuestafinal.setPersona(perdto);
		    	    respuestafinal.setPhone(phoneDTO);
		    	    respuestafinal.setAddres(adresDTO);
		            transactionManager.commit(status);
		            
		        	return new WrapperResponse<>(true,"success",respuestafinal)
		    				.createResponse(HttpStatus.OK);
		        } catch (Exception e) {
		            transactionManager.rollback(status);
		            String errorMessage = "Error :"+e.getMessage(); // Add the specific error message here
		            return new ResponseEntity<>(new WrapperResponse<>(false, errorMessage, null), HttpStatus.INTERNAL_SERVER_ERROR);
		        }
		    } catch (Exception e) {
		        String errorMessage = "Error: " + e.getMessage(); // Add the specific error message here
		        return new ResponseEntity<>(new WrapperResponse<>(false, errorMessage, null), HttpStatus.INTERNAL_SERVER_ERROR);
		    } 
    }
	@GetMapping
	public ResponseEntity<List<PesonDTO>> findAlls(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
			){
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Person> articulos = ser.findAll(page);
		List<PesonDTO> articulosDTO = convert.fromEntity(articulos);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		
	}
	
	}
    

