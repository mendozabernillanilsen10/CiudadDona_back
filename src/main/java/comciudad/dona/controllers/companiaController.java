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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import comciudad.dona.converters.ResponsibleConverters;
import comciudad.dona.converters.RolCoverters;
import comciudad.dona.converters.UserConvertes;
import comciudad.dona.converters.UsuarioConverter;
import comciudad.dona.converters.companyConverters;
import comciudad.dona.dtos.AddressDTO;
import comciudad.dona.dtos.AuthResponse;
import comciudad.dona.dtos.CompanyDTO;
import comciudad.dona.dtos.PesonDTO;
import comciudad.dona.dtos.PhoneDTO;
import comciudad.dona.dtos.RegisterCompany;
import comciudad.dona.dtos.RegisterRequest;
import comciudad.dona.dtos.ResponsibleDTO;
import comciudad.dona.dtos.RolDTO;
import comciudad.dona.dtos.UsuarioDTO;
import comciudad.dona.entity.Address;
import comciudad.dona.entity.Company;
import comciudad.dona.entity.Person;
import comciudad.dona.entity.Phone;
import comciudad.dona.entity.Responsible;
import comciudad.dona.entity.Role;
import comciudad.dona.entity.User;
import comciudad.dona.entity.ubdistrito;
import comciudad.dona.service.AddressService;
import comciudad.dona.service.AuthService;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.PersonService;
import comciudad.dona.service.PhoneService;
import comciudad.dona.service.ResponsiService;
import comciudad.dona.service.RolService;
import comciudad.dona.service.companiaService;
import comciudad.dona.utils.WrapperResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/Company")
public class companiaController {
    @Autowired
	private companiaService service;
    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private RolService serviceRole;
	@Autowired
	private AddressService serviceAdress ;

    @Autowired
    private DistritoService distritoService ;
	@Autowired
	private PhoneService servicePhone;
	
	@Autowired
	private ResponsiService resposableser;
	private final AuthService authService;
	UsuarioConverter userconverter=new UsuarioConverter();
	UserConvertes conUsers = new UserConvertes();
	PersonaConverters conPersona =new PersonaConverters();
	RolCoverters roleconverter = new RolCoverters ();
	PersonaConverters convert= new PersonaConverters ();
	private companyConverters converter=new companyConverters();
	PhoneConverters Phoneconvert = new PhoneConverters ();
	AddressConverters Adressconverter = new AddressConverters();
	ResponsibleConverters rc = new ResponsibleConverters();
	@PostMapping(value = "/registers")
	public ResponseEntity<WrapperResponse<RegisterCompany>>  register(
    		 @RequestParam("Sucursal") String Sucursal,
    		    @RequestParam("RazonSocial") String RazonSocial,
    		    @RequestParam("Ruc") String Ruc,
    		    @RequestParam("Email") String Email,
    		    @RequestParam("password") String password,
    		    @RequestParam("Em_Numero_celular") String Em_Numero_celular,
    		    @RequestParam("Em_Numero_whatsapp") String Em_Numero_whatsapp,
    		    @RequestParam("Reference") String Reference,
    		    @RequestParam("street") String street,
    		    @RequestParam("IdDistrito") Long IdDistrito,
    		    @RequestParam("Res_Nombre") String Res_Nombre,
    		    @RequestParam("ResApellido") String ResApellido,
    		    @RequestParam("ResNumero_celular") String ResNumero_celular,
    		    @RequestParam("ResNumero_whatsapp") String ResNumero_whatsapp,
    		    @RequestParam("role_role") UUID  role_role

			)
	
    {
		try {
		        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		        TransactionStatus status = transactionManager.getTransaction(def);
		        try {
		        	RegisterCompany respuestafinal = new RegisterCompany();
			        
			        Role role = serviceRole.findById(role_role);
			        RolDTO articulosDTO =roleconverter.fromEntity(role);
			        
			        RegisterRequest request = new RegisterRequest();
			        request.setUsername(Email);
			        request.setPassword(password);
			        request.setRole(role);
			        AuthResponse authResponse = authService.register(request);
			        UsuarioDTO userdto  = userconverter.fromEntity(authResponse.getUsuario());
			        User usuario  = new User();
			        usuario.setId(authResponse.getUsuario().getId());
			        
			        Company compan = new Company();
			        compan.setRuc(Ruc);
			        compan.setBusinessName(RazonSocial);
			        compan.setIdUser(usuario);
			        compan.setBranch(Sucursal);
			        Company compani = service.save(compan);
					CompanyDTO compDTO = converter.fromEntity(compani);
			        
					Phone phone = new Phone();
		            phone.setCelular(Em_Numero_celular);
		            phone.setWhatsapp(Em_Numero_whatsapp);
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
		    	    Responsible res =  new Responsible ();
		    	    res.setCelular(ResNumero_celular);
		    	    res.setWhatsapp(ResNumero_whatsapp);
		    	    res.setCompany(compani);
		    	    res.setName(ResNumero_whatsapp);
		    	    res.setSurName(ResNumero_whatsapp);		    	    
		    	    Responsible resInsert= resposableser.save(res);
		    	    ResponsibleDTO responsableDto =rc.fromEntity(resInsert); 
		    	    
		    	    respuestafinal.setUsuario(userdto);
		    	    respuestafinal.setAddres(adresDTO);
		    	    respuestafinal.setEmpresa(compDTO);
		    	    respuestafinal.setPhone(phoneDTO);
		    	    respuestafinal.setAddres(adresDTO);
		    	    respuestafinal.setToken(authResponse.getToken());
		    	    respuestafinal.setRole(articulosDTO);
		    	    respuestafinal.setResponsable(responsableDto);
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
	public ResponseEntity<List<CompanyDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
			){

		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Company> articulos = service.findAll(page);
		List<CompanyDTO> articulosDTO =converter.fromEntity(articulos);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<CompanyDTO>> findById(@PathVariable("id") UUID id) {
		Company compani = service.findById(id);
		CompanyDTO compDTO=converter.fromEntity(compani);
		return new WrapperResponse<CompanyDTO>(true,"succes",compDTO).createResponse(HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<CompanyDTO> create(@RequestBody CompanyDTO articuloDTO) {		
		Company compani = service.save(converter.fromDTO(articuloDTO));
		CompanyDTO compDTO=converter.fromEntity(compani);
		return new WrapperResponse(true, "success", compDTO).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CompanyDTO> update(@PathVariable("id") Long id,@RequestBody CompanyDTO ingreso) {
		Company updateIngreso = service.save(converter.fromDTO(ingreso));
		if(updateIngreso==null) {
			return ResponseEntity.notFound().build();
		}
		CompanyDTO ingresoReturn=converter.fromEntity(updateIngreso);
		return new WrapperResponse(true, "success", ingresoReturn).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
		service.delete(id);
		return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
	}

}
