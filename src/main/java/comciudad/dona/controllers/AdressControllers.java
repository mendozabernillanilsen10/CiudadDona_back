package comciudad.dona.controllers;
import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comciudad.dona.converters.AddressConverters;
import comciudad.dona.converters.DistritoConverters;
import comciudad.dona.converters.PersonaConverters;
import comciudad.dona.dtos.AddressDTO;
import comciudad.dona.entity.Address;
import comciudad.dona.service.AddressService;
import comciudad.dona.service.DistritoService;
import comciudad.dona.service.PersonService;
import comciudad.dona.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/Address")
public class AdressControllers {
	@Autowired
	AddressService service ;
	AddressConverters converter = new AddressConverters();

	@Autowired
	PersonService ser ;
	PersonaConverters convert= new PersonaConverters ();
	@Autowired
	DistritoService distritoService ;
	DistritoConverters converD = new DistritoConverters();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping
	public ResponseEntity<List<AddressDTO>> findAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
			){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Address> articulos = service.findAll(page);
		List<AddressDTO> articulosDTO =converter.fromEntity(articulos);
		return new WrapperResponse(true, "success", articulosDTO).createResponse(HttpStatus.OK);		

	}
		
}
